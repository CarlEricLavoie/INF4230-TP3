/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.neural.network;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Carl
 */
public class CoucheNeuronne {
    
    Neuronne[] neuronnes;
    
    public CoucheNeuronne(int nbNeuronnes, Neuronne[] entrees, Random r){
        this.neuronnes = new Neuronne[nbNeuronnes];
        for(Neuronne n : neuronnes){
            n = new Neuronne();
            for(Neuronne entree : entrees){
                n.ajouterEntree(entree, r.nextFloat());
            }           
        }
    }
    
    public void evaluerCouche(){
        for(Neuronne n : neuronnes){
            n.evaluerEntree();
        }
    }
    
    public float[] getSorties(){
        float[] valeurRetour = new float[neuronnes.length];
        for(int i = 0; i < neuronnes.length; ++i){
            valeurRetour[i] = neuronnes[i].getSortie();
        }
        return valeurRetour;
    }
    
    /**
     *  TEST EN HAUT 
     *
     */

    float[] sorties; //représente la valeur qui est donné a chaque sorties représent le nombre de neuronnes.
    float[] entrees; //représente la valeur de chaque entrées;
    float[] poids; //représente le poid donné à chaque entrée;

    public CoucheNeuronne(int nbEntrees, int nbSorties, Random r) {
        sorties = new float[nbSorties];
        entrees = new float[nbEntrees + 1]; //+1 pour le bias
        poids = new float[(1 + nbEntrees) * nbSorties];
        initialiserPoids(r);
    }

    public void initialiserPoids(Random r) {
        for (int i = 0; i < poids.length; i++) {
            poids[i] = (r.nextFloat() - 0.5f) * 4f;
        }
    }
    
    

    /**
     * Execute un couche de neuronnes selon l'entree. Les valeurs de retours
     * sont ensuite passés via une copie du array.
     *
     * @param in
     * @return
     */
    public float[] run(float[] in) {
        System.arraycopy(in, 0, entrees, 0, in.length);
        entrees[entrees.length - 1] = 1;
        int offs = 0; //permet de faire un bond pour les poids de la prochaine neuronne.
        Arrays.fill(sorties, 0);
        for (int i = 0; i < sorties.length; i++) {
            for (int j = 0; j < entrees.length; j++) {
                sorties[i] += poids[offs + j] * entrees[j];
            }
            /**
             * if (isSigmoid) { output[i] = (float) (1 / (1 +
             * Math.exp(-output[i]))); }
            *
             */
            offs += entrees.length; //prochaine neuronne
        }
        return Arrays.copyOf(sorties, sorties.length);
    }
    
}
