package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int POPULATE_SIZE = 10;

        ArrayList<Chromosome> chromosomeList = new ArrayList(POPULATE_SIZE);

        for (int i = 0; i < POPULATE_SIZE; i++) {
            chromosomeList.add(new Chromosome(i + 1));
            chromosomeList.get(i).generateRandomPhenotype();
        }

        for (Chromosome i : chromosomeList) {
            System.out.println(i.getPhenotype());
        }
    }
}
