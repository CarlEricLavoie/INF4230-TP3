/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genome;

/**
 *
 * @author Carl
 */
public abstract class Genome {
    int fitness;
    Object[] valeurs;
    
    public double fitnessNormalisée(){
        return 1 / fitness;
    }
    
    public String toString(){
        String s = new String();
        for(Object o : valeurs){
            s += o.toString();
        }
        return s;
    }
    
    public Object[] getValeurs(){
        return this.valeurs;
    }
}
