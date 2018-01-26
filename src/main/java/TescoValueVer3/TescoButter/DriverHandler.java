package TescoValueVer3.TescoButter;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Hello world!
 *
 */
public class DriverHandler {

	public static AndroidDriver getDriver() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("deviceName", "ANDROID");
		caps.setCapability("platformName", "Android");

		return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
	}
}
