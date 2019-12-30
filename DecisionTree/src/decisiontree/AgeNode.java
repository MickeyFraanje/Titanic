/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import static decisiontree.Node.increment;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Micke
 */
public class AgeNode extends Node {

    public HashMap node(String feature, String target, HashMap<String, ArrayList> dataset) {
        x.put("Child", 0);
        x.put("Adult", 0);
        x.put("Senior", 0);

        //Loops through each element in the given feature list
        for (int i = 0; i < dataset.get(feature).size(); i++) {

            //If the person in the current row survived, a 1 is added to the total survival count of that feature
            if (dataset.get(target).get(i).equals(1)) {

                increment(x, parseAge(dataset.get(feature).get(i))); //Method to increment the total survival count
            }
        }

        bestFeature(x);
        return x;
    }

    //Checks if the person is an child, adult or senior
    String parseAge(Object a) {
        String ageGroup;
        
        if ((Float) a < 18.0) { 

            return ageGroup = "Child";

        } else if ((Float) a > 60.0) {
            
            return ageGroup = "Senior";

        } else {
            return ageGroup = "Adult";
        }
    }
}
