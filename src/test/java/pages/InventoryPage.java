package pages;

import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage extends BasePage{

   @FindBy(id = "add-to-cart-sauce-labs-backpack")
   private WebElement addToCart;

   @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cart;

   @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    private WebElement remove;

    public InventoryPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void addToCart (){
        addToCart.click();
    }
    public void remove(){
        addToCart.click();
        WebDriverWait webDriverWait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        remove.click();
    }
}
