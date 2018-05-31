import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Ex07MulticastServer {

	public static void main(String[] args) {

		DatagramPacket packet = null;
		MulticastSocket socket = null;

		try {

			socket = new MulticastSocket();
			System.out.println("Server Ready.............");

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			/*
			 *  IPv4 (192.168.20.2)
			 *  A Class : 0000 => 	0.0.0.0 ~ 127.255.255.255 	; N.H.H.H
			 *  B Class : 1000 => 128.0.0.0	~					; N.N.H.H
			 *  C Class : 1100 => 192.0.0.0	~					; N.N.N.H
 			 *  D Class : 1110 => 224.0.0.0 ~ 					; Multicast용 ip 대역
			 *  E Class : 1111 => 240.0.0.0 ~					; 연구용으로 예약
			 *  
			 */
			
			// ; 멀티캐스트의 핵심입니다
			InetAddress address = InetAddress.getByName("224.128.5.6");
			
			while(true) {
				System.out.println("입력 : ");

				String msg = reader.readLine();

				packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, 9004);

				socket.send(packet);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
