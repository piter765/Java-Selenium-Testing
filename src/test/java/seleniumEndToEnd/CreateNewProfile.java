package seleniumEndToEnd;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateNewProfile extends BaseTest {

    By myAccountMenu = By.xpath("//div[@id='widget-navbar-217834']//span[contains(text(), 'My account')]");
    By continueButton = By.xpath("//div[@id='content']//a[contains(text(), 'Continue')]");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By agreeCheckbox = By.xpath("//label[@for='input-agree']");
    By continueRegistrationButton = By.xpath("//input[@type='submit' and @value='Continue']");
    By logout = By.xpath("//div[@id='widget-navbar-217834']//span[contains(text(), 'Logout')]");


    @Test
    public void test1_CreateNewProfile() {
        //driver.findElement(By.xpath("//div[@id='widget-navbar-217834']//span[contains(text(), 'My account')]")).click();
        click(myAccountMenu);
        click(continueButton);
        type(firstName, "Piotr");
        type(lastName, "Kowalski");
        type(email, generateRandomEmail());
        type(telephone, "123456789");
        type(password, "Test1234");
        type(confirmPassword, "Test1234");
        click(agreeCheckbox);
        click(continueRegistrationButton);

        Actions act = new Actions(driver);
        act.moveToElement(find(myAccountMenu)).perform();
        click(logout);
    }

    private String generateRandomEmail() {
        return RandomStringUtils.random(4, true,  true) + "@gmail.com";
    }

}
