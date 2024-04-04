# Alert and Poupus using Selenium on Lambda Test

## What is this Repository about?

- This repository showcases practical examples of handling alerts and popups encountered during web automation testing with Selenium WebDriver in Java.
- Demonstrates techniques for interacting with different types of alerts (simple, confirm, prompt) and popups using Selenium APIs. 
- This project uses Maven as build tool and TestNG framework to run the tests.
### Prerequisites
1. Install and set environment variable for java.
    * Windows - https://www.oracle.com/java/technologies/downloads/
    * Linux - ```  sudo apt-get install openjdk-8-jre  ```
    * MacOS - Java should already be present on Mac OS X by default.
2 Install and set environment varibale for Maven.
    * Windows - https://maven.apache.org/install.html
    * Linux/ MacOS -  [Homebrew](http://brew.sh/) (Easier)

### Run your First Test
1. Clone the Java-Selenium-Sample repository. 
```
git clone https://github.com/LambdaTest/java-selenium-sample.git
```
2. Next get into Java-Selenium-Sample folder, and import Lamabdatest Credentials. You can get these from lambdatest automation dashboard.
   <p align="center">
   <b>For Linux/macOS:</b>:
 
```
export LT_USERNAME="YOUR_USERNAME"
export LT_ACCESS_KEY="YOUR ACCESS KEY"
```
<p align="center">
   <b>For Windows:</b>

```
set LT_USERNAME="YOUR_USERNAME"
set LT_ACCESS_KEY="YOUR ACCESS KEY"
```
Step 3. You may also want to run the command below to check for outdated dependencies. Please be sure to verify and review updates before editing your pom.xml file as they may not be compatible with your code.
```
mvn versions:display-dependency-updates
```
Step 4. By default, tests would be running on LambdaTest Platform on Chrome and Firefox Browsers.
```
mvn clean test -DLT_USERNAME=<username> -DLT_ACCESS_KEY=<access-key> -Dtest=<class to be executed>
```
