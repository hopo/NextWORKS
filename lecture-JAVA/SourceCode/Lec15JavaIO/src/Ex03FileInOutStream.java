import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03FileInOutStream {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		File file = new File("/home/pc33/io/test.txt");

		try {
			// ! 파일에 데이터 출력 (Write)
			// fos = new FileOutputStream(file); // ;; 실제 파일을 만든다
			fos = new FileOutputStream(file, true); // ;; append 여부
			fos.write('H');
			fos.write('e');
			fos.write('l');
			fos.write('l');
			fos.write('o');

			// ! 여러 바이트(배열) 출력
			byte[] data = { ',', 'J', 'a', 'v', 'a' };

			fos.write(data);

			System.out.println("============ 파일 출력 완료 ============");

			// ! 파일로부터 입력(Read)
			fis = new FileInputStream("src/Ex03FileInOutStream.java");

			// byte[] buff = new byte[fis.available()]; // ;; 파일의 크기만큼 배열을 만든다
			byte[] buff = new byte[256];

			while (true) {

				// int x = fis.read(); // ;; 한 바이트씩 읽기
				// System.out.print((char) x);

				int x = fis.read(buff); // ;; 바이트 배열로 읽기
				System.out.print(new String(buff));

				if (x < 0) {
					System.out.println("파일의 끝에 도달 했습니다.");
					break;
				}
			}

		} catch (FileNotFoundException e) { // ;; 경로가 틀리면 FileNotFound
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ! 자원 반납
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
			}
		}

	}
}
