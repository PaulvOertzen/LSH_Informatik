##Documentation
This File is for documenting our code and the changes we have applied to it. 

The setText class is used to read the text which is stored in a specific .txt-file. 
This is done with a BufferedReader and a FileReader. The content of this File is stored in a variable called input.
The While-function is used to itterate through each line of the file, until there is nothing left to read, 
after that the BufferedReader is closed.  

The getJump.java contains a class getJump that defines a HashMap and two functions. The Function fillHashMap() fills the HashMap
with abc and it's values, that the getJumpF Functions need to return the Length of the next Jump as LenghtOfJump. The getJumpF()
Function requires a character as parameter. It looks up the given character in the HashMap and returns it's value, that was set
by fillHashMap(). .The class structure is only temporary until we found a suitable solution for our project. !!!WorkInProgress!!!