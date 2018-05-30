import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Ex02URL {
	
	public static void main(String[] args) throws IOException {
		
		// !
		URL url = new URL("https://www.naver.com:443/index.html?user_name=san");
		
		System.out.println("protocol: " + url.getProtocol());
		System.out.println("hoset: " + url.getHost());
		System.out.println("port: " + url.getPort());
		System.out.println("path: " + url.getPath());
		System.out.println("query: " + url.getQuery());
		
		// ! URL을 통해서 자원 가져오기.
		URLConnection urlConn = url.openConnection();
		
		InputStream in = urlConn.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		int i = 1;
		while(true) {
			String html = reader.readLine();
			if(html == null) {
				break;
			}
			System.out.printf("%d ", i++);
			System.out.println(html);
		}
	}

}
