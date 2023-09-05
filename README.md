This data structure is an array of linkedlists.

Background:
Molecules of DNA can be broken down into pairs of 4 different basis known as Adenine(A), Cytosine(C), Guanine(G), and Thymine(T). This program was designed to take a DNA molecule represented by a long string of basies, and count the different pairs that exist in that molecule of DNA.

Implementation:
First, an alphabet was created. Each base was assigned an index of an array ranging from 1-4. Each location in the array points to a Linkedlist where each node is a occurance of that respective base, and the data within that node is the second base in the pair. When this runs, the total amount of occurances of each base can be counted by checking the length of the Linkedlist at that index, and the amount of times a specific pair occurs in a molecule can also be counted by checking the data within each node of that list.

Analysis:
