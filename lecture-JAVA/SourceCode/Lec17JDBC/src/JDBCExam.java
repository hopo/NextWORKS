import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
# 찾아라 ojdc6.jar
/u01/app/oracle/product/11.2.0/xe/jdbc/lib

# 찾아라 기본 jar
/usr/lib/jvm/java-8-oracle/jre/lib/

# but project lib에다가 설치 합니다.


# project에 lib을 만들고 jdbc6을 카피한다

# project 우클릭
BuildPath -> libraries -> add jar

# restart eclipse
*/

public class JDBCExam {

	public static void main(String[] args) throws IOException {

		// ! #1 oracle 드라이버 로딩
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공.");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// ! #2 데이터베이스 연결
		Connection conn = null;

		// ex) “jdbc:oracle:thin:@127.0.0.1:1521:SID“
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "java";
		String password = "oracle";

		Statement stmt = null;	// ; 정적쿼리에 적합하다
		PreparedStatement pstmt = null;	// ; 동적쿼리
		
		String query = null;

		try {

			// ! 커넥션 객체 생성(BD connecting)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("커넥션 성공.");

			// ! #3 쿼리 실행
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			// ; 값을 입력 받습니다
			System.out.print("ID: ");
			String id = reader.readLine();

			System.out.print("PASS: ");
			String pwd = reader.readLine();

			System.out.print("NAME: ");
			String name = reader.readLine();

			System.out.print("PHONE: ");
			String phone = reader.readLine();

			System.out.print("EMAIL: ");
			String email = reader.readLine();
			
			// !! 회원등록
			// ;; pstmt
			query = " INSERT INTO TB_MEMBER ( "
					+ " MEM_ID, "
					+ " MEM_PWD, "
					+ " MEM_NAME, "
					+ " MEM_PHONE, "
					+ " MEM_EMAIL, "
					+ " REG_DATE "
					+ " ) VALUES ( "
					+ " ?, "
					+ " ?, "
					+ " ?, "
					+ " ?, "
					+ " ?, "
					+ " SYSDATE ) ";

			// !! 기준 쿼리 생성
			pstmt = conn.prepareStatement(query); // ;; 기준쿼리를 먼저 받아놓는다

			// !! 데이터 바인딩.
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			
			int updCnt = pstmt.executeUpdate(); // ;; INSERT 문
			System.out.println(updCnt + " 명이 정상 등록 되었습니다.");
			
			// ;; stmt
			query = "SELECT "
					+ "		mem_id, "
					+ "		mem_pwd, "
					+ "		mem_name, "
					+ "		mem_phone, "
					+ "		mem_email, "
					+ "		reg_date "
					+ " FROM "
					+ "		tb_member "; 
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query); // ;; SELECT 문. 실행할때 쿼리를 받는다
			
			System.out.println("=============== 회원목록 ===============");
			System.out.println("아이디\t 비밀번호\t 이름\t 전화번호\t 이메일\t 가입일자\t");
			
			while(rs.next()) {
				String mem_id = rs.getString("mem_id"); // ;배열이 아님. 첫번째(1) but 필드명으로 콜
				String mem_pwd = rs.getString("mem_pwd");
				String mem_name = rs.getString("mem_name");
				String mem_phone = rs.getString("mem_phone");
				String mem_email = rs.getString("mem_email");
				String reg_date = rs.getString("reg_date");
				System.out.printf("%s\t %s\t %s\t %s\t %s\t %s\n",
							mem_id, mem_pwd, mem_name, mem_phone, mem_email, reg_date);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ! #4 연결 종료
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
