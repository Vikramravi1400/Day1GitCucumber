package com.stepdefin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.pojo.FaceBookPagePojo;

import com.libbase.LibGlobal;

import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;

public class FaceBookPageStep_Def extends LibGlobal{
	@Given("User launch the browser")
	public void user_launch_the_browser() {
	
	}

	@Given("User enters the URL")
	public void user_enters_the_URL() {
		getUrl("https://www.facebook.com/");
	}

	@When("User enters the username and password")
	public void user_enters_the_username_and_password(DataTable table) throws IOException {
		FaceBookPagePojo f = new FaceBookPagePojo();
	  List<Map<String,String>> asMaps = table.asMaps();
	  Map<String, String> map = asMaps.get(0);
	      String string = map.get("userName");
	      String string2 = map.get("password");
	      System.out.println(string+" - "+string2);
	  
	
	
	insertValue(f.getTxtBoxUser(),string );
	insertValue(f.getTxtBoxpass(),string2);
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		FaceBookPagePojo f = new FaceBookPagePojo();
           click(f.getBtnLogIn());
	}
	@Then("User navigates to login failure page")
	public void user_navigates_to_login_failure_page() throws InterruptedException {
		Pause(2000);
		String currentUrl = getCurrentUrl();
		Assert.assertTrue("not navigated to login failure page", currentUrl.contains("login"));
		
		
	}
    /*
	@When("User enters the {string} and {string}")
	public void user_enters_the_and(String userName, String password) throws InterruptedException {
		FaceBookPagePojo f = new FaceBookPagePojo();
		insertValue(f.getTxtBoxUser(),userName);
		insertValue(f.getTxtBoxpass(),password);
	*/	
		
		
	}

	

