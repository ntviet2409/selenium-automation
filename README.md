# About Selenium Automation Framework

This framework is basically developed and designed to automate web applications (both UI and API)

# Work Flow
At a high level, the [Git Development Workflow](http://wiki.aurea.local/x/VYCCD) being followed is:

1. Create a branch
2. Do your work
3. Prepare feature/bug_fix branch (Make sure commit history is clean) 
4. Raise pull request to merge your branch into the main repo branches

# Tools, Approaches and Technologies Used

* Gherkin
* Core Java
* Maven
* Spring
* Selenium WebDriver ver3
* Restassured
* Cucumber
* Junit
* Hamcrest
* POM
* Lombok
* Jackson
* Allure Report
* Chrome or Firefox at the latest versions

# How to Setup & Configure

  1. Install and IDE such as VScode/IntelliJ/Eclipse (Any latest version will work)
  2. Install Maven plugin in IDE if it is not present/enabled. Also install plugins for Lomboks and Gherkins
  3. Use git lfs clone to download the automation framework to your local system 
  4. Locate pom.XML and right click and choose Run As -> Maven Build
  5. Check whether the build is successful
  6. From command prompt go to project level and execute following command(it is advised to use command line option to run): 
	mvn clean test

# How to run feature test

To run feature specific tests , either create and add your own Test file similar to LoginTest.java OR please edit test runner class MasterTest.java and update the tags = "@<feature_tag_name>".

    mvn clean test -Dcucumber.options="--tags @<feature_tag_name>"

# How to see the report
When "mvn clean install" is finished, the Allure report will be generated as .json file under directory "allure-results" under project root directory. Generate Allure html report by running the command:

    allure serve allure-results
