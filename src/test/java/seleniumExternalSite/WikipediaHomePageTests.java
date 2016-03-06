package seleniumExternalSite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import basics.AbstractSelenium;
import pages.ArticlePage;
import pages.CreateNewAccount;
import pages.HomePage;

public class WikipediaHomePageTests extends AbstractSelenium {
		
	private HomePage homePage;
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
		homePage = initializeHomePage();
	}

	@Test
	public void shouldReturnTitle() {
		
		String title = driver.getTitle();
		assertTrue(title.equals("Wikipedia, wolna encyklopedia"));
	}

	@Test
	public void shouldChangeTabs() {	
		homePage.clickAuthors();
//		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().equals("Historia i autorzy strony „Wikipedia:Strona główna” – Wikipedia, wolna encyklopedia"));
		homePage.clickSourceText();
//		System.out.println(driver.getTitle());	
		assertTrue(driver.getTitle().equals("Tekst źródłowy strony Wikipedia:Strona główna – Wikipedia, wolna encyklopedia"));
		homePage.clickReadMe();
//		System.out.println(driver.getTitle());	
		assertTrue(driver.getTitle().equals("Wikipedia, wolna encyklopedia"));
	}	
	
	@Test
	public void shouldFindArticle() {
		ArticlePage article = homePage.searchArticte("Montezuma I");
		assertEquals(article.getFirstHeadingText(), "Montezuma I[edytuj]");
		assertTrue(driver.getTitle().equals("Montezuma I – Wikipedia, wolna encyklopedia"));
		
	}
	
	@Test
	public void shouldRedirectTo() {
		ArticlePage article = homePage.searchArticte("Montezuma I");
		driver.findElement(By.linkText("Huitzilíhuitl")).click();
		
		assertEquals(article.getFirstHeadingText(), "Huitzilíhuitl[edytuj]");
		assertTrue(driver.getTitle().equals("Huitzilíhuitl – Wikipedia, wolna encyklopedia"));
		
	}
	
	@Test
	public void shouldFailCreatingNewUser() {
		CreateNewAccount newUserPage = homePage.createNewAccount();
		newUserPage.enterLoginName("Kurnik Wielgachny");
		newUserPage.clickCreateNewUser();
		assertTrue(newUserPage.hasError());
		
		newUserPage.enterPassword("ola");
		newUserPage.clickCreateNewUser();
		assertTrue(newUserPage.hasError());
		
		newUserPage.enterPassword("ola");
		newUserPage.enterConfirmPassword("ola");
		newUserPage.clickCreateNewUser();
		assertTrue(newUserPage.hasError());

	
		newUserPage.enterPassword("ola");
		newUserPage.enterConfirmPassword("ola");
		newUserPage.enterCaptcha("nie mam pojęcia");
		newUserPage.clickCreateNewUser();
		assertTrue(newUserPage.hasError());
	}
}