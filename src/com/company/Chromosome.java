package com.company;

import java.util.Random;

class Chromosome {
    private int chromosomeId;
    private int adaptationEval;
    private int phenotype;
    private String binaryPhenotype;
    private double selectionProbability;

    Chromosome(int chromosomeId){
        this.chromosomeId = chromosomeId;
    }
    
    Chromosome(String binaryPhenotype){
    	this.binaryPhenotype=binaryPhenotype;
    	this.phenotype=Integer.parseInt(binaryPhenotype, 2);
    }

    Chromosome(Chromosome chromosome)
    {
        this.chromosomeId = chromosome.getChromosomeId();
        this.setAdaptationEval(chromosome.getAdaptationEval());
        this.phenotype = chromosome.getPhenotype();
        this.binaryPhenotype = chromosome.getBinaryPhenotype();
        this.setSelectionProbability(chromosome.getSelectionProbability());
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
    public double getSelectionProbability() {
        return selectionProbability;
    }
    public int getChromosomeId() { return  chromosomeId; }
    // Setters
    public void setAdaptationEval(int adaptationEval) {
        this.adaptationEval = adaptationEval;
    }
    public void setSelectionProbability(double selectionProbability) { this.selectionProbability = selectionProbability; }
    public void setChromosomeId(int chromosomeId){ this.chromosomeId = chromosomeId; }
    public void evaluateAdaptation()
    {
        adaptationEval = (int)(2*(Math.pow(phenotype,2)+1));
    }

    public void generateRandomPhenotype()
    {
        Random r = new Random();
        phenotype = r.nextInt(127);
        binaryPhenotype = Integer.toBinaryString(phenotype);
        if (binaryPhenotype.length() < 7 )
        {
            int prefix = 7 - binaryPhenotype.length();
            String zeros = "";
            for (int k = 0; k < prefix; k++)
                zeros += "0";
            binaryPhenotype = zeros + binaryPhenotype;
        }
    }


}
