Feature: HomeLoans borrowing Calculations and eligibilty based on user inputs

Background:
Given launch homeloan calculation tool

@Loans
Scenario: Validate the Borrowing estimate on valid inputs

Given Application Type is Single
And Applicant has '0' dependants
And Property to buy is Home to live in
And Applicant has 'income (before tax)' as '80000'
And Applicant has 'other income' as '10000'
And Applicant has 'Other commitments' as '0'
And Applicant has 'expenses' as '500'
And Applicant has 'homeloans' as '0'
And Applicant has 'otherloans' as '0'
And Applicant has 'credit' as '10000'
Then Click on calculate BorrowEstimate button
When verify if estimate is '479000'
Then click on start over button to reset values

@Loans
Scenario: Validating the error response for invalid inputs
Given Application Type is Single
And Applicant has '0' dependants
And Property to buy is Home to live in
And Applicant has 'income (before tax)' as '0'
And Applicant has 'other income' as '0'
And Applicant has 'Other commitments' as '0'
And Applicant has 'expenses' as '1'
And Applicant has 'homeloans' as '0'
And Applicant has 'otherloans' as '0'
And Applicant has 'credit' as '0'
Then Click on calculate BorrowEstimate button
When verify estimate error response on submit