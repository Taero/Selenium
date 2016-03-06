package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import basics.AbstractPageObject;

public class ArticlePage extends AbstractPageObject {

	public ArticlePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public String getFirstHeadingText() {
		WebElement h1 = driver.findElement(By.id("firstHeading"));
//		System.out.println("h1.getTagName() : " + h1.getTagName());
//		System.out.println("h1.getText() : " + h1.getText());
//		System.out.println("h1.toString() : " + h1.toString());
		return h1.getText();
	}
	
}
