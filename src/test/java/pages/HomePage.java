package test.java.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;

public class HomePage {
    private Logger logger = LogManager.getLogger(HomePage.class);
    WebDriver driver;
    WebDriverWait wait;


    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchInput;
    @FindBy(xpath = "//*[@id='nav-search-submit-text']/input")
    public WebElement searchSubmitBtn;



    public HomePage(WebDriver driver){
        logger.trace("HOME PAGE was initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
        PageFactory.initElements(driver, this);

    }

    public HomePage open(){
        logger.info("Open Amazon home page");
        driver.get(PropertyLoader.loadProperty("url"));
        return this;
    }
    public HomePage searchInputSubmit(String text){
        logger.info("Input " +text + " to search field");
        searchInput.sendKeys(text);
        searchSubmitBtn.click();
        return this;
    }

}