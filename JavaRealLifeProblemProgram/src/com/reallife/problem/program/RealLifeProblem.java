package com.reallife.problem.program;
/*
------------------------ 
Elevator System 
------------------------ 

Use Cases : 

1. Passanger/User wants to go to the different floor. 
2. He request the floor number in the elevator system 
3. Elevator picks the person 
4. Elevator delivers the person to the floor. 

-----------------------------------
What if elevator is running ? 

-> If it is going to the same direction, it will pick the person on its way 
-> If it is open state, it will wait to get it running state 
-> If elevator is in halt/maintainance state, it will not respond 
-> If it is waiting state, it will start moving. 

------------------ Alternate usecases---- 
-> Elevator has a maximum number of floor. 
-> A user can request for call, alarm, stop, keep door open/close such commands 
-> Elevator has preferrences like door will keep open for 5 seconds for loading or unloading. 

------------------ 
Let's find out the classes, attribute and datastructure by doing language analysis 
--------------------------------------------------------------------------------- 
1. Passanger 
-> srcFloor 
-> destinationFloor 
*issueRequest(int dest) 
*issueAlarm() 
*issueStop() 

2. Elevator 
-> state 
-> direction 
-> speed 
-> targetted Floors 
*openDoor() 
*moveUp() 
*moveDown() 
*stop() 
*startAlarm() 

3. State (Enum) 
-> Running, Open, Idle, Stopped, Alarmed 

4. Floor 
-> number 
-> isServiced 
*/