import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        // 1. 创建 DatagramSocket
        DatagramSocket clientSocket = new DatagramSocket();

        // 2. 将消息转换为字节数组
        String message = "Hello, UDP Server!";
        byte[] sendData = message.getBytes();

        // 3. 获取服务器的 IP 地址
        InetAddress serverAddress = InetAddress.getByName("localhost");

        // 4. 创建数据包并指定服务器的 IP 地址和端口号
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 8888);

        // 5. 发送数据包
        clientSocket.send(sendPacket);
        
        System.out.println("Message sent to the server: " + message);

        // 6. 关闭 socket
        clientSocket.close();
    }
}
