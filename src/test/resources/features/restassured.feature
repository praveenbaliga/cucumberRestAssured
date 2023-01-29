Feature: Rest assured CRUD operations


  #GET method
  Scenario:
    Given the end point
    When user performs get operation
    Then user should be able to get employee information
    And user should be able to verify the data in the output

  # POST method
  Scenario:
    Given the end point
    When user performs post operation
    Then user should be able to post employee information

   # PUT method
  Scenario:
    Given the end point
    When user performs post operation
    Then user should be able to post employee information


  # Schema validator
  Scenario:
    Given the end point
    When user performs get operation
    Then user should be able to validate the output against the schema


