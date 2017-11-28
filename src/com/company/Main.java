package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        final int POPULATE_SIZE = 30;
        //System.out.println(Math.pow(5,2));
        Population population1 = new Population(POPULATE_SIZE);
        population1.calculateEachChromoSelectionProbability();

        System.out.println("Populacja przed krzyzowaniem:");

        for (Chromosome i : population1.getChromosomes()) {
            System.out.println("Fenotyp: " + i.getPhenotype() + "      Genotyp: " + i.getBinaryPhenotype()
                    + "       Wartosc przystosowania: " + i.getAdaptationEval() + "      Prawdopodobienstwo wyboru:" + i.getSelectionProbability() + "     ch id:" + i.getChromosomeId());
        }
        Population populationForCrossing = new Population(population1.selectAndGetBestAdaptedChromosomes());
        Population afterCrossing = new Population(populationForCrossing.crossChromosome());
        afterCrossing.calculateEachChromoSelectionProbability();

        for (int x = 0; x < 190; x++)
        {
            afterCrossing = new Population(afterCrossing.selectAndGetBestAdaptedChromosomes());
            afterCrossing = new Population(afterCrossing.crossChromosome());
            afterCrossing.calculateEachChromoSelectionProbability();
        }
        System.out.println("Populacja po krzyzowaniem:");
        for (Chromosome i : afterCrossing.getChromosomes()) {
            System.out.println("Fenotyp: " + i.getPhenotype() + "      Genotyp: " + i.getBinaryPhenotype()
                    + "       Wartosc przystosowania: " + i.getAdaptationEval() + "      Prawdopodobienstwo wyboru:" + i.getSelectionProbability() + "     ch id:" + i.getChromosomeId());
        }

    }
}
