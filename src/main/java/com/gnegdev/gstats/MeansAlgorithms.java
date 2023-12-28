package com.gnegdev.gstats;

import java.util.Arrays;

public class MeansAlgorithms {
    public static double arithmeticMean(double[] numbersArray) {
        return Arrays.stream(numbersArray).sum() / numbersArray.length;
    }
    public static double harmonicMean(double[] numbersArray) {
        double sum = 0;

        for(double v : numbersArray) {
            sum += 1.0 / v;
        }

        return numbersArray.length / sum;
    }
    public static double geometricMean(double[] numbersArray) {
        double sum = 0;

        for(double v : numbersArray) {
            sum += Math.log(v);
        }
        sum /= numbersArray.length;

        return Math.exp(sum);
    }
    public static double median(double[] numbersArray) {
        Arrays.sort(numbersArray);
        double median;
        if (numbersArray.length % 2 == 0) {
            median = (numbersArray[numbersArray.length / 2] + numbersArray[numbersArray.length / 2 - 1]) / 2;
        } else {
            median = numbersArray[numbersArray.length / 2];
        }
        return median;
    }
}
