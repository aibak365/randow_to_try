#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>  // exit
//note i used input in the server to send what do you want
const unsigned short int PORT = 1234;

int main(void)
{
	while(1==1)
	{
	
	int fd, connectionfd,valread;
	struct sockaddr_in ownAddress;
	struct sockaddr_in remAddress;
	int addrlen;
	char str[INET_ADDRSTRLEN];
	char *hello="welcom\n pls know when you sent something wait the respnose from the server\n";
	char *sendstr[1000];
	char rc[1024]={0};

	//create a socket:
	if( (fd = socket(PF_INET, SOCK_STREAM, 0)) == -1 )
	{
		perror( "socket" );
		exit(1);
	}

	//IP address and port number of the server:
	ownAddress.sin_family = AF_INET;  //AF_INET= IPv4
	ownAddress.sin_port = htons(PORT);  //htons=change Host byte order TO Network byte order, Short data
	ownAddress.sin_addr.s_addr = INADDR_ANY;  //INADDR_ANY=listen on each 
                                                  //available network interface;
						  //can also listen on a specific address
	memset(&(ownAddress.sin_zero), '\0', 8);

	//bind to the address and port:
	if( bind(fd, (struct sockaddr *) &ownAddress, sizeof(struct sockaddr)) == -1)
	{
		perror( "bind" );
		exit(2);
	}

	//listen (wait) for incoming connections from clients:
	if( listen(fd, 5) == -1)  //5=backlog (waiting queue length), usually between 5 and 10
	{
		perror( "listen" );
		exit(3);
	}

    	puts("Waiting for incoming connections...");

	//accept the incoming connection, ie. establish communication with a client:
	addrlen = sizeof(struct sockaddr_in);
	if( (connectionfd = accept( fd, (struct sockaddr *)&remAddress, &addrlen)) == -1 ) 
	{
		perror( "accept" );
		exit(4);
	}
	
	//now we have a working connection between this server and some client;
	//we can receive and send data

	//we can also check the address of the connected client:
	inet_ntop(AF_INET, &(remAddress.sin_addr), str, INET_ADDRSTRLEN);
		//(ntop=Network byte order TO (textual) Presentation);
		//a similar function, inet_ntoa(remAddress.sin_addr), is now deprecated
	printf("Connection from: %s\n", str); 
	send(connectionfd,hello,strlen(hello),0);
	while(1==1)
	{
	valread = read( connectionfd,rc,1024);
	if(valread<=0)
	{
		printf("the client disconnected\n");
		close( connectionfd ); 
		close( fd ); 
		int true = 1;
		setsockopt(fd,SOL_SOCKET,SO_REUSEADDR,&true,sizeof(int));
		break;
	}
	else
	{
	printf("%s\n",rc);
	printf("enter input\n");
	scanf("%s\n", sendstr);
	send(connectionfd,sendstr,strlen(sendstr),0);
	}

	}
	}
	
}
