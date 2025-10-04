Assignment 2: Min-Heap Implementation
Project Overview
Implementation of Min-Heap data structure with performance analysis for Algorithm Analysis course.

Implementation Details
Algorithm: Min-Heap

Student: Pair 4, Student A

Language: Java

Features: Insert, ExtractMin, DecreaseKey, Merge operations

Project Structure
text
Assignment_2_minheap/
├── MinHeap.java              # Main Min-Heap implementation
├── PerformanceTracker.java   # Performance metrics collection
├── BenchmarkRunner.java      # CLI benchmark runner
├── MinHeapTest.java          # Test suite
├── docs/
│   └── analysis-report.pdf   # Analysis report
└── README.md
Quick Start
Compile all files:
javac *.java

Run tests:
java MinHeapTest

Run benchmarks:
java BenchmarkRunner

Performance Results
Key metrics collected:

Time complexity: O(log n) for insert/extract operations

Space complexity: O(n) auxiliary space

Benchmark results for n = 100, 1000, 10000, 100000 elements

Complexity Analysis
Insert: O(log n) time

ExtractMin: O(log n) time

DecreaseKey: O(log n) time

Merge: O(n log n) time

Peer Review
Analysis of partner's Max-Heap implementation included in docs/analysis-report.pdf