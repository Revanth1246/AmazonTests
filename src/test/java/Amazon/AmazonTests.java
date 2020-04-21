package Amazon;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utility_Scripts.Shared_Functions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import PageObjects.AmazonPageObjects;
import PageObjects.SignOutPage;
import PageObjects.SearchProductPage;

public class AmazonTests extends Shared_Functions{
	Shared_Functions SF=new Shared_Functions();
	AmazonPageObjects APO;
	SignOutPage SOP;
	SearchProductPage SPP;

@BeforeClass
public void setUp() throws Exception  {
	System.out.print("Creating HTML Results File");
	ResultFilepath=SF.CreateHTMLFile("AmazonTestResults");
	System.out.print("ResultFilepath is :"+ResultFilepath);
	SF.LaunchApp();
	
	// SF.driver.resetInputState();
		//Create HTML Folder	
}

@Test
public void AmazonLogin() throws Exception {
	try {
		APO=new AmazonPageObjects();
		Test=extent.startTest("Amazon Test Started");
		System.out.println("Reached HOme page1");
		Test.log(LogStatus.PASS,"Signin Functionality");	
		//Login to Amazon App
		Test.log(LogStatus.PASS,"Enter User Credentials");
		APO.Login();
		SF.getScreenshot(ResultFolderpath+"\\Login.png");
		Test.log(LogStatus.PASS,"Login Successful:"+Test.addScreenCapture(ResultFolderpath+"\\Login.png"));
		extent.endTest(Test);
		extent.flush();	
		
		//Search PRoduct
		SPP=new SearchProductPage();
		SPP.Search_Product();
	}
	catch(Exception e)
	{
		SF.getScreenshot(ResultFolderpath+"\\Error.png");
		Test.log(LogStatus.FAIL,e.getMessage()+" Error during Login:"+Test.addScreenCapture(ResultFolderpath+"\\Error.png"));
		extent.endTest(Test);
		extent.flush();	
	}
}

@AfterClass
public void teardown() throws InterruptedException, IOException{
	Test=extent.startTest("SignOut");	
	SOP=new SignOutPage();
	SOP.SignOut();
	try {
		SF.getScreenshot(ResultFolderpath+"\\SignOutPage.png");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Test.log(LogStatus.PASS,"Signout Successfull:"+Test.addScreenCapture(ResultFolderpath+"\\SignOutPage.png"));
	extent.endTest(Test);
	extent.flush();
}
}
