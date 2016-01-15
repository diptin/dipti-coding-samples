package org.diptin.numbers;

import java.util.Objects;

/**
 * A Mathematics professor has a class of N students. He decides to cancel class
 * if fewer than K students are present when class starts.
 * Given the arrival time of each student, determine if the class is canceled.
 */
public class MathClass {
    private final int totalStudents;
    private final int requiredStudents;

    public MathClass (int totalStudents, int requiredStudents) {
        if (totalStudents < 0) {
            throw new IllegalArgumentException("Total number of students can not be negative");
        }
        if (requiredStudents < 0 || requiredStudents > totalStudents) {
            throw new IllegalArgumentException("required students must be positive number, " +
                    "greater than total number of students");
        }
        this.totalStudents = totalStudents;
        this.requiredStudents = requiredStudents;
    }

    /**
     * @param arrivalTimes arrival times of students compared to class time. can be positive, negative or zero
     * @return true if class is cancelled
     *         false if class is Not cancelled
     */
    public boolean isClassCancelled (int[] arrivalTimes) {
        Objects.requireNonNull(arrivalTimes, "arrival time can not be null");

        if (arrivalTimes.length != totalStudents) {
            throw new IllegalArgumentException ("arrival times for exactly " + totalStudents + " required.");
        }
        int count = 0;
        for (int arrivalTime : arrivalTimes) {
            if (arrivalTime <= 0) {
                count++;
            }
        }
        return (count < requiredStudents);
    }
}
