This data structure is an array of linkedlists.

Background:
Molecules of DNA can be broken down into pairs of 4 different basis known as Adenine(A), Cytosine(C), Guanine(G), and Thymine(T). This program was designed to take a DNA molecule represented by a long string of basies, and count the different pairs that exist in that molecule of DNA.

Implementation:
First, an alphabet was created; each base was assigned an index of an array ranging from 1-4. Each location in the array points to a Linkedlist where each node is a occurance of that respective base, and the data within that node is the second base in the pair. 

Analysis:
Using array indexes to represent the different bases made the following runtimes and operations possible:

-Total amount of occurances of each base can be counted by checking the length of the linkedlist at that index O(n)
-Amount of times a specific pair occurs in a molecule(AT,GT,etc) is counted by checking the data within each node of that bases's list O(n)
-Adding a new node to any of the lists O(1)
