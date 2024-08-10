package com.wissen.codingtemplate;

public class SlidingWindowFlexibleLongest {
	private static W slidingWindowFlexibleLongest(List<T> input) {
	    initialize window, ans
	    int left = 0;
	    for (int right = 0; right < input.size(); ++right) {
	        append input.get(right) to window
	        while (invalid(window)) {         // update left until window is valid again
	            remove input.get(left) from window
	            ++left;
	        }
	        ans = Math.max(ans, window);           // window is guaranteed to be valid here
	    }
	    return ans;
	}
}
