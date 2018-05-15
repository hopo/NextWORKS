package control.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// !!! JavaBeans > ValueObject = Model
public class Camera {
	
	StringProperty maker;
	StringProperty image;
	IntegerProperty price;

	public Camera() {}
	
	public Camera(String maker, String image, int price) {
		this.maker = new SimpleStringProperty(maker); // 구현 클래스 SimpleStringProperty()
		this.image = new SimpleStringProperty(image);
		this.price = new SimpleIntegerProperty(price);
	}
	
	// set get maker
	public void setMaker(String maker) {
		if(this.maker == null) {
			this.maker = new SimpleStringProperty();
		}
		this.maker.set(maker);
	}
	public String getMaker() {
		return maker.get();
	}
	public StringProperty makerProperty() {
		return maker;
	}

	// set get image
	public void setImage(String image) {
		if(this.image == null) {
			this.image = new SimpleStringProperty();
		}
		this.image.set(image);
	}
	public String getImage() {
		return image.get();
	}
	public StringProperty imageProperty() {
		return image;
	}

	// set get price
	public void setPrice(int price) {
		if(this.price == null) {
			this.price = new SimpleIntegerProperty();
		}
		this.price.set(price);
	}
	public int getPrice() {
		return price.get();
	}
	public IntegerProperty priceProperty() {
		return price;
	}
	
}
