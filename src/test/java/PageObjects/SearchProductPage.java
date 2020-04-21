package PageObjects;
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.PageFactory;
import Utility_Scripts.Shared_Functions;
import io.appium.java_client.android.nativekey.AndroidKey;
public class SearchProductPage extends Shared_Functions{
	
Shared_Functions SF;
	
	//**** Landing Page ****/
	
	// Search Editbox
	
	 @AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	 AndroidElement Search_Editbox;
	 
	 //// Email Textbox
	
	 @AndroidFindBy(xpath="//*[contains(@text,'Electronics')]")
	 AndroidElement Search_option_text;
	 
	 //// Deliver to Australia 'Dont Change" option
		
	 @AndroidFindBy(id="com.amazon.mShop.android.shopping:id/left_button")
	 AndroidElement Deliver_Dont_Change_btn;
	 
	 //Explore Departments
	 
	 @AndroidFindBy(id="Explore Departments")
	 AndroidElement Explore_Departments;
	 
	 //// Search_Results_Filter on Email page
		
	 @AndroidFindBy(id="s-all-filters")
	 AndroidElement Search_Results_Filter;
	 
	 //// SignIn button on Password page
		
	 @AndroidFindBy(xpath="VIZIO M-Series Quantum 65” Class (64.5” Diag.) 4K HDR Smart TV")
	 AndroidElement VIZIO_Product;
	 
	 
	  //**** Product page ****/
	 
	 //Search button
	 
	 @AndroidFindBy(id="fezLauncherLink-announce")
	 AndroidElement Product_TryNow_btn;
	 
	//
	 @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"See All Buying Options See All Buying Options\"]")
	 AndroidElement See_All_Buying_options_btn;
	 
	//
	 @AndroidFindBy(xpath="//*[contains(@content-desc,'Add to cart')]")
	 AndroidElement Add_to_Cart_btn;
	 //
	 
	// Cart Page
	
	 @AndroidBy(id="com.amazon.mShop.android.shopping:id/action_bar_cart_image")
	 AndroidElement Cart_Icon;

	
	 
	 @AndroidBy(xpath="//android.view.View[contains(@content-desc,'Subtotal')]")
	 AndroidElement SubTotal_Price;
	 
	 @AndroidBy(xpath="//android.widget.Button[@content-desc=\"Proceed to checkout\"]")
	 AndroidElement Proceed_Checkout_Btn;
	 
	
	 
	 // Address Page
	 
	 @AndroidBy(xpath="//android.widget.Button[@content-desc=\"Deliver to this address \"]")
	 AndroidElement Deliver_To_Address_btn;
	
	 @AndroidFindBy(id="enterAddressAddressLine1")
	 AndroidElement Street_No;
	
	 // Samsung TV
	 
	 @AndroidFindBys(@AndroidBy(xpath="//*[contains(@text,'Samsung QN65Q60RAFXZA')]"))
	 List<AndroidElement> Product_Samsung;
	
	
	//************************************
	//*****	Page Factory Initialization *****
	//*************************************
	    public SearchProductPage(){

	        this.driver = SF.driver;
	        //This initElements method will create all WebElements

	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	        System.out.println("Completed Init");	        

	    }
	    public void Search_Product() throws InterruptedException
		   {
			   System.out.println("Reached Slide Product");
			   Thread.sleep(2000);
			   //SF.ScrollBottom("Revanth");
			   
			   if(Deliver_Dont_Change_btn.isDisplayed())
			   {
				   Deliver_Dont_Change_btn.click();
				   SF.driver_Wait(Search_Editbox);
			   }
				SF.SendKeys(Search_Editbox, "65-inch tv");
//				Thread.sleep(2000);
				SF.driver_Wait(Search_option_text);
				Search_option_text.click();	
				Thread.sleep(8000);
				System.out.println("LongPressed Tapped");				
				Thread.sleep(6000);
				try {
					SF.driver_Wait(Search_Results_Filter);
					}catch(Exception e)
					{
						if(Explore_Departments.isDisplayed())
						{
							SF.SendKeys(Search_Editbox, "65-inch tv");
//							Thread.sleep(2000);
							SF.driver_Wait(Search_option_text);
							Search_option_text.click();	
							Thread.sleep(8000);
						}
					}
				
				System.out.println("Reached Product results");
				Thread.sleep(5000);
				
				SF.SlideOnce();
				SF.SlideOnce();
				SF.SlideOnce();
				VIZIO_Product.click();
				SF.driver_Wait(Product_TryNow_btn);
				//Get the Product String
				String Product_desc=VIZIO_Product.getText();
				SF.SlideOnce();
				See_All_Buying_options_btn.click();
				SF.driver_Wait(Add_to_Cart_btn);
				Add_to_Cart_btn.click();
				Thread.sleep(5000);
				Cart_Icon.click();
				SF.driver_Wait(Proceed_Checkout_Btn);				
				String Checkout_price=SubTotal_Price.getText();
				
				Proceed_Checkout_Btn.click();
				SF.driver_Wait(Deliver_To_Address_btn);	
				Deliver_To_Address_btn.click();
				
				}
	    	
			
			   
			   
		   }

