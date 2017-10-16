package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        final int POPULATE_SIZE = 10;

        Population population1 = new Population(POPULATE_SIZE);
        Population population2 = new Population(POPULATE_SIZE);
        population1.calculateEachChromoSelectionProbability(); 


        population2.crossChromosome(population1);
        population2.calculateEachChromoSelectionProbability();      

        Population population3 = new Population(population1.selectAndGetBestAdaptedChromosomes());


        System.out.println("Populacja przed krzyzowaniem:");
            for (Chromosome i : population1.getChromosomes()) {
                System.out.println(i.getPhenotype() + "\t" + i.getBinaryPhenotype()
                                    + "\t" + i.getAdaptationEval() + "\t" + i.getSelectionProbability() + "ch id:" + i.getChromosomeId());
        }
            System.out.println("Populacja po krzyzowaniu:");
            for (Chromosome j : population2.getChromosomes()) {
                System.out.println(j.getPhenotype() + "\t" + j.getBinaryPhenotype()
                                    + "\t" + j.getAdaptationEval() + "\t" + j.getSelectionProbability() + "ch id:" + j.getChromosomeId());
        }

        System.out.println("Populacja 1 po wybraniu najlepszych:");
        for (Chromosome j : population3.getChromosomes()) {
            System.out.println(j.getPhenotype() + "\t" + j.getBinaryPhenotype()
                    + "\t" + j.getAdaptationEval() + "\t" + j.getSelectionProbability() + "ch id:" + j.getChromosomeId());
        }

    }
}
