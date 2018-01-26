package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

	protected final Logger Log = LoggerFactory.getLogger(getClass());

	protected final AndroidDriver driver;

	protected WebDriverWait wait;

	public BasePage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
}
