package stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class shoppingcart {

	WebDriver driver;
	
	WebElement product1;
	WebElement product2;
	WebElement addtocartBtn;
	WebElement addtocartBtn1;
	WebElement gotocartBtn;
	WebElement updateItems;
	WebElement deleteItem;
	WebElement chkItems;
	WebElement productTitle;
	WebElement cartIcon;
	WebElement checkout;
	
	@Given("User must be on homepage to shop products {string}")
	public void user_must_be_on_homepage_to_shop_products(String string) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(op);
		driver.get(string);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	@When("User signs in to shop products")
	public void user_signs_in_to_shop_products() {
		
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	}

	@Then("User should be able to sign in")
	public void user_should_be_able_to_sign_in() throws InterruptedException {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("ap_email")).sendKeys("****");
		driver.findElement(By.id("continue")).click();
	    driver.findElement(By.id("ap_password")).sendKeys("****");
	    driver.findElement(By.id("signInSubmit")).click();
	    Thread.sleep(3000);
	}

	@Then("User should be able to add update cart and checkout")
	public void user_should_be_able_to_add_update_cart_and_checkout() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://www.amazon.ca/AmazonBasics-Patio-Lights-Black-50/dp/B073WGN8DW/ref=sr_1_1?crid=1GNRB2G6UEJ11&keywords=Amazon+Basics+PL100-50-BLK+Patio+String+Light%2C+50+Feet%2C+Black&qid=1687759029&sprefix=amazon+basics+pl100-50-blk+patio+string+light%2C+50+feet%2C+black+%2Caps%2C190&sr=8-1");
		addtocartBtn = driver.findElement(By.cssSelector("#add-to-cart-button"));
		addtocartBtn.click();
		driver.get("https://www.amazon.ca/gp/product/B09ZB66L28/ref=ox_sc_act_title_1?smid=A2YUFNZCTK4USK&psc=1");
		addtocartBtn1 = driver.findElement(By.id("add-to-cart-button"));
		addtocartBtn1.click();
		gotocartBtn = driver.findElement(By.cssSelector("#sw-gtc > span > a"));
		gotocartBtn.click();
		
		updateItems = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		Select obj = new Select(updateItems);
		obj.selectByVisibleText("3");
		
		deleteItem = driver.findElement(By.xpath("//*[@id=\\\"sc-active-Cf7020b6a-b256-4d55-8e12-e4ace16981a5\\\"]/div[4]/div/div[3]/div[1]/span[2]/span/input"));
		deleteItem.click();
		
		chkItems = driver.findElement(By.xpath("//*[@id=\\\"sc-active-C50a5c2f6-4951-43ab-ae41-780ffca35a91\\\"]/div[4]/div/div[1]/label/input"));
		chkItems.click();
		deleteItem.click();
		
		productTitle = driver.findElement(By.xpath("//*[@id=\\\"sc-active-C6bc43a16-035b-470d-beaa-981f11e9e3c6\\\"]/div[4]/div/div[3]/ul/li[1]/span/a/span[1]/span/span[2]"));
		productTitle.click();
		
		cartIcon = driver.findElement(By.id("nav-cart"));
		cartIcon.click();
		
		checkout = driver.findElement(By.xpath("//*[@id=\\\"sc-buy-box-ptc-button\\\"]/span/input"));
		checkout.click();
		Thread.sleep(3000);
	}
}
