# java-battleship

This is a terminal game designed to be executed in local environment.

# Project objective:
Practice java OOP programming by building a famous, classic game - Battleship

# How to play?
- Two players take turn to enter 5 ships in game field. Each with length 5,4,3,3,2.
- You can imagine 2 players have 2 secret boards. In each board, the upper part shows cells a player hit and really hit the opponent ships. The lower part shows their own ships state. The below is a demo of one side of the boards.

(Opponent state. “~” is sea, “X” means hit ship.)
  1 2 3 4 5 6 7 8 9 10
A X ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

---------------------
(Own state. “~” means sea, “O” means ships not yet get hit, “X” means hit ship.)
  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~
B O M ~ ~ ~ ~ ~ ~ O ~
C O ~ ~ ~ ~ ~ ~ ~ O ~
D O ~ ~ ~ ~ ~ ~ ~ O ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ O O O O O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ O ~ ~ ~ ~ ~ ~ ~ ~
J ~ O ~ ~ ~ ~ ~ O O O


- Then the game start.
- Each player take turns to hit the opponent. The opponent then gives 1 of the 2 responses: hit or miss. Both players mark the result. The game continue until 1 of the player loses all his ship.

# How to run in local environment?
Clone the Main.java file into your local environment. Run as Main.
