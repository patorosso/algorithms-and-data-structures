# Divide and conquer

## Definition

Divide and conquer is a problem-solving strategy that involves breaking a problem into smaller subproblems, solving the subproblems, and combining the solutions to the subproblems to solve the original problem.

    The subproblems are similar in structure to the original problem.

## Examples

### Binary search

Binary search is a classic example of the divide-and-conquer strategy. The idea is to divide the array into two halves and recursively search for the target element in one of the halves.

Note: conquer is not needed, is trivial. Im just searching halves and discarding them. The important part is the divide.

![Binary search](./images/binary-search.png)

### Powering numbers

One could do the math function power using this strategy. For example, to calculate x^n, one could divide the problem into x^(n/2) and x^(n/2) and then multiply the results. Remembering base cases and also having in mind when N is even or odd, because if it's odd one should do x^(n-1) \* x.

![Binary search](./images/power.png)

### Merge sort

Merge sort is another example of the divide-and-conquer strategy. The idea is to divide the array into two halves, sort each half, and then merge the two sorted halves to produce a sorted array.

### Quick sort

Quick sort is another example of the divide-and-conquer strategy. The idea is to divide the array into two halves, partition the array around a pivot element, and then recursively sort the two halves.
