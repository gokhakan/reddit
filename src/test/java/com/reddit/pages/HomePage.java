package com.reddit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id= "accept-all-cookies-button")
    public WebElement acceptAllCookies;

    @FindBy(id = "login-button")
    public WebElement loginIcon;

    public void clickLoginIcon() {
        loginIcon.click();
    }
}
