package dsa;

import java.util.Scanner;

public class CopyOfMedianOfStreamNumbers {

    public static void main(String[] args) {

        int[] ip = new int[100];
        int countLeft = 0, countRight = 0;
        float currentMedian = 0f;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] minHeap = new int[2 * n];
        int[] maxHeap = new int[2 * n];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if ((countLeft - countRight) == 0) {
                if (temp <= currentMedian) {
                    currentMedian = addMaxHeap(maxHeap, temp, countLeft);
                    countLeft++;
                } else {
                    currentMedian = addMinHeap(minHeap, temp, countRight);
                    countRight++;
                }
            } else if ((countLeft - countRight) < 0) {
                if (temp <= currentMedian) {
                    addMaxHeap(maxHeap, temp, countLeft);
                    countLeft++;
                } else {
                    currentMedian = processRightHeap(minHeap, maxHeap, temp,
                            currentMedian, countLeft, countRight);
                    countLeft++;
                    // countRight--;
                }
            } else if ((countLeft - countRight) > 0) {

                if (temp > currentMedian) {
                    addMinHeap(minHeap, temp, countRight);
                    countRight++;
                } else {
                    currentMedian = processLeftHeap(minHeap, maxHeap, temp,
                            currentMedian, countLeft, countRight);
                    countRight++;
                }
            }
            System.out.println(currentMedian);
        }

    }

    private static float processLeftHeap(int[] minHeap, int[] maxHeap, int ip,
            float currentMedian, int countLeft, int countRight) {

        // temp into root of left heap and place new at the root of the node
        // and heapify
        int root = maxHeap[0];
        maxHeap[0] = ip;

        // heapify right by adding smallest of each level as child
        maxHeapify(maxHeap, countLeft);

        // add currentMedian to right minHeap;
        addMinHeap(minHeap, root, countRight);
        currentMedian = (minHeap[0] + maxHeap[0]) * 1f / 2;

        return currentMedian;

    }

    private static float processRightHeap(int[] minHeap, int[] maxHeap, int ip,
            float currentMedian, int countLeft, int countRight) {

        // temp into root of left heap and place new at the root of the node
        // and heapify
        int root = minHeap[0];
        minHeap[0] = ip;

        // heapify right by adding smallest of each level as child
        minHeapify(minHeap, countRight);

        // add currentMedian to left maxHeap;
        addMaxHeap(maxHeap, root, countLeft);
        currentMedian = (minHeap[0] + maxHeap[0]) * 1f / 2;

        return currentMedian;

    }

    private static void minHeapify(int[] minHeap, int countRight) {
        int pos = 0;
        while (countRight >= pos * 2 + 1) {
            if ((pos * 2 + 1) == countRight && !(minHeap[pos*2+1]==0)) {
                int temp = minHeap[pos];
                minHeap[pos] = minHeap[pos * 2 + 1];
                minHeap[pos * 2 + 1] = temp;
                pos = pos * 2 + 1;
            } else if (minHeap[pos * 2 + 1] < minHeap[pos * 2 + 2]) {
                int temp = minHeap[pos];
                minHeap[pos] = minHeap[pos * 2 + 1];
                minHeap[pos * 2 + 1] = temp;
                pos = pos * 2 + 1;
            } else {
                int temp = minHeap[pos];
                minHeap[pos] = minHeap[pos * 2 + 2];
                minHeap[pos * 2 + 2] = temp;
                pos = pos * 2 + 2;
            }
        }
    }

    private static float addMinHeap(int[] minHeap, int ip, int countRight) {

        if (countRight == 0) {
            minHeap[0] = ip;
            return minHeap[0];
        }

        int temp = minHeap[0];
        minHeap[0] = ip;
        minHeap[countRight] = temp;
        minHeapify(minHeap, countRight);
        return minHeap[0];
    }

    private static void maxHeapify(int[] maxHeap, int countLeft) {
        int pos = 0;
        while (countLeft >= pos * 2 + 1) {
            if ((pos * 2 + 1) == countLeft) {
                int temp = maxHeap[pos];
                maxHeap[pos] = maxHeap[pos * 2 + 1];
                maxHeap[pos * 2 + 1] = temp;
                pos = pos * 2 + 1;
            }
            if (maxHeap[pos * 2 + 1] > maxHeap[pos * 2 + 2]) {
                int temp = maxHeap[pos];
                maxHeap[pos] = maxHeap[pos * 2 + 1];
                maxHeap[pos * 2 + 1] = temp;
                pos = pos * 2 + 1;
            } else {
                int temp = maxHeap[pos];
                maxHeap[pos] = maxHeap[pos * 2 + 2];
                maxHeap[pos * 2 + 2] = temp;
                pos = pos * 2 + 2;
            }
        }
    }

    private static float addMaxHeap(int[] maxHeap, int ip, int countLeft) {
        if (countLeft == 0) {
            maxHeap[0] = ip;
            return maxHeap[0];
        }

        int temp = maxHeap[0];
        maxHeap[0] = ip;
        countLeft++;
        maxHeap[countLeft] = temp;
        maxHeapify(maxHeap, countLeft);
        return maxHeap[0];
    }
}