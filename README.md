# AI QA BDD Automation Framework

A scalable and enterprise-ready automation framework built using Java, Selenium WebDriver, Appium, Cucumber BDD, TestNG, REST Assured, and Maven.

This framework supports:

- UI Automation Testing
- API Automation Testing
- Mobile Automation Testing (Android & iOS)
- Database Validation
- Parallel Execution
- Jira Integration
- Advanced Reporting
- MCP Server Integration
- CI/CD Integration with GitHub Actions

---

# Framework Architecture

This automation solution is divided into two repositories:

| Repository | Purpose |
|---|---|
| **Private Repo (`qa-automation-core`)** | Contains reusable automation engine, utilities, listeners, driver management, reporting, Jira integration, mobile utilities, and framework core |
| **Public Repo (`qa-bdd-tests`)** | Contains feature files, runners, step definitions, test scenarios, and project-specific test implementations |

---

# Features

## BDD Automation
- Cucumber BDD with Gherkin syntax
- Reusable step definitions
- Tag-based execution

## UI Automation
- Selenium WebDriver support
- Cross-browser execution
- Page Object Model design
- Smart waits and reusable methods

## Mobile Automation
- Appium support for Android and iOS
- Native App Testing
- Mobile Browser Testing
- Gesture support (Swipe, Scroll, Long Press)

## API Automation
- REST API validation
- Request/Response verification
- JSON serialization and deserialization

## Reporting
- ExtentReports integration
- Screenshot capture on failures
- Execution summary generation

## Jira Integration
- Automatic Jira ticket creation
- Failure logging support

## Parallel Execution
- Multi-threaded execution using TestNG
- Faster execution time

## Database Validation
- UI vs Database comparison testing
- JDBC integration

## MCP Server Integration
- GitHub MCP Server
- Selenium MCP Server
- Appium MCP Server

---

# Technology Stack

| Technology | Usage |
|---|---|
| Java | Core programming language |
| Selenium WebDriver | Web automation |
| Appium | Mobile automation |
| Cucumber | BDD implementation |
| TestNG | Test execution |
| Maven | Build management |
| REST Assured | API testing |
| MySQL | Database validation |
| ExtentReports | Reporting |
| GitHub Actions | CI/CD |
| Docker | MCP Server execution |

---

# Repository Structure

## Private Repository — `qa-automation-core`

```text
qa-automation-core/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── utilities/
│       │           ├── CustomWebDriverListener.java
│       │           ├── DriverFactory.java
│       │           ├── ExtentUtility.java
│       │           ├── JiraUtility.java
│       │           ├── ReusableMethods.java
│       │           ├── ScreenshotUtil.java
│       │           ├── MobileUtils.java
│       │           └── TestBaseClass.java
│       └── resources/
│           └── ConfigFiles/
│               └── config.properties
├── mcp.json
├── pom.xml
└── README.md
```

---

## Public Repository — `qa-bdd-tests`

```text
qa-bdd-tests/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       ├── runners/
│       │       │   └── CucumberTestRunner.java
│       │       └── stepdefinitions/
│       │           ├── ApiSteps.java
│       │           ├── CucumberHooks.java
│       │           ├── MobileSteps.java
│       │           └── UISteps.java
│       └── resources/
│           └── features/
│               ├── ApiTests.feature
│               ├── MobileTests.feature
│               ├── UIDBComparisonTests.feature
│               └── UISearchTests.feature
├── testng-bdd-web.xml
├── pom.xml
└── README.md
```

---

# Prerequisites

Before running the framework, install the following:

- Java 8 or higher
- Maven 3.6+
- Git
- Node.js
- Docker Desktop
- Android SDK
- Appium Server

---

# Installation

## Clone Public Repository

```bash
git clone https://github.com/anilds47/qa-bdd-tests.git
cd qa-bdd-tests
```

---

## Install Dependencies

```bash
mvn clean install
```

---

# Maven Dependency for Public Repo

Add the private core framework dependency inside the public repo `pom.xml`.

```xml
<dependency>
    <groupId>com.qaautomation</groupId>
    <artifactId>qa-core-framework</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

---

# Configuration

## config.properties

```properties
# Browser Configuration
browser=chrome
headless=false

# Application URLs
baseUrl=https://example.com
apiBaseUrl=https://api.example.com

# Database Configuration
dbUrl=jdbc:mysql://localhost:3306/testdb
dbUsername=user
dbPassword=password

# Jira Configuration
jiraUrl=https://yourcompany.atlassian.net
jiraUsername=username
jiraPassword=password
jiraProjectKey=PROJ

