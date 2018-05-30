import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex04ChatServer {

	public static void main(String[] args) {

		ServerSocket server = null;

		try {

			server = new ServerSocket(9001);
			System.out.println(">>> Server Ready....");

			// ! 클라이어트 요청 대기
			Socket soc = server.accept();

			System.out.println("Client 요청 수락" + soc.getRemoteSocketAddress());

			SenderThread sender = new SenderThread(soc);
			ReceiverThread receiver = new ReceiverThread(soc);
			
			// ! 독립 스레드로 스타트
			sender.start();
			receiver.start();

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println(">>>>> 서버 main Thread 사망");

	}

}
