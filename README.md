Selenium Java Automation Project (TestNG)

This repository includes a basic end-to-end automation script created using Java, Selenium WebDriver, and TestNG.

🚀 Prerequisites

Before running the test, make sure you have the following set up:
JDK 8 or higher installed on your system
Selenium WebDriver JAR files added to your project’s build path
TestNG plugin installed in your Eclipse IDE (or added via Maven if preferred)

🧪 Test Workflow
The automated scenario covers these steps:
Opens a web browser
Loads the target webpage
Searches for a Bluetooth speaker
Chooses a product from the search results
Verifies availability details
Closes the browser once the test is complete

📂 Folder Structure
Project/
├── src/
│   ├── Flipkart.java
├── testng.xml
└── README.md


Flipkart.java – Contains the core Selenium test code

testng.xml – Defines the TestNG suite to be executed

README.md – Documentation file

▶️ Executing testng.xml in Eclipse

To run the suite file:
Find testng.xml in the Project Explorer
Right-click on the file
Choose Run As → TestNG Suite
