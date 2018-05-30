import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex01InetAddress {

	public static void main(String[] args) throws UnknownHostException {

		// !
		System.out.println("===== Local System Info =====");

		InetAddress local = InetAddress.getLocalHost();

		System.out.println("getHostName(): " + local.getHostName());
		System.out.println("getHostAddress(): " + local.getHostAddress());
		System.out.println("getLoopbackAddress(): " + local.getLoopbackAddress());

		// ! 1
		System.out.println("\n===== Remote System Info =====");

		InetAddress remote = InetAddress.getByName("www.naver.com");

		System.out.println("getHostName(): " + remote.getHostName());
		System.out.println("getHostAddress(): " + remote.getHostAddress());
		System.out.println("getLoopbackAddress(): " + remote.getLoopbackAddress());

		// ! 2
		System.out.println("\n===== Remote System Info 2 =====");

		InetAddress[] remotes = InetAddress.getAllByName("www.naver.com");

		for (InetAddress r : remotes) {
			System.out.println("getHostName(): " + r.getHostName());
			System.out.println("getHostAddress(): " + r.getHostAddress());
		}

	}

}
