Graph with every key
edges are directional between nodes

if a node pair can reach each other, the graph is cyclic and thus faulty

if anode is reachable by another but not in reverse direction, the this node is smaller than the other one

par example:
A -> B, E
B -> C
C -> F, D
D ->
E -> G
F -> D
G -> F