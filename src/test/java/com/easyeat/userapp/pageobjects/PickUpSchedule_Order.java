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

public class PickUpSchedule_Order {
			
		WebDriver ldriver;
		WebDriverWait wait;
		
		public PickUpSchedule_Order(WebDriver rdriver) {
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
		
		@FindBy(xpath = "//*[contains( text(),'PickUp')]")
		@CacheLookup
		public
		WebElement verify_ordertype;
		
		@FindBy(xpath = "//*[contains( text(),'CHANGE')]")
		@CacheLookup
		public
		WebElement change_ordertype;
		
		@FindBy(xpath = "//*[@id='order_type']/div[3]")
		@CacheLookup
		public
		WebElement select_pickup;
		
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
		
		@FindBy(xpath = "//*[@id='menuModalItems1']")
		@CacheLookup
		public
		WebElement select_menucatgry;
		
		@FindBy(xpath = "//span[normalize-space()='Lunch Special']")
		@CacheLookup
		public
		WebElement menu;
		
		//@FindBy(xpath = "//*[@class='my-1']//following::button[@class='addToCart ']")
		@FindBy(xpath = "//*[@id='4e22b52d35b8468e8394e11bd498ae1f']/div/div[3]/div[2]/div/button")
		@CacheLookup
		public
		WebElement select_item;
		
		@FindBy(xpath = "//*[@id='cartFooter']/div/div[2]")
		@CacheLookup
		public
		WebElement click_viewcart;
		
		@FindBy(xpath = "//*[@id='cartFooter']/div/div[2]/div")
		@CacheLookup
		public
		WebElement click_logintopay;
		
		@FindBy(xpath = "//*[@id='root']/div/div/div[4]/div/input")
		@CacheLookup
		WebElement enter_phoneno;
		
		@FindBy(xpath = "//*[@id='root']/div/div/button")
		@CacheLookup
		public
		WebElement click_signin;
		
		@FindBy(xpath = "//*[contains(text(),'Proceed To Pay')]")
		@CacheLookup
		public
		WebElement proceedtopay;
		
		@FindBy(xpath = "//*[@id='panel1a-header']/div[2]/span[1]")
		@CacheLookup
		WebElement select_others;
		
		@FindBy(xpath = "//*[@id='panel1a-content']/div/div[1]/div/div")
		@CacheLookup
		WebElement select_online;
		
		@FindBy(xpath = "//*[@id='panel1a-content']/div/div[3]/div[2]/div[2]/div[2]/div/div")
		@CacheLookup
		WebElement click_proceed;
		
		@FindBy(xpath = "//*[contains(text(),'HSBC')]")
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
		
		@FindBy(xpath = "//*[@id='fpx_form']/div/div/div[2]/div/button")
		@CacheLookup
		WebElement request_tac;

		@FindBy(xpath = "//*[@class='otp']")
		@CacheLookup
		WebElement copy_tac;
		
		@FindBy(xpath = "//*[@id='otp-input']")
		@CacheLookup
		WebElement paste_tac;
		
		@FindBy(xpath = "//button[text()='Pay Now']")
		@CacheLookup
		WebElement click_paynow;
		
		@FindBy(xpath = "//*[@id='root']/div/div/div/div[5]/div[1]")
		@CacheLookup
		public
		WebElement verify_orderType_statuspage;
		
		@FindBy(xpath = "//*[@id='root']/div/div/div/div[8]/div[1]")
		@CacheLookup
		public
		WebElement verify_orderType_scheduledstatuspage;
		
		
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
