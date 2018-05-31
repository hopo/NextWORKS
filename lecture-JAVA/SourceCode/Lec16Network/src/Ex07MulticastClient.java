import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Ex07MulticastClient {

	public static void main(String[] args) {

		DatagramPacket packet = null;
		MulticastSocket socket = null;

		try {

			socket = new MulticastSocket(9004);
			System.out.println("클라이언트 대기");

			InetAddress address = InetAddress.getByName("224.128.5.6");
			// ;; 그룹에 조인
			socket.joinGroup(address);

			// ;; 데이터 수신
			byte[] data = new byte[256];
			packet = new DatagramPacket(data, data.length);

			while (true) {
				socket.receive(packet);
				System.out.println("수신 > " + new String(packet.getData(), 0, packet.getLength()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
