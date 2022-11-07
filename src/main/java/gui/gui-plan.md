# gui Plan 

Implementation plan: 
1. Research JavaFX
2. Victor and Clark meet to talk about gui to Game functions and how we want to make it work together. 
3. Complete a basic console simulation of the same thing without JavaFX
    - 15 x 15 board simulated scrabble game. Every cell is separated by "-"
    - player first starts game by running the program. First input is the player 1 and player 2 names
    - player can play a move by imputing the letter as the first parameter, followed by the coordinate as the second parameter. 
    - once ready to play the move, the player can type "play"
    - word played is displayed, player name, player score, points gained is displayed as well. The board is updated
      - if word is illegal, a display pops up prompting the player 1 to replay the move
      - if word is legal, the move is played.
    - player two plays their move, continues in that circle.
    - implement what happens when game is ended.
      - when a player "resigns" the game by calling "quit"
      - when players end the game and the file needs to be stored (players can choose whether to save or not)
    - implement what happens when a player has no moves - player needs to redraw from the board
4. Implement JavaFX basic usage 
    - display screen
    - have an entry screen with the title of our game, and one button called "Play"
    - add a "Rules" button to the same page
    - have a 15 x 15 board of empty space with a dot at the middle of every tile
    - have a 15 x 15 board of empty squares with letter multipliers (add word multipliers if we have time)
    - create a display screen of current words available on the right hand side of the screen. 
    - have people able to type the letter and coordinate into a text field input. Word displays. 
    - be able to press the play button after person places all the words they want
