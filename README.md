# cubic-and-quartic-graph
used https://guides.lib.berkeley.edu/how-to-write-good-documentation for how to write this
computer science project

purpose: this programs purpose is to take in a cubic or quartic function and return the ordered pairs along with some other information

ex: the function I want to input is f(x) = 3(x-1)³(x-5)

<-------program starts------->

enter amount of x intercepts on graph: 2

enter coeffient: 3

enter x intercepts: 1

5

enter power's: 1 to the power of 3

5 to the power of 1

printing ordered pairs:

(-10, 59895)    <---- max y of scope

(-9, 42000)

(-8, 28431)

(-7, 18432)

(-6, 11319)

(-5, 6480)

(-4, 3375)

(-3, 1536)

(-2, 567)

(-1, 144)

(0, 15)    <---- y-intercept        

(1, 0)    <---- x-intercept

(2, -9)

(3, -48)

(4, -81)    <---- min y of scope    

(5, 0)    <---- x-intercept

(6, 375)

(7, 1296)

(8, 3087)

(9, 6144)

(10, 10935)

<-------program ends------->

inputs/outputs of functions:


input: x-intercepts of polynomial function

output: -(x-intercepts)

signSwap(int[] xinter)


input: x cord, x-intercepts, coeffient, power of the corresponding x-intercept

output: y of polynomial function

solveForY(int x,int[] equation,int coeffient,int[] pow)


input: x-inters

output: scope or how big the graph should be 

graphScope(int[] xInter)


input: x-intercepts, coeffient, pow of the corresponding x-intercept

output: ordered pairs

graphBuilder(int[] xinters,int coeffient,int pow[])


input: ordered pairs

output: largest y in scope

relativeMax(int[][] orderedPairs)


input: ordered pairs

output: smallist y in scope

relativeMin(int[][] orderedPairs)

