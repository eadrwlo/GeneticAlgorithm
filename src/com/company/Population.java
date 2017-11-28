package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Population {

    private ArrayList <Chromosome> chromosomes;
    private int populationSize;

	public int getPopulationSize() {
		return this.populationSize;
	}

    Population(int populationSize)
	{
        this.populationSize = populationSize;
        chromosomes = new ArrayList<>(populationSize);
        for (int i = 0; i < populationSize; i++) {
            chromosomes.add(new Chromosome(i));
            chromosomes.get(i).generateRandomPhenotype();
            chromosomes.get(i).evaluateAdaptation();
        }
    }
    
    Population(ArrayList<Chromosome> e)
	{
		chromosomes = new ArrayList<>(e.size());
		this.populationSize = e.size();
		for(int i=0;i<e.size();i++)
		{
			chromosomes.add(new Chromosome(e.get(i)));
			chromosomes.get(i).evaluateAdaptation();
		}
    }

    public ArrayList<Chromosome> getChromosomes() {
        return chromosomes;
    }

    public void calculateEachChromoSelectionProbability()
	{
        int amount = 0;
        for (Chromosome i: chromosomes)
        {
            amount += i.getAdaptationEval();
        }

        for (Chromosome i: chromosomes)
        {
           i.setSelectionProbability(i.getAdaptationEval() / (double)amount );
        }
    }
    
    public ArrayList<Chromosome> crossChromosome()
	{
		System.out.println("Rozmiar w cross na poczatku: " + getPopulationSize());
		ArrayList<Chromosome> afterCrossChromosomes = new ArrayList<>(getPopulationSize());
    	Random i = new Random();
    	int maxLocus;
    	int locus;
    	String ch1Substring;
    	String ch2Substring;
    	
    	String newChromosomeBinaryPhenotype1;
    	String newChromosomeBinaryPhenotype2;
    	
    	for(int j = 0; j < getPopulationSize() / 2 ; j++) {

    		Random randomInt = new Random();
    		int crossProbability = randomInt.nextInt(10);

			Chromosome ch1 = chromosomes.get(i.nextInt(getPopulationSize()));
			Chromosome ch2 = chromosomes.get(i.nextInt(getPopulationSize()));

			String ch1BinaryPhenotype = newChromosomeBinaryPhenotype1 = ch1.getBinaryPhenotype();
			String ch2BinaryPhenotype = newChromosomeBinaryPhenotype2 = ch2.getBinaryPhenotype();
			if (crossProbability > 5)
			{
				System.out.println("Wylosowany "+j+" ch "+ch1BinaryPhenotype);
				System.out.println("Wylosowany "+j+1+" ch "+ch2BinaryPhenotype);
				locus = i.nextInt(7);
				System.out.println("Locus: "+locus);

				ch1Substring = ch1BinaryPhenotype.substring(locus);
				ch2Substring = ch2BinaryPhenotype.substring(locus);

				System.out.println("CH1 substrgin: "+ch1Substring);
				System.out.println("CH2 substrgin: "+ch2Substring);

				newChromosomeBinaryPhenotype1 = ch1BinaryPhenotype.replaceAll(ch1Substring, ch2Substring);
				newChromosomeBinaryPhenotype2 = ch2BinaryPhenotype.replaceAll(ch2Substring, ch1Substring);
			}

			afterCrossChromosomes.add(new Chromosome(newChromosomeBinaryPhenotype1));
			afterCrossChromosomes.add(new Chromosome(newChromosomeBinaryPhenotype2));

			System.out.println("1 chromosome po mutacji: "+newChromosomeBinaryPhenotype1);
			System.out.println("2gi chromosome po mutacji: "+newChromosomeBinaryPhenotype2);
    	}
		for (int n = 0; n < afterCrossChromosomes.size(); n++)
		{
			afterCrossChromosomes.get(n).setChromosomeId(n);
		}
		System.out.println("Rozmiar w crossCg=hrmo: " + afterCrossChromosomes.size());
		return afterCrossChromosomes;
    }

    public ArrayList<Chromosome> selectAndGetBestAdaptedChromosomes()
	{
		byte adaptationDistributionTable [] = new byte[10000];
		int totalSelectionProbalility = 0;
		int currentChromoSelectionProbalility;
		for (Chromosome chromo : chromosomes )
		{
			currentChromoSelectionProbalility = (int)(chromo.getSelectionProbability() * 10000);
			//System.out.println("totalSelectionProbalility + currentChromoSelectionProbalility: " + (totalSelectionProbalility + currentChromoSelectionProbalility));
			int upperLimit = totalSelectionProbalility + currentChromoSelectionProbalility;
			upperLimit = (upperLimit > 10000) ? 1000 : upperLimit;
			//System.out.println("Rand w selectAndGet" + currentChromoSelectionProbalility);
			if (chromo.getChromosomeId() == 0)
			{
				for (int i = 0; i < currentChromoSelectionProbalility; i++ )
				{
					adaptationDistributionTable[i] = (byte)chromo.getChromosomeId();
				}
			}
			else
			{

				for (int i = totalSelectionProbalility; i < upperLimit; i++ )
				{
					adaptationDistributionTable[i] = (byte)chromo.getChromosomeId();
				}
			}
			totalSelectionProbalility += currentChromoSelectionProbalility;

			//System.out.println(totalSelectionProbalility);
		}
		Random random = new Random();
		int a;

		ArrayList<Chromosome> newBestAdaptedChromosomesList = new ArrayList(this.getPopulationSize());

		for (int i = 0; i < this.getPopulationSize(); i++)
		{
			a = random.nextInt(10000);
			//System.out.println("Rand w selectAndGet" + a + adaptationDistributionTable[a]);
			newBestAdaptedChromosomesList.add(new Chromosome(chromosomes.get(adaptationDistributionTable[a])));
		}
		System.out.println("Rozmiar w selectAndGetBestAdaptedChromosomes: " + newBestAdaptedChromosomesList.size());
		return newBestAdaptedChromosomesList;
	}
}
