package Testcases;    

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestScenario1 {

	String Status="";
	Page page;

	@Parameters({"Browser","Platform","BrowserVersion"})
	@BeforeMethod
	public void setUpGrid(String Browser,String Platform,String BrowserVersion)
	{
		JsonObject capabilities=new JsonObject();
		JsonObject ltoptions= new JsonObject();
		String userName="anuradha.bartondegmail";
		String accessKey="Go6XUtGVRW8Re0nxveqUtGQjpEzm4oGsqUiUHqYeUOX6kpvA5r";
		capabilities.addProperty("browserVerion", BrowserVersion);
		capabilities.addProperty("browserName", Browser);
		ltoptions.addProperty("user", userName);
		ltoptions.addProperty("accessKey", accessKey);
		ltoptions.addProperty("name", "PlaywrightDemo");
		ltoptions.addProperty("build", "PlaywrightDemo");
		ltoptions.addProperty("platform", Platform);	
		ltoptions.addProperty("visual", true);
		ltoptions.addProperty("video", true);
		ltoptions.addProperty("network", true);
		capabilities.add("LT:options", ltoptions);

		Playwright playwright=Playwright.create();
		BrowserType chromium=playwright.chromium();
		String caps="";
		try {
			caps = URLEncoder.encode(capabilities.toString(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cdpUrl="wss://cdp.lamdatest.com/playwright?capabilities="+caps;
		Browser browser=chromium.connect(cdpUrl);
		page=browser.newPage();
		page.navigate("https://www.duckduckgo.com");
		Locator locator=page.locator("[name='q']");
		locator.fill("lamdatest");
		page.keyboard().press("Enter");
		String title=page.title();
		Assert.assertEquals(title, "LambdaTest at DuckDuckGo", "Title is wrong");
		browser.close();
		page.close();
		playwright.close();
		
		//to upload file on Cloud grid
		//driver.setFileDetector(new LocalFileDetector());
	}

	@Test(timeOut=30000)
	public void softAssertDemoTest()
	{  
		
	}
	@AfterMethod
	public void tearDown()
	{

	}
}

