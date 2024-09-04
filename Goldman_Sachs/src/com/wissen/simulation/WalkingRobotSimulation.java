package com.wissen.simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WalkingRobotSimulation {

	//TC: O(k*n)  where n is no. of commands & 1 <= k <= 9
    //SC: O(2*m) where m is no. of obstacles 
	
	public int robotSim(int[] commands, int[][] obstacles) {
		// 0: North, 1: East, 2:South, 3:West
		int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
		int[] currPos = new int[]{0,0};
		int res = 0;
		int curDir = 0; //facing towards north
		
		Map<Integer, HashSet<Integer>> hmap = new HashMap<>();
		for(int[] obstacle : obstacles) {
			int x = obstacle[0];
			int y = obstacle[1];
			//if x is not present in map, then create new hashset to store corresponding y values
			if(!hmap.containsKey(x)) {
				hmap.put(x, new HashSet<>());
			}
			hmap.get(x).add(y);
		}
		
		for(int command: commands) {
			if(command == -1) { //take right turn
				curDir = (curDir + 1) % 4; //from west(3) to north(0) (in a cycle)
				continue;
			}
			
			if(command == -2) {
				//take turn left
				curDir = curDir - 1;
				if(curDir == -1) { //from north(0) to west(3) (in a cycle)
					curDir = 3;
				}
				continue;
			}
			
			//move forward command
			//towards which direction robot has to move k times
			int[] direction = directions[curDir];
			for(int step = 0; step < command; step++) {
				int nextX = currPos[0] + direction[0];
				int nextY = currPos[1] + direction[1];
				//at next x & next y there is an obtacle, break the loop here & go to the next command
				if(hmap.containsKey(nextX) && hmap.get(nextX).contains(nextY)) {
					break;
				}
				//update the currPos(x,y) if we can move in facing direction
				currPos[0] = nextX;
				currPos[1] = nextY;
			}
			
			int euclideanDist = (currPos[0] * currPos[0]) + (currPos[1] * currPos[1]);
			//take max of euclideanDist after each command finished
			//it might happen that in due to some command we can go closer towards the origin(0,0)
			res = Math.max(res, euclideanDist);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
