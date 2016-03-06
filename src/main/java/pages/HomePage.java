package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basics.AbstractPageObject;

public class HomePage extends AbstractPageObject{	
	@FindBy(linkText="Tekst źródłowy")
	private WebElement sourceTextTab;
//	@FindBy(linkText="Tekst źródłowy")
//	private WebElement sourceTextTab;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
	}
		
	public TextSourcePage clickSourceText() {
		sourceTextTab.click();
		return PageFactory.initElements(driver, TextSourcePage.class);
	}
	
	public HomePage clickReadMe() {
		readThisTab.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
//	public FindOwnersPage clickFindOwner() {
//		findOwner.click();
//		return PageFactory.initElements(driver, FindOwnersPage.class);
//	}
	
}
