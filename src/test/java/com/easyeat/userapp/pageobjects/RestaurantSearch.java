package com.easyeat.userapp.pageobjects;



import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RestaurantSearch {
	
	WebDriver ldriver;
	
	public RestaurantSearch(WebDriver rdriver) {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//*[@id='homeRestaurantSearchInput']")
	@CacheLookup
	WebElement enter_restaurantName;

	@FindBy(xpath = "//*[@class='mr-2 ml-2']//div/descendant::div[@class='row   ']")
	@CacheLookup
	List <WebElement>  select_restaurant;
	
	@FindBy(xpath = "//*[@class='row   ']")
	@CacheLookup
	WebElement  restaurant;
	
	@FindBy(xpath = "//*[contains(text(),'Restaurants not found.')]")
	@CacheLookup
	WebElement  restaurant_notfound;
	
	
	public void setrestaurantSearch(String rname) {
		enter_restaurantName.sendKeys(rname);
	}
	
	public void selectrestaurant(String rname) {
	    for(int i=0; i< select_restaurant.size(); i++) {
	    	String listitem=select_restaurant.get(i).getText();
	    	if (listitem.contains(rname)) {
	    		try {
	    			Actions actions = new Actions(ldriver);
	    		    Action action=actions.moveToElement(restaurant).click().build();
	    			action.perform();
	    		}
	    			catch (Exception e) {
	    				System.out.println(e);
	    			}	
			}
	    	else {
				String rest_notfound=restaurant_notfound.getText();
				System.out.println(rest_notfound);
			}
	    }
	}
	
	
	public void restaurant_notfound(String rname) {
		restaurant_notfound.getText();
		
	}
	
	
}

	
