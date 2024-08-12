package com.wissen.simulation;

public class RobotBoundedInACircle {
	
	//TC: O(n)
	//SC: O(1)
	public static boolean isRobotBounded(String instructions) {
        char currDir = 'N';
        int x=0, y=0;
        
        for(char incoming: instructions.toCharArray()) {
            if(incoming == 'G') { //go straight by 1 unit
                x = x + (currDir == 'E' ? 1 : 0);
                x = x + (currDir == 'W' ? -1 : 0);
                y = y + (currDir == 'N' ? 1 : 0);
                y = y + (currDir == 'S' ? -1 : 0);
            }
            else { //take left or right turn, based on taken direction update curr dir
                if(currDir == 'N') {
                    if(incoming == 'L') {
                        currDir = 'W';
                    }
                    else {
                        currDir = 'E';
                    }
                } else if(currDir == 'S') {
                    if(incoming == 'L') {
                        currDir = 'E';
                    }
                    else {
                        currDir = 'W';
                    }
                } else if(currDir == 'E') {
                    if(incoming == 'L') {
                        currDir = 'N';
                    }
                    else {
                        currDir = 'S';
                    }
                } else if(currDir == 'W') {
                    if(incoming == 'L') {
                        currDir = 'S';
                    }
                    else {
                        currDir = 'N';
                    }
                }
            }
        }
        
        if(x == 0 && y == 0 || (currDir != 'N')) {
            return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		String instructions = "GG";
		System.out.println(isRobotBounded(instructions));

	}

}
