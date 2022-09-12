package stepDefenations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import cucumber.api.java.en.*;
import pageObject.LoginPage;

public class Steps {
      public WebDriver driver;
	 public LoginPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
	    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver/chromedriver.exe");
	     driver=new ChromeDriver();
	     lp=new LoginPage(driver);
	}

	@When("User Opens URL {string}")
	public void user_Opens_URL(String url) {
	  driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
	   lp.setUserName(email);
	   lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() {
	  lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
	   if(driver.getPageSource().contains("Login was unsuccessful.")) {
		   driver.close();
		  Assert.assertTrue( false);
	   }
	   else
	    {
		  Assert.assertEquals(title, driver.getTitle());
	   }
	}

	@When("User Click on Log out link")
	public void user_Click_on_Log_out_link() throws InterruptedException {
	  lp.clickLogout();
	  Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		
		driver.quit();
	  }
}
