# Results

The output of my results can be seen in the 'output.txt' file.

Some quick observations tell us the following:

- There are about half as many edges as vertices

- The node degree distribution appears to decrease logarithmically

- There are 591439 components

- Component size distribution decreases slower than the degree distribution

- There is a significant outlier in the components size distribution (455236, 1259, 872 make the top three)

# Time and memory

For the full graph to run it took 1224 seconds to run.

4.3 GB of memory was used.

Specs of machine that was used to run the code:

- 2.8 GHz Intel Core i7

- 16 GB RAM 2133 MHz LPDDR3

Some other benchmarks are:

- 10000 lines -> 0.3 seconds
- 100k -> 2.1 s
- 1m -> 17.4 s
- 10m -> 182 s
- 20m -> 378 s
- 40m -> 773 s
- Full graph (~64m) -> 1224 s

My observation of the time complexity is that the code runs close to linear growth.

# Algorithms

We iterate through the input file twice. First to create the hash table, then again to set up the graph. Making the time complexity T(2|E|) since each row represents an edge, hence O(|E|).

I have used the Breadth first search approach to search through the completed graph. As discussed in the course BFS has O(|V|+|E|). BFS is called for every component in the graph.

Node degree distribution also runs in O(|V|+|E|) while Component size distribution is limited by the size of the largest component.

# Improvements

If I were to attempt this project again I would think about these things:

- Perhaps use Byte arrays instead of String arrays to preserve memory

- Both Boolean arraylists mark and isAlive could be combined to one

- It is probably inefficient to run through the scanner adding vertices to the full extent and then forming edges. This leaves many overlapped contigs as nodes with no edge. To combat this one could add edges and create vertices simultaneously

# Requirements

Checklist:

1. Runs on the full graph [2p] (YES)

- On a significantly reduced graph [1p] (YES)

2. Skilled github usage [1p]

...* I have commited almost every day over the last few weeks (even slow progress)

...* All necessary files are in the private github repository

...* I have used multiple branches when working

3. Implemented course algorithms [1p]

...* Usage of BFS

...* Avoided quadratic time complexity

4. Discussion of algorithms [1p]

...* I have reflected on time complexity and memory usage

...* Described algorithms used in my code

5. Lab notebook [1p]

...* I have added my thoughts and tracked progress on a daily basis