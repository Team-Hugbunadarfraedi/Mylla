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

public class SeleniumTestPlayerWinIT {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = System.getenv("STAGING_SERVER");
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPlayerWinIT() throws Exception {
		selenium.open("/index.html");
		assertEquals("", selenium.getText("id=0"));
		assertEquals("", selenium.getText("id=1"));
		assertEquals("", selenium.getText("id=2"));
		assertEquals("", selenium.getText("id=3"));
		assertEquals("", selenium.getText("id=4"));
		assertEquals("", selenium.getText("id=5"));
		assertEquals("", selenium.getText("id=6"));
		assertEquals("", selenium.getText("id=7"));
		assertEquals("", selenium.getText("id=8"));
		assertEquals("Player 1's turn", selenium.getText("id=Player"));
		selenium.click("id=0");
		selenium.click("id=1");
		selenium.click("id=2");
		assertEquals("X", selenium.getText("id=0"));
		assertEquals("O", selenium.getText("id=1"));
		assertEquals("X", selenium.getText("id=2"));
		selenium.selectWindow("null");
		selenium.click("id=4");
		selenium.click("id=3");
		selenium.click("id=7");
		assertEquals("Player 2 wins", selenium.getText("id=results"));
		assertEquals("X", selenium.getText("id=0"));
		assertEquals("O", selenium.getText("id=1"));
		assertEquals("X", selenium.getText("id=2"));
		assertEquals("X", selenium.getText("id=3"));
		assertEquals("O", selenium.getText("id=4"));
		assertEquals("", selenium.getText("id=5"));
		assertEquals("", selenium.getText("id=6"));
		assertEquals("O", selenium.getText("id=7"));
		assertEquals("", selenium.getText("id=8"));
		assertEquals("Player 1's turn", selenium.getText("id=Player"));
		selenium.click("id=5");
		assertEquals("Player 2 wins", selenium.getText("id=results"));
		assertEquals("Player 1's turn", selenium.getText("id=Player"));
		assertEquals("Player 1's turn", selenium.getText("id=Player"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
