$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/discover.feature");
formatter.feature({
  "name": "Discover Website",
  "description": "  In order to validate Discover Website\n  As a user\n  I wish to verify the cash advance is greater than 20%",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify 20% Cash Advance",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to discover website",
  "keyword": "Given "
});
formatter.match({
  "location": "UIsteps.iNavigateToDiscoverWebsite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the Credit Cards Icon",
  "keyword": "And "
});
formatter.match({
  "location": "UIsteps.iClickOnTheCreditCardsIcon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the apply now secured credit card",
  "keyword": "And "
});
formatter.match({
  "location": "UIsteps.iClickTheApplyNowSecuredCreditCard()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat stepdefs.UIsteps.iClickTheApplyNowSecuredCreditCard(UIsteps.java:74)\n\tat ✽.I click the apply now secured credit card(file:src/test/resources/features/discover.feature:11)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});