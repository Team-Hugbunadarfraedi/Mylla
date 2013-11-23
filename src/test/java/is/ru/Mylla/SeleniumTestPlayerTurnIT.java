package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class SeleniumTestPlayerTurnIT {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = System.getenv("STAGING_SERVER");
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPlayerTurnIT() throws Exception {
		selenium.open("/index.html");
		assertEquals("Player 1's turn", selenium.getText("id=Player"));
		selenium.click("id=0");
		assertEquals("Player 2's turn", selenium.getText("id=Player"));
		selenium.click("id=4");
		assertEquals("Player 1's turn", selenium.getText("id=Player"));
		selenium.click("id=1");
		assertEquals("Player 2's turn", selenium.getText("id=Player"));
		selenium.click("id=ResetGame");
		assertEquals("Player 1's turn", selenium.getText("id=Player"));
		selenium.click("id=ResetGame");
		assertEquals("Player 1's turn", selenium.getText("id=Player"));
		selenium.click("id=ResetGame");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
