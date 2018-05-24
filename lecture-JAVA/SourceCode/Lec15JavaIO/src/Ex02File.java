import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex02File {

	public static void main(String[] args) throws IOException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		String today = dateFormat.format(new Date());

		File parent = new File("/home/pc33/io/" + today);

		// ! 파일 존재여부 확인
		if (parent.exists()) {
			System.out.println(parent.getPath() + "가 존재 합니다.");
		} else {
			System.out.println(parent.getPath() + "가 NOT 존재 합니다.");

			// ! 디렉토리 생성
			if (parent.mkdirs()) {
				System.out.println(parent.getPath() + " Make Directory Success.");
			}
		}

		// ! 파일 생성.
		File file = new File(parent, "sample.txt");

		if (!file.exists()) {
			if (file.createNewFile()) {
				System.out.println(parent.getPath() + " 파일 생성 Success.");
			}
		} else {
			if(file.setReadOnly()) { // ;; RO file
				System.out.println(parent.getPath() + " Change Mode Read Only.");
			}
		}
	}

}
