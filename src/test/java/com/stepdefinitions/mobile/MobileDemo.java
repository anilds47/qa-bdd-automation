package com.stepdefinitions.mobile;

import com.utilities.DriverFactory;
import com.utilities.MobileUtils;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobileDemo  {


    List<String> allItems;
    @When("User is on the home screen")
    public void user_is_on_the_home_screen() {
        System.out.println("User is on Home Screen");

    }
    @When("User clicks on Views")
    public void user_clicks_on_views() {
        WebElement views = DriverFactory.getDriver().findElement(AppiumBy.accessibilityId("Views"));
        views.click();
        System.out.println("Opened 'Views' section");
    }
    @When("User scrolls until Tabs is visible and clicks")
    public void user_scrolls_until_tabs_is_visible_and_clicks() {
        MobileUtils.scrollUntilElementVisible(By.xpath("//android.widget.TextView[@text='Tabs']"));
        DriverFactory.getDriver().navigate().back();
    }


    @Then("I fetch all list items")
    public void iFetchAllListItems() {
        allItems = MobileUtils.fetchAllTexts();
    }

    @And("I print all items")
    public void iPrintAllItems() {
        System.out.println("===== ALL ITEMS =====");
        for (int i = 0; i < allItems.size(); i++) {
            System.out.println((i + 1) + ". " + allItems.get(i));
        }
    }

    @And("I click on {string}")
    public void iClickOn(String image) {
        MobileUtils.scrollAndClick(image);
    }

    @And("User reset the app")
    public void userResetTheApp() {
        DriverFactory.resetApp();
    }
}