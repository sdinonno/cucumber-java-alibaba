# cucumber-java-aliexpress

Repository with practice on the website https://www.aliexpress.com/.

# Tech Stack
    1. Java
    2. Maven
    3. Cucumber
    4. Selenium 
    5. WebDriverManager
    6. TestNG

# Code
On pom.xml you will find dependencies and plugins that we will use for the code.

## src/main/java


## src/test/java
On this folder we will find all the code. It is compose by:

    1. hooks
    2. runner
    3. stepdefs

## src/test/resources/features
On this folder you will find the features files.

# Execution
Inside the directory where the project is located:

    1. mvn test

Other ways to run the tests:

    1. mvn test -Dcucumber.options="classpath:features/my_first.feature" to run specific feature.






