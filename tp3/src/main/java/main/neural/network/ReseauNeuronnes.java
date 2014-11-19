/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.neural.network;

import java.util.Random;

/**
 *
 * @author Carl
 */
public class ReseauNeuronnes {
    CoucheNeuronne[] couches;
    
    public ReseauNeuronnes(int[] nbNoeuds){
        couches = new CoucheNeuronne[nbNoeuds.length];
        for(int i = 0; i < nbNoeuds.length; i++){
            if(i == 0){
                couches[i] = new CoucheNeuronne(0, nbNoeuds[i], new Random());
            }else{
                couches[i] = new CoucheNeuronne(nbNoeuds[i-1], nbNoeuds[i], new Random());
            }  
        }
    }
    
    
    
    
    public float[] evaluer(float[] entrees){
        for(int i = 0; i < couches.length; i++){
            if(i == 0){
                System.out.println("GOT HERE" + entrees[0]);
                couches[i].evaluerCouche(entrees);
            }else{
                couches[i].evaluerCouche(couches[i-1]);
            }
        }
        return couches[couches.length -1].getSorties();
    }
    
    private void afficherCouches(){
        for(CoucheNeuronne couche : couches){
            System.out.println("~~~~~Couche~~~~~");
            for(Float f : couche.getSorties()){
                System.out.println(f + " ~~ ");
            }
        }
    }
    
    
    public static void main(String[] args){
        int[] nbNeuronnes = {3,2};
        ReseauNeuronnes r = new ReseauNeuronnes(nbNeuronnes);
        
        float[] entrees = {new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat()};
        
        r.evaluer(entrees);
        r.afficherCouches();
        
    }
}
