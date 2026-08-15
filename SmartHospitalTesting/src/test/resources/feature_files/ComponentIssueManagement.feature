@Harini
@ComponentIssueManagement
Feature: Harini_17/05/2026  Blood Component Issue
Background:
Given the user is on the login page
When the user clicks Super Admin button
And the user clicks the Sign in button
Then the user should be redirected to super admin dashboard
When the user clicks on the Blood Bank menu
And the user clicks on Component Issue button
Then the Component Issue Detail Status page should be displayed

Scenario: Verify user is able to search blood issue by recipient name
When the user searches blood issue details
  | ReceivedTo |
  | Jamie      |
Then the corresponding blood issue record should be displayed