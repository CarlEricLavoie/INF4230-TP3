/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.neural.network;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author Carl
 */
public class Neuronne implements Comparable{
    static int cmpt = 0;
    private int id;
    TreeMap<Neuronne, Float> poidsEntrees = new TreeMap();
    float sortie = 0;
    float valeurActivation = new Random().nextFloat();
    
    
    public Neuronne(){
        id = cmpt++;
    }
    
    
    public void ajouterEntree(Neuronne n, Float f){
        poidsEntrees.put(n, f);
    }
    
    /**
     * Doit definir la sortie
     */
    public void evaluerEntree(){
        int calculValeurActivation = 0;
        for(Entry<Neuronne, Float> e : poidsEntrees.entrySet()){
            calculValeurActivation += e.getKey().getSortie() * e.getValue();
        }
        
        if(calculValeurActivation >= valeurActivation){
            this.sortie = 1;
        }
    }
    
    public void evaluerEntreeForcee(float entree){
        if(entree >= valeurActivation){
            this.sortie = Float.MAX_VALUE;
        }
    }

    
    public float getSortie(){
        return this.sortie;
    }

    @Override
    public int compareTo(Object o) {
        return ((Integer)this.id).compareTo(((Neuronne)o).id);
    }
}
