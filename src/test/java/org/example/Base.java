package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Base {


    private static WebDriver driver = new ChromeDriver();
    private static SoftAssert sassert = new SoftAssert();
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

}