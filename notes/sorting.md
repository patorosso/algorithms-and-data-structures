# Sorting algorithms

## Insertion

### Description

Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort. However, on small lists it performs very well.

### Complexity

    Big O notation: O(n^2), for worst case.

### Steps

1. Start from the second element of the array.

2. Compare the current element with the previous elements.

3. If the current element is smaller than the previous element, swap them.

4. Repeat the process until the array is sorted.

## Tim sort

### Description

Tim sort is a hybrid sorting algorithm derived from merge sort and insertion sort. It was designed to perform well on many kinds of real-world data. It was implemented by Tim Peters in 2002 for use in the Python programming language.

### Complexity

    Big O notation: O(n log n), for worst case.

### Steps

1. Divide the array into blocks.

2. Sort the individual blocks using insertion sort.

3. Merge the blocks together using merge sort.

4. Insertion sort is used to sort small blocks.
