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
public class DecisionTree {

    ArrayList<Integer> prediction = new ArrayList();
 
    void tree(HashMap<String, ArrayList> test, HashMap<String, ArrayList> dataset) {
        Node node = new Node();
        AgeNode ageNode = new AgeNode();
        
        prediction.clear(); //Clears the prediction ArrayList so it can predict on a new dataset
        
        for (int i = 0; i < test.get("Class").size(); i++) {
            int survivalCount = 0;
            int survived = 0;
            
            if (test.get("Class").get(i).equals(node.bestFeature(node.node("Class", "Survived", dataset)))) {
                survivalCount++;
            }else{
                survivalCount--;
            }
            
            if (test.get("Sex").get(i).equals(node.bestFeature(node.node("Sex", "Survived", dataset)))) {
                survivalCount++;
            }else{
                survivalCount--;
            }
            
            //In the specific case of age, the age is classified into an age group first
            if (ageNode.parseAge(test.get("Age").get(i)).equals(node.bestFeature(ageNode.node("Age", "Survived", dataset)))) {
                survivalCount++;
            }else{
                survivalCount--;
            }
            
            if (test.get("Sibsp").get(i).equals(node.bestFeature(node.node("Sibsp", "Survived", dataset)))) {
                survivalCount++;
            }else{
                survivalCount--;
            }
            
            if (test.get("Parch").get(i).equals(node.bestFeature(node.node("Parch", "Survived", dataset)))) {
                survivalCount++;
            }else{
                survivalCount--;
            }
            
            //Based on the score of the checked features, did this person survive?
            if(survivalCount<=0){ 
                survived = 0;
            }else{
                survived = 1;
            }
            prediction.add(survived);
            
        }

    }
    ArrayList<Integer> getPrediction(){
        return prediction;
    }
}
