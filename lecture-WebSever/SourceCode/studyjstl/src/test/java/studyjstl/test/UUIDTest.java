package studyjstl.test;

import java.util.UUID;

public class UUIDTest {
	public static void main(String[] args) {
		int i = 0;
		while (i != 1000) {
//			System.out.println((UUID.randomUUID().toString()));
//			System.out.println((UUID.randomUUID().getLeastSignificantBits()));
			System.out.println((UUID.randomUUID().toString().length()));
			i++;
		}
	}

}
