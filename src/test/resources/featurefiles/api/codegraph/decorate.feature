@api
Feature: Admin can update decorator - [CODEGRAPH-2885]

  Scenario: Admin can update decorator - [25806982]
    When Get a decorator by name TestDecorator1, description Test decorator, type Normal Decorator, specifics registry2.swarm.devfactory.com/codenation/halstead-decorator:v2.1.0
    Then Verify validation request should be successful
