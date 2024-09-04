package com.wissen.math;

//71_72 test cases have passed
public class FindTheStudentThatWillReplaceChalk {
	
	//TC: O(n)
    //SC: O(1)
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        // Calculate the total sum of chalk required in one iteration
        long sum = 0;
        
        for(int i = 0; i < n; i++) {
            sum += chalk[i];
        }
        System.out.println(sum);
        //reducing the number of major iteration(cylce over chalk array) 
        //by k / sum;
        int remainChalk = (int) (k % sum);
        
        for(int i = 0; i < n; i++) {
            if(chalk[i] > remainChalk) {
                return i;
            }
            
            remainChalk -= chalk[i];
        }
        // In theory, this line should never be reached
        return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
