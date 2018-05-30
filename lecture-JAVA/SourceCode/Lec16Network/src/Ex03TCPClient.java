import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex03TCPClient {

	public static void main(String[] args) {
		
		Socket soc = null;

		try {

			// ! 서버로 접근 요청.
			soc = new Socket("192.168.20.14", 9000);

			System.out.println("to서버 접속 성공 : " + soc.getRemoteSocketAddress());

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			PrintWriter writer = new PrintWriter(soc.getOutputStream(), true); // ; autoflush=true

			while (true) {
				System.out.print("메시지 > ");
				String msg = reader.readLine();
				if(msg == null || "exit".equals(msg)) {
					break;
				}
				writer.println(msg);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(soc != null) {
					soc.close();
				}
			} catch (Exception e2) {
			}
		}
		
	}

}
