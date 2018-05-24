import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04FileInOutStream {

	public static void main(String[] args) {

		File source = new File("/home/pc33/io/gnome-tyr_02.png");
		File target = new File("/home/pc33/io/gnome-tyr_02_copy.png");

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(target);

			byte[] buff = new byte[256];

			while (true) {
				// int x = fis.read(); // ;; 읽기
				int x = fis.read(buff); // ;; 읽기2
				if (x < 0) {
					System.out.println("== 파일 복사 완료 ==");
					break;
				}
				// fos.write(x); // ;; 쓰기
				fos.write(buff, 0, x); // ;; 쓰기2
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ;; 자원 해제
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {}
		}
	}

}
