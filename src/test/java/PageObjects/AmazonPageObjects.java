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
public class AmazonPageObjects extends Shared_Functions{
Shared_Functions SF;
	
	//**** Landing Page ****/
	
	// SignIn Button
	
	 @AndroidFindBy(id="com.amazon.mShop.android.shopping:id/sign_in_button")
	 AndroidElement SignIN_btn;
	 
	 //// Email Textbox
	
	 @AndroidFindBy(id="ap_email_login")
	 AndroidElement Email_Editbox;
	 
	 //// Continue button on Email page
		
	 @AndroidFindBy(id="continue")
	 AndroidElement Continue_EmailBtn;
	 
	 //// Password Editbox on Email page
		
	 @AndroidFindBy(id="ap_password")
	 AndroidElement Password_Editbox;
	 
	 //// SignIn button on Password page
		
	 @AndroidFindBy(id="signInSubmit")
	 AndroidElement SignIN_PwdBtn;
	 
	 
	  //**** Welcome Page ****/
	 
	 //Search button
	 
	 @AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	 AndroidElement Search_Editbox;
	 
	 
	 //select the product
	
	 @AndroidFindBys({@AndroidBy(id="com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")})
	 List<AndroidElement> Search_Results_product;

	 
	 
	 //Search results
	 @AndroidBy(xpath="//*[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_suggestions' and @index='1']")
	 AndroidElement Search_Results;
	 
	 
	 
	 // iew in your room
	 
	 @AndroidFindBy(id="fezLauncherLink-announce")
	 AndroidElement View_In_your_room;
	
	 // Samsung TV
	 
	 @AndroidFindBys(@AndroidBy(xpath="//*[contains(@text,'Samsung QN65Q60RAFXZA')]"))
	 List<AndroidElement> Product_Samsung;
	
	
	//************************************
	//*****	Page Factory Initialization *****
	//*************************************
	    public AmazonPageObjects(){

	        this.driver = SF.driver;
	        //This initElements method will create all WebElements

	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	        System.out.println("Completed Init");	        

	    }
	    
	    public void Login() throws IOException
	    {
	    	//Get username and password from configuration file
	    	String username=SF.GetFileValue("username");
	    	String password=SF.GetFileValue("password");	    
	    	//Thread.sleep(10000);
	    	SF.driver_Wait(SignIN_btn);
	    	//SF.Webdriver_Wait(By.id("com.amazon.mShop.android.shopping:id/sign_in_button"));
	    	System.out.println("Reached HOme page");
	    	WebElement element=SF.driver.findElement(By.id("com.amazon.mShop.android.shopping:id/sign_in_button"));
	    	SF.Click_Element(SignIN_btn);
	    
	    	SF.driver_Wait(Email_Editbox);
	    	SF.SendKeys(Email_Editbox,username);
//	    	SF.getScreenshot(ResultFolderpath+"\\UsernamePage.png");
//			Test.log(LogStatus.PASS,"Username Page:"+Test.addScreenCapture(ResultFolderpath+"\\UsernamePage.png"));
//	    	//SF.Click_Element(Continue_EmailBtn);
//			extent.flush();
			System.out.println("Entered Username");
			SF.driver_Wait(Continue_EmailBtn);
	    	Continue_EmailBtn.click();
	    	SF.driver_Wait(Password_Editbox);
	    	SF.SendKeys(Password_Editbox,password);
	    	SF.getScreenshot(ResultFolderpath+"\\PasswordPage.png");
			Test.log(LogStatus.PASS,"Password Page:"+Test.addScreenCapture(ResultFolderpath+"\\PasswordPage.png"));
			extent.flush();
	    	SF.driver_Wait(SignIN_PwdBtn);	    	
	    	SF.Click_Element(SignIN_PwdBtn);
	    	SF.driver_Wait(Search_Editbox);
	    	SF.getScreenshot(ResultFolderpath+"\\WelcomePage.png");
			Test.log(LogStatus.PASS,"Welcome Page displayed successfully:"+Test.addScreenCapture(ResultFolderpath+"\\WelcomePage.png"));
			extent.flush();
	    }
	    
	 
}
