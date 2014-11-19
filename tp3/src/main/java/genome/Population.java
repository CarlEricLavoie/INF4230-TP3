/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Carl
 */
public class Population<T> {
    static int i = 0;
    Genome[] genomes;
    public Population(int nbGenomes){
        
    }
    
    private List<Object> rouletteSelection(int selectionSize){
        double[] fitnesses = new double[genomes.length];
        fitnesses[0] = genomes[0].fitnessNormalisée();
        for(int i = 1; i < genomes.length; i++){
            double fitness = genomes[i].fitnessNormalisée();
            fitnesses[i] = fitnesses[i -1 ] + fitness;
        }
        
        List<Object> selection = new ArrayList<Object>(selectionSize);
        
        for(int i = 0; i < selectionSize; i++){
            double randomFitness = new Random().nextDouble() * fitnesses[fitnesses.length - 1];
            int index = Arrays.binarySearch(fitnesses, randomFitness);
            if(index < 0){
                index = Math.abs(index +1);
            }
            selection.add(genomes[index]);
        }
        
        return selection;       
    }
}
