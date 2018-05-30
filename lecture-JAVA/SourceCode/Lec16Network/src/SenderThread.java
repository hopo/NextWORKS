import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThread extends Thread {

	Socket soc;

	public SenderThread(Socket soc) {
		this.soc = soc;

	}

	@Override
	public void run() {

		try {

			// ! 키보드로 부터 메시지 입력
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(soc.getOutputStream());

			while (true) {

				System.out.print("MESSAGE >> ");
				String msg = reader.readLine();
				if (msg == null || "exit".equals(msg)) {
					break;
				}
				writer.println(msg);
				writer.flush();
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
