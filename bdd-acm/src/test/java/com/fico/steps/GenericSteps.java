package com.fico.steps;

import com.fico.webdriver.WebConnector;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GenericSteps {
  
  WebConnector con;
  public GenericSteps(WebConnector con) {
    this.con=con;
  }
  
  @Before
  public void before(Scenario s){
    System.out.println("*****Before*****"+s.getName());
    con.initReports(s.getName());
  }
  
  @After
  public void after(){
    System.out.println("*****after*****");
    con.quit();
  }
  
  @Given("^I open (.*)$")
  public void openBrowser(String browserName){
    con.infoLog("Opening Browser"+browserName);
    con.openBrowser(browserName);
  }
  
  @And("^I navigate to (.*)$")
  public void navigate(String url){
    con.navigate(url);  
  }
      
  @And("^I type (.*) in (.*) field$")
  public void type(String data,String locatorKey){
    con.type(locatorKey, data);
  }
  
  @And("^I Click on (.*)$")
  public void click(String locatorKey){
    con.click(locatorKey);
  }

}
