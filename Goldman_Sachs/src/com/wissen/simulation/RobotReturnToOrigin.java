package com.wissen.simulation;

public class RobotReturnToOrigin {
	
	public boolean judgeCircle(String moves) {
        char currDir = moves.charAt(0);
        int x=0, y=0;
        //identify initial direction
        if(currDir == 'U') {
            y = y + 1;
        } else if(currDir == 'D') {
            y = y - 1;
        } else if(currDir == 'L') {
            x -= 1;
        } else { //currDir == 'R'
            x += 1;
        }
        
        for(int i = 1; i < moves.length(); i++) {
            currDir = moves.charAt(i);
            if(currDir == 'U') {
                y = y + 1;
            } else if(currDir == 'D') {
                y = y - 1;
            } else if(currDir == 'L') {
                x -= 1;
            } else { //currDir == 'R'
                x += 1;
            }
        }
        
        return (x == 0 && y == 0);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
