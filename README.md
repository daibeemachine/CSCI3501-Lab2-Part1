# Lab 2-3
By Anton Olson, Keenan McCall, Johnette Nagbe

# Sorting Experiment 1 (Lab Part 1)

The output for Sorting Experiment 1 is in outputExperiment1.txt.

These observations are from our submission for Part 1 of the lab.

## Observations

When running the experiments, we noticed that Timsort (Mergesort) always kept a consistent 9999 comparison counter, 
while Quicksort tended to jump around more with its counter, always ending up significantly larger comparison count than Mergesort.  
Experiment 2 seemed to be the fastest, with Experiments 3 and 4 sharing similar times and Experiment 1 ending up as the slowest.

# Sorting Experiment 2 (Lab Part 2)
In Sorting Experiment 2, we ran the same four experiments three times with
Quicksort, Randomized Quicksort, Median Quicksort, and Quicksort to Insertion Sort.

## Experiment Info

### Experiment 1 (Random Sequence)
Creates a random sequence of 10,000 numbers ranging from 1 to 1,000,000.

### Experiment 2 (Linear Sequence)
Creates a linear sequence of 10,000 numbers, starting at 1 and ending at 10,000.

### Experiment 3 (Reverse Linear Sequence)
Creates a reverse linear sequence of 10,000 numbers, starting at 10,000 and ending at 1.

### Experiment 4 (Sorted Sequences)
Creates 10 reverse sequences of 1000 numbers, using a random value for each sequence's starting point 
and decrementing it by one for each index.

## Observations

We outputted the results of SortingExperiment 2 at output.txt.

### Random Sequence

Looking at our three runs, we noticed that Regular Quicksort and Quicksort to Insertion Sort tends to be the fastest,
with Quicksort to Insertion sort using less comparisons than Regular QUicksort. Randomized Quicksort tends to be the slowest,
taking up the most amount of comparisons and running the longest.

### Linear Sequence

For Linear Sequences, Regular Quicksort and Quicksort to Insertion sort have the fastest runtimes, again, and their amount of comparisons
are the exact same. This comes from a linear array already being sorted, so insertion sort does not need to rely on any comparisons.
Randomized Quicksort and Median Quicksort seemed to take a similar amount of time, but Randomized Quicksort still resulted in the
most amount of comparisons.

### Reverse Linear Sequence

For the Reverse Linear Sequences, Regular Quicksort seemed to run much faster than the other three quicksort methods, but
Quicksort to Insertion sort still relied on less comparisons. Median Quicksort seemed to run the longest overall, but Randomized Quicksort
used the most amount of comparisons

### Sorted Sequences

For the Sorted Sequences, Quicksort tended to run the quickest, but it tended to use the most amount of comparisons. Quicksort to Insertion Sort
ran the second fastest and it used the least amount of comparisons. Randomized Quicksort ended up taking the longest amount of time overall.

## Reflection

It seems that Quicksort to Insertion sort takes the least amount of comparisons to run overall, but Regular Quicksort seems to run the fastest.
Perhaps, the lack of speed in the other quicksort implementations came from some lack in optimizations in our code. But, since the amount of comparisons
in the other quicksort algorithms generally tended to end up lower than regular quicksort, maybe investing more time into optimizing the efficiency
of the optimized quicksort algorithms might be a good idea.

