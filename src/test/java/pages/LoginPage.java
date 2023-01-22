/*
Testira se sajt: https://www.saucedemo.com/

Koristiti apstrakciju i nasledjivanje za zajednicke stvari za testove i za stranice.
*/
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement username;

    @FindBy (name = "password")
    private WebElement password;

    @FindBy (id = "login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void login(String userName, String Password){
      username.sendKeys(userName);
        password.sendKeys(Password);
        loginBtn.click();
    }
}
