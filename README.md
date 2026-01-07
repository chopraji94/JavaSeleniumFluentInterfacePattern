# Java Selenium Fluent Interface Pattern

This repository demonstrates the implementation of the **Fluent Interface Design Pattern** in a Selenium Automation Framework. The primary goal of this pattern is to improve code readability and maintainability by utilizing **Method Chaining**.



## 🎯 What is the Fluent Interface Pattern?

The Fluent Interface pattern allows you to chain method calls together in a single statement. In the context of Selenium Page Objects, this means each action method returns an object (usually `this` or the next Page Object), allowing the test to flow logically.

### Before (Standard Page Object)
```java
LoginPage login = new LoginPage(driver);
login.enterUsername("admin");
login.enterPassword("password123");
login.clickLoginButton();
After (Fluent Interface)
Java

new LoginPage(driver)
    .enterUsername("admin")
    .enterPassword("password123")
    .clickLoginButton();
🚀 Key Benefits
Readability: Tests read like natural language sentences.

Conciseness: Reduces boilerplate code and repeated object references.

Flow: Clearly visualizes the user journey through the application.

🛠️ Tech Stack
Language: Java (JDK 8+)

Automation: Selenium WebDriver

Test Runner: TestNG

Build Tool: Maven

📂 Project Structure
Plaintext

JavaSeleniumFluentInterfacePattern
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── pages
│   │               └── FluentLoginPage.java    # Page Object with chaining logic
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── tests
│   │               └── FluentLoginTest.java    # Test class using chained methods
├── pom.xml                                     # Dependencies
└── testng.xml                                  # Suite Configuration
⚙️ How It Works (The "Return This" Magic)
To implement a Fluent Interface, your Page Object methods must return an object instead of void.
```

Returning the same page: If an action keeps the user on the same page (e.g., typing in a field), the method returns this (the current class instance).

Returning a new page: If an action navigates to a new page (e.g., clicking login), the method returns a new instance of the next Page Object.

Code Example (src/main/java/.../FluentLoginPage.java)
Java

public class FluentLoginPage {
    WebDriver driver;

    public FluentLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Returns 'this' to allow chaining on the same page
    public FluentLoginPage enterUsername(String user) {
        driver.findElement(By.id("user")).sendKeys(user);
        return this; 
    }

    public FluentLoginPage enterPassword(String pass) {
        driver.findElement(By.id("pass")).sendKeys(pass);
        return this;
    }

    // Returns a new Page Object representing the next screen
    public HomePage clickLogin() {
        driver.findElement(By.id("loginBtn")).click();
        return new HomePage(driver);
    }
}
📦 Dependencies
Ensure your pom.xml includes:

selenium-java

testng

webdrivermanager

🏃‍♂️ How to Run Tests
Using Maven
Run the tests via the command line:

Bash

mvn clean test
Using IDE (IntelliJ / Eclipse)
Open testng.xml or the specific Test class.

Right-click and select Run.

🤝 Contributing
Fork the repository.

Create your feature branch.

Add new fluent pages or tests.

Submit a Pull Request.

📚 References
Fluent Interface - Martin Fowler

Selenium WebDriver Documentation
