/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

/**
 *
 * @author Micke
 */
public class TreeResults {
    
    float accuracy;
    String features;
    
    public TreeResults(float a, String f){
        this.accuracy = a;
        this.features = f;
    }
}
