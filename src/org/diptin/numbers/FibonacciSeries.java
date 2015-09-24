package org.diptin.numbers;

/**
 * Created by dipti on 9/24/15.
 */

public class FibonacciSeries {
    int[] fibSeries;

    public int getFibonacciForRank(int number) {
        if (number < 0) {
            return -1;
        }
        //fibSeries = new int[number+1];
        //return recGetFibonacciForRank(number);

        if (number == 0) {
            return 0;
        }
        fibSeries = new int[2];
        int i = 0;
        fibSeries[i++] = 0;
        fibSeries[i++] = 1;

        int res;
        while (i <= number) {
            res = fibSeries[0] + fibSeries[1];
            fibSeries[0] = fibSeries[1];
            fibSeries[1] = res;
            i++;
        }
        return fibSeries[1];
    }

    private int recGetFibonacciForRank(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            fibSeries[1] = 1;
            return 1;
        }
        if (fibSeries[n] == 0) {
            fibSeries[n] = recGetFibonacciForRank(n-1) + recGetFibonacciForRank(n-2);
        }
        return fibSeries[n];
    }
}
