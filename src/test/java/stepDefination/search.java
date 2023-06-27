package stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class search {

	WebDriver driver;
	
	WebElement search;
	WebElement sortby;
	WebElement filter;
	WebElement filters;
	WebElement pagination;
	WebElement nextpage;
	
	@Given("User must be on homepage to search products {string}")
	public void user_must_be_on_homepage_to_search_products(String string) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(op);
		driver.get(string);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	@When("User clicks on Sign in button to search products")
	public void user_clicks_on_sign_in_button_to_search_products() {
		
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	}

	@Then("Sign in dialog box should be displayed and User should be able to sign in")
	public void sign_in_dialog_box_should_be_displayed_and_user_should_be_able_to_sign_in() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#authportal-main-section > div:nth-child(2) > div.a-section.a-spacing-base > div.a-section > form > div > div")));
		boolean actual = dialog.isDisplayed();
	    Assert.assertEquals(true,actual);
	    driver.findElement(By.id("ap_email")).sendKeys("****");
		driver.findElement(By.id("continue")).click();
	    driver.findElement(By.id("ap_password")).sendKeys("****");
	    driver.findElement(By.id("signInSubmit")).click();
	    Thread.sleep(3000);
	}

	@Then("User searches query in search box and results should be displayed with all options")
	public void user_searches_query_in_search_box_and_results_should_be_displayed_with_all_options() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		search = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		search.sendKeys("T-Shirts");
		search.submit();
		
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		sortby = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-0\"]/span/i")));*/
		
		sortby = driver.findElement(By.cssSelector("#s-result-sort-select"));
		boolean s = sortby.isDisplayed();
		Assert.assertEquals(true,s);
		
		filter = driver.findElement(By.cssSelector("#p_36\\\\/12035761011 > span > a > span"));
		boolean f = filter.isDisplayed();
		Assert.assertEquals(true,f);
		
		filters = driver.findElement(By.cssSelector("#p_n_feature_twenty_browse-bin\\\\/31847698011 > span > a > span"));
		boolean fs = filters.isDisplayed();
		Assert.assertEquals(true,fs);
		
		pagination = driver.findElement(By.xpath("//*[@id=\\\"search\\\"]/div[1]/div[1]/div/span[1]/div[1]/div[51]/div"));
		boolean p = pagination.isDisplayed();
		Assert.assertEquals(true,p);
		Thread.sleep(3000);
	}

	@Then("User should be able to sort, filter results and click pagination")
	public void user_should_be_able_to_sort_filter_results_and_click_pagination() throws InterruptedException {
		
		Select obj1 = new Select(sortby);
		obj1.selectByVisibleText("Price: Low to high");
		filter.click();
		filters.click();
		nextpage = driver.findElement(By.xpath("//*[@id=\\\"search\\\"]/div[1]/div[1]/div/span[1]/div[1]/div[68]/div/div/span/a[3]"));
		nextpage.click();
		Thread.sleep(3000);
	}
}
