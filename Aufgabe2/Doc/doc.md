# How to use
## Execution
``` 
run the "Aufgabe2.jar" or self-compile and execute the files in source
```
## Usage
when prompted, input the path to a file or press enter and use a default path defined in the program
# How it works
## In human language
- The program reads the given file
- it transforms the content so that it can work with it
- it adds the given comparisons as edges to a graph
- it sorts the graph using topological sort
- it strips the output to only the requested items
- it prints those items to the console
## a more detailed description
### Main
#### main()
initialises IO_functions as iof and Graph as graph, then uses iof to get the data given in provided file.
After that, the graph is created, the individual keys are extracted and topological sort is executed.
At last, the sorted items are cleaned so that only the wanted items remain, then the result is printed.
### Graph
has a private map of nodes and lists of nodes which represents the graph, named adjacencyListMap.
#### shrinkToOnlyValuesOfInterest()
this function takes in a string as provided in given file, initialises a List (splitItems), then loops through the entire string and only adds valid characters to the splitItemsList, then returns it.
#### BuildGraphByList()
Loops through the List provided, but skipps the first and last line. then, it loops through all the elements of the line except the first one, then initialises indecies n and n-1 as Nodes and adds those to the graph. This creates a directional graph.
#### addEdge()
takes two Nodes, then adds these to the graph
### TopologicalSort
#### topologicalSort()
initialises degrees as a map of nodes and integers, initialises queue as a Queue of nodes, initialised highestOrder as a List.
then sets all degrees to 0, loops trough the nodes and sets degrees depending on the neighbours, adds all 0 degree nodes to queue.
then, while queue is not empty, it adds the given node to highestOrder, goes through highest order and sets the degrees according to neighbours. then, removes the item from queue when it has o degrees.