Feature: Weather Forecast Test

Scenario Outline: Validate 5 Days Forecast for a City.

Given Get the Forecast for "<CityName>"
When User Calls the "Get5DayFcstAPI" with "Post" http request
Then Data returned
|speed|deg |
|4.35|309|
Examples:
|CityName|
|London|
