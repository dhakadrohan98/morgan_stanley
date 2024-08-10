package com.wissen.codingtemplate;

public class SlidingWindowFlexibleShortest {
	private static W slidingWindowFlexibleShortest(List<T> input) {
	    initialize window, ans
	    int left = 0;
	    for (int right = 0; right < input.size(); ++right) {
	        append input.get(right) to window
	        while (valid(window)) {
	            ans = Math.min(ans, window);   // window is guaranteed to be valid here
	            remove input.get(left) from window
	            ++left;
	        }
	    }
	    return ans;
	}
}
