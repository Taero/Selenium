package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basics.AbstractPageObject;

public class CreateNewAccount extends AbstractPageObject{	
	@FindBy(className="loginText")
	protected WebElement loginName;
	@FindBy(id="wpPassword2")
	protected WebElement password;
	@FindBy(id="wpRetype")
	protected WebElement retypePassword;
	@FindBy(name="wpCaptchaWord")
	protected WebElement captchaInputBox;
	@FindBy(name="wpCreateaccount")
	protected WebElement createAccountButton;
	
	public CreateNewAccount(WebDriver driver) {
		super(driver);
	}
		
	public void enterLoginName(String name) {
		loginName.sendKeys(name);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void enterConfirmPassword(String pass) {
		retypePassword.sendKeys(pass);
	}
	public void enterCaptcha(String value) {
		captchaInputBox.sendKeys(value);
	}
	
	public CreateNewAccount clickCreateNewUser() {
		createAccountButton.click();
		return PageFactory.initElements(driver, CreateNewAccount.class);
	}
	
	public boolean hasError() {
		try {
			driver.findElement(By.className("errorbox"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}	
}