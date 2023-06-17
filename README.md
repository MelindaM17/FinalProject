## FastTrackIT final project documentation

The purpose of this project is to automate the testing of the website https://demoqa.com/books using various testing tools.

The framework used is Selenium WebDriver, and the tests are run with TestNG.

The **pom.xml** file contains all the Maven dependencies that are necessary for running the tests: Selenium, Chrome Driver, TestNG, FireFox Driver.

The project was created using the **Page Object Model** design pattern, so it consists of 2 packages: pages and testCases.

The **pages** package contains the locators from the pages BookStorePage, LoginPage, RadioButtonPage and TextBoxPage. It also contains the BasePage class which is the parent class for the other classes. Here I set the URL for the tested website and common settings for each class:
- through the **@BeforeClass** method, an instance of Google Chrome is opened, after which it will be redirected to the tested website;
- through the **@AfterMethod** method, the instance of Chrome is closed after running each test.

The **testCases** package contains the test cases related to the elements of the classes mentioned in the pages package.

The project contains both positive scenarios, through which I ran tests using valid data and inputs, as well as negative scenarios, where I used invalid data and inputs and verified the presence of error messages.

TestNG will execute the test cases and finally generates a report with the test results:
![Picture1](https://github.com/MelindaM17/FinalProject/assets/132599174/2c4861ac-578d-4722-a9a5-2a1d04d11242)
