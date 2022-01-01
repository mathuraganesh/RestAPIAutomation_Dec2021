Feature: JIRA Issue

#Assignment 
#==========
#1) Create a issue  with body using Scenario Outline (2 set of data) and verify response body
#2) Update the one of the issue with description and add assertion with status code & contentType. 
#3) Including Cucumber annotation , Scenario , Scenario Outline

Scenario Outline: Create a issue  with body with 2 set of data

Given Send the request with body as 'summary' and 'description'
And Verify the Status code as 201
Then Verify the response body contains ContentType as 'json'

Examples:
|summary												 |description																																					 |
|create issue in RA project-1data|Creating of an issue using project keys and issue type names using the REST API-1data|
|create issue in RA project-2data|Creating of an issue using project keys and issue type names using the REST API-2data|


Scenario: Update an issue  with body with 1 set of data

Given Update the request with body as 'Update issue in RA project' and 'Update of an issue using project keys and issue type names using the REST API'
And Verify the Status code as 204
Then Verify the response body contains ContentType as 'json'