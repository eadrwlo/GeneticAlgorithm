package com.company;

import java.util.ArrayList;

public class Population {
    private ArrayList <Chromosome> chromosomes;
    private int populationSize;

    Population(int populationSize){
        this.populationSize = populationSize;
        chromosomes = new ArrayList<>(populationSize);
        for (int i = 0; i < populationSize; i++) {
            chromosomes.add(new Chromosome(i + 1));
            chromosomes.get(i).generateRandomPhenotype();
            chromosomes.get(i).evaluateAdaptation();
        }
    }

    public ArrayList<Chromosome> getChromosomes() {
        return chromosomes;
    }

    public void calculateEachChromoSelectionProbability(){
        int amount = 0;
        for (Chromosome i:
             chromosomes) {
            amount += i.getAdaptationEval();
        }
        for (Chromosome i:
                chromosomes) {
           i.setSelectionProbability(i.getAdaptationEval() / (float)amount );
        }

    }
}
