//package com.example.tests;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class LoginRC {
	@Before
	public void setUp() throws Exception {
		DefaultSelenium selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.palaoo.com/");
		selenium.start();
	}

	@Test
	public void testLoginRC() throws Exception {
		DefaultSelenium selenium = null;
		selenium.open("/pkm/index.jsp");
		selenium.click("link=로그인");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=emailName", "testqa06");
		selenium.type("id=email_domain", "infraware.co.kr");
		selenium.type("id=passwd", "infra12");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=로그아웃");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		DefaultSelenium selenium = null;
		selenium.stop();
	}
}
