package com.kgc.et;

import java.text.DecimalFormat;

import static com.kgc.et.EqualTemperament.B8;
import static com.kgc.et.EqualTemperament.C0;

public class Main {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("##.00");

        StringBuilder table = new StringBuilder();
        table.append("| Октава   | C       | C#      | D       | D#      | E       | F       | F#      | G       | G#      | A       | A#      | B       |").append("\n");
        table.append("|:---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|---------|").append("\n");

        StringBuilder octaveBuilder = new StringBuilder("| 0        |");
        int counter = 0;
        int octaveCounter = 0;
        for (int note = C0; note <= B8; note++) {
            String noteString = format.format(EqualTemperament.calculate(note));
            octaveBuilder.append(" ")
                    .append(noteString)
                    .append(" ".repeat(Math.max(0, 8 - noteString.length()))).append("|");
            counter++;
            if (counter >= 12) {
                counter = 0;
                octaveCounter++;
                table.append(octaveBuilder).append("\n");
                octaveBuilder.delete(0, octaveBuilder.length());
                octaveBuilder.append("| ").append(octaveCounter).append("        |");
            }
        }
        System.out.println(table);
    }
}
