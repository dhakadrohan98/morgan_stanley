package com.wissen.string;

import java.util.*;
public class LastSubstringInLexicographicalOrder {
	
	//TC: O(n)
	//SC: O(1)
	public String lastSubstring(String s) {
	    int n = s.length();
	    int i = 0, j = 1, k = 0;
	    while (j + k < n) {
	        if (s.charAt(i + k) == s.charAt(j + k)) {
	            k++;
	        } else if (s.charAt(i + k) > s.charAt(j + k)) {
	            j = j + k + 1;
	            k = 0;
	        } else {
	            i = Math.max(i + k + 1, j);
	            j = i + 1;
	            k = 0;
	        }
	    }
	    return s.substring(i);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//complex approach
	public String lastSubstring_1(String s) {
        int n = s.length();
        char mmax = 'a';

        // Find the maximum character in the string
        for (char c : s.toCharArray()) {
            if (c > mmax) {
                mmax = c;
            }
        }

        // Create a list of candidates with the highest character
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == mmax) {
                candidates.add(i);
            }
        }

        int offset = 1;
        while (candidates.size() > 1) {
            char curMax = 'a';
            List<Integer> newCand = new ArrayList<>();

            // Find the maximum character at the current offset
            for (int i : candidates) {
                if (i + offset < n) {
                    char c = s.charAt(i + offset);
                    if (c > curMax) {
                        curMax = c;
                    }
                }
            }

            // Filter candidates based on the current maximum character
            for (int i = 0; i < candidates.size(); i++) {
                int st = candidates.get(i);
                if (i > 0 && candidates.get(i - 1) + offset == st) {
                    continue;
                }
                if (st + offset < n && s.charAt(st + offset) == curMax) {
                    newCand.add(st);
                }
            }

            candidates = newCand;
            offset++;
        }

        return s.substring(candidates.get(0));
    }
	
	//13_26 test cases passed
		public String lastSubstring_2(String s) {
	        int n = s.length();
	        int[] ascciValues = new int[n];
	        for(int i=0; i<n; i++) {
	            ascciValues[i] = s.charAt(i);
	        }
	        
	        int largest = 0;
	        int indx = -1;
	         for(int i=n-1; i >= 0; i--) {
	            int val = s.charAt(i);
	            if(val >= largest) {
	                indx = i;
	                largest = val;
	            }
	        }
	        // System.out.println(largest + " indx " + indx);
	            
	        return s.substring(indx, n);
	    }
		
	public String lastSubstring3NotSuccessful(String s) {
        int n = s.length();
        int[] prefixGreater = new int[n];
        Stack<Integer> st = new Stack<>(); //monotonic stack
        for(int i = n-1; i >= 0 ; i--) {
            int val = s.charAt(i);
            
            if(st.isEmpty()) {
                prefixGreater[i] = val;
            }
            else { //!st.isEmpty()
                if(st.peek() > val) {
                   prefixGreater[i] =  st.peek();
                   st.push(val);
                }
                else { //st.peek() <= val
                    while(!st.isEmpty() && st.peek() <= val) {
                        st.pop();
                    }
                    if(!st.isEmpty()) {
                       prefixGreater[i] =  st.peek();
                    } else { // stack becomes empty
                        prefixGreater[i] = val; 
                    }
                }
            }
            st.push(val);
        }
        System.out.println(Arrays.toString(prefixGreater));
        return s;
    }

}
