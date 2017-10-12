package com.company;

import java.util.Random;

class Chromosome {
    private int chromosomeId;
    private int adaptationEval;
    private int phenotype;
    private String binaryPhenotype;
    private float selectionProbability;

    Chromosome(int chromosomeId){
        this.chromosomeId = chromosomeId;
    }

    int getPhenotype(){
        return phenotype;
    }
    String getBinaryPhenotype(){
        return binaryPhenotype;
    }

    int getAdaptationEval() {
        return adaptationEval;
    }

    void setAdaptationEval(int adaptationEval) {
        this.adaptationEval = adaptationEval;
    }

    void evaluateAdaptation(){
        adaptationEval = 2*(phenotype^2+1);
    }

    void generateRandomPhenotype(){
        Random r = new Random();
        phenotype = r.nextInt(127);
        binaryPhenotype = Integer.toBinaryString(phenotype);
    }

    public void setSelectionProbability(float selectionProbability) {
        this.selectionProbability = selectionProbability;
    }

    public float getSelectionProbability() {
        return selectionProbability;
    }
}
