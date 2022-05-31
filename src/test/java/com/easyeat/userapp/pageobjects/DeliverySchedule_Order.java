package com.easyeat.userapp.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliverySchedule_Order {
			
		WebDriver ldriver;
		WebDriverWait wait;
		
		public DeliverySchedule_Order(WebDriver rdriver) {
			 ldriver=rdriver;
			 PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath = "//*[contains( text(),'How to Order')]")
		@CacheLookup
		public
		WebElement verify_onboardingscreen;
		
		@FindBy(xpath = "//*[contains( text(),'START ORDERING')]")
		@CacheLookup
		public
		WebElement click_startordering;
		
		@FindBy(xpath = "//*[@class='h5']")
		@CacheLookup
		public
		WebElement verify_restaurant;
		
		@FindBy(xpath = "//*[contains( text(),'Delivery')]")
		@CacheLookup
		public
		WebElement verify_ordertype;
		
		@FindBy(xpath = "//*[contains( text(),'CHANGE')]")
		@CacheLookup
		public
		WebElement change_ordertype;
		
		@FindBy(xpath = "//*[contains( text(),' Custom Date Time')]")
		@CacheLookup
		public
		WebElement click_scheduledordertime;
		
		@FindBy(xpath = "//*[contains( text(),'Continue')]")
		@CacheLookup
		public
		WebElement click_continue;
		
		@FindBy(xpath = "//*[contains( text(),'Save')]")
		@CacheLookup
		public
		WebElement click_save;
		
		@FindBy(xpath = "//*[contains( text(),'OPEN MENU')]")
		@CacheLookup
		public
		WebElement click_openmenu;
		
		@FindBy(xpath = "//div[@class='modalBody modal-body']//div[@class='innerDiv']//div")
		@CacheLookup
		public
		WebElement select_menucatgry;
		
		@FindBy(xpath = "//span[normalize-space()='Chicken Platter']")
		@CacheLookup
		public
		WebElement menu;
		
		//@FindBy(xpath = "//*[@class='my-1']//following::button[@class='addToCart ']")
		@FindBy(xpath = "//*[@id='088c8925033d420f9747e8b7a1a459be']/div/div[3]/div[2]/div/button")
		@CacheLookup
		public
		WebElement select_item;
		
		@FindBy(xpath = "//div[contains(text(),'View Cart')]")
		@CacheLookup
		public
		WebElement click_viewcart;
		
		@FindBy(xpath = "//div[@class='fw-600 cartFooterDetailIcon']")
		@CacheLookup
		public
		WebElement verify_cartstatus;
		
		@FindBy(xpath = "//div[@class='whitebutton']")
		@CacheLookup
		public
		WebElement click_logintopay;
		
		@FindBy(xpath = "//input[@class=' form-control']")
		@CacheLookup
		WebElement enter_phoneno;
		
		@FindBy(xpath = "//*[contains(text(),'Sign In')]")
		@CacheLookup
		public
		WebElement click_signin;
		
		@FindBy(xpath = "//*[contains(text(),'Proceed To Pay')]")
		@CacheLookup
		public
		WebElement proceedtopay;
		
		@FindBy(xpath = "//div[@class='MuiAccordionSummary-content']")
		@CacheLookup
		WebElement select_others;
		
		@FindBy(xpath = "//div[contains(text(),'Online Banking - FPX')]")
		@CacheLookup
		WebElement select_online;
		
		@FindBy(xpath = "//div[@class='mb-0 fw-600 d-flex align-items-center justify-content-center text-capitalize']")
		@CacheLookup
		WebElement click_proceed;
		
		@FindBy(xpath = "//input[@value='fpx_amb']")
		@CacheLookup
		WebElement select_bank;
		
		@FindBy(xpath = "//*[@id='txtUsername']")
		@CacheLookup
		WebElement setusername;
		
		@FindBy(xpath = "//*[@id='txtPassword']")
		@CacheLookup
		WebElement setpassword;
		
		@FindBy(xpath = "//*[@id='login-btn']")
		@CacheLookup
		WebElement click_login;
		
		@FindBy(xpath = "//button[@name='pay']")
		@CacheLookup
		WebElement request_tac;

		@FindBy(xpath = "//*[@class='otp']")
		@CacheLookup
		WebElement copy_tac;
		
		@FindBy(xpath = "//*[@id='otp-input']")
		@CacheLookup
		WebElement paste_tac;
		
		@FindBy(xpath = "//button[@class='pay-btn']")
		@CacheLookup
		WebElement click_paynow;
		
		@FindBy(xpath = "//*[contains(text(),'Order Placed')]")
		@CacheLookup
		public WebElement verify_orderstatus;
		
		@FindBy(xpath = "//button[contains(text(),'Done')]")
		@CacheLookup
		public WebElement click_done;
		
		@FindBy(xpath = "//div[@class='col-12 fw-600 fs-18 px-1 appHeader']")
		@CacheLookup
		public
		WebElement verify_orderType_statuspage;
		
		@FindBy(xpath = "//*[@id='root']/div/div/div/div[8]/div[1]")
		@CacheLookup
		public
		WebElement verify_orderType_scheduledstatuspage;
		
		@FindBy(xpath = "//img[@alt='goBack']")
		@CacheLookup
		public WebElement click_back;
		
		
		public String verify_text(WebElement text) {
			  return text.getText();
				
			}
		
	    public void click(WebElement click) {
		click.click();
	    }
		
		
		public void select_action(WebElement mouse_click) {
			Actions actions = new Actions(ldriver);
		    Action action=actions.moveToElement(mouse_click).click().build();
			action.perform();
		}

		
		public void enter_phoneno(String phnum) {
			Actions actions = new Actions(ldriver);
		    Action action=actions.moveToElement(enter_phoneno).click().build();
			action.perform();
			enter_phoneno.sendKeys(phnum);
		}
		
		public void select_onlinefpx(String uname,String pwd ) throws InterruptedException {
			JavascriptExecutor jse=(JavascriptExecutor) ldriver;
			//jse.executeScript("arguments[0].scrollIntoView(true);", select_others);
			Actions actions = new Actions(ldriver);
			Action action_select_others=actions.moveToElement(select_others).click().build();
		    action_select_others.perform();
			jse.executeScript("arguments[0].scrollIntoView(true);", select_online);
			select_online.click();
			Thread.sleep(2000);
			Action action_selectbank=actions.moveToElement(select_bank).click().build();
		    action_selectbank.perform();
		   
		    Action action_proceed=actions.moveToElement(click_proceed).click().build();
		    action_proceed.perform();
		    Thread.sleep(3000);
		    setusername.sendKeys(uname);
		    setpassword.sendKeys(pwd);
		    click_login.click();
		    jse.executeScript("arguments[0].scrollIntoView(true);", request_tac);
			request_tac.click();String get_otp=copy_tac.getText();
			String otp=get_otp.split("TAC")[1].replaceAll("[^0-9]", "");
			paste_tac.sendKeys(otp);
			jse.executeScript("arguments[0].scrollIntoView(true);", click_paynow);
			click_paynow.click();
	
		}

		

		
		
}
