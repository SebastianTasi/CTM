# Writing a README sample

**Version 1.0.0**

Code and document samples for the writing a README test 

----

## Contributors

- Sebastian Tasi <tasi.sebastian@gmail.com>

---

## License & copyright

© Sebastian Tasi, London 



*Project Title 
Software QA Engineer Coding Challenge - Cucumber - v1

*Installation guide:* 
This is a maven project. so It's assumed that the host running this code have Java and maven installed and already set. 
Here is the guide for maven installation just in case : https://maven.apache.org/install.html

Project get all dependencies from maven repository. So no additional installation needed.

*Below are the dependencies are being used for this project 

Cucumber-Junit,
Cucumber-java,
RestAssured,
TestNG,
Selenium,
Bonigarcia Webdriver 

##Credentials  
Cucumber use public key and private key to authorize the request. to externalize the data a configuration reader utility are created to read configuration.properties. 
Due to sensitive nature of the keys , user is expected to provide his/her own key while running the tests. 

##Build and run your project 
This is maven project and tests are written in Cucumber Gherkin language . so we use maven command line commands to run the project as below to pick up tests:  

Go to your project directory from terminal and hit following commands

-- mvn clean test ( This is the main command of running Test from Terminal and getting the Cucumber HTML reports in Target Foldersoi )

-- mvn test (default will run on local firefox browser).

-- mvn test "-Dbrowser=chrome" (to use any other browser).

-- mvn test -Dcucumber.options="classpath:features/my_first.feature" to run specific feature.

-- mvn test -Dcucumber.options="–-plugin html:target/result-html" to generate a HTML report.

-- mvn test -Dcucumber.options="–-plugin json:target/result-json" to generate a JSON report.

##Architecture Info

-- src/test/resources/features : A new feature file will be created  under this path .feature ext required (Gherkin Syntax : is the language that Cucumber understands)

-- src/test/java/StepDefinition : Every feature file will be define by a step definition that comes into this package

-- src/test/java/env : Configuration/Setup comes from "CukesRunner" that allows you to glue your code location "Step_Definition", define test results output format "html, json, xml". "Hooks" you configure all @Before and @After test settings. "DriverUtil" contains code for initializing driver instances
 
-- src/main/java/browserConfig : Providing capabilities and platform information here



    Framework can be built with using TestNg or Junit  but preferred to use Cucumber BDD.
It is created basic Page Object Model design pattern but it can improve if needed.

*The design is POM(Page Object Model) framework is actual BDD Cucumber framework. I have Page Object Classes (Page Factory) to identify and store elements to utilize in testing and with help of PageWebFactory i am able to utilize all this elements through StepDefinition.
Runner Class is specifically to run all tests from one location.
The design is also Singleton Driver.
I will use Utilities to store Driver utility, Configuration reader utility, excel utilities, Page utilities, Browser utilities
I also store my cucumber feature files separately it also helps in reusability and utilise.
Step definitions are storing my actual code.
Hooks before and after steps and also take screenshoots.
An extra class for rerun will help us to rerun failed scenarios."# CTM" 
