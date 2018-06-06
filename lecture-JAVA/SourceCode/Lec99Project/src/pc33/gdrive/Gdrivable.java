package pc33.gdrive;

interface Gdrivable {
	
	/*
	 *  using gdrive command
	 */

	public void list();
	public void download();
	public void upload(String filePath);

}
