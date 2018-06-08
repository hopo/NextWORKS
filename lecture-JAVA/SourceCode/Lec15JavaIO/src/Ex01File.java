import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex01File {

	public static void main(String[] args) throws IOException {

		// // ! File
		// // File file = new File("/home/pc33/io/sample.txt");
		// File file = new File("..", "/home/pc33/io/sample.txt"); // ;; 정보만 같고 있지 생성되진
		// 않는다.
		//
		// // ! 경로 관련 메서드
		// System.out.println("getAbsolutePath() : " + file.getAbsolutePath());
		// System.out.println("getCanonicalPath() : " + file.getCanonicalPath());
		// System.out.println("getPath() : " + file.getPath());
		// System.out.println("getName() : " + file.getName());
		// System.out.println("getParent() : " + file.getParent());
		// System.out.println();

		// ! root 디렉토리 ls
		File[] roots = File.listRoots(); // ;; 루트 디렉토리 목록, Unix 하나, Windows는 하나 이상
		// System.out.println("root" + roots[0]);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");

		for (int i = 0; i < roots.length; i++) {

			File rootDir = roots[i];

			File[] files = rootDir.listFiles();

			// !! 수정일자, 형식, 크기, 파일명 출력
			System.out.println("LastModified\t\t Type\t Size\t\t FileName");
			for (File f : files) {
				System.out.printf("%s\t %s\t %s\t\t %s\n",
						dateFormat.format(new Date(f.lastModified())),
						(f.isDirectory() ? "<DIR>" : "     "),
						(f.length() / (1 << 10)) + " KB", f.getName());
			}
		}
	}
}
