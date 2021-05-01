
# Table of Contents

1.  Project and student
2.  Chosen variant (step 4)
    1.  Controller{}
    2.  Game.getFourTiles()
    3.  MyView.askFourTiles(int player, ArrayList<Tile> fourTiles)
    4.  Game.canFourTilesBePut(int player, Position position)
    5.  Board.canFourTilesBePut(position)
    6.  Game.putFourTiles(int player, ArrayList<Tile> fourTiles, Position position)
    7.  View{} and Model{}
3.  Multiple winners and draw (step 3)




# Project and student

Project: `Lucky Numbers`

Student: `g56935`



# Chosen variant (step 4)

I didn't know if we had to write this file in English or in French, so I did both in REAMDE.md and LISEZMOI.md.

For the start of the game, I chose to code the third variant: `Official version`

To be able to do this, I had to modify some parts of my program, and add some as well.



## Controller{}

I first modified my `Controller` class to add a list of Tiles in the `case NOT_STARTED` block.

Then I created a `for` loop that goes from zero to the number of players (2 to 4).

In this `for` loop, I started by adding four random Tiles in the list of Tiles, using the method `Game.getFourTiles()`

Then I wrote a `While` Loop that will run as long as there is at least one Tile left in the list of four Random Tiles.

In this `While` loop, I first display the boards of the players using `MyView.displayGame()`, then I ask the current player (of the first `for` loop) to enter the position where he wants to put the first Tile of the list of random Tiles (`MyView.askFourTiles()`).

After that, I put the Tile in his board and I remove it from the list of random Tiles (`Game.putFourTiles()`), and I do that again until there are no random Tiles left (`while`), then it will do the same for each player (`for`) until all the Tiles of all Players are placed on their board.

Then the game starts.



## Game.getFourTiles()

This method just creates four random Tiles and returns a list with all of them.



## MyView.askFourTiles(int player, ArrayList<Tile> fourTiles)

This method takes two variables as a parameter:

-   An integer, the number of the current player we are working with (the `i` of the `for` loop)
-   an ArrayList of Tiles, the list of the four random Tiles we just created

It is important to know which player is concerned,  and which Tiles he can add on his board.

This method will first show the four random Tiles to the player, and ask him where he wants to put the first one.

It will ask for a row, but not a column, because the column is equal to the row (he must put it in diagonal). This method will keep asking until the player enters a valid row (1 to 4) and until the place chosen is free, because we can't put two Tiles at the same place at this moment of the game. To do this, I use the method `Game.canFourTilesBePut()` that I wrote to check if the user didn't choose wrong place.



## Game.canFourTilesBePut(int player, Position position)

This method uses the method `Board.canFourTilesBePut()`.



## Board.canFourTilesBePut(position)

This method returns true only if the position is free, inside the board, and in the diagonal.



## Game.putFourTiles(int player, ArrayList<Tile> fourTiles, Position position)

Now that we know the player, the list of four random Tiles and the (valid) position where the player wants to put it, we can add it on his board and remove it from the four random Tiles list.

As explained before, this method will just add the Tile in the board of the Player at the Position chosen, then remove the Tile from the list of four random Tiles.



## View{} and Model{}

I added 1 abstract method to `View` and 3 abstract methods to `Model`, because I thought they were essential to the proper functioning of the game.

`View:`

-   `askFourTiles();`

`Model:`

-   `getFourTiles();`
-   `canFourTilesBePut();`
-   `putFourTiles();`



# Multiple winners and draw (step 3)

I thought it would be a great idea to explain here how my multiple winners work.

When I wanted to write my `getWinners()` method, I first thought about returning a list of players, which I thought was the best solution.

Then I read the project statement several times, and I realized that it is written that the only modification to be made on the `getWinner()` method, is only to add an "s" to it.

So I looked for a way to be able to know the different winners using only an integer, and I found a solution that I think is absolutely correct.

I decided to use a process similar to the one used for permissions in Linux systems, based on the powers of two.

Indeed: `Read=4`, `Write=2` and `eXecute=1`. This allows us to determine all the permissions of a file only using a decimal integer. So, if we have `rwx`, then the integer will be `4+2+1 = 7`, and if we have `r-x` then it will be `4+1 = 5`. This allows us to find the values ​​by making modulos on the total number.

So, I decided that `player0=1`, `player1=2`, `player2=4` and `player3=8`. This can easily be found by performing `2^playerNb`.

Then, if for example the number of `winners = 10`, then we can find the winners by doing these steps:

-   (10%8 < 10)? yes then player3 won and (winners=winners&#x2013;2<sup>3</sup>) = 2
-   (2%4 < 2)? no then player2 didn't win
-   (2%2 < 2)? yes then player1 is a winner and (winners=winners&#x2013;2<sup>1</sup>) = 0
-   (0% 1 <0)? no then player0 didn't win

Therefore, with `winners=10`, the winners are player4 and player2.

Of course I didn't write all these lines, I only wrote this one in a loop:

-   `(winners%2^playerNb < winners) ? yes then print("playerNb won") and (winners-=2^playerNb)`

I must also specify that I chose to use modulos in order to train myself to use this operation which was unknown to me until this year. But in reality it seems to me that this method could work very well by checking if (winners-8 >= 0) then (winners-4 >= 0) etc &#x2026;

I also added a way to determine if a game is a draw or not. So, I created a private method (`MyView.calcDraw()`) that returns the value of winners if all players win, and when displaying winners, I compare this value with the actual value of winners in the current game. So, if the two values are the same, then all the players are tied, and I am calling a draw.

I preferred to specify this so that my code is not incomprehensible when it is read by another person.

Thank you for reading this.

