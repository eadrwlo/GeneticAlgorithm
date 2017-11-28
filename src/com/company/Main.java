package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        final int POPULATE_SIZE = 10;
        //System.out.println(Math.pow(5,2));
        Population population1 = new Population(POPULATE_SIZE);
        //Population population2 = new Population(POPULATE_SIZE);
        population1.calculateEachChromoSelectionProbability(); 


        //population2.crossChromosome(population1);
        //population2.calculateEachChromoSelectionProbability();
        System.out.println("Populacja przed krzyzowaniem:");
        double suma = 0;
        for (Chromosome i : population1.getChromosomes()) {
            System.out.println("Fenotyp: " + i.getPhenotype() + "      Genotyp: " + i.getBinaryPhenotype()
                    + "       Wartosc przystosowania: " + i.getAdaptationEval() + "      Prawdopodobienstwo wyboru:" + i.getSelectionProbability() + "     ch id:" + i.getChromosomeId());
            suma += i.getSelectionProbability();
        }
        System.out.println(suma);
        for (int i=0; i < 6; i++)
        {
            System.out.println("Numer petli:" + i);
            population1 = new Population(population1.selectAndGetBestAdaptedChromosomes());
            population1.calculateEachChromoSelectionProbability();
        }


        //System.out.println(population3.getChromosomes().get();
        //population3.getChromosomes().get(1).setSelectionProbability(4);

        System.out.println("Populacja przed krzyzowaniem:");
            for (Chromosome i : population1.getChromosomes()) {
                System.out.println("Fenotyp: " + i.getPhenotype() + "      Genotyp: " + i.getBinaryPhenotype()
                                    + "       Wartosc przystosowania: " + i.getAdaptationEval() + "      Prawdopodobienstwo wyboru:" + i.getSelectionProbability() + "     ch id:" + i.getChromosomeId());
        }
//
//        for (int i = 0; i < 10; i++)
//        {
//            //population1.selectAndGetBestAdaptedChromosomes();
//            Population population3 = new Population(population1.selectAndGetBestAdaptedChromosomes());
//        }



//            System.out.println("Populacja po krzyzowaniu:");
//            for (Chromosome j : population2.getChromosomes()) {
//                System.out.println(j.getPhenotype() + "\t" + j.getBinaryPhenotype()
//                                    + "\t" + j.getAdaptationEval() + "\t" + j.getSelectionProbability() + "ch id:" + j.getChromosomeId());
//            }

//        System.out.println("Populacja 3 po wybraniu najlepszych:");
//        for (Chromosome j : population3.getChromosomes()) {
//            System.out.println(j.getPhenotype() + "\t" + j.getBinaryPhenotype()
//                    + "\t" + j.getAdaptationEval() + "\t" + j.getSelectionProbability() + "ch id:" + j.getChromosomeId());
//        }

    }
}
