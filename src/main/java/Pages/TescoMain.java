package Pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;

public class TescoMain extends BasePage {

	@FindBy(className = "close")
	public WebElement close;
	@FindBy(className = "menu-cls-1")
	public WebElement menu;
	@FindBy(css = ".tcnh-menus [href*='ezakupy.tesco.pl']")
	public WebElement eZakupyWE;

	public TescoMain(AndroidDriver driver) {

		super(driver);
	}

	public void openPage() {

		driver.get("http://tesco.pl");
	}

	public boolean validateMainpage() {

		boolean elements = false;

		if (menu.isDisplayed()) {
			elements = true;
			Log.info("Menu is displayed correctly.");
		} else {
			elements = false;
			Log.warn("Menu is not displayed correctly!");
		}
		return elements;
	}

	public void testGoToEZakupy() {

		close.click();
		Log.info("Close button was clicked.");
		menu.click();
		Log.info("Menu button was clicked.");
		eZakupyWE.click();
		Log.info("EZakupy button was clicked.");

		// - to nie jest potrzebne, chyba ze chcialbys pozniej zrobic w tescie
		// Assert.assertEquals(OCZEKIWANY_URL, OTRZYMANY_URL)
		//WebElement eZakupy = eZakupyWE;
		//String linkEZakupy = eZakupy.getAttribute("href");
		//driver.get(linkEZakupy);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));


	}

}
