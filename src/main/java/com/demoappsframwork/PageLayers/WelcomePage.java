package com.demoappsframwork.PageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WelcomePage extends BasePage {
	
	private final By registerLink = By.xpath("//a[@href='/register']");
	private final By loginLink = By.xpath("//a[@href='/login']");
	private final By cartLink = By.xpath("//a[@href='/cart']");
	private final By whistlistLink = By.xpath("//a[@href='/wishlist']");
	private final By bookLink = By.xpath("//a[@href='/books']");
	private final By searchTextField = By.id("small-searchterms");
	private final By productItem = By.xpath("//div[@class='product-item']//h2/a");
	private final By searchButton = By.xpath("//input[@type='submit']");
	private final By addToCartButton = By.xpath("//input[@type='button' and @value='Add to cart']");
	private final By shoppingCartLink = By.xpath("//span[.='Shopping cart']");
	private final By productTitleResult = By.xpath("//td[@class='product']/a");
	private final By apparelAndShoesLink = By.xpath("//a[@href='/apparel-shoes']");
	private final By jewelryLink = By.xpath("//a[@href='/jewelry']");
	private final By electronicsLink = By.xpath("//a[@href='/electronics']");
	private final By computers = By.xpath("//a[@href='/']");
	
	
	public WelcomePage(WebDriver driver) {
		super(driver);
	}
	
	public By productsTitleListInCart(int index) {
		return By.xpath("(//td[@class='product']//a) ["+ index +"]");
	}
	public boolean checkRegisterLinkIsEnabled() {
		return elementControls.checkElementIsEnabled(fluentWait.locateElement(registerLink));
	}
    
	public boolean checkLoginLinkIsEnabled() {
		return elementControls.checkElementIsEnabled(fluentWait.locateElement(loginLink));
	}

	public boolean checkCartLinkIsEnabled() {
		return elementControls.checkElementIsEnabled(fluentWait.locateElement(cartLink));
	}

	public boolean checkWhishlistLinkIsEnabled() {
		return elementControls.checkElementIsEnabled(fluentWait.locateElement(whistlistLink));
	}

	public String apparelAndShoesLinkIsEnabled() {
		 elementControls.clickOnElement(fluentWait.locateElement(apparelAndShoesLink));
		return browserControls.fetchPageTitle();
	}
        
	public String checkBookLinkIsEnabled() {
		 elementControls.clickOnElement(fluentWait.locateElement(bookLink));
		return browserControls.fetchPageTitle();
	}
          
	public String checkjweleryLinkIsEnabled() {
		 elementControls.clickOnElement(fluentWait.locateElement(jewelryLink));
		return browserControls.fetchPageTitle();
	}

	public String electronicsLinkIsEnabled() {
		 elementControls.clickOnElement(fluentWait.locateElement(electronicsLink));
		return browserControls.fetchPageTitle();
	}

	
	public String checkRegisterPage() {
		elementControls.checkElementIsEnabled(fluentWait.locateElement(registerLink));
		return browserControls.fetchPageTitle();
	}
	
	public String checkLoginPage() {
		elementControls.checkElementIsEnabled(fluentWait.locateElement(loginLink));
		return browserControls.fetchPageTitle();
	}
	
	public String checkCartPage() {
		elementControls.checkElementIsEnabled(fluentWait.locateElement(cartLink));
		return browserControls.fetchPageTitle();
	}
	
	public String checkWhishlistPage() {
		elementControls.checkElementIsEnabled(fluentWait.locateElement(whistlistLink));
		return browserControls.fetchPageTitle();
	}
	
	 public boolean checkSearchFieldEnabled() {
		return elementControls.checkElementIsEnabled(fluentWait.locateElement(searchTextField));
	}
	public String checkBookPage() {
		elementControls.clickOnElement(fluentWait.locateElement(bookLink));
		return browserControls.fetchPageTitle();
	}
	
	public void verifyTitleRegisterLink() {
		elementControls.clickOnElement(fluentWait.locateElement(registerLink));
	}
	
	public RegisterPage clickOnRegisterLink() {
		elementControls.clickOnElement(fluentWait.locateElement(registerLink));
		return new RegisterPage(driver);
	}
	public LoginPage clickOnLoginLink() {
		elementControls.clickOnElement(fluentWait.locateElement(loginLink));
		return new LoginPage(driver);
	}
	
	public String searchProduct(String productName) {
		elementControls.enterValues(fluentWait.locateElement(searchTextField), productName);
		elementControls.clickOnElement(fluentWait.locateElement(searchButton));
		return elementControls.fetchElementText(fluentWait.locateElement(productItem));
	}
	
	public String addToCartAndVerify(String productName) {
		elementControls.enterValues(fluentWait.locateElement(searchTextField), productName);
		elementControls.clickOnElement(fluentWait.locateElement(searchButton));
		elementControls.clickOnElement(fluentWait.locateElement(addToCartButton));
		elementControls.clickOnElement(fluentWait.locateElement(shoppingCartLink));
		return elementControls.fetchElementText(fluentWait.locateElement(productTitleResult));
	}
     
	public String checkApparelAndShoesPage() {
		elementControls.clickOnElement(fluentWait.locateElement(apparelAndShoesLink));
		return browserControls.fetchPageTitle();
	}
	
	public String checkJewelryPage() {
		elementControls.clickOnElement(fluentWait.locateElement(jewelryLink));
		return browserControls.fetchPageTitle();
	}
		
		public String checkElectronicsPage() {
			elementControls.clickOnElement(fluentWait.locateElement(electronicsLink));
			return browserControls.fetchPageTitle();
		}
		
		public String verifyMultipleProductsCart(String productName, int index) {
		elementControls.enterValues(fluentWait.locateElement(searchTextField),productName);
		elementControls.clickOnElement(fluentWait.locateElement(searchButton));
		elementControls.clickOnElement(fluentWait.locateElement(addToCartButton));
		elementControls.clickOnElement(fluentWait.locateElement(shoppingCartLink));
		return elementControls.fetchElementText(fluentWait.locateElement(productsTitleListInCart(index)));
	}
}
