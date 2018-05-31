import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Ex05MultiChatServer {

	// * clientList : ArrayList
	// ! 클라이언트 목록
	public static ArrayList<Client> clientList = new ArrayList<>();

	// * Client : inner class
	// ; 각각의 클라이언트와 통신을 담당하는 객체.
	class Client extends Thread {

		Socket soc;
		PrintWriter writer;
		String nickName;

		Client(Socket soc) { // ;; 네트워크 입출력을 위하여 soc가 필요

			this.soc = soc;

			try {

				// ;; 자신의 클라이언트에게 메시지를 송신
				writer = new PrintWriter(soc.getOutputStream(), true);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {

				// ;; 접속된 클라이언트로 부터 수신.(읽는다)
				BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));

				// ;; 별명 수신.
				nickName = reader.readLine();
				// ;;; 별명 알려주ㄴ다
				sendAll("#" + nickName + "님이 입장하였습니다.");

				while (true) {
					String msg = reader.readLine();
					if (msg == null) {
						break;
					}

					// ;; 서버에 접속된 모든 클라이은테에게 전송(쓴다)
					sendAll(nickName + "님의 말 : " + msg);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (soc != null) {
						soc.close();
					}
				} catch (Exception e2) {
				}
				clientList.remove(this);
				sendAll("#" + nickName + "님이 퇴장하였습니다.");
			}

		}

		// ; 전체에게 msg를 보내기
		public void sendAll(String msg) {
			for (Client client : clientList) {

				client.writer.println(msg);

			}

		}

	}

	// * start()
	// ; static method(main)은 non static을 다루기 복잡하다
	public void start() {

		ServerSocket server = null;

		try {

			server = new ServerSocket(9002);
			System.out.println(">>> Server Ready............");

			while (true) {
				// ; 클라이언트 요청 대기
				Socket soc = server.accept(); // ; 하나의 클라이언트 접속 soc
				System.out.println(">> 클라이너트 접속: " + soc.getRemoteSocketAddress());

				Client client = new Client(soc);
				clientList.add(client);
				client.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// * main()
	public static void main(String[] args) {

		Ex05MultiChatServer multiChatServer = new Ex05MultiChatServer();

		multiChatServer.start();
	}

}
