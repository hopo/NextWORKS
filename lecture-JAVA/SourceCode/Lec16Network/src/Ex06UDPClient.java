import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Ex06UDPClient {

	public static void main(String[] args) {

		DatagramPacket packet = null;
		DatagramSocket socket = null;

		try {

			// ;; 소켓 생성.
			socket = new DatagramSocket(9003);
			System.out.println(">>> 클라이언트 생성.");

			byte[] data = new byte[256];
			// ;; 소켓 수신용 패킷.
			packet = new DatagramPacket(data, data.length);

			while (true) {
				// ;; 데이터 수신
				socket.receive(packet);
				System.out.println("수신 > " + new String(packet.getData(), 0, packet.getLength()));
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
