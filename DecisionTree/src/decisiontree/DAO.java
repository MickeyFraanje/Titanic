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
        HashMap<String, ArrayList> trainingData = new HashMap<>(loader.getDataset("train.csv"));
        HashMap<String, ArrayList> testData = new HashMap<>(loader.getDataset("test.csv"));
             
        ArrayList<TreeResults> treeList = new ArrayList();

        //Input the dataset you want to test, the dataset you want the model to train on, and the features you want the model to train on
        treeList.add(createTree(testData, trainingData, "Class, Sex, Age, Sibsp, Parch"));
        treeList.add(createTree(testData, trainingData, "Sex, Age, Sibsp, Parch"));
        treeList.add(createTree(testData, trainingData, "Class, Sex, Age"));
        treeList.add(createTree(testData, trainingData, "Sex"));
        treeList.add(createTree(testData, trainingData, "Sibsp, Parch"));
        

    }
    static TreeResults createTree(HashMap test, HashMap train, String features) throws FileNotFoundException{
        DecisionTree tree = new DecisionTree();
        tree.tree(test, train, features);
        
        SurvivalParser sp = new SurvivalParser();
        HashMap<String, ArrayList> survivalData = new HashMap<>(sp.getSurvival("gender_submission.csv"));
        
        Test t = new Test();
        
        TreeResults result = new TreeResults(t.testAccuracy(survivalData, tree.getPrediction()), features);
        
        System.out.println("The accuracy is: "+ result.accuracy + "% with features: "+features);
        
        return result;
    }
    static void bestTree(ArrayList t){
        
    }
}
