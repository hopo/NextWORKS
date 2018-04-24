
public class InterfaceMain {

	public static void main(String[] args) {

		// 첫번째 방법
		// SeperateVolume book1 = new SeperateVolume("A010-23", "신용권", "이것이 자바다");
		// AppCDInfo cd1 = new AppCDInfo("C1234-96", "리눅스 설치 부록CD");
		// SeperateVolume book2 = new SeperateVolume("B010-23", "홍형경", "오라클 SQL 활용");
		// AppCDInfo cd2 = new AppCDInfo("D1234-96", "MicroSofrt Office 활용예제");

		// book1.checkOut("이산", "2018-04-24");
		// cd1.checkOut("이산", "2018-04-24");
		// book2.checkOut("이산", "2018-04-24");
		// cd2.checkOut("이산", "2018-04-24");

		Lendable[] lendList = {
			new SeperateVolume("A010-23", "신용권", "이것이 자바다"),
			new AppCDInfo("C1234-96", "리눅스 설치 부록CD"),
			new SeperateVolume("B010-23", "홍형경", "오라클 SQL 활용"),
			new AppCDInfo("D1234-96", "MicroSofrt Office 활용예제")
		};
		
		checkOutAll(lendList, "설현", "2018-04-24");
	}
	
	public static void checkOutAll(Lendable[] lendList, String borrower, String date) {
		for(int i = 0; i < lendList.length; i++) {
			lendList[i].checkOut(borrower, date);
		}
		
	}

}
