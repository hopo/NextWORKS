import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread {

	Socket soc;

	public ReceiverThread(Socket soc) {
		this.soc = soc;
	}

	@Override
	public void run() {

		try {

			// ! 소켓로 부터 메시지를 읽기
			BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));

			while (true) {
				String msg = reader.readLine();
				if (msg == null) {
					break;
				}
				System.out.println("RECEIVER > " + msg);
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
		}

	}

}
