package com.reddit.stepDefs;

import com.reddit.utilities.*;
import com.reddit.pages.HomePage;
import com.reddit.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Steps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


    @Given("user is on home page")
    public void user_is_on_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForPageToLoad(20);
        assertEquals(Driver.get().getTitle(), "Reddit - Dive into anything");
        BrowserUtils.waitFor(2);
//        Driver.get().findElement(By.id("accept-all-cookies-button")).click();


    }

    @Given("user clicks on login icon")
    public void user_clicks_on_login_icon() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.id("login-button")).click();


    }

    @When("user logs in")
    public void user_logs_in() {
        BrowserUtils.waitFor(2);

        Set<String> windowHandles = Driver.get().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(Driver.get().getWindowHandle())) {
                Driver.get().switchTo().window(handle);
                break;
            }
        }
        Driver.get().findElement(By.id("login-username")).sendKeys(ConfigurationReader.get("username"));
        Driver.get().findElement(By.id("login-password")).sendKeys(ConfigurationReader.get("password"));
        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.xpath("(//button[@type='button'])[4]")).click();

        BrowserUtils.waitFor(3);
    }

    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
        Assert.assertEquals("Reddit - Dive into anything", Driver.get().getTitle());
    }

    @When("user searches for {string}")
    public void user_searches_for(String topic) {
//        Driver.get().switchTo().defaultContent();
        BrowserUtils.waitFor(6);
        Driver.get().findElement(By.id("accept-all-cookies-button")).click();

//        Driver.get().findElement(By.xpath("//input[@placeholder='Search Reddit']")).sendKeys(topic);


    }
}