/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Micke
 */
public class DAO {

    public static void main(String[] args) throws FileNotFoundException {
        CSVLoader loader = new CSVLoader();
        DecisionTree tree = new DecisionTree();
        SurvivalParser sp = new SurvivalParser();
        Test test = new Test();

        HashMap<String, ArrayList> trainingData = new HashMap<>(loader.getDataset("train.csv"));
        HashMap<String, ArrayList> testData = new HashMap<>(loader.getDataset("test.csv"));
        HashMap<String, ArrayList> survivalData = new HashMap<>(sp.getSurvival("gender_submission.csv"));

        tree.tree(trainingData, trainingData);

        tree.tree(testData, trainingData);
        
        System.out.println(test.testAccuracy(survivalData, tree.getPrediction()));

    }
}
