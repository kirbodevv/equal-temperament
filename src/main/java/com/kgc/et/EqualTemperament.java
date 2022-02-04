package com.kgc.et;

public class EqualTemperament {
    /**
     * Reference frequency (A4) in Hz
     */
    public static double reference = 440;

    /**
     * Interval from A4 to C0 in semitones
     */
    public static final int C0 = -57;

    /**
     * Interval from A4 to B8 in semitones
     */
    public static final int B8 = 50;

    public static double calculate(int semitone) {
        return reference * Math.pow(2, semitone / 12d);
    }
}
