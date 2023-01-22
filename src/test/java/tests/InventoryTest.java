package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

public class InventoryTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    InventoryPage inventoryPage;
    LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\colic\\OneDrive\\Radna površina\\QA\\chromedriver.exe");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        inventoryPage = new InventoryPage(driver, webDriverWait);
        loginPage = new LoginPage(driver, webDriverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void addToCart() {
        inventoryPage.addToCart();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText(), "1");
    }

    @Test
    public void removeFromCart() {
        inventoryPage.remove();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText(), "");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
