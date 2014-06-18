pd1-wookierepellent-vorobyev-tsui
=================================
Derek Tsui, George Vorobyev  

| Description |  
The project is a physics demonstration of globular objects of Ooze that interact with each other.    
Physics concepts involved include: vectors, springs, gravity, momentum, Newton's Laws of Motion.  
Clicking on the screen produces various types objects (which are extensions of the MyPoint class).  
MyPoints can interact by becoming neighbors and exerting a spring force on each other, and all MyPoints must deal with gravity.  

Suggestions for experimenting:  
Point objects are points that create more rigid structures and platforms.  
Node objects are less rigid than points.  
Ooze is so loose that it can flow.  Its spring constant is the smallest.  

- Platforms can be built by making fixed points (press Shift, see "What Works")  
- Try making a narrow tube of Points such as a funnel, and forcing Ooze through it.  
- Try filling the bottom with any type of point, and then turning off gravity.  

| Instructions |  
Before compiling a folder named "build" is needed in the same directory that contains the "jellyworld" folder  

| Run in terminal |  
./compile	compiles  
./run		runs  

| What Works |  

Click the screen to make ooze.  
Click the screen while pressing Shift to make fixed ooze.

Debug mode: see the neighbor connections by pressing "D"  
Pause: press "P"  
Gravity on/off: press "G"

Toggle between Points, Ooze, and Nodes using "-" and "=".  

Increase point size: "]"  
Decrease point size: "["  

| What Doesn't |  
Currently missing features include: 
Platform/map saving  
Collision  

| Data Structure Highlights |  
LinkedLists are used to store all the nodes on the screen, and the links between nodes.  