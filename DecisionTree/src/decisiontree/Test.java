/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Micke
 */
public class Test {

    public float testAccuracy(HashMap<String, ArrayList> real, HashMap<String, ArrayList> pred) {
        float score = 0;
        int j = 0;
        for (int i = 0; i < pred.get("ID").size(); i++) { //Checks how many predictions were correct

            if (real.get("ID").get(i).equals(pred.get("ID").get(j))) { //Checks if the ID's are identical

                if (real.get("Survived").get(i).equals(pred.get("Survived").get(j))) { //Checks if the prediction was correct

                    score++;

                }
                j++; //Increments the prediction arraylist when the ID of the real list is the same
                
            }

        }
        return score / pred.get("ID").size() * 100; //Calculates the percentage of the accuracy
    }
}
