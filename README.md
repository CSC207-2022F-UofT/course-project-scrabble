# Scrabble

Welcome to Scrabble, a game played and loved by millions around the world. Our team has decided to embark on a journey to rewrite 
scrabble using CSC207 principles and course concepts! 

Team members: Victor, Clark, Umair, Jazli, Francisco, Claire and Davit. 

## Rules of our game
We have written up [revised rules for scrabble](https://github.com/CSC207-2022F-UofT/course-project-scrabble/blob/main/src/main/java/gui/resources/revised_rules_of_scrabble.md) for our game. 
The rules of scrabble can also be visible through our UI pages. 

## How to play our game
To make it easy for everyone to use our game, we have created the following short tutorial on running and playing our scrabble game.

### First Step: Running the Game
To run our game, a player can `Run ScrabbleApp.java` in their console or through Intellij. Immediately following the run, the following page should display.
![image](/resources/WelcomePage.png)

### Second Step: Rules
Clicking on the `Rules` button will result in the following page. This can be convenient whenever someone wants to review how the game works!
![image](/resources/RulesPage.png)

## Third Step: Create Game
Clicking on the `Create Game` button will result in the following page. This button allows a user to start a new game from scratch with new player's names. The resulting page will pop up asking for the user to input their names.

![image](/resources/CreateGamePage.png)

## Fourth Step: Start Game
Clicking on the `Start Game` button on this page will result in the game loading. The game will take a few seconds to load as it must generate a large number of buttons. The following page will be visible after this step. There will be a 15x15 board, along with 7 tiles lining the bottom of the board. The 7 tiles consist of the available letters to be played. There are also five buttons located at the bottom for functionalities that will be explained below. 
![image](/resources/InitialBoardState.png)

## Fifth Step: Playing a Letter
If a user wants to play a letter, they must first click on the letter from the holder. They can click on any button on the holder. This will make the letter disappear, and the user will be only allowed to click on any tile in the 15x15 range to play their move. Following a click on any empty tile on the board, the letter will be immediately placed on the board. This continues until the user plays all of their moves. 
![image](/resources/PlayingA.png)

## Sixth Step: Playing a Word 
If the user decides that their preferred candidate move to play, they can press the `Play Move` button. This button will send the result to the "brain" of our application, and will spit back a result. If the word is valid, then it will indicate that it is the next player's turn to play. If the move is invalid, it will indicate that the move is invalid and display "Invalid Move" on the screen.
![image](/resources/PlayingAWord.png)

## Seventh Step: Recalling Tiles
If the user finds that their moves don't make sense and would like to replace their letters in another order, they can do so by pressing the `Recall Tiles` button. This will recall the tiles in the previous ordering seen at the start of the move.

## Eighth Step: Shuffling Hands
If the user finds that the hand is hard to read, and would like to move their tiles around, they can call the `Shuffle Hand` button, which moves the tiles on the holder around in a randomized order.
![image](/resources/ShuffleHandButton.png)

## Ninth Step: Game Play
Continue playing words and scoring words correctly.
![image](/resources/real-game.png)

## Final Step: Ending Game
If both players agree to end the game, then they can press the `End Game` button, which will calculate the scores of the game and display them back through our Exit page. Our application will also calculate if there are no tiles left to be played, which will also end the game according to our rules. The winner will then be displayed for everyone to see. 
