package seleniumEndToEnd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class AddToWishlist extends BaseTest {

    By myAccountMenu = By.xpath("//div[@id='widget-navbar-217834']//span[contains(text(), 'My account')]");
    By email = By.id("input-email");
    By password = By.id("input-password");
    By loginButton = By.xpath("//input[@type='submit' and @value='Login']");
    By searchField = By.xpath("//div[@id='entry_217822']//input[@aria-label='Search For Products']");
    By searchButton = By.xpath("//div[@id='search']//button[text()='Search']");
    By iPhone = By.xpath("//div[@id='entry_212469']//a[text()='iPhone']");
    By heartButton = By.xpath("//*[@id=\"image-gallery-216811\"]/div[1]/button");
    By wishListButton = By.xpath("//div[@id='notification-box-top']//a[contains(text(), 'Wish List (1)')]");

    @Test
    public void test3_AddToWishlist() {
        click(myAccountMenu);
        type(email, "PiotrKowalski@gmail.com");
        type(password, "Test1234");
        click(loginButton);
        type(searchField, "iPhone");
        click(searchButton);
        click(iPhone);
        click(heartButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(wishListButton));
        click(wishListButton);
    }
}
