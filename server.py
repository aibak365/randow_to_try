# CN lab 9
# Names aibak aljadayah
# Group: <Wednesday>

# imports
import http.server as HTTP
import socketserver
import sys

# define class to handle GET/POST request
class ReqHandler(HTTP.BaseHTTPRequestHandler):

    def do_GET(self): # overridden method
        
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        
        if self.path == "/exit":
            print("Requested to close server...")
            my_server.server_close()
            sys.exit()
        
        self.wfile.write(bytes("<html><head><title>CN lab. 9</title></head>", "utf-8"))
        self.wfile.write(bytes("<h3>Previous GET Request:</h3><p>%s</p>" % self.path, "utf-8"))
        self.wfile.write(bytes("<body>", "utf-8"))
        self.wfile.write(bytes("<h3>POST Form:</h3>", "utf-8"))
        self.wfile.write(bytes('<form action="" method="post">'
                               'x = <input type="text" name="x"><br>'
                               '<form action="" method="post">'
                               'x = <input type="text" name="aibak_1"><br>'
                               '<input type="submit" value="Post">'
                               '</form>', "utf-8"))
        self.wfile.write(bytes("</body></html>", "utf-8"))

        return

    def do_POST(self): # overridden method
        res_len = int(self.headers['Content-Length'])
        res = self.rfile.read(res_len)
        
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()

        res_val = res.decode("utf-8")
        self.wfile.write(bytes("<html><head><title>CN lab. 9</title></head>", "utf-8"))
        self.wfile.write(bytes("<h3>Previous POST Request:</h3><p>%s</p>" % res_val, "utf-8"))
        self.wfile.write(bytes("<body>", "utf-8"))
        self.wfile.write(bytes("<h3>GET Form:</h3>", "utf-8"))
        self.wfile.write(bytes('<form action="" method="get">'
                               'request = <input type="text" name="req"><br>'
                               '<form action="" method="get">'
                               'request = <input type="text" name="aibak_2"><br>'
                               '<input type="submit" value="Get"></form>', "utf-8"))
        self.wfile.write(bytes("</body></html>", "utf-8"))
        
        return

host ="127.0.0.1"
port_number =1234
srv_address = (host, port_number) # TCP address as tuple
my_server = socketserver.TCPServer(srv_address, ReqHandler)
print("Server started at %s:%d" % (srv_address[0], srv_address[1]))
my_server.serve_forever() # start the server, listen/respond to requests
