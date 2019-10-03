package Example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket(9999);

        byte[] b1 = new byte[1204]; //size

        DatagramPacket dp = new DatagramPacket(b1, b1.length);
        ds.receive(dp);
        String str = new String(dp.getData());
        int num = Integer.parseInt(str.trim());
        int result = num * num;

        //sent the data back to client
        byte[] b2 = (result + "").getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort()); //getPort give you the same portNum
        ds.send(dp1);
    }
}