# Mobile Configuration
MobilePlatform=Android
MobileDeviceUDID=emulator-5554
AppiumServerUrl=http://127.0.0.1:4723/wd/hub
MobileDeviceName=AndroidDevice
MobileAppPackage=com.example.app
MobileAppActivity=.MainActivity
MobileAutomationName=UiAutomator2
```

---

# MCP Server Setup

This framework supports Model Context Protocol (MCP) servers for advanced automation support.

## Docker Installation

Download Docker Desktop:

https://www.docker.com/products/docker-desktop

Verify installation:

```bash
docker --version
docker run hello-world
```

---

# MCP Configuration

## MCP File Location

### Windows
```text
%APPDATA%\github-copilot\intellij\mcp.json
```

### Linux / macOS
```text
~/.config/github-copilot/intellij/mcp.json
```

---

## Sample MCP Configuration

```json
{
  "servers": {
    "github": {
      "command": "docker",
      "args": [
        "run",
        "-i",
        "--rm",
        "-e",
        "GITHUB_PERSONAL_ACCESS_TOKEN",
        "-e",
        "GITHUB_API_HOST",
        "ghcr.io/github/github-mcp-server"
      ],
      "env": {
        "GITHUB_PERSONAL_ACCESS_TOKEN": "github_pat_token",
        "GITHUB_API_HOST": "api.github.com"
      }
    },

    "selenium": {
      "command": "npx",
      "args": [
        "-y",
        "@angiejones/mcp-selenium@latest"
      ]
    },

    "appium-mcp": {
      "disabled": false,
      "timeout": 60000,
      "type": "stdio",
      "command": "npx",
      "args": [
        "appium-mcp@latest"
      ],
      "env": {
        "ANDROID_HOME": "C:\\Users\\anild\\AppData\\Local\\Android\\Sdk"
      }
    }
  }
}
```

---

# Running Tests

## Execute All Tests

```bash
mvn test -DsuiteXmlFile=testng-bdd-web.xml
```

---

## Run Smoke Tests

```bash
mvn test -Dcucumber.options="--tags @smoke"
```

---

## Run Mobile Tests

```bash
mvn test -Dcucumber.options="--tags @mobile"
```

---

## Execute Tests in Chrome

```bash
mvn test -Dbrowser=chrome
```

---

## Execute Tests in Firefox

```bash
mvn test -Dbrowser=firefox
```

---

# TestNG Parallel Execution

```xml
<suite name="BDD Test Suite" parallel="methods" thread-count="3">
    <test name="BDD Tests">
        <classes>
            <class name="com.runners.WebCucumberTestRunner"/>
        </classes>
    </test>
</suite>
```

---

# Mobile Automation Setup

## Install Appium

```bash
npm install -g appium
npm install -g appium-doctor
```

---

## Install Android Driver

```bash
appium driver install uiautomator2
```

---

## Install iOS Driver

```bash
appium driver install xcuitest
```

---

## Start Appium Server

```bash
appium --address 127.0.0.1 --port 4723
```

---

# Android Setup

1. Enable Developer Options
2. Enable USB Debugging
3. Connect device or emulator

Verify device:

```bash
adb devices
```

---

# iOS Setup

1. Install Xcode
2. Start iOS simulator
3. Verify simulator

```bash
xcrun simctl list devices
```

---

# Reporting

Generated reports:

```text
HtmlReports/Reports/
HtmlReports/FailedScreenshots/
test-summary.html
test-summary.txt
```

---

# GitHub Actions Support

Supports:

- Self-hosted runners
- Parallel mobile execution
- Dynamic device configuration
- Emulator and real device execution

---

# Best Practices

- Follow Page Object Model
- Use reusable step definitions
- Avoid hardcoded waits
- Maintain reusable utilities
- Use tags for categorization
- Keep locators centralized

---

# Troubleshooting

## Common Issues

### WebDriver Not Found
Use WebDriverManager or add browser driver to system PATH.

### Appium Session Failure
Verify Appium server is running and device is connected.

### Docker Issues
Ensure Docker Desktop is running before starting MCP servers.

### Parallel Execution Issues
Use thread-safe driver management.

---

# Debug Mode

```bash
mvn test -DforkCount=0 -DreuseForks=false
```

---

# Contributing

1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push changes
5. Create pull request

---

# License

This project is licensed under the MIT License.

---

# Author

## Anil D S

Senior Software Test Engineer

Specializations:
- Selenium Automation
- Appium Automation
- API Automation
- BDD Framework Development
- CI/CD Integration
- Mobile Automation
- Test Framework Architecture

GitHub:
https://github.com/anilds47

---

# Support

For issues and support:

- Create GitHub Issues
- Review troubleshooting section
- Check framework documentation
