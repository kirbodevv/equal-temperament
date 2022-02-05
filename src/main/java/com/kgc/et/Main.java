package com.kgc.et;

import net.steppschuh.markdowngenerator.table.Table;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("##.00");

        Table.Builder tableBuilder = new Table.Builder()
                .withAlignments(Table.ALIGN_LEFT, Table.ALIGN_RIGHT)
                .addRow("Ноты", 0, 1, 2, 3, 4, 5, 6, 7, 8);
        String[] notes = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

        for (int n = 0; n < notes.length; n++) {
            String[] octaves = new String[10];
            octaves[0] = notes[n];
            for (int octave = 0; octave <= 8; octave++) {
                octaves[octave + 1] =
                        format.format(EqualTemperament.calculate(EqualTemperament.C0 + n + octave * 12));
            }
            tableBuilder.addRow((Object[]) octaves);
        }
        System.out.println(tableBuilder.build());
    }
}
