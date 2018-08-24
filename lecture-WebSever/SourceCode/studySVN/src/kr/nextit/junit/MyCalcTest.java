package kr.nextit.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MyCalcTest {

	// ; JUnit4 어노테이셔
	// @BeforeClass : 클래스 실행 전에 딱 한번
	// @AfterClass : 클래스 실행 후에 딱 한번
	// @Before : 각 @Test 실행 전에 매번 (setUp())
	// @After : 각 @Test 실행 후에 매번 (tearDown())
	// @Test : 단위 테스트 대상 메서드 명시

	private MyCalc my = null;

	@BeforeClass
	public static void befClass() {
		System.out.println(">>> befClass() Call"); // ;;;확인용
	}

	@AfterClass
	public static void aftClass() {
		System.out.println(">>> aftClass() Call"); // ;;;확인용
	}

	@Before
	public void setUp() {
		System.out.println(">>> setUp() Call"); // ;;;확인용
		my = new MyCalc();
	}

	@After
	public void tearDown() {
		System.out.println(">>> tearDown() Call"); // ;;;확인용
		my = null;
	}

	@Test
	public void testSum() {

		int r = my.sum(1, 10);
		if(r > 50) {
			fail("FAIL!");
		}

		// System.out.printf("test결과 : %d", r);
		assertEquals("test같은 값: ", 55, r);
	}

	@Test
	public void testSum2() {

		int r = my.sum(1, 100);

		assertEquals("test2같은 값: ", 5050, r);
	}

	@Test(timeout=5)
	public void testSum3() {

		int r = my.sum(1, 100);

		assertEquals("test3같은 값: ", 5050, r);
	}

	@Test(expected=RuntimeException.class)
	public void testSum4() {

		int r = my.sum(-3, 100);

		assertEquals("test4같은 값: ", 5050, r);
	}

	@Ignore
	@Test(timeout=5)
	public void testSum5() {

		int r = my.sum(1, 100);

		assertEquals("test5같은 값: ", 5050, r);
	}

}
