Feature: IncidentManagement

Scenario: Create the Incident

#Given Set the EndPoint
#And Enter  the basic Authentication with Valid Credentials
When Create the Post Request
Then Verify the status code as 201
And Verify the Response body contain ContentType as 'application/json'


Scenario: Create the Incident with 2 Set of Data

#Given Set the EndPoint
#And Enter  the basic Authentication with Valid Credentials
When Create the Post Request with Body as 'Create The Incident' and 'Software'
Then Verify the status code as 201
And Verify the Response body contain ContentType as 'application/json'

Scenario Outline: Create the Incident with 2 Set of Data

#Given Set the EndPoint
#And Enter  the basic Authentication with Valid Credentials
When Create the Post Request with Body as '<shor_desc>' and '<category>'
Then Verify the status code as 201
And Verify the Response body contain ContentType as 'application/json'

Examples:
#rows and columns
|shor_desc								|category|
#1st row
|Create the Incident-data1|Hardware|
#2nd row
|Create the Incident-data2|Software|