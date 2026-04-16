# 📊 Sorting Algorithms Simulator

Welcome to my **Algorithms and Data Structures I** project! This repository contains a comprehensive collection of major sorting algorithms, implemented to demonstrate their logic, efficiency, and use cases.

---

## 🚀 Implemented Algorithms

### 1. Insertion Sort
* **Logic:** Builds the final sorted array one item at a time by "inserting" each new element into its proper place among the already-sorted elements.
* **Best Use Case:** Small datasets or arrays that are already nearly sorted.
* **Time Complexity:** $O(n^2)$

### 2. Selection Sort
* **Logic:** Repeatedly finds the minimum element from the unsorted part and moves it to the beginning.
* **Best Use Case:** When memory writes are expensive, as it minimizes the number of swaps.
* **Time Complexity:** $O(n^2)$

### 3. Bubble Sort
* **Logic:** A simple comparison-based algorithm where adjacent elements are swapped if they are in the wrong order. The largest values "bubble" to the end.
* **Best Use Case:** Educational purposes; rarely used in real-world production.
* **Time Complexity:** $O(n^2)$

### 4. Merge Sort
* **Logic:** A "divide and conquer" algorithm that recursively splits the array in half, sorts the halves, and merges them back together.
* **Best Use Case:** Large datasets and linked lists where stability is required.
* **Time Complexity:** $O(n \log n)$

### 5. Quick Sort
* **Logic:** Picks a 'pivot' element and partitions the array into two sub-arrays: elements less than the pivot and elements greater than the pivot.
* **Best Use Case:** General-purpose sorting; usually the fastest in practice for in-memory sorting.
* **Time Complexity:** $O(n \log n)$ average.

### 6. Heap Sort
* **Logic:** Uses a Binary Heap data structure to find the maximum element and move it to the end of the array repeatedly.
* **Best Use Case:** Systems where a guaranteed $O(n \log n)$ is needed without the extra memory overhead of Merge Sort.
* **Time Complexity:** $O(n \log n)$

### 7. Bucket Sort
* **Logic:** Distributes elements into several "buckets," then sorts each bucket individually (often using Insertion Sort).
* **Best Use Case:** Uniformly distributed data, such as floating-point numbers in a specific range.
* **Time Complexity:** $O(n + k)$ average.

### 8. Radix Sort
* **Logic:** A non-comparative sorting algorithm that processes data digit by digit, from the least significant to the most significant.
* **Best Use Case:** Sorting large lists of integers or fixed-length strings.
* **Time Complexity:** $O(nk)$

---

## 📊 Performance Comparison

| Algorithm | Average Time | Space Complexity | Stable? |
| :--- | :--- | :--- | :--- |
| **Insertion** | $O(n^2)$ | $O(1)$ | Yes |
| **Selection** | $O(n^2)$ | $O(1)$ | No |
| **Bubble** | $O(n^2)$ | $O(1)$ | Yes |
| **Merge** | $O(n \log n)$ | $O(n)$ | Yes |
| **Quick** | $O(n \log n)$ | $O(\log n)$ | No |
| **Heap** | $O(n \log n)$ | $O(1)$ | No |
| **Bucket** | $O(n + k)$ | $O(n)$ | Yes |
| **Radix** | $O(nk)$ | $O(n + k)$ | Yes |

---
*This project was completed as part of the Algorithms and Data Structures I course.*
