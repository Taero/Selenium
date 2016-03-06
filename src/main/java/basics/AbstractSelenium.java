package basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;

@RunWith(SeleniumScreenshotJUnit4Runner.class)
public class AbstractSelenium {
	protected WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "c:\\projects\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);				
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("init.accept_languages", "en,pl,de");
	}
	
	public HomePage initializeHomePage() {
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public void takeScreenshot() throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\projects\\starterkitz\\workspace\\starterkit\\Selenium\\testScreenshots"+screenshot.getName());
		FileUtils.copyFile(screenshot, destFile);
		System.out.println(String.format("[[ATTACHMENT|%s]]", destFile.getAbsolutePath()));
	}
	
	@After
	public void tearDown() {
		if(driver != null) {
			driver.close();
			driver.quit();
		}
	}
}