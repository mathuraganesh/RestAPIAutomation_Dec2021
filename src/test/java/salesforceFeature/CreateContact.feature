Feature: Create the Contact and Verify the Contact name

Scenario: Create the Contact

Given Create the Post with Body as 'Divya' and 'Lakshmi'
And Verify the Response code as 201
Then Validate the Response Body Contains as 'json'