import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex04ChatClient {

	public static void main(String[] args) {

		Socket soc = null;

		try {

			soc = new Socket("192.168.20.11", 9001);
			System.out.println(">>> 클라이언트 접속 성공: " + soc.getRemoteSocketAddress());
			
			SenderThread sender = new SenderThread(soc);
			ReceiverThread receiver = new ReceiverThread(soc);
			
			sender.start();
			receiver.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(">>>>> 클라인트 main Thread 사망");
	}

}
