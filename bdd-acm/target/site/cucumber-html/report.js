$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/com/fico/acm/Login.feature");
formatter.feature({
  "name": "Logging into Siron ACM",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Logging into Siron ACM",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.step({
  "name": "I open \u003cBrowser\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to loginURL",
  "keyword": "And "
});
formatter.step({
  "name": "I login inside application",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Username",
        "shashankrajput@fico.com"
      ]
    },
    {
      "cells": [
        "Password",
        "morning@12"
      ]
    }
  ]
});
formatter.step({
  "name": "login should be \u003cResult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Browser",
        "Result"
      ]
    },
    {
      "cells": [
        "Chrome",
        "Success"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Logging into Siron ACM",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open Chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to loginURL",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.navigate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I login inside application",
  "rows": [
    {
      "cells": [
        "Username",
        "shashankrajput@fico.com"
      ]
    },
    {
      "cells": [
        "Password",
        "morning@12"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.login(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should be Success",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.validateLogin(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});