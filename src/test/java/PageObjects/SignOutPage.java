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
import PageObjects.AmazonPageObjects;

public class SignOutPage extends Shared_Functions {
	
	Shared_Functions SF=new Shared_Functions();
	AmazonPageObjects APO=new AmazonPageObjects();
	//**** Landing Page ****/
	
		// SignIn Button
		
		 @AndroidFindBy(id="com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
		 AndroidElement SignOut_Menu_btn;
		 
		 //// Email Textbox
		
		 @AndroidFindBy(xpath="//*[@resource-id='com.amazon.mShop.android.shopping:id/anp_drawer_item' and @instance='33']")
		 AndroidElement Settings;
		 
		 //// SignOut button on Email page
			
		 @AndroidFindBy(xpath="//*[@text='Not Test? Sign out']")
		 AndroidElement SignOut_btn;
		 
		 //// Signout page
		 
		
		 @AndroidFindBy(xpath="//*[@text='SIGN OUT']")
		 AndroidElement SignOut;
		
		//************************************
			//*****	Page Factory Initialization *****
			//*************************************
			    public SignOutPage(){

			        this.driver = SF.driver;
			        //This initElements method will create all WebElements

			        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			        System.out.println("Completed Init");
			        

			    }
			    
			    public void SignOut() throws InterruptedException, IOException
			    {
			    	System.out.println("Revched SignOut");
			    	driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
			    	SF.driver_Wait(SignOut_Menu_btn);
			    	SignOut_Menu_btn.click();
			    	System.out.println("Clicked SignOut");
			    	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			    	SF.getScreenshot(ResultFolderpath+"\\HamburgerMenuPage.png");
					Test.log(LogStatus.PASS,"Clicked on HamburgerMenu successfully:"+Test.addScreenCapture(ResultFolderpath+"\\HamburgerMenuPage.png"));
			    	SF.Slide(Settings);
			    	Settings.click();
			    	SF.driver_Wait(SignOut_btn);
			    	SF.getScreenshot(ResultFolderpath+"\\SignOutLinkPage.png");
					Test.log(LogStatus.PASS,"Clicking on SignOut:"+Test.addScreenCapture(ResultFolderpath+"\\SignOutLinkPage.png"));
			    	SignOut_btn.click();
			    	SF.driver_Wait(SignOut);
			    	SignOut.click();
			    	SF.driver_Wait(APO.SignIN_btn);
			    	System.out.println("Signout Successful");
			    	
			    }
			    
			    
}
