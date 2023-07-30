package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Base {


    protected   WebDriver driver = new ChromeDriver();
    protected  SoftAssert sassert = new SoftAssert();
    protected  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    protected JavascriptExecutor jse = (JavascriptExecutor) driver;


}

