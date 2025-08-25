package com.selenium_testng.day28;

import org.testng.annotations.*;

public class testngAnnotations {
	@BeforeClass
	void a() {
		System.out.println("Before Class");
	}

	@BeforeSuite
	void a2() {
		System.out.println("Before Suite");

	}

	@AfterClass
	void a3() {
		System.out.println("After Class");
	}

	@AfterSuite
	void a4() {
		System.out.println("After Suite");
	}

	@Test
	void a5() {
		System.out.println("Test ");
	}

	@BeforeMethod
	void a6() {
		System.out.println("Before Method");
	}

	@AfterMethod
	void a7() {
		System.out.println("After Method");
	}

	@AfterTest
	void a8() {
		System.out.println("After Test");

	}

	@BeforeTest
	void a9() {
		System.out.println("Before Test");

	}

}
