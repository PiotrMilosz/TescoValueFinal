package TescoValueVer3.TescoButter;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.TescoEZakupy;
import Pages.TescoMain;
import io.appium.java_client.android.AndroidDriver;

public class AppiumDriverBase {

	protected AndroidDriver driver;
	public TescoMain mainT;
	public TescoEZakupy eZakupy;

	@BeforeClass
	protected void createAppiumDriver() throws MalformedURLException {

		driver = DriverHandler.getDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		mainT = new TescoMain(driver);
		eZakupy = new TescoEZakupy(driver);
	
	}

	@AfterClass
	public void afterTest() {

		driver.quit();
	}

}
