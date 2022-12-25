package testSuites;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.PG_ChooseYourPlan;

public class TS_TestSuit_01 {

	WebDriver driver;
	PG_ChooseYourPlan pg_ChooseYourPlan = new PG_ChooseYourPlan();

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shanp\\eclipse-workspace\\StcTV\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void TC_001() {
		
		pg_ChooseYourPlan.open(driver, "https://subscribe.stctv.com/");
		
		pg_ChooseYourPlan.selectLanguageAsEnglish(driver);

		String country[] = { "Bahrain", "KSA", "Kuwait" };
		for (int a = 0; a < country.length; a++) {
			if (country[a].equals("Bahrain")) {
				System.out.println("======================== Package " + country[a] + " verifications ===================");
				pg_ChooseYourPlan.selectCountry(driver, country[a]);
				
				pg_ChooseYourPlan.verifyPackage(driver, "Lite");
				pg_ChooseYourPlan.verifyPackagePriceAndCurrancy(driver, "Lite", "2", "BHD", 1);
				
				pg_ChooseYourPlan.verifyPackage(driver, "Classic");
				pg_ChooseYourPlan.verifyPackagePriceAndCurrancy(driver, "Classic", "3", "BHD", 2);
				
				pg_ChooseYourPlan.verifyPackage(driver, "Premium");
				pg_ChooseYourPlan.verifyPackagePriceAndCurrancy(driver, "Premium", "6", "BHD", 3);
			} else if (country[a].equals("KSA")) {
				System.out.println("======================== Package " + country[a] + " verifications ===================");
				pg_ChooseYourPlan.selectCountry(driver, country[a]);
				
				pg_ChooseYourPlan.verifyPackage(driver, "Lite");
				pg_ChooseYourPlan.verifyPackagePriceAndCurrancy(driver, "Lite", "15", "SAR", 1);
				
				pg_ChooseYourPlan.verifyPackage(driver, "Classic");
				pg_ChooseYourPlan.verifyPackagePriceAndCurrancy(driver, "Classic", "25", "SAR", 2);
				
				pg_ChooseYourPlan.verifyPackage(driver, "Premium");
				pg_ChooseYourPlan.verifyPackagePriceAndCurrancy(driver, "Premium", "60", "SAR", 3);
			} else if (country[a].equals("Kuwait")) {
				System.out.println("======================== Package " + country[a] + " verifications ===================");
				pg_ChooseYourPlan.selectCountry(driver, country[a]);
				
				pg_ChooseYourPlan.verifyPackage(driver, "Lite");
				pg_ChooseYourPlan.verifyPackagePriceAndCurrancy(driver, "Lite", "1.2", "KWD", 1);
				
				pg_ChooseYourPlan.verifyPackage(driver, "Classic");
				pg_ChooseYourPlan.verifyPackagePriceAndCurrancy(driver, "Classic", "2.5", "KWD", 2);
				
				pg_ChooseYourPlan.verifyPackage(driver, "Premium");
				pg_ChooseYourPlan.verifyPackagePriceAndCurrancy(driver, "Premium", "4.8", "KWD", 3);
			} else {
				System.out.println("Country is not in the List");
			}
		}
		pg_ChooseYourPlan.quiteBrowser(driver);
	}
}
