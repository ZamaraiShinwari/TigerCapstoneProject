package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import core.Base;
import io.cucumber.java.Scenario;

public class Utils extends Base {
	public static Scenario verify;
	public static void hoveMouseOverElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public static String getTextFromUI(WebElement element) {
		String textFromUI = element.getText();
		return textFromUI;
	}

	public static void clickOnRadioButton(WebElement element) {
		try {
			if (element.isDisplayed() == true && element.isEnabled() == true && element.isSelected() == false) {
				element.click();
			} else {
				System.out.println("One of the conditions did not return expected value");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickOnCheckBoxButton(WebElement element) {
		try {
			if (element.isDisplayed() == true && element.isEnabled() == true && element.isSelected() == false) {
				element.click();
			} else {
				System.out.println("One of the conditions did not return expected value");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void takeScreenShot(String screenshotName) throws IOException {
//
//		String path = ".\\output\\screenshots\\";
//
//		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//		try {
//			FileUtils.copyFile(file, new File(path + screenshotName + ".png"));
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("takeScreenshot: => Exception was throw during execution");
//		}
//	}
	
	public static void takeScreenShot() {

		String location = System.getProperty("user.dir") + "\\output\\screenshots\\";
		String screenShotFileName = screenShotName() + ".png";

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File(location + screenShotFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in execution");
		}

	}

	public static String screenShotName() {

		Date date = new Date();
		String screenShot = date.toString().replace(":", "_").replace(" ", "_");
		return screenShot;

	}

	public static void clickWithJSE(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void highlightelementRedBorder(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
	}

	public static void highlightelementBackground(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.background='yellow'", element);
	}

	public static void highlightelementBorderAndBackground(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}

	public static void scrolldownPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, 1000)");

	}

	public static void sendKeys(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "'", element);
	}

	
	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}


	public static void switchToWindow() {
		Set<String> WindowsHandles = driver.getWindowHandles();
		Iterator<String> it = WindowsHandles.iterator();
		String window = it.next();
		driver.switchTo().window(window);
	}

	
	public static String getText(WebElement ele) {
		String ElementText = ele.getText();
		return ElementText;
	}

	
	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, targetElement).perform();

	}

//	public static void takeScreenshotForStep() {
//		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		verify.attach(screenshot, "image/png", "Step Screenshot");
//	}

}