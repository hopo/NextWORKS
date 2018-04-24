package practice;

public class BorrowerMain {
	public static void main(String[] args) {
		
		Lendable book1 = new SeparateVolume("B99-3309", "Python_Web_Programming");
		Lendable book2 = new SeparateVolume("B33-1234", "Slam_Dunk");
		Lendable cd1 = new AppCDInfo("C32-2233", "Taxi_Driver");
		Lendable cd2 = new AppCDInfo("C11-0001", "Kingkong");
		
		cd1.checkOut("OBAMA", "Mar-03");
		cd2.checkOut("Mesi", "Mar-04");
		book1.checkOut("Amber", "Apr-24");
		book2.checkOut("Sooki", "Apr-30");
	}

}
