package ztest;

public class RuntimeDemo {

	   public static void main(String[] args) {
	      try {

	         // create a new array of 2 strings
	         String[] cmdArray = new String[2];

	         // first argument is the program we want to open
	         cmdArray[0] = "/usr/bin/xed";

	         // second argument is a txt file we want to open with notepad
	         cmdArray[1] = "test.txt";

	         // print a message
	         System.out.println("Executing xed and opening test.txt");

	         // create a process and execute cmdArray
	         Process process = Runtime.getRuntime().exec(cmdArray);

	         // print another message
	         System.out.println("test.txt should now open.");

	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	   }
	} 
