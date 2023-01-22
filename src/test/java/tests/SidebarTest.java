package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import pages.SidebarPage;

import java.time.Duration;

/*Testirati logout dugme, da li vas na klik vrati na originalni url i
kada odete sa driver.get na https://www.saucedemo.com/inventory.html da li pise poruka:
 “Epic sadface: You can only access '/inventory.html' when you are logged in.”*/
public class SidebarTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    InventoryPage inventoryPage;
    LoginPage loginPage;
    SidebarPage sidebarPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\colic\\OneDrive\\Radna površina\\QA\\chromedriver.exe");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        inventoryPage = new InventoryPage(driver, webDriverWait);
        loginPage = new LoginPage(driver, webDriverWait);
        sidebarPage = new SidebarPage(driver, webDriverWait);

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void logout(){
        sidebarPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
}
