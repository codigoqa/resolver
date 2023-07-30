package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestClass extends Base {

    @Test(dataProvider = "loginData")
    public void test1(String email, String password) {

        // Assert that both email address and password inputs are present

        WebElement emailInput = driver.findElement(By.id("inputEmail"));
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));


        // Assert email password & login button
        assert emailInput.isDisplayed() : "Test Failed! Email input is missing.";
        assert passwordInput.isDisplayed() : "Test Failed! Password input is missing.";
        assert loginButton.isDisplayed() :"Test Failed! Login Button not displaye" ;


        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();


    }

    @Test
    public void test2() throws InterruptedException {

        jse.executeScript("scroll(0,120);");
        List<WebElement> test2div = driver.findElements(By.xpath("//ul[@class='list-group']//li"));
        // Assert that there are three values in the listgroup
        sassert.assertEquals(test2div.size(), 3, "The list does not have 3 values");

        WebElement listItem = test2div.get(1);
        String actualItem2 = listItem.getText();
        sassert.assertTrue(actualItem2.contains("List Item 2"), "List Item 2 is not displayed");

        // Assert that the second list item's value is set to "Bage 6"
        WebElement badgeValue =driver.findElement(By.xpath("(//ul[@class='list-group']//li//span)[2]"));
        String secondListItemValue = badgeValue.getText();
        System.out.println("The secondList Item Value is:"+secondListItemValue);
        sassert.assertTrue(secondListItemValue.contains("6"), "List Item 2 badge value is not 6");

        sassert.assertAll();

    }

    @Test
    public void test3() throws InterruptedException {

        jse.executeScript("scroll(0,550);");

        // assert option 1 od displayed
        WebElement displayedOption = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
        sassert.assertEquals(displayedOption.getText(), "Option 1", "Option 1 is not the default value");
        displayedOption.click();

        // click option 3
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Option 3')]")));
        WebElement selectOption3 = driver.findElement(By.xpath("//a[contains(text(),'Option 3')]"));
        selectOption3.click();
    }

    @Test
    public  void test4() throws InterruptedException {


        jse.executeScript("scroll(0,750);");


        // First button enbaled
        WebElement selectBtn = driver.findElement(By.xpath("//div[@id='test-4-div']//button[contains(@class,'btn-primary')]"));
        sassert.assertTrue(selectBtn.isEnabled(), "Button is not enbaled");
        // Second button disabled
        WebElement unselectBtn = driver.findElement(By.xpath("//div[@id='test-4-div']//button[contains(@class,'btn-secondary')]"));
        sassert.assertFalse(unselectBtn.isEnabled(), "unselect Button is not enbaled");


    }

    @Test
    public void test5() throws InterruptedException {



        jse.executeScript("scroll(0,950);");



        WebElement clickBtn = driver.findElement(By.xpath("//div[@id='test-5-div']//button[contains(@class,'btn-primary')]"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickBtn));
        clickBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='test5-alert']")));
        WebElement message = driver.findElement(By.xpath("//div[@id='test5-alert']"));
        sassert.assertTrue(message.isDisplayed(), "Message is not displayed");

    }

    @Test
    public void test6() throws InterruptedException {


        jse.executeScript("scroll(0,1350);");


        List<WebElement> tableElements = driver.findElements(By.xpath("//tbody//tr//td"));
        List<String> tableNames = new ArrayList<>();

        for (int i = 0; i < tableElements.size(); i++) {
            tableNames.add(tableElements.get(i).getText());
        }

        String extractTableValue = returnTableValue(tableNames,2,2);
        sassert.assertEquals(extractTableValue,"Ventosanzap","The expected value not match");


    }

    public String returnTableValue(List<String> tableNames, int row, int col) {

        String[][] TableVal = new String[3][3];
        int k = 0;

        for (int i = 0; i < TableVal.length; i++) {
            for (int j = 0; j < 3; j++) {
                TableVal[i][j] = tableNames.get(k);
                k++;
            }
        }
        return TableVal[row][col];

    }

    public void closeBrowser(){
        driver.quit();
    }
}




