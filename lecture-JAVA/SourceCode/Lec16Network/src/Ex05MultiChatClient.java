import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex05MultiChatClient {
	
	public static void main(String[] args) {
		
		Socket soc = null;
		
		try {

			soc = new Socket("192.168.20.2", 9002);
			System.out.println(">>> 클라이언트 접속 성공: " + soc.getRemoteSocketAddress());
			
			String nickName = "Obama";
			
			SenderThread sender = new SenderThread(soc, nickName);
			ReceiverThread receiver = new ReceiverThread(soc);
			
			sender.start();
			receiver.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
