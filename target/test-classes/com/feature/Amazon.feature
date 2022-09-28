Feature: Amazon Application

@smoke
Scenario: Home Page
Given user Lauch The Application Url
When user Click The Dropdown And Select The category
And enter The Product In SearchBox And  Click The SearchIcon

@regression
Scenario: Search Result Page
When user Count The Number Of Product Under Results
And user Count The Number of Products Under More_Results
Then close The Application Url
