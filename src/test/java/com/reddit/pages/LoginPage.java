package com.reddit.pages;

import com.reddit.utilities.ConfigurationReader;
import com.reddit.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[@class='flex items-center gap-xs'][normalize-space()='Log In']")
    public WebElement username;

    @FindBy(xpath = "//span[@class='flex items-center gap-xs'][normalize-space()='Log In']")
    public WebElement password;

    @FindBy(xpath = "//auth-flow-modal[@pagename='login_username_and_password']//div[@class='w-100']")
    public WebElement login;

    public  void login(){
        username.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
        login.click();
    }
}

