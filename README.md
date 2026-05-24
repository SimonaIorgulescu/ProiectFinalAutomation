# Framework de testare automata pentru PRACTICE SOFTWARE TESTING

Framework de testare automata construit cu Java,Selenium,TestNG,
Maven, RestAssured si Allure Reports pentru testare UI si testare API.

## Tehnologii folosite:

- Java
- Selenium
- TestNG
- Maven
- Allure Reports
- Rest Assured

## Driver folosit
WebDriver Chrome

## Comanda pentru instalare Maven
mvn clean install

## Structura Proiectului

````
allure-report
allure-results
screenshots
src
    main
        java
            Pages
            utils
    test
        java
            API.config
            APITests
            Base
            Listener
            TestCases
            Tests
            utils
        resources
            -RegressionTests.xml
            -SmokeTests.xml
            -tests.xml
        README.md
````


## Rularea testelor

Rularea tuturor testelor:
mvn clean test

mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/tests.xml".

## Generare de rapoarte Allure:

mvn allure:serve

Generare raport static:

mvn allure:report

## Locatia raportului:
allure-report/index.html

## Locatia testelor UI
````
src
    test
        Tests
````

## Locatia testelor API
````
src
    test
        APITests
````
