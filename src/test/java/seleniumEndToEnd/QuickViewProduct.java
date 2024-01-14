package seleniumEndToEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import static org.testng.Assert.assertTrue;

public class QuickViewProduct extends BaseTest {

    By shopByCategory = By.xpath("//*[@id=\"entry_217832\"]/a");
    By componentsCategory = By.xpath("//div[@id='entry_217841']//span[contains(text(),'Components')]");
    By product = By.xpath("//div[@id='entry_212408']//img[@class='lazy-load']");
    By quickViewButton = By.xpath("//*[@id=\"entry_212408\"]/div/div[1]/div/div[1]/div[2]/button[3]");
    By buyNowButton = By.xpath("//div[@id='entry_212965']//button[contains(text(), 'Buy now')]");

    @Test
    public void test4_QuickViewProduct() {
        click(shopByCategory);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(componentsCategory));

        click(componentsCategory);

        WebElement productImage = find(product);
        Actions act = new Actions(driver);

        act.moveToElement(productImage).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(quickViewButton));
        click(quickViewButton);

        WebElement buyNowButtonElement;
        buyNowButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(buyNowButton));
    }
}
