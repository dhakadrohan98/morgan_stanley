package com.wissen.design.newdatastructure;

import java.util.*;

class TrieNode {
    // If this node represents a file, 'content' stores the file's content. 
    // If it's a directory, 'content' is null.
    String content = null;
    
    // 'children' is a map that stores the subdirectories or files under this directory.
    // TreeMap is used to maintain the order of keys.
    Map<String, TrieNode> children = new TreeMap<>();
}

public class FileSystem {
    // The root of the Trie, representing the root directory "/"
    TrieNode root = new TrieNode();

    // List the content of a directory or a file at a given path
    public List<String> ls(String path) {
        TrieNode curNode = root;

        // If path is not the root, traverse to the target directory or file
        if (!path.equals("/")) {
            String[] list = path.split("/");
            String curString;
            for (int i = 1; i < list.length; i++) {
                curString = list[i];
                curNode = curNode.children.get(curString);

                // If the last node is a file, return its name
                if (i == list.length - 1 && curNode.content != null) {
                    return Arrays.asList(curString);
                }
            }
        }

        // If it's a directory, return all its children (sorted by name)
        List<String> children = new LinkedList<>(curNode.children.keySet());
        return children;
    }

    // Create a directory (and any necessary subdirectories) at the given path
    public void mkdir(String path) {
        TrieNode curNode = root;
        String[] arr = path.split("/");

        // Traverse or create nodes for each part of the path
        for (int i = 1; i < arr.length; i++) {
            String curString = arr[i];
            if (!curNode.children.containsKey(curString)) {
                // Create a new directory if it doesn't exist
                curNode.children.put(curString, new TrieNode());
            }
            curNode = curNode.children.get(curString);
        }
    }

    // Add content to a file. If the file doesn't exist, create it.
    public void addContentToFile(String filePath, String content) {
        TrieNode curNode = root;
        String[] arr = filePath.split("/");

        // Traverse to the file's directory, creating directories if necessary
        for (int i = 1; i < arr.length; i++) {
            String curString = arr[i];
            if (!curNode.children.containsKey(curString)) {
                // Create a new directory or file node if it doesn't exist
                curNode.children.put(curString, new TrieNode());
            }
            curNode = curNode.children.get(curString);
        }

        // If the file already exists, append the content; otherwise, create a new file
        if (curNode.content != null) {
            curNode.content += content;
        } else {
            curNode.content = content;
        }
    }

    // Read the content from a file at the given path
    public String readContentFromFile(String filePath) {
        TrieNode curNode = root;
        String[] arr = filePath.split("/");

        // Traverse to the file node
        for (int i = 1; i < arr.length; i++) {
            String curString = arr[i];
            if (!curNode.children.containsKey(curString)) {
                // This block should not normally be needed, but it ensures the node exists
                curNode.children.put(curString, new TrieNode());
            }
            curNode = curNode.children.get(curString);
        }

        // Return the file's content
        return curNode.content;
    }
}