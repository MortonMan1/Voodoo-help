import java.net.*;
import java.io.*;

public class VoodooClient
{
	public static void main(String args[]) throws IOException
	{
		int serverPort = 48879;
		String host = "192.168.1.113";
		
		
			// get a datagram socket
	    DatagramSocket socket = new DatagramSocket();
	
	        // send request
	    byte[] Text = {0x00, 0x07, 0x01};
	    InetAddress address = InetAddress.getByName(host);
	    DatagramPacket packet = new DatagramPacket(Text, Text.length, address, serverPort);
	    socket.send(packet);
	    System.out.println("Sent initialiser");
	    
	    byte[] Text2 = {0x01, 0x07, 0x01};
	    DatagramPacket packet2 = new DatagramPacket(Text2, Text2.length, address, serverPort);
	    socket.send(packet2);
	    System.out.println("Sent ON");
	
	    socket.close();
	}
}	
