## Guess The Number

The program selects a random number (the default range is from 0 to 100) and prompts the user to guess it.
The program displays the minimum and maximum numbers in the our range, the user enters the number and the program injects a message that is a number greater or less than the number indicated. Then narrows the range.
In case of incorrect input an error message will be displayed.
When the entered number coincides with the hidden one, a congratulatory message and the complete statistics list of the entered data are displayed.

#### how to start
__UNIX__


need installed [maven](https://maven.apache.org/install.html)
 - download or git clone
 - type in terminal where pom file locate: ```mvn package```
 - type ```java -jar target/GuessTheNumber-1.0-SNAPSHOT-jar-with-dependencies.jar ```
