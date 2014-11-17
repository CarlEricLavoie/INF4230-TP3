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
    
    public float[] evaluer(float[] entrees){
        for(int i = 0; i < couches[0].neuronnes.length; ++i){
            couches[0].neuronnes[i].evaluerEntreeForcee(entrees[i]);
        }
        
        
        for(int i = 1; i < couches.length; i++){
            couches[i].evaluerCouche();
        }
        afficherCouches();
        return couches[couches.length-1].getSorties(); 
    }
    
    private void afficherCouches(){
        for(CoucheNeuronne couche : couches){
            System.out.println("~~~~~Couche~~~~~");
            for(Neuronne n : couche.neuronnes){
                System.out.println(n.sortie + " ~~ ");
            }
        }
    }
    
    
    public static void main(String[] args){
        ReseauNeuronnes r = new ReseauNeuronnes();
        CoucheNeuronne[] couches = new CoucheNeuronne[2];
        Neuronne[] nc1 = new Neuronne[2];
        nc1[0] = new Neuronne();
        nc1[1] = new Neuronne();
        Neuronne[] nc2 = new Neuronne[2];
        nc2[0] = new Neuronne();
        nc2[1] = new Neuronne();
        for(Neuronne n : nc2){
            n.ajouterEntree(nc1[0], new Random().nextFloat());
            n.ajouterEntree(nc1[1], new Random().nextFloat());
        }
        
        CoucheNeuronne c1 = new CoucheNeuronne(0, null, new Random());
        c1.neuronnes = nc1;
        
        CoucheNeuronne c2 = new CoucheNeuronne(2, c1.neuronnes, new Random());
        c2.neuronnes = nc2;
        couches[0] = c1;
        couches[1] = c2;
        
        float[] entrees = new float[2];
        entrees[0] = 0.6f;
        entrees[1] = 0.8f;
        
        r.couches = couches;
        r.evaluer(entrees);
        
    }
}
