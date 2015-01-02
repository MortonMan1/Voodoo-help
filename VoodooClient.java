import java.net.*;
import java.io.*;

public class VoodooClient
{
	public static void main(String[] args) {
        // TODO code application logic here
        int port = 48879;		// REPLACE WITH YOUR CORE's PORT
        String host = "10.0.0.31";	// REPLACE WITH YOUR CORE'S IP
       
        try {
            Socket clientSocket = new Socket(host, port);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            byte[] output7 = {0x00, 0x07, 0x01};   // Set pin 7 to OUTPUT
            byte[] high7 = {0x01, 0x07, 0x01};  // Set pin 7 to HIGH
            byte[] low7 = {0x01, 0x07, 0x00};  // Set pin 7 to HIGH
            
            outToServer.write(output7);
            System.out.println("Sent initialiser");

            for(int i = 0; i<10; i++)
            {
                outToServer.write(high7);
                System.out.println("Sent ON");
                Thread.sleep(1000);
                outToServer.write(low7);
                System.out.println("Sent OFF");
                Thread.sleep(1000);
            }
            
            clientSocket.close();
        } catch (SocketException ex) {
            Logger.getLogger(VoodooSparkClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VoodooSparkClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(VoodooSparkClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}	
