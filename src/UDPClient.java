import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket();

        int i = 8;
        byte[] b = String.valueOf(i).getBytes(); //getBytes method belongs to string
        InetAddress ia = InetAddress.getLocalHost();

        DatagramPacket dp = new DatagramPacket(b, b.length, ia,9999);//data, data length, ip address, port num
        //data only recieve byte
        ds.send(dp); //send the data to the socket



        //accept the response from the server, require a new datagramPacket to recieve it
        byte[] b1 = new byte[1024]; //no recieving data yet, give a randon num
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
        ds.receive(dp1);

        String str = new String(dp1.getData());
        System.out.println("result is " + str);





    }
}
