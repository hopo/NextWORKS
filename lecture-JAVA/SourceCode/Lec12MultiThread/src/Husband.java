
public class Husband extends Thread {

	public Husband(String name) {

		// this.setName(name);
		super(name);
	}

	@Override
	public void run() {
		
		Ex03SynchMain.account.deposit(80000);
		
		System.out.println(getName() + " deposit(80000) :  " + Ex03SynchMain.account.getBalance());
		
	}

}
