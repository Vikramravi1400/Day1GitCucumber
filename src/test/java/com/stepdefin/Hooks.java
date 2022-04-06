package com.stepdefin;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.libbase.LibGlobal;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends LibGlobal {

	@Before
	public void before(Scenario sc) {
		System.out.println("Before");

		String name = sc.getName();
		System.out.println(name);

		getDriver();
	}

	@After
	public void after(Scenario sc) {
		System.out.println("After");
		boolean failed = sc.isFailed();
		System.out.println(failed);

		if (failed) {
			TakesScreenshot tk = (TakesScreenshot) driver;
			byte[] screenshotAs = tk.getScreenshotAs(OutputType.BYTES);
			sc.embed(screenshotAs, "Fb/png");

		}

		closeBrowser();
	}

}
