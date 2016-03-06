package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.*;

public class AbstractPageObject {
	protected WebDriver driver;
	@FindBy(linkText="Historia i autorzy")
	protected WebElement authorsTab;
	@FindBy(linkText="Czytaj")
	protected WebElement readThisTab;
	@FindBy(linkText="Dyskusja")
	protected WebElement discussTab;
	@FindBy(id="searchInput")
	protected WebElement searchInput;
	@FindBy(id="searchButton")
	protected WebElement searchBaton;
	@FindBy(linkText="Utwórz konto")
	protected WebElement newAccount;
	
	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean hasError() {
		try {		//do poprawy
			driver.findElement(By.className("help-inline"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}	
	}
	
	public AuthorsPage clickAuthors() {
		authorsTab.click();
		return PageFactory.initElements(driver, AuthorsPage.class);
	}
	
	public HomePage clickReadMe() {
		readThisTab.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public DiscussPage clickDiscuss() {
		discussTab.click();
		return PageFactory.initElements(driver, DiscussPage.class);
	}

	public ArticlePage searchArticte(String search) {
		searchInput.sendKeys(search);
		searchBaton.click();
		return PageFactory.initElements(driver, ArticlePage.class);
	}
	
	public CreateNewAccount createNewAccount() {
		newAccount.click();
		return PageFactory.initElements(driver, CreateNewAccount.class);
	}

}
