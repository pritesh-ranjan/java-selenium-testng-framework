# java-selenium-testng-framework
# Test Automation Framework

The Test Automation Framework is designed for automating UI testing using Selenium and TestNG. It provides a structured approach to writing automated tests, with a focus on maintainability, reusability, and efficient reporting.

## Features

- **Version control:** The project code is stored in Azure Repos, utilizing Git for efficient version control.
- **CI/CD:** Azure DevOps pipeline is used for continuous integration and deployment, enabling seamless automation workflows.
- **UI Testing:** Java Selenium and TestNG are employed for UI testing within the framework.
- **Build Management:** Maven is used for the build lifecycle, with project dependencies defined in the `pom.xml` file.
- **Configuration Management:** Test framework configuration information is stored in a properties file.
- **Base Test Class:** Contains common code required by all test methods, including setup and teardown methods for initializing and closing the WebDriver and managing database connections.
- **Custom Exception Classes:** Enhances error identification through custom exception classes located in the main package.
- **Important Constants:** Defines common constant information, such as UI values and names, in the main package.
- **Custom Annotations:** Utilizes custom annotations for reporting purposes, particularly with ReportPortal integration.
- **Assertions Package:** Incorporates AssertJ for performing hard and soft assertions.
- **Page Object Model:** Implements the Page Object Model design pattern, with a base page class containing common methods for interacting with pages. Each page class inherits from the base page class and has private locators, with public methods for interacting with those locators.
- **Test Classes:** Test classes inherit from the base test class and include their own setup and teardown methods. Each test method is annotated with `@Test`, with additional information such as groups and data providers specified within the annotation.
- **Logging:** Utilizes log4j along with TestNG ITestListener for comprehensive logging.
- **Utility Package:** Contains common utility methods, including a properties reader for retrieving configuration information, methods for reading test data from JSON files, and database connection and query execution methods.
- **Code Readability:** Lombok is used to enhance code readability and conciseness.

## Usage

To use the Test Automation Framework, follow these steps:

1. Clone the project repository from Azure Repos.
2. Ensure that the necessary dependencies specified in the `pom.xml` file are installed.
3. Configure the test framework by modifying the properties file with the required settings.
4. Implement your UI tests by creating test classes that inherit from the base test class and utilizing the provided annotations and utility methods.

### Sample Test Method

```java
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        loginPage.clickLoginButton();
        // Add assertions and further test steps here
    }
}
```

## Run the tests
Command Line Execution

```bash
mvn clean test
```





## Contribution

Contributions to the Test Automation Framework are welcome! If you encounter any issues, have suggestions for improvements, or would like to add new features, please create a pull request or open an issue in the project repository.

## License

The Test Automation Framework is open-source and available under the [MIT License](https://opensource.org/licenses/MIT). Feel free to modify and distribute it as needed.
