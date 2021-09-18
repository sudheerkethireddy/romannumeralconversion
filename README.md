# Numeral to Roman Conversion API
This repo holds the code that exposes a REST API that coverts integer to numeric.


## Implementation rationale
The problem statement is to develop a REST API that converts integer to roman numeral. Since there is only
one resource/function to be acted upon, we have only one Resource to Implement the CRUD operations against.
The problem statement is to return only the roman numeral of an input integer, we have only
implemented GET call. When the client calls POST, PUT DELETE operations, we return NOT SUPPORTED implying that only GET is supported.
Also implemented OPTIONS call that gives you overview of the allowed calls by the end point.

## Organization of the flow
The entry point to the application is via the `RomanNumericServiceApplication` that resides outside of all the classes since
it can load all the beans under various packages which will be within the class path of the `RomanNumericServiceApplication` class.
Upon starting this class all the beans are loaded into spring-context.
`RomanNumericController` class is the entry point for every API call. The 
controller bean inturn calls the service class named `IntegerToRomanConversionService` that holds
the business logic. The problem statement is to calculate roman numeral for integers in the range 1-3999 which is finite and can be handled
by the service class and in-memory without any database required. Since there is no Calls to API, there are no DAO/DTO beans to be defined.



## Swagger Doc
Also implemented swagger doc that gives the customer access to the API and play  with. This swagger doc is implemented using Spring boot Open API.
The swagger doc can be accessed at the uri `http://localhost:8093/swagger-ui/index.html`

## Code coverage

extensive unit tests are added to make sure that all scenarios covered. The line coverage
stands at 98% and class coverage at 100%. Below screenshot shows
the same.
![Unit Test Coverage](src/main/resources/unit-testing.png?raw=true )

## Metrics, Monitoring and Alerting:
