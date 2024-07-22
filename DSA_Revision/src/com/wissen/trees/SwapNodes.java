package com.wissen.trees;

import java.util.*;

import java.util.*;


//    https://www.hackerrank.com/challenges/swap-nodes-algo/problem
class Node {
    int value;
    int data;
    Node left;
    Node right;
    
    Node(int value) {
        this.value = value;
    }
}

//TC: O(n*k) --> n is no. of nodes & k -> queries
//SC: O(n)
public class SwapNodes {
    
	//TC: O(n)
	//SC: O(n)
    public static Node buildTree(List<List<Integer>> indexes) {
        Node root = new Node(1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        for (List<Integer> index : indexes) {
            Node current = queue.poll();
            int left = index.get(0);
            int right = index.get(1);
            if (left != -1) {
                current.left = new Node(left);
                queue.add(current.left);
            }
            if (right != -1) {
                current.right = new Node(right);
                queue.add(current.right);
            }
        }
        return root;
    }
    
    //TC: O(n)
    //SC: O(h) h -> height of the tree (determined by recursion depth)
    //In case of skew tree -> O(h=n)
    public static void swapAtDepth(Node node, int depth, int k) {
        if (node == null) return;
        
        if (depth % k == 0) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        
        swapAtDepth(node.left, depth + 1, k);
        swapAtDepth(node.right, depth + 1, k);
    }
    
    //TC: O(n)
    //SC: O(h)+O(n)≈O(n)
    public static List<Integer> inorderTraversal(Node node) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(node, result);
        return result;
    }
    
    private static void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }
    
    //TC: O(m*n) + O(n) IndorderTraversal   m-> number of nodes & n -> no. of queries
    public static List<List<Integer>> swapNodes(List<List<Integer>> ind, List<Integer> queries) {
        Node root = buildTree(ind);
        List<List<Integer>> results = new ArrayList<>();
        
        for (int k : queries) {
            swapAtDepth(root, 1, k);
            results.add(inorderTraversal(root));
        }
        
        return results;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> indexes = new ArrayList<>();
        indexes.add(Arrays.asList(2, 3));
        indexes.add(Arrays.asList(4, 5));
        indexes.add(Arrays.asList(-1, -1));
        indexes.add(Arrays.asList(-1, -1));
        indexes.add(Arrays.asList(-1, -1));
        
        List<Integer> queries = Arrays.asList(2, 1);
        
        List<List<Integer>> results = swapNodes(indexes, queries);
        
        for (List<Integer> result : results) {
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

