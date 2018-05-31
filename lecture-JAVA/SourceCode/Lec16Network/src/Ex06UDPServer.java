import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Ex06UDPServer {

	public static void main(String[] args) {

		DatagramPacket packet = null;
		DatagramSocket socket = null;

		try {

			// ;; 소켓 생성
			socket = new DatagramSocket(); // ;; 포트가 꼭 피리요하진 않다 송신만 할것이니깐

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("입력 : ");
				String msg = reader.readLine();
				if (msg == null) {
					break;
				}

				// for (int i = 2; i <= 254; i++) {
				InetAddress address = InetAddress.getByName("192.168.20.255"); // ;; '255': Broadcast IP Address	

				// ;; 데이터그램 패킷 생성. byte[] <- String.getBytes()
				// ;;; UDP 핵심
				packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, 9003);

				// ;; 데이터그램 송신
				socket.send(packet);
				// }
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
