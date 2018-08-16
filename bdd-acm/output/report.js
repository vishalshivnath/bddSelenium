$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com\\fico\\test\\acm\\login\\login.feature");
formatter.feature({
  "line": 1,
  "name": "Logging into Salesforce",
  "description": "\r\nIn order to work\r\nas sales person\r\nI want ot login",
  "id": "logging-into-salesforce",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 8,
  "name": "Logging in salesforce",
  "description": "",
  "id": "logging-into-salesforce;logging-in-salesforce",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I go to \"loginURL\" on \"Chrome\"",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I enter \"loginusername\" as \"shashankrajpu\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I enter \"loginpassword\" as \"evening@321\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click on \"loginbutton\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "login should be \"success\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "loginURL",
      "offset": 9
    },
    {
      "val": "Chrome",
      "offset": 23
    }
  ],
  "location": "LoginTest.gotoJira(String,String)"
});
formatter.result({
  "duration": 11949538576,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "loginusername",
      "offset": 9
    },
    {
      "val": "shashankrajpu",
      "offset": 28
    }
  ],
  "location": "LoginTest.I_enter(String,String)"
});
formatter.result({
  "duration": 147877305,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "loginpassword",
      "offset": 9
    },
    {
      "val": "evening@321",
      "offset": 28
    }
  ],
  "location": "LoginTest.I_enter(String,String)"
});
formatter.result({
  "duration": 131370000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "loginbutton",
      "offset": 12
    }
  ],
  "location": "LoginTest.I_click_on(String)"
});
formatter.result({
  "duration": 177953784,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "success",
      "offset": 17
    }
  ],
  "location": "LoginTest.Then_login_should_be(String)"
});
formatter.result({
  "duration": 20050478004,
  "error_message": "java.lang.AssertionError: expected:\u003csuccess\u003e but was:\u003cfailure\u003e\r\n\tat org.testng.Assert.fail(Assert.java:89)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:489)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:171)\r\n\tat org.testng.Assert.assertEquals(Assert.java:181)\r\n\tat com.fico.test.acm.login.LoginTest.Then_login_should_be(LoginTest.java:45)\r\n\tat ✽.Then login should be \"success\"(com\\fico\\test\\acm\\login\\login.feature:14)\r\n",
  "status": "failed"
});
});