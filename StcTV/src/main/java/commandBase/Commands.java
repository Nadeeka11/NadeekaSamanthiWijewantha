package commandBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commands {

	public void launch(WebDriver driver, String URL) {
		try {
			driver.get(URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void type(WebDriver driver, By element, String value) {
		try {
			driver.findElement(element).clear();
			driver.findElement(element).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(WebDriver driver, By element) {
		try {
			driver.findElement(element).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(WebDriver driver, String element) {
		try {
			driver.findElement(By.xpath(element)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void select(WebDriver driver, By element, String value) {
		try {
			Select select = new Select(driver.findElement(element));
			select.selectByVisibleText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getText(WebDriver driver, By element) {
		try {
			driver.findElement(element).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(WebDriver driver, String element) {
		try {
			return driver.findElement(By.xpath(element)).getText();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public void quiteBrowser(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitTillElementLoad(WebDriver driver, By element, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(waitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitTillElementLoad(WebDriver driver, String element, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(waitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitTillElementLoad(int waitTime){
		try {
			Thread.sleep(waitTime);
		} catch (Exception e) {
			e.printStackTrace();
	}

	}

}
