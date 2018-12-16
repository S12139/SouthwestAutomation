# SouthwestAutomation

Instructions for running the test:
1) After cloning the project, open Eclipse and import the project.
2) Make sure Selenium jar is added to the project.
3) Download chromedriver.exe and place it in "C:\Selenium\Jar Files and Drivers" directory.
4) Go to src/tests/SearchFlight.java. Right click and run as testng. 

Test Case:
1) Go to https://www.southwest.com/
2) Validate whether user is on correct url
3) In the flights tab, enter departure airport, arrival airport and date. Click on search.
4) On the search results page, validate departure airport, arrival airport and date. 
5) Click on non stop flights and validate that only nonstop flights are displayed.
6) Select a price and then click on continue.
7) On the Trip and Price Details Page validate departure airport, arrival airport, date and the flight price.
