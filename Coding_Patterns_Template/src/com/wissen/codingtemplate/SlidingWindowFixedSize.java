package com.wissen.codingtemplate;

public class SlidingWindowFixedSize {
	private static W slidingWindowFixed(List<T> input, int windowSize) {
	    W ans = window = input[0..windowSize);
	    for (int right = windowSize; right < input.size(); ++right) {
	        int left = right - windowSize;
	        remove input.get(left) from window
	        append input.get(right) to window
	        ans = optimal(ans, window);
	    }
	    return ans;
	}
}
