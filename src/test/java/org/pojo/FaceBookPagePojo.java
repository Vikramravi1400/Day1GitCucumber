package org.pojo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libbase.LibGlobal;
import com.stepdefin.Hooks;

public class FaceBookPagePojo extends LibGlobal {
	public FaceBookPagePojo() {
		PageFactory.initElements(Hooks.driver, this);	
		}
		
		@FindBy(id="email")
		private WebElement txtBoxUser;
		
		@FindBy(id="pass")
		private WebElement txtBoxpass;
		
		@FindBy(name="login666")
		private WebElement btnLogIn;

		public WebElement getTxtBoxUser() {
			return txtBoxUser;
		}

		public WebElement getTxtBoxpass() {
			return txtBoxpass;
		}

		public WebElement getBtnLogIn() {
			return btnLogIn;
		}



}
