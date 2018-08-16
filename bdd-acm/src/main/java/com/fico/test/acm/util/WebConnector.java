package com.fico.test.acm.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebConnector {

  //logging
  //initialize property file
  //selenium layer -selenium commands
  WebDriver driver=null;
  Properties OR=null;
  Properties config=null;
  
  //constructor
  public WebConnector(){
    if(OR==null){
      //intalize OR
        try{
          OR=new Properties();
          FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\fico\\test\\acm\\config\\OR.properties");
          OR.load(fs);
          // Intailize config to corresponding env
          config=new Properties();
          fs =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\fico\\test\\acm\\config\\"+OR.getProperty("testEnv")+"_config.properties");
          config.load(fs);
          System.out.println(config.getProperty("loginURL"));
          System.out.println(OR.getProperty("loginusername"));
        }
        catch(Exception e){
        System.out.println("Error in intizating properties files");
      }
      
    }
  }
  
  public void openBrowser(String browserType){
    if(browserType.equals("Mozilla")){
      driver=new FirefoxDriver();
    }else if (browserType.equals("Chrome")){
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromeDriver\\chromedriver.exe");
      driver=new ChromeDriver();
    }else if (browserType.equals("IE")){
      //Set the IE server exe path and intialize
    }
    driver.manage().window().maximize();
    //implicit wait
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  
  //to which you want to hit
  public void navigate(String URL){
    driver.get(config.getProperty(URL));
  }
  
  public void click(String objectName){
    driver.findElement(By.xpath(OR.getProperty(objectName))).click();
  }
  
  public void type(String text,String objectName){
    driver.findElement(By.xpath(OR.getProperty(objectName))).sendKeys(text);
  }
  
  public void select(String text,String objectName){
    driver.findElement(By.xpath(OR.getProperty(objectName))).sendKeys(text);
  }
  
  public boolean isElementPresent(String objectName){
    int count=driver.findElements(By.xpath(OR.getProperty(objectName))).size();
    if(count==0)
      return false;
    else
      return true;
  }
  
}


//*************************Application depended functions**************************


