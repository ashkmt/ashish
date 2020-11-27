This is a maven project, with pom.xml has all the dependencies.
The src folder in the repository contains all the code.

I installed Natural9.0 for Gherkin support.
The test can be run through eclipse "RunAs->JUnit Test".

Framework:
Given is parameterized with the "CityName" parameter, this can cater to all the possible ways the parameter 'q'
can be input({City Name} or {City Name},{State} or {City Name},{State},{country}) as given in the API Docs.
the Given method in the step Defination parses the City input.

Expected Result were input in DataTable, which will be compared with the response after deserialising it.
As it was a big JSON, I only planned to compare the "list"->"wind" attribute, which is one of the Dominant Condition.

Result:
Error: On deserialising the results.


