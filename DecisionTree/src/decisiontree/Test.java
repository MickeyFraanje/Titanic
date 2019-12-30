/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.util.ArrayList;

/**
 *
 * @author Micke
 */
public class Test {
    //IN PROGRESS
    public float testAccuracy(ArrayList<Integer> d, ArrayList<Integer> p){
        float score = 0;
        
        for(int i = 0; i < d.size(); i++){ //Checks how many predictions were correct
            if(d.get(i).equals(p.get(i))){
                score++;
            }
        }
        return score / d.size() * 100; //Calculates the percentage of the accuracy
        
    }
}
