package pc33.gdrive02;

interface Gdrivable {
	
	/*
	 *  using gdrive command
	 */

	public void list();
	public void download();
	public void upload(String filePath);

}
