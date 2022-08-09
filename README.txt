This test was created based on a guide given by 
https://blog.logigear.com/test-automation/building-a-selenium-framework-from-a-to-z/
!!---the info.txt contains the info within the page to construct a selenium testing framework

This framework is based on 4 packages:

drivers: contains classes and methods tocall selenuim web driver for firefox and chrome
	ChormeDriverManager: contains the file path of the chrome driver. NOTE: you should change this path when you run this test.
	DriverManager: contain the method that instantiates the selenium driver
	DriverManagerFactory: allows us to choose the browser we will use and instatiantes them
	DriverType: is an enum with all the browser option we have configured

InitialInformation: contains classes with methods that allows us to extract info. to begin with other classes
	SetUp: contains info about chrome driver manager, the initial page we want the test to begin with and the 
		location of the driver manager for chrome in our case
	ReadData: Contains the method that reads the excel file to fill the register user form and toehr testcases
	UrlManager: contains the methos that read the excel file with the urls we want to start with the test

PageObjects: contains the locators for the tests and the methods to simplify the testcases methods. Some methods
	include the name of the testcase class that implements it.

TestCases: Contains the testcases clases. Within each class at the beginning of it you can find the 
	pageObjects it will use and the name of the method it will implement.
-------------------------------------------------------------------------------------
NOTES: -Currently only the the test case RegisterAccountTest is the one that implements the excel file reading and extracting data
	-I had some issues creating inheritance from the class SetUp and it was removed, instead a setUp() method
		was added with the label @BeforeTest, this substitutes the SetUp class in all test cases.
	-The class UrlManager is not being used yet. Time issues, will do eventually
	
IMPORTANT NOTE: -Chrome 103 which is the version used for these test cases had a bug. this is the reason why everytime you see the
	url the chrome driver starts with is the log in page and not the home page. If you begin the teste in the home page 
	the web page will not load and stuk on the home page. This bug is solved by using another version of chrome and it
	respective driver. For simplicity this was not done.

