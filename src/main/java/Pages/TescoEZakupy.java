package Pages;

import java.math.BigDecimal;
import java.util.List;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class TescoEZakupy extends BasePage {

	@FindBy(className = "icon-close-white")
	public WebElement closeCookie;
	@FindBy(className = "browse-store")
	public WebElement zacznijZakupyBtn;
	@FindBy(className = "menu-tree__inner")
	public WebElement menu;
	@FindBy(id = "search-input")
	public WebElement search;
	@FindBy(xpath = "//*[@id=\"search-form\"]/button")
	public WebElement searchBtn;

	public TescoEZakupy(AndroidDriver driver) {

		super(driver);
		wait = new WebDriverWait(driver, 10);
	}

	public void goToZakupy() {

		// For debug purposes
		Log.info(driver.getCurrentUrl());

		wait.until(ExpectedConditions.elementToBeClickable(closeCookie));
		closeCookie.click();
		Log.info("Close cookie button was clicked");
		zacznijZakupyBtn.click();
		Log.info("Zacznij zakupy button was clicked");
	}

	public void search(String whatToSearch) {
		search.sendKeys(whatToSearch);
		Log.info("Search Item podane");
		searchBtn.click();
		Log.info("Search kliknięte");
	}

	public void searchClear() {
		search.clear();

	}

	public void priceVerifier() {
		List<WebElement> listOfPrices = driver.findElements(By.className("tile-content"));
		double priceDouble = 10000.00;
		String itemPrice = null;
		String butterName = null;
		for (int i = 0; i < listOfPrices.size(); i++) {
			// Cena za kg
			WebElement pricePerKgWE = listOfPrices.get(i).findElement(By.className("price-per-quantity-weight"));
			WebElement priceValueWE = pricePerKgWE.findElement(By.className("value"));
			String pricePerKgStr = priceValueWE.getText();
			String filteredString = pricePerKgStr.replaceAll(",", ".");
			double pricePerKgDouble = Double.parseDouble(filteredString);
			//Cena detaliczna
			WebElement pricePerItemWE = listOfPrices.get(i).findElement(By.className("price-control-wrapper"));
			WebElement priceValueItemWE = pricePerItemWE.findElement(By.className("value"));
			String pricePerItemStr = priceValueItemWE.getText();
			// Nazwa masała
			WebElement nameWE = listOfPrices.get(i).findElement(By.className("product-details--content"));
			WebElement nameTitle = nameWE.findElement(By.className("product-tile--title"));
			String nameStr = nameTitle.getText();

			// System.out.println(pricePerKgDouble);
			// Porównywarka
			if (priceDouble > pricePerKgDouble) {
				priceDouble = pricePerKgDouble;
				butterName = nameStr;
				itemPrice = pricePerItemStr;
			}

		}
		Log.info("Wynik to " + butterName + " w cenie "+ itemPrice +" zl, co wychodzi za sztuke/kg/litr " + priceDouble + " zl BIEREJ!!");

	}

	/*
	 * public void goToDepartment(String dataIndexInt) { List<WebElement>
	 * listOfDepartments = menu.findElements(By.tagName("a")); for (int i = 0; i <
	 * listOfDepartments.size(); i++) { String descOfDep =
	 * listOfDepartments.get(i).getAttribute("data-index"); if
	 * (dataIndexInt.equals(descOfDep)) { listOfDepartments.get(i).click();
	 * Log.info("Nabiał i jaja selected"); }
	 * 
	 * }
	 * 
	 * }
	 */

}
