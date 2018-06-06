package pc33.gdrive04;

import javafx.scene.control.TextArea;

interface Gdrivable {
	
	/*
	 *  using gdrive command
	 */

	public void list(TextArea textArea);
	public void download();
	public void upload(String filePath);

}
