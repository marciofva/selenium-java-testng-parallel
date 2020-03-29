# Java-selenium-testng
---

This project is an E2E automated functional testing for an **e-commerce** website using Selenium and TestNG.


## Pre-requisites:

- NodeJS
- Java 8 JDK
- Maven
- Chrome browser (latest version)
- Firefox browser (latest version)


## Installation:

It is required to setup **ChromeDriver** and **GeckoDriver** on your system. Follows below:

- **Chrome**: To run the tests locally with _Chrome_, install ChromeDriver from [here](http://chromedriver.chromium.org/)


- **Firefox**: To run the tests locally with _Firefox_, install GeckoDriver from [here](https://github.com/mozilla/geckodriver/releases)


## Technologies ##

- **TestNG**: Allows to use data provider to manage all test data in each test scenario as well as this tool provides listeners to interact in test execution


- **Allure**: Generate a readable report with screenshot for those failure scenarios


## Supported environment ##

The browser value is passed as a parameter in test suite xml.

- **CHROME**: `<parameter name="browser" value="chrome" />`



- **FIREFOX**: `<parameter name="browser" value="firefox" />`


## Parallelism ##

Used maven-surefire configuration to run suites in parallel. In addition, the project is designed to use *thread-local* for each webdriver instance. Used **suitethreadpoolsize=3**, because there are 3 test suites.


```console
<properties>
	<property>
		<name>suitethreadpoolsize</name>
		<value>3</value>
	</property>
</properties>
```


## Running tests ##

- Run all test suites in parallel with _Chrome_ and _Firefox_

```console
$ mvn clean test -DsuiteXmlFile=suite-tests/TestSuites.xml
```

- Run *Login* test suite

```console
$ mvn clean test -DsuiteXmlFile=suite-tests/LogInTestSuite.xml
```

- Run *Signin* test suite

```console
$ mvn clean test -DsuiteXmlFile=suite-tests/SignInTestSuite.xml
```

- Run *Checkout* test suite

```console
$ mvn clean test -DsuiteXmlFile=suite-tests/CheckoutTestSuite.xml
```

## Generate Allure Report:

After test execution using maven, run the command:

```console
$ allure serve target/allure-results/
```

## References:

[Allure Documentation](https://docs.qameta.io/allure/)

[Maven Surefire Plugin Using TestNG](https://maven.apache.org/surefire-archives/surefire-2.22.2/maven-surefire-plugin/examples/testng.html)
