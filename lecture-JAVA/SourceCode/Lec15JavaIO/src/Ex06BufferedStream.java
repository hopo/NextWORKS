import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06BufferedStream {

	public static void main(String[] args) {

		// ! Non Buffered(FileIOStream) VS Buffered

		File source = new File("/home/pc33/io/StayWithMeMV.m4v");
		File target1 = new File("/home/pc33/io/StayWithMeMV-1.m4v");
		File target2 = new File("/home/pc33/io/StayWithMeMV-2.m4v");

		FileInputStream fis = null;
		FileOutputStream fos = null;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {

			// !! Non 버퍼드 스트림.
			fis = new FileInputStream(source);
			fos = new FileOutputStream(target1);

			long startTime = System.currentTimeMillis();
			System.out.println("Non 버퍼드 스트림 시작");

			while (true) {
				int x = fis.read();
				if (x < 0) {
					break;
				}
				fos.write(x);
			}

			long duration = System.currentTimeMillis() - startTime;
			System.out.println("duration : " + duration);

			// !! 버퍼드 스트림.
			bis = new BufferedInputStream(new FileInputStream(source));
			bos = new BufferedOutputStream(new FileOutputStream(target2));

			startTime = System.currentTimeMillis();
			System.out.println("버퍼드 스트림 시작");

			while (true) {
				int x = bis.read();
				if (x < 0) {
					break;
				}
				bos.write(x);
			}
			// bos.flush(); // ;; 버퍼의 공간을 비우기.

			duration = System.currentTimeMillis() - startTime;
			System.out.println("Buffering Duration : " + duration);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {}
		}

	}

}
