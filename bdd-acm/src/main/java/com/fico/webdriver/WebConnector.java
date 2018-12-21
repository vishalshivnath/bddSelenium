package com.fico.webdriver;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fico.reports.ExtentManager;

public class WebConnector {
  
  WebDriver driver;
  public String name;
  public Properties prop;
  public ExtentReports rep;
  public ExtentTest scenario;
  
  public WebConnector(){
    //name="A";
    
  if(prop==null) {  
    try {
          prop= new Properties();
          FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/project.properties");
          prop.load(fs);
      } catch (Exception e) {
          e.printStackTrace();
          // report
      }
    } 
  }
  
  public void openBrowser(String browserName){ 
  if(browserName.equals("Mozilla"))
    driver= new FirefoxDriver();
  else if(browserName.equals("Chrome")){
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromerDriver/chromedriver");
    driver= new ChromeDriver();
    }else if(browserName.equals("IE"))
    driver= new InternetExplorerDriver();
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  
  public void navigate(String urlKey) {
      driver.get(prop.getProperty(urlKey));
      driver.manage().window().maximize();
  }
  
  public void click(String objectKey) {
    getObject(objectKey).click(); 
  }
  
  public void type(String objectKey,String data) {
    getObject(objectKey).sendKeys(data);
  }
  
  //Central function to extract objects --In Properties files you can have it with _id,_xpath i.e in feature files as well you need to add the code for the same here
  public WebElement getObject(String objectKey){
    WebElement e =null;
    try{
     e= driver.findElement(By.xpath(prop.getProperty(objectKey)));
     WebDriverWait wait =new WebDriverWait(driver, 5);
     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(objectKey))));
     /*
     if(objectKey.endsWith("_xpath")) {
       e = driver.findElement(By.xpath(prop.getProperty(objectKey)));// present
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(objectKey))));
     */
    }catch (Exception ex){
      //report the failure--If not present;invisible
      ex.getMessage();
    }
    return e;
  }
  
  public void login(String username,String password){
    type("username",username);
    type("password",password);
    click("loginbutton");
  }
  
  //--In Properties files you can have it with _id,_xpath i.e in feature files as well you need to add the code for the same here
  public boolean isElementPresent(String objectKey){
    List<WebElement> e=null;
    e= driver.findElements(By.xpath(prop.getProperty(objectKey)));
    if (e.size()==0)
      return false;
    else
      return true;
  }
  
  public void validateLogin(String expectedResult){
    boolean result=isElementPresent("UserNameAfterLogin");
    String actualResult="";
    if(result)
      actualResult="Success";
    else 
      actualResult="Failure";
    infoLog("Got actual result as"+ actualResult);
    infoLog("Expected Result"+ expectedResult);
    if(!expectedResult.equals(actualResult))
      System.out.println("ScenarioFailure"); //Reporting failure
  }
  
  
  //***************Logging**********/
  public void infoLog(String msg){
    scenario.log(Status.INFO, msg);
  }
  
  public void failureLog(String errMsg){
    scenario.log(Status.FAIL, errMsg);
  }
  
  //*********Reporting********/
  public void initReports(String scenarioName){
    rep=ExtentManager.getInstance(prop.getProperty("reportPath"));
    scenario=rep.createTest(scenarioName);
    scenario.log(Status.INFO, "Starting"+scenarioName);
  }
  public void quit() {
    if(rep!=null)
      rep.flush();
  }
  
  
  
}
