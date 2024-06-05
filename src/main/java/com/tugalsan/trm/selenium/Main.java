package com.tugalsan.trm.selenium;

import com.tugalsan.api.log.server.TS_Log;
import com.tugalsan.api.thread.server.sync.TS_ThreadSyncTrigger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

//WHEN RUNNING IN NETBEANS, ALL DEPENDENCIES SHOULD HAVE TARGET FOLDER!
public class Main {

    final private static TS_Log d = TS_Log.of(Main.class);
    final private static TS_ThreadSyncTrigger killTrigger = TS_ThreadSyncTrigger.of();

    //cd C:\me\codes\com.tugalsan\trm\com.tugalsan.trm.selenium
    //java --enable-preview --add-modules jdk.incubator.vector -jar target/com.tugalsan.trm.selenium-1.0-SNAPSHOT-jar-with-dependencies.jar
    public static void main(String[] args) {
//        EdgeOptions options = new EdgeOptions();
//options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge Beta\\Application\\");
//EdgeDriver driver = new EdgeDriver(options);
        
        
        System.setProperty("webdriver.edge.driver", "C:\\bin\\selenium\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/users/sign_in");
        WebElement username = driver.findElement(By.id("user_email_login"));
        WebElement password = driver.findElement(By.id("user_password"));
        WebElement login = driver.findElement(By.name("commit"));
        username.sendKeys("abc@gmail.com");
        password.sendKeys("your_password");
        login.click();
        String expectedUrl = driver.getCurrentUrl();
        System.out.println("expectedUrl: " + expectedUrl);
    }
}

/*


Pre-request:
Microsoft Edge Web Sürücüsü | Microsoft Edge Geliştiricisi
Kararlı Kanal – x64
Download to: C:\\bin\\selenium\\edgedriver_win64\\msedgedriver.exe

Pom.xml:
<dependency>
	<groupId>org.seleniumhq.selenium</groupId>
	<artifactId>selenium-edge-driver</artifactId>
	<version>4.21.0</version>
</dependency>

module-info.java:
org.seleniumhq.selenium.edge_driver;

Main.java:
System.setProperty("webdriver.edge.driver", "C:\\bin\\selenium\\edgedriver_win64\\msedgedriver.exe");
WebDriver driver = new EdgeDriver();
driver.manage().window().maximize();
driver.get("https://www.browserstack.com/users/sign_in");
WebElement username = driver.findElement(By.id("user_email_login"));
WebElement password = driver.findElement(By.id("user_password"));
WebElement login = driver.findElement(By.name("commit"));
username.sendKeys("abc@gmail.com");
password.sendKeys("your_password");
login.click();
String expectedUrl = driver.getCurrentUrl();
System.out.println("expectedUrl: " + expectedUrl);

*/
