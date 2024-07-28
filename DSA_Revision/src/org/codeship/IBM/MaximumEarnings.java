package org.codeship.IBM;

import java.util.*;
public class MaximumEarnings {
	public static long findMaximumEarning(List<Integer> send, List<Integer> receive, List<Integer> amount, List<Integer> capacity) {
        int n = send.size();
        int m = capacity.size();

        // Create a list of tasks
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(send.get(i), receive.get(i), amount.get(i)));
        }

        // Sort tasks based on the amount in descending order
        Collections.sort(tasks, (a, b) -> b.amount - a.amount);

        // Sort server capacities in ascending order
        Collections.sort(capacity);

        // Initialize total earnings
        long totalEarnings = 0;

        // Iterate through each task and try to assign it to a server
        for (Task task : tasks) {
            for (int i = 0; i < m; i++) {
                if (capacity.get(i) >= task.send && capacity.get(i) >= task.receive) {
                    totalEarnings += task.amount;
                    capacity.set(i, -1); // Mark this server as used
                    break;
                }
            }
        }

        return totalEarnings;
    }

    // Task class to hold task details
    static class Task {
        int send;
        int receive;
        int amount;

        Task(int send, int receive, int amount) {
            this.send = send;
            this.receive = receive;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        // Sample Inputs
        List<Integer> send1 = Arrays.asList(1, 4, 7);
        List<Integer> receive1 = Arrays.asList(2, 19, 10);
        List<Integer> amount1 = Arrays.asList(10, 10, 8);
        List<Integer> capacity1 = Arrays.asList(3, 9);
        System.out.println(findMaximumEarning(send1, receive1, amount1, capacity1)); // Output: 10

        List<Integer> send2 = Arrays.asList(7, 2);
        List<Integer> receive2 = Arrays.asList(11, 9);
        List<Integer> amount2 = Arrays.asList(100, 150);
        List<Integer> capacity2 = Arrays.asList(7, 5, 8);
        System.out.println(findMaximumEarning(send2, receive2, amount2, capacity2)); // Output: 0
    }
}
