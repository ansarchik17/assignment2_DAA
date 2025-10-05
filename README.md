Peer Analysis (Part 2 – Cross Review) Insertion Sort

1. Asymptotic Complexity Analysis

Time Complexity

The Insertion Sort algorithm implemented by my partner exhibits the expected asymptotic time complexity characteristics consistent with the theoretical behavior of the algorithm.
	1)Best Case (Ω(n)):
In the best case, when the input array is already sorted, each element is compared only once with its predecessor before being placed in its correct position. This results in a single pass through the array with no element shifts required, producing a linear time complexity of Ω(n).
	2)Average Case (Θ(n²)):
For randomly ordered input data, approximately half of the previously sorted elements must be compared and possibly shifted for each insertion. Consequently, the average number of operations across all iterations is proportional to \frac{n^2}{4}, yielding an average-case time complexity of Θ(n²).
	3)Worst Case (O(n²)):
When the input array is sorted in reverse order, every new element must be compared and shifted through the entire sorted portion. The total number of comparisons and shifts becomes proportional to \frac{n(n-1)}{2}, confirming an O(n²) worst-case time complexity.

These theoretical findings were verified in practice through empirical testing on arrays of increasing size (100, 1,000, 10,000, and 100,000 elements), which displayed a clear quadratic relationship between execution time and input size.

Space Complexity

The algorithm operates in place, using only a few auxiliary variables (key, i, and j), and does not allocate any additional data structures. Thus, its space complexity is O(1).
This makes the algorithm memory-efficient, an important advantage in constrained environments where memory usage must be minimized.

Recurrence Relation

Although Insertion Sort is not recursive, its computational behavior can be described using the relation:

T(n) = T(n - 1) + O(n)

Solving this recurrence yields:

T(n) = O(n^2)

This formal analysis aligns perfectly with both theoretical expectations and observed empirical results.


2. Code Review & Optimization

a. Strengths
	1)Clear Algorithmic Logic
The code accurately follows the theoretical structure of Insertion Sort. Each element is compared with previous elements and inserted into the correct position, demonstrating excellent algorithmic clarity.
	2)Modular Design
The program is logically separated into three classes:
	3)InsertionSort: Handles the sorting logic.
	4)BenchmarkRunner: Automates performance testing.
	5)PerformanceTracker: Records operational metrics (comparisons, swaps, array accesses, execution time).
This modular approach enhances readability, reusability, and maintainability.
	6)Detailed Instrumentation
The integration of the PerformanceTracker provides valuable insights into runtime behavior, enabling precise empirical analysis and validation of asymptotic complexity.
	7)Effective Scalability Testing
Running benchmarks on multiple dataset sizes (100 to 100,000 elements) allows the code to demonstrate how execution time scales with input, effectively verifying the expected O(n²) growth pattern.

b. Identified Inefficiencies
	1.	Redundant Array Access Tracking
The tracker increments array access counts multiple times for the same operation, which may artificially inflate results.
Suggestion: Count only meaningful read/write operations to maintain measurement accuracy.
	2.	Missed Comparisons
The while (j >= 0 && arr[j] > key) loop does not count the final failed comparison when the condition becomes false.
Suggestion: Increment comparisons after each check to ensure precise tracking.
	3.	Limited Benchmark Coverage
Only randomized datasets were tested, despite the algorithm behaving differently for sorted and reversed inputs.
Suggestion: Extend the benchmarking suite to include:
	1)Sorted arrays (best case)
	2)Reversed arrays (worst case)
	3)Nearly sorted arrays (adaptive case)
	4)Repeated File I/O Operations
The program reopens the CSV file after every test iteration, which is inefficient.
Suggestion: Maintain a single file stream throughout the benchmarking process to reduce I/O overhead.
	5.	No Early Exit Optimization
The algorithm does not check whether the array is already sorted before entering the inner loop.
Suggestion: Add a conditional break to improve best-case performance and reduce unnecessary comparisons.

c. Proposed Enhancements
	1.	Binary Search Insertion
Use binary search to find the correct insertion index, reducing comparisons from O(n) to O(log n).
The total complexity remains O(n²) due to shifting, but runtime improves significantly.
	2.	Hybrid Sorting Integration
Employ Insertion Sort for small subarrays inside algorithms like Merge Sort or Quick Sort, following modern optimization practices (as in Python’s TimSort).
	3.	Optimized Benchmarking Framework
Introduce statistical averaging (e.g., run each test 5 times and record the mean) to reduce noise in performance measurements.


3. Empirical Validation

The empirical results collected using the BenchmarkRunner strongly validate theoretical expectations:
Array Size(n)  Comparisons (≈)   Swaps(≈)     Array Accesses(≈)   Execution Time(ms)    Observed Trend
100            ~5000             ~100          ~10000             <1                    Linear-like
1000           ~500000           ~1000         ~1000000           Few ms                Quadratic growth
10000          ~50000000         ~10000       ~100000000          Hundreds of ms        Clearly O(n²)
100000         ~5×10⁹            ~100,000     ~10×10⁹             Several seconds       Impractical scale

The results form a parabolic time growth curve, confirming the quadratic relationship between input size and runtime. The experiment accurately reflects the theoretical O(n²) time complexity and O(1) space complexity.


4. Overall Evaluation

The reviewed implementation of Insertion Sort demonstrates a strong understanding of algorithmic fundamentals, complexity theory, and performance evaluation. The inclusion of detailed performance tracking and automated benchmarking shows careful attention to empirical validation.

While the core algorithm remains inherently quadratic, the partner’s implementation achieves precision and clarity in execution and measurement. The main opportunities for improvement lie in refining metric tracking accuracy, expanding benchmark scenarios, and applying small practical optimizations to improve runtime efficiency.


5. Conclusion

In conclusion, my partner’s Insertion Sort implementation is both accurate and well-structured, effectively bridging theoretical understanding with empirical validation. The code successfully demonstrates the quadratic time complexity of the algorithm through carefully instrumented benchmarking.
Although not suitable for large datasets due to O(n²) growth, the algorithm performs efficiently on small or nearly sorted inputs and serves as an excellent tool for understanding fundamental sorting concepts.
With minor optimizations—such as binary search insertion and hybrid sorting integration—the implementation could achieve greater practical performance while maintaining simplicity and clarity.
