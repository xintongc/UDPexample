import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer2 {

	public static void main(String[] args) {
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(7777);
			byte[] buffer = new byte[1000];// to stored the received data from
											// the client.
			System.out.println("Server 7777 Started............");
			while (true) {// non-terminating loop as the server is always in
							// listening mode.
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				// Server waits for the request to
				// come------------------------------------------------------------------
				aSocket.receive(request);// request received
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(),
						request.getPort());// reply packet ready
				aSocket.send(reply);// reply sent
			}
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
	}
}
