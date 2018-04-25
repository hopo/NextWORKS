package kr.or.nextit.shape;

public class Rectangle {
	
	public int width;
	public int height;
	
	public Rectangle() {}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getArea() {
		return width * height;
	}

}
