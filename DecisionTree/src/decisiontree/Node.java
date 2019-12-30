/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Micke
 */
public class Node {
    HashMap<Object, Integer> x = new HashMap();
    
    public HashMap node(String feature, String target, HashMap<String, ArrayList> dataset) {

        //Loops through each element in the given feature list
        for (int i = 0; i < dataset.get(feature).size(); i++) {

            //If the current feature does not exist as a key in x yet, it is now added
            if (!x.containsKey(dataset.get(feature).get(i))) {
                x.put(dataset.get(feature).get(i), 0);

            }
            //If the person in the current row survived, a 1 is added to the total survival count of that feature
            if (dataset.get(target).get(i).equals(1)) {

                increment(x, dataset.get(feature).get(i)); //Method to increment the total survival count

            }
        }
        bestFeature(x);
        return x;
    }
    
    //Calculates which feature has the highest probability of survival
public Object bestFeature(HashMap<Object,Integer> hm){
        Object index = Collections.max(hm.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
        return index;

    }
    

//Adds 1+ to the total survival count of a feature
    public static void increment(HashMap<Object, Integer> hm, Object key) {
        Integer count = hm.get(key);

        if (count == null) {
            count = 1;
        }
        hm.put(key, count + 1);

    }

}
