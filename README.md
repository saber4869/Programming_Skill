# Programming_Skill
UoE course




Third Library:
JUnit:
Introduction
JUnit is a test framework which uses annotations to identify methods that specify a test.


System requirements
To follow along and try out the code for this tutorial, you need a working installation of Sun's JDK 1.5.0_09 (or later) or the IBM developer kit for Java technology 1.5.0 SR3. For the sections on running JUnit 4 in Eclipse, you need a working installation of Eclipse 3.2 or later. For the section on Ant, you need version 1.6 or greater.
The recommended system configuration for this tutorial is as follows:
A system supporting either the Sun JDK 1.5.0_09 (or later) or the IBM developer kit for Java technology 1.5.0 SR3 with at least 500MB of main memory
At least 20MB of disk space to install the software components and examples covered
The instructions in the tutorial are based on a Microsoft Windows operating system. All the tools covered in the tutorial also work on Linux and UNIX systems.
（https://www.ibm.com/developerworks/java/tutorials/j-junit4/index.html）




summary of key design decisions and reasons for these:

1.Make the map:



2.for the algorithm, 
2.1 initialize the animal information 

First two animal classes (hare and puma) have been declared to store the information of these.
In the 2 classes, they contain the basic static statistics information (like birthrate, predationRate and so on), the location on the map and the density value.

And then, with the help of the map architecture(where contains land and water), we give all the land nodes of pumas and hares some random values which are between 0 and 5 so that all the land nodes have the initial values for algorithm.
2.2 make the model of algorithm
Next step is to achieve the algorithm. In order to get the right model of puma and hare, we need to calculate every node's neighbor first because accroding to the formula [picture of it], [前四邻居之和] is a necessary part and the number of neighbor is another essential part. 
The core part of the algorithm is how to get the correct number of neighbor
Our method is to calculate different situations of the location for the map
[正方形地图 四个边balbala]
when...
when,,,,
when...
Although the performance may not be so much excellent, we 

2.3 calculate the next generation of puma and hare
After we get the number of the neighbors and the value respectively, we can calculate the result of density of next generation.
We 


3. output the pmm document and the average density
