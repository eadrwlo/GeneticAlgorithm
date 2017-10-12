package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int POPULATE_SIZE = 10;

        Population population1 = new Population(10);
        population1.calculateEachChromoSelectionProbability();

        for (Chromosome i : population1.getChromosomes()) {
            System.out.println(i.getPhenotype() + "\t" + i.getBinaryPhenotype()
                                + "\t" + i.getAdaptationEval() + "\t" + i.getSelectionProbability());
        }

    }
}
