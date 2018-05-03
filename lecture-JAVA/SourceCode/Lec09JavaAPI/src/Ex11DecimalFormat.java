import java.text.DecimalFormat;

public class Ex11DecimalFormat {
	
	
	public static void main(String[] args) {

		// 숫자 포맷. ex in DB) FM('#,###', 12000)
		
		double num = 1234567.89;

		DecimalFormat formatter = new DecimalFormat();
		System.out.println("default: " + formatter.format(num));
		
		formatter = new DecimalFormat("0.0");
		System.out.println("0.0: " + formatter.format(num));

		formatter = new DecimalFormat("#,###.0");
		System.out.println("#,###,0: " + formatter.format(num));

		formatter = new DecimalFormat("\u00A4 #,###.0");
		System.out.println("\\u00A4 #,###.0: " + formatter.format(num));
		
	}

}
