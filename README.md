pd1-wookierepellent-vorobyev-tsui
=================================
Derek Tsui, George Vorobyev  

| Description |  
The project is a physics demonstration of globular objects of Ooze that interact with each other.    
Clicking on the screen produces Ooze objects (which are extensions of the MyPoint class).  
MyPoints can interact by becoming neighbors and exerting a spring force on each other, and all MyPoints must deal with gravity.  

| Instructions |  
Before compiling a folder named "build" is needed in the same directory that contains the "jellyworld" folder  

| Run in terminal |  
./compile	compiles  
./run		runs  


| What Works |  

Click the screen to make ooze.  
Debug mode: see the neighbor connections by pressing "D"  
Pause: press "P"  
Increase link connectivity size: "]" (only in debug mode)  
Decrease link connectivity size: "[" (only in debug mode)  

| What Doesn't |  
Currently missing features include:  
Different types of MyPoints  
Collision  

| Data Structure Highlights |  
LinkedLists are used to store all the nodes on the screen, and the links between nodes.  