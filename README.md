# java_samples
Difference between countdown Latch and cyclic barrier.
ans: multiple child threads join to give combined result to parent thread::: this cyclic barrier.
     each thread will call decrement the latch, main thead will be awaiting.
     cyclic barrier can be reset.
