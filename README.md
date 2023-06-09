# Robots-Suck
Simulating robots cleaning a dirty room with Java

## Text Files
Within this project are two important files in determining the parameters of the simulation.

### _room.txt_
Just one line containing one integer _**M**_, which determines how many how many cells are within each axis of the room (square grid). </br>
We make the assumption that the number is odd.

### _robots.txt_
Consists of the first line being the number of robots present and every subsequent line being the horizontal and vertical coordinates as well as the initial direction of travel. </br>
When **_N > 1_**, by default the first robot starts at the coordinates (0, 0) with the direction of travel up (U)

_Example:_
When there is only one robot,
> 1</br>
> 5 5 D

Where the only robot starts at (5, 5) with a direction of travel downwards.

When there are _n_ number of tickets,
> 3</br>
> 5 5 D     (coordinates for robot _n-1_) </br>
> 0 1 R     (coordinates for robot _n-2_) </br>
> h_n v_n d_n
