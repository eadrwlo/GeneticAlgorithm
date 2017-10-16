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
    		chromosomes = e;
    		populationSize = chromosomes.size();
    		for(int i=0;i<e.size();i++)
    		{
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
           i.setSelectionProbability(i.getAdaptationEval() / (float)amount );
        }
    }
    
    public ArrayList<Chromosome> crossChromosome(Population e)
	{
    	ArrayList<Chromosome> chromosomes=e.getChromosomes();
		ArrayList<Chromosome> AfterCorssChromosomes=new ArrayList<>(e.getPopulationSize());
    	Random i=new Random();
    	int maxLocus;
    	int locus;
    	String ch1Substring;
    	String ch2Substring;
    	
    	String newChromosomeBinaryPhenotype1;
    	String newChromosomeBinaryPhenotype2;
    	
    	for(int j=0;j<e.getPopulationSize()/2;j++)
    	{
			Chromosome ch1 = chromosomes.get(i.nextInt(e.getPopulationSize()));
			Chromosome ch2 = chromosomes.get(i.nextInt(e.getPopulationSize()));

			String ch1BinaryPhenotype=ch1.getBinaryPhenotype();
			String ch2BinaryPhenotype=ch2.getBinaryPhenotype();

			//System.out.println("Wylosowany "+j+" ch "+ch1BinaryPhenotype);
			//System.out.println("Wylosowany "+j+1+" ch "+ch2BinaryPhenotype);

			if(ch1BinaryPhenotype.length()>ch2BinaryPhenotype.length())
			{
				maxLocus=ch2BinaryPhenotype.length();
			}
			else
			{
				maxLocus = ch1BinaryPhenotype.length();
			}

			locus=i.nextInt(maxLocus);

			//System.out.println("Locus: "+locus);

			ch1Substring=ch1BinaryPhenotype.substring(locus);
			ch2Substring=ch2BinaryPhenotype.substring(locus);

			//System.out.println("CH1 substrgin: "+ch1Substring);
			//System.out.println("CH2 substrgin: "+ch2Substring);

			newChromosomeBinaryPhenotype1=ch1BinaryPhenotype.replaceAll(ch1Substring, ch2Substring);

			newChromosomeBinaryPhenotype2=ch2BinaryPhenotype.replaceAll(ch2Substring, ch1Substring);

			AfterCorssChromosomes.add(new Chromosome(newChromosomeBinaryPhenotype1));

			// Tu chyba powinien byc wrzucany newChromosomeBinaryPhenotype2?? Jest nie uzywany. Zmnien jak cos.
			AfterCorssChromosomes.add(new Chromosome(newChromosomeBinaryPhenotype1));

			//System.out.println("1 chromosome po mutacji: "+newChromosomeBinaryPhenotype1);
			//System.out.println("2gi chromosome po mutacji: "+newChromosomeBinaryPhenotype2);
		}
    	return AfterCorssChromosomes;
    }

    public ArrayList<Chromosome> selectAndGetBestAdaptedChromosomes()
	{
		byte adaptationDistributionTable [] = new byte[10000];
		int totalSelectionProbalility = 0;
		int currentChromoSelectionProbalility;
		for (Chromosome chromo : chromosomes )
		{
			currentChromoSelectionProbalility = (int)(chromo.getSelectionProbability() * 10000);
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
				for (int i = totalSelectionProbalility; i < totalSelectionProbalility + currentChromoSelectionProbalility; i++ )
				{
					adaptationDistributionTable[i] = (byte)chromo.getChromosomeId();
				}
			}
			totalSelectionProbalility += currentChromoSelectionProbalility;
		}
		Random random = new Random();
		int a;

		ArrayList<Chromosome> newBestAdaptedChromosomesList = new ArrayList(this.getPopulationSize());

		for (int i = 0; i < this.getPopulationSize(); i++)
		{
			a = random.nextInt(10000);
			System.out.println("Rand w selectAndGet" + a + adaptationDistributionTable[a]);
			newBestAdaptedChromosomesList.add((chromosomes.get(adaptationDistributionTable[a])));
		}

		return newBestAdaptedChromosomesList;


	}
}
