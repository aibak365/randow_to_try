/* Based on: 
https://randomnerdtutorials.com/esp8266-ds18b20-temperature-sensor-web-server-with-arduino-ide/
https://techtutorialsx.com/2017/04/09/esp8266-connecting-to-mqtt-broker/
*/

// Libraries
#include <ESP8266WiFi.h>
#include <OneWire.h>
#include <DallasTemperature.h>
#include <PubSubClient.h>

// WiFi settings:
const char* ssid = "wifi_for_esp";
const char* password =  "pass_for_esp";

// MQTT settings:
const char* mqttServer = "broker.hivemq.com";
const int mqttPort = 1883;
const char* nameForMyDevice = "weCan";  // Try to be unique! Otherwise the server will not communicate with the board
const char* topicPublish = "cnet/temp/aibakHere";
const char* topicSubscribe = "cnet/info";

// Data wire of the sensor is connected to GPIO number...
#define ONE_WIRE_BUS 4

// Setup a oneWire instance to communicate with any OneWire device:
OneWire oneWire(ONE_WIRE_BUS);
// Pass our oneWire reference to Dallas Temperature sensor:
DallasTemperature sensor(&oneWire);
// Network communication stuff:
WiFiClient netClient;
PubSubClient MQTTclient(netClient);

// the code that only runs once on boot:
void setup() {
  // Initializing serial port for debugging purposes:
  Serial.begin(115200);

  // Setup WiFi connection:
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.println("Connecting to WiFi..");
  }
  Serial.println("Connected to the WiFi network");
  Serial.print("Local IP address: ");
  Serial.println(WiFi.localIP());
  
  // Setup connection with MQTT broker:
  MQTTclient.setServer(mqttServer, mqttPort);
  MQTTclient.setCallback(callback);
  while (!MQTTclient.connected()) {
    Serial.println("Connecting to MQTT...");
    if (MQTTclient.connect(nameForMyDevice)) {
      Serial.println("Connected to MQTT");  
    } else {
      Serial.print("failed with state ");
      Serial.println(MQTTclient.state());
      delay(1000);
    }
  }
  // Now you can make MQTT subscriptions to topics. 
  // See https://pubsubclient.knolleary.net/api --> subscribe() function
  
  MQTTclient.subscribe(topicSubscribe,1);

  // Initialize temperature measurements:
  sensor.begin();
}

// Callback function - executed when MQTT message is received.
void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived in topic: ");
  Serial.println(topic);
  Serial.print("Message: ");
  for (int i = 0; i < length; i++) {
    Serial.print((char)payload[i]);
  }
  Serial.println();
  Serial.println("-----------------------");
}

void getTemperature() {
  // Read temperature (in deg. Celsius) from the sensor:
  float temperature;
  sensor.requestTemperatures(); 
  delay(2000);
  temperature = sensor.getTempCByIndex(0);

  // Prepare string with measurement result:
  char stringNumberOnly[10];  // make it long enough to include everything!
  char stringFullMessage[20];  // make it long enough to include everything!
  dtostrf(temperature, 2, 2, stringNumberOnly);  // convert decimal number to string
  sprintf(stringFullMessage, "%s deg.C", stringNumberOnly);  // include the number in a longer string

  // Display in console:
  Serial.println(stringFullMessage);
  
  // Now you may send the measurement (preferably stringNumberOnly) with MQTT.
  // See https://pubsubclient.knolleary.net/api --> publish() function
  
  MQTTclient.publish(topicPublish,stringNumberOnly);
}

// the code that runs repeatedly:
void loop() {
  getTemperature();  // deal with temperature measurement
  MQTTclient.loop();  // maintain connection with MQTT broker and receive messages (if any)
}
