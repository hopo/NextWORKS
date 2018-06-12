package pc33.gdrive13;

import javafx.scene.control.TextArea;

interface Gdrivable {
	
	/*
	 *  using gdrive command
	 */

	public void list(TextArea textArea);
	public void download(String id, String downloadPath);
	public void upload(String filePath);
	public void delete(String id);

}
