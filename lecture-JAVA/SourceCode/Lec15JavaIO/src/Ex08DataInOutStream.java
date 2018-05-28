import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex08DataInOutStream {

	public static void main(String[] args) {

		File file = new File("/home/pc33/io/data.dat");

		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {

			dos = new DataOutputStream(new FileOutputStream(file));
			dis = new DataInputStream(new FileInputStream(file));

			int[] num = { -15, -5, 0, 5, 10, 15, 18, 29, 28, 23, 18, 5 };

			for (int n : num) {
				dos.writeInt(n);
			}

			System.out.println("파일 출력 완료.");

			while (true) {
				try {
					int x = dis.readInt();
					System.out.println(x);
				} catch (EOFException e) {
					System.out.println("파일의 끝에 도달했습니다.");
					break;
				}
			}

			// int nNum = 120;
			// dos.writeInt(nNum); // 4byte
			// dos.writeShort(50); // 2byte
			// dos.writeChar('A'); // 2byte
			// dos.writeDouble(3.14); // 8byte
			// dos.writeBoolean(true);
			// dos.writeUTF("문자열 출력.");
			//
			// dis = new DataInputStream(new FileInputStream(file));
			// System.out.println("int : " + dis.readInt());
			// System.out.println("short : " + dis.readShort());
			// System.out.println("char : " + dis.readChar());
			// System.out.println("double : " + dis.readDouble());
			// System.out.println("boolean : " + dis.readBoolean());
			// System.out.println("string : " + dis.readUTF());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
				if (dis != null) {
					dis.close();
				}
			} catch (Exception e2) {
			}
		}

	}

}
