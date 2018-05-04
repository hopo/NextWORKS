
public class Wife extends Thread {

	public Wife(String name) {
		this.setName(name);
		// super(name);
	}

	@Override
	public void run() {

		Ex03SynchMain.account.withdraw(50000);

		System.out.println(getName() + " withdraw(50000) : " + Ex03SynchMain.account.getBalance());

	}

}
