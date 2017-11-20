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
    
    Chromosome(String binaryPhenotype){
    	this.binaryPhenotype=binaryPhenotype;
    	this.phenotype=Integer.parseInt(binaryPhenotype, 2);
    }

    // Getters
    public int getPhenotype(){
        return phenotype;
    }
    public String getBinaryPhenotype(){
        return binaryPhenotype;
    }
    public int getAdaptationEval() {
        return adaptationEval;
    }
    public float getSelectionProbability() {
        return selectionProbability;
    }
    public int getChromosomeId() { return  chromosomeId; }
    // Setters
    public void setAdaptationEval(int adaptationEval) {
        this.adaptationEval = adaptationEval;
    }
    public void setSelectionProbability(float selectionProbability) { this.selectionProbability = selectionProbability; }

    public void evaluateAdaptation()
    {
        adaptationEval = 2*(phenotype^2+1);
    }

    public void generateRandomPhenotype()
    {
        Random r = new Random();
        phenotype = r.nextInt(127);
        binaryPhenotype = Integer.toBinaryString(phenotype);
    }


}
