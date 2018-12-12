package com.fico.steps;

import java.util.Map;

import com.fico.webdriver.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ApplicationSteps {
  
  WebConnector con;
  public ApplicationSteps(WebConnector con) {
    this.con=con;
  }
  
  @Then("^login should be (.*)$")
  public void validateLogin(String expectedResult){
    con.validateLogin(expectedResult);   
  }
  
  @And("^I login inside application$")
  public void login(Map<String,String> data){
    con.infoLog("UserName"+data.get("Username"));
    con.infoLog("Password"+data.get("Password"));
    //System.out.println(data.get("Username"));
    //System.out.println(data.get("Password"));
    con.login(data.get("Username"),data.get("Password"));
  }
  
}
