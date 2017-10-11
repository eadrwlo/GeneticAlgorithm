package com.company;

import java.util.Random;

class Chromosome {
    private int chromosomeId;
    private int adaptationEval;
    private int phenotype;

    Chromosome(int chromosomeId){
        this.chromosomeId = chromosomeId;
    }

    int getPhenotype(){
        return phenotype;
    }
    void evaluateAdaptation(){
        adaptationEval = 2*(phenotype^2+1);
    }

    void generateRandomPhenotype(){
        Random r = new Random();
        phenotype = r.nextInt(127);
    }

}
