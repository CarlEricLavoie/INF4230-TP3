/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.neural.network;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Carl
 */
public class CoucheNeuronne {
    
    float[] poidsEntrees;
    float[] sorties;
    private int nbEntrees;
    
    
    public CoucheNeuronne(int nbEntrees, int nbNeuronnes, Random r){
        this.nbEntrees = nbEntrees;
        this.sorties = new float[nbNeuronnes];
        this.poidsEntrees = new float[nbEntrees * nbNeuronnes];
        for(int i = 0; i < (nbEntrees * nbNeuronnes); i++){
            this.poidsEntrees[i] = r.nextFloat();
        }
    }
    
    public void evaluerCouche(CoucheNeuronne couchePrecedente){
        for(int i = 0; i < sorties.length; i++){
            sorties [i] = 0;
            for(int j = 0; j < nbEntrees; j++){
                System.out.println(sorties.length + " :: " + i + " :: " + j + " :: " + nbEntrees );
                sorties [i] += couchePrecedente.sorties[j] * poidsEntrees[i * nbEntrees + j];
                
                sorties[i] = fonctionEvaluation(sorties[i]);
            }
        }
    }
    
    public void evaluerCouche(float[] valeursEntrees){
        for(int i = 0; i < sorties.length; i++){
            sorties [i] = valeursEntrees[i];
            sorties[i] = fonctionEvaluation(sorties[i]);
        }
    }
    
    private float fonctionEvaluation(float f){
        //linéaire
        return f;
    }
    
    public float[] getSorties(){
        return this.sorties;
    }
    
}
