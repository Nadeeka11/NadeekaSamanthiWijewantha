package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commandBase.Commands;

public class PG_ChooseYourPlan extends Commands{

	By btn_SelectLanguageEnglish = By.xpath("//a[@id='translation-btn']");
	By btn_CountryName = By.xpath("//span[@id='country-name']");
	
	public void open(WebDriver driver, String URL) {
		launch(driver, URL);
	}

	public void selectLanguageAsEnglish(WebDriver driver) {
		waitTillElementLoad(driver, btn_SelectLanguageEnglish, 2000);
		click(driver, btn_SelectLanguageEnglish);
	}
	
	public void verifyPackage(WebDriver driver, String prm_PackageName) {
		waitTillElementLoad(driver, "//strong[text()='" + prm_PackageName + "']", 2000);
		driver.findElement(By.xpath("//strong[text()='" + prm_PackageName + "']"));
		System.out.println("Package " + prm_PackageName + " is available");
	}
	
	public void verifyPackagePriceAndCurrancy(WebDriver driver, String prm_PackageName, String prm_Price, String prm_Currency, int prm_index) {
		waitTillElementLoad(driver, "//strong[text()='"+prm_PackageName+"']/../../../following-sibling::div[1]/div[2]/div["+prm_index+"]", 2000);
		String var_PackagePriceDetails = getText(driver, "//strong[text()='"+prm_PackageName+"']/../../../following-sibling::div[1]/div[2]/div["+prm_index+"]");
		if (var_PackagePriceDetails.contains(prm_Price)) {
			System.out.println("Package '" + prm_PackageName + "' price is " + prm_Price);
		}else {
			System.out.println("Package '" + prm_PackageName + "' price is " + prm_Price + ". That is incorrect");
		}
		
		if (var_PackagePriceDetails.contains(prm_Currency)) {
			System.out.println("Package '" + prm_PackageName + "' currancy is " + prm_Currency);
		}else {
			System.out.println("Package '" + prm_PackageName + "' currancy is " + prm_Currency + ". That is incorrect");
		}
	}
	
	public void selectCountry(WebDriver driver, String prm_Country){
		waitTillElementLoad(driver, btn_CountryName, 2000);
		click(driver, btn_CountryName);
		waitTillElementLoad(2000);
		click(driver, "//span[contains(@id,'contry-lable') and normalize-space()='"+prm_Country+"']");
	}
	
}
