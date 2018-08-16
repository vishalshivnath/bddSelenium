package com.fico.test.acm.login;

import org.testng.Assert;

import com.fico.test.acm.util.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


//step --
public class LoginTest {
  
  WebConnector selenium=new WebConnector();

  @Given("^I go to \"([^\"]*)\" on \"([^\"]*)\"$")
  public void gotoJira(String url,String browser){
      selenium.openBrowser(browser);
      selenium.navigate(url);
      //System.out.println("going to Jira "+ url +" on "+ browser );
  }
  
  @And("I enter \"([^\"]*)\" as \"([^\"]*)\"$")
  public void I_enter(String object,String text){
    selenium.type(text, object);
    //System.out.println("Entering in "+ object +" on "+ text );
  }
  
  @And("I click on \"([^\"]*)\"$")
  public void I_click_on(String object){
    selenium.click(object);
    //System.out.println("Clicking on "+ object);
  }
  
  @Then("login should be \"([^\"]*)\"$")
  public void Then_login_should_be(String expectedResult){
    boolean result=selenium.isElementPresent("projectsDropDown");
    //System.out.println("Login result "+ expectedResult);
    String actualResult=null;
    if(result)
      actualResult="success";
    else
      actualResult="failure";
    Assert.assertEquals(actualResult,expectedResult);
    
  } 
}
