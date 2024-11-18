# Instruction:
This is a short instruction on how to use this program and what is does.
## How it works:
This program works like this: <br>
You save your text, which you want to be checked as a .txt file.
The program takes your text and iterates through it and determines if there is an intersection or not. 
If there is an intersection you will find a '$$$' -marking in your text, this is the word, you must change in order
to prevent an intersection.
In case there is no intersection in your text, you do not need to change anything at all and there will not be any markings in your text.
If an intersection occurred, you will be notified through the terminal, in case there is not one, you will not be notified. <br>
## How to use:
Before you can execute this programm, please had over to Oracle's Website, download and install the latest jdk version. <br>
Once you have done this step, open your terminal and go to the folder "ExecutableProgramm". <br>
Then use the following command: java -jar Hopsitext.jar <br>
You will get a message, to specify a filepath, where the file you want to be checked lives.
You have to specify an absolute directory. An absolute directory looks something like this: <br>
Windows: "C:\Users\User\Documents\file.txt" <br>
Linux: "/home/user/documents" <br>
<br>
In case you want to close the programm, simply press Ctrl+C
## Troubleshooting:
Please take special care of the directory-specification, since the program will not find your intended file if there are typo's, etc.
You will get an error-message in case of an invalid directory and put it a new one.
Please make sure, that your intended directory is not hidden, secured by a password or encrypted. 

