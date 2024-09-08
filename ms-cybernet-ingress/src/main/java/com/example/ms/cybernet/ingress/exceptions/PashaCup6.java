package com.example.ms.cybernet.ingress.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PashaCup6 {

    public static void main(String[] args) {
        List<Integer> current = List.of(2, 5, 9);

        System.out.println(getMaxImpactedServers(current, 2));
    }



    //3rd task 100%
    public static int maxGameScore(List<Integer> cell) {
        int n = cell.size();
        int[] scores = new int[n];
        scores[0] = 0;

        for (int i = 1; i < n; i++) {
            scores[i] = scores[i - 1] + cell.get(i);
            for (int j = 2; j <= i; j++) {
                if (isPrimeEndingIn3(j) && i - j >= 0) {
                    scores[i] = Math.max(scores[i], scores[i - j] + cell.get(i));
                }
            }
        }

        return scores[n - 1];
    }

    private static boolean isPrimeEndingIn3(int num) {
        if (num <= 2 || num % 2 == 0) {
            return false;
        }
        if (num % 10 != 3) {
            return false;
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //2nd task
    public static int getMaxImpactedServers(List<Integer> priority, int k) {
        int n = priority.size();
        int maxImpacts = 0;
        for (int i = 0; i < n; i++) {
            int impacts = 0;
            boolean[] impacted = new boolean[n];

            for (int j = 0; j < n; j++) {
                if (i != j && !impacted[j] && Math.abs(priority.get(i) - priority.get(j)) <= k) {
                    impacts++;
                    impacted[j] = true;
                }
            }

            // Update the maximum impacts
            maxImpacts = Math.max(maxImpacts, impacts);
        }

        return maxImpacts;
    }


    // 1st task
    public static int getMinSteps(List<Integer> current, List<Integer> desired) {
        Map<Integer, Integer> desiredIndexMap = new HashMap<>();
        for (int i = 0; i < desired.size(); i++) {
            desiredIndexMap.put(desired.get(i), i);
        }

        int[] positions = new int[current.size()];
        for (int i = 0; i < current.size(); i++) {
            positions[i] = desiredIndexMap.get(current.get(i));
        }
        return minSwapsToSort(positions);
    }

    private static int minSwapsToSort(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == i) {
                continue;
            }
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j];
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }
}
