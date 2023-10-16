import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        // 1. 创建 DatagramSocket，监听一个端口
        DatagramSocket serverSocket = new DatagramSocket(8888);

        // 2. 创建数据包，用于接收数据
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        System.out.println("Server is waiting for packets...");

        // 3. 循环接收数据包
        while (true) {
            // 接收客户端发送的数据包
            serverSocket.receive(receivePacket);
            
            // 获取数据并打印
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received: " + message);
        }
    }
}
