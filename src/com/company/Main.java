package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	

    public static void main(String[] args) {
        int POPULATE_SIZE = 10;

        Population population1 = new Population(10);
        Population population2 = new Population(10);
        population1.calculateEachChromoSelectionProbability(); 
       
        population2.crossChromosome(population1);
        population2.calculateEachChromoSelectionProbability();      
               
        System.out.println("Populacja przed krzyzowaniem:");
            for (Chromosome i : population1.getChromosomes()) {
                System.out.println(i.getPhenotype() + "\t" + i.getBinaryPhenotype()
                                    + "\t" + i.getAdaptationEval() + "\t" + i.getSelectionProbability());
        }
            System.out.println("Populacja po krzyzowaniu:");
            for (Chromosome j : population2.getChromosomes()) {
                System.out.println(j.getPhenotype() + "\t" + j.getBinaryPhenotype()
                                    + "\t" + j.getAdaptationEval() + "\t" + j.getSelectionProbability());
        }
    }
}
