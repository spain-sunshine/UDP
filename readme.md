# Java 实现的简单的UDP通信
展示了使用Java的 `DatagramSocket` 和 `DatagramPacket` 在服务器和客户端之间进行基本的 UDP 通信。

## 启动服务器
## 启动客户端

## 代码解释
UDPServer:
创建一个 DatagramSocket，监听 8888 端口。
服务器进入一个无限循环，等待进入的数据包。
当接收到一个数据包时，提取其数据并打印。
UDPClient:
消息（"Hello, UDP Server!"）被转换为字节。
使用消息字节、目标服务器地址（localhost）和端口（8888）创建一个 DatagramPacket。
使用 DatagramSocket 发送数据包。

# 注意事项
UDP 是一个无连接的协议。不能保证发送的数据包会被接收，或者它们会按发送的顺序被接收。
这只是一个简单的展示。在真实的场景中，需要错误处理、数据包验证和其他考虑因素。

### 问题
**问题**：运行步骤及UDP原理：
**答案**：
运行步骤:

首先运行 UDPServer，它会开始监听 8888 端口。
然后运行 UDPClient，它会发送一个消息到服务器。
UDP 通信的原理:

UDP 是一种无连接的协议，这意味着发送方可以在没有任何握手过程的情况下直接发送数据包。
数据被打包并直接发送到目标地址。没有确认、没有超时重发、没有顺序保证。
由于其简单性和高效性，UDP 常用于实时通信，例如语音和视频通信。
这个示例展示了 UDP 的基础：如何创建数据报套接字、如何发送和接收数据包。不过，请注意，在实际应用中，你可能需要处理更多的细节，例如错误检查、数据包丢失和顺序等问题。
---
**问题**：DatagramSocket和DatagramPacket是什么
**答案**：
在 Java 中，DatagramSocket 和 DatagramPacket 是用于实现 UDP 通信的两个主要类。让我们更深入地了解它们：

1. DatagramSocket:
描述：这是用于发送和接收数据报包的套接字。你可以将其视为 UDP 通信的端点。
功能：
发送：它可以用于发送 DatagramPacket。
接收：它也可以用于接收 DatagramPacket。
绑定：当你创建一个 DatagramSocket 实例时，它可以绑定到特定的端口上，以便其他系统知道如何与它通信。
例子：在上述代码中，DatagramSocket serverSocket = new DatagramSocket(8888); 创建了一个绑定到端口 8888 的 DatagramSocket。
2. DatagramPacket:
描述：这是数据报通信的数据包。它包含要发送或接收的数据，以及目标或源的地址和端口信息。
功能：
数据载体：它携带了要发送或已接收的数据。
地址和端口信息：它包含了数据包的目标地址和端口（用于发送）或源地址和端口（用于接收）。
例子：在上述代码中，以下代码创建了一个数据报包，包含要发送的消息、目标地址和端口：
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 8888);
## 简单地说：
DatagramSocket 是你的通信端点，它是你发送或接收数据的地方。
DatagramPacket 是你发送或接收的实际数据，它包含数据内容和关于数据来源或目的地的信息。
在 UDP 通信中，你创建一个 DatagramPacket，填充数据和目标信息，然后使用 DatagramSocket 发送它。同样，当你接收一个数据报时，你使用 DatagramSocket 接收数据到 DatagramPacket，然后从 DatagramPacket 中提取数据。

**问题**InetAddress serverAddress = InetAddress.getByName("localhost");这段代码怎么通过localhost获取服务器的ip地址？
**答案**:
1. localhost:
localhost 是一个特殊的主机名，它总是指向本机的 IP 地址。在 IPv4 中，它通常指向 127.0.0.1。在 IPv6 中，它指向 ::1。每台计算机上的网络软件都默认知道 localhost 是什么，并将其解析为相应的 IP 地址。

2. InetAddress.getByName():
InetAddress.getByName() 是 Java 中的方法，用于通过主机名获取 IP 地址。当你为这个方法提供一个主机名（如 localhost、google.com 等）时，它将尝试解析这个主机名并返回相应的 InetAddress 对象。

当你使用 InetAddress.getByName("localhost"):

Java 会查找主机名 localhost。
由于 localhost 是一个预定义的名字，Java 知道它应该解析为 127.0.0.1（或在 IPv6 中为 ::1）。
因此，该方法返回一个 InetAddress 对象，代表 IP 地址 127.0.0.1。
总结:
在你的代码中，当你使用 localhost 时，你实际上是在告诉程序连接到运行该程序的同一台计算机。这很有用，例如当你的服务器和客户端都在同一台机器上运行时，用于测试和开发。

服务器不需要定义 localhost，因为 localhost 总是指向正在运行的机器。无论你在哪里运行你的代码，localhost 总是指向该机器的回环地址（通常是 127.0.0.1）。
