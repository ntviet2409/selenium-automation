# About Selenium Automation Framework

This framework is basically developed and designed to automate web applications 

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
* Selenium WebDriver ver.3
* Cucumber
* POM Design pattern
* Junit
* Chrome or Firefox at the latest versions

# How to Setup & Configure

  1. Install and IDE such as VScode/IntelliJ/Eclipse (Any latest version will work)
  2. Install Maven plugin in IDE if it is not present/enabled
  3. Use git lfs clone to download the automation framework to your local system 
  4. Locate pom.XML and right click and choose Run As -> Maven Build
   (Alternatively skipping step 6,7,8, you can run from console of IDE or system console as "mvn clean install" to give a trial run)
  5. Check whether the build is successful
  6. From command prompt go to project level and execute following command(it is advised to use command line option to run): 
	mvn clean test

# How to run feature test

To run feature specific tests , either create and add your own Test file similar to LoginTest.java OR please edit test runner class MasterTest.java and update the tags = "@<feature-name>".

    mvn clean test -Dcucumber.options="--tags @<feature-name>"

	Examples:
		<feature-name> = "@WalletHub"
		<feature-name> = "@Facebook"

To run whole suite, please edit the test runner class MasterTest.java and update the tags = "@All"
