package pc33.gdrive02;

public class GdriveCommand implements Gdrivable {

	@Override
	public void list() {
		// gdrive list

	}

	@Override
	public void download() {
		// gdrive download ID --path ./

	}

	@Override
	public void upload(String filePath) {
		// ! gdrive upload ./

		try {

			// ;; create a new array of 2 strings
			String[] cmdArray = new String[3];

			// ;; first argument is the program we want to open
			cmdArray[0] = "/usr/local/bin/gdrive";
			cmdArray[1] = "upload";

			// ;; second argument is a txt file we want to open with notepad
			cmdArray[2] = filePath;

			// ;; print a message
			System.out.println(">>> Executing gdrive upload");

			// ;; create a process and execute cmdArray
			Process process = Runtime.getRuntime().exec(cmdArray);
			// process.destroy();

			// ;; print another message
			System.out.println(">>> " + filePath + " upload complete");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
