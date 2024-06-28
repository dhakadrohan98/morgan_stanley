package com.wissen.trees;

import java.util.*;

//TC: O(n) == O(LH) + O(RH) + O(LeaveNodes)
//SC: O(n)
public class BoundaryTraversal {

	public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
    
    
    public static void leftBoundary(Node root, ArrayList<Integer> list) {
        Node curr = root;
        while(curr != null) {
            
            if(isLeaf(curr) == false) {
                list.add(curr.data);
            }
            if(curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }
    
     public static void rightBoundary(Node root, ArrayList<Integer> list) {
        Node curr = root;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null) {
            
            if(isLeaf(curr) == false) {
                temp.add(curr.data);
            }
            if(curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        //reverse the temp list for right bounday elements 
        Collections.reverse(temp);
        list.addAll(temp);
    }
    
    public static void addLeaves(Node root, ArrayList<Integer> list) {
        //base case
        if(root.left == null && root.right == null) {
            list.add(root.data);
            return;
        }
        
        if(root.left != null) {
           addLeaves(root.left, list);   
        }
        if(root.right != null) {
            addLeaves(root.right, list);   
        }
    }
    
	public static ArrayList <Integer> boundary(Node root)
	{
	    ArrayList <Integer> list = new ArrayList<>();
	    if(root == null) {
	        return list;
	    }
	    
	    if(isLeaf(root) == false) {
	        list.add(root.data);
	    }
	    leftBoundary(root.left, list);
	    addLeaves(root, list);
	    rightBoundary(root.right, list);
	    return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
