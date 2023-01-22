package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SidebarPage extends BasePage{

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logoutBtn;

    WebDriver driver;
    WebDriverWait webDriverWait;
    LoginPage loginPage;

    public SidebarPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
        loginPage = new LoginPage(driver, webDriverWait);
    }

    public void logout() {
        loginPage.login("standard_user", "secret_sauce");
        burgerMenu.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logoutBtn.click();
    }
}
