/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Micke
 */
public class CSVLoader {

    HashMap<String, ArrayList> dataset = new HashMap();

    public HashMap getDataset(String file) throws FileNotFoundException {
        
        ArrayList<Integer> survived = new ArrayList();
        ArrayList<Integer> pClass = new ArrayList();
        ArrayList<String> sex = new ArrayList();
        ArrayList<Float> age = new ArrayList();
        ArrayList<Integer> sibsp = new ArrayList();
        ArrayList<Integer> parch = new ArrayList();

        Scanner scanner = new Scanner(new File(file));

        //Separates the header from the rest of the dataset
        String header = scanner.nextLine();
        
        if (header.contains("Survived")) { //Checks if it is a test dataset (Doesn't contain a survived column)
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] features = line.split(",");

                if (features[6].isEmpty()) {
                    //Skips the line if the age feature has missing values
                } else {
                    //Adds each feature to its own ArrayList in its apropriate datatype
                    survived.add(Integer.valueOf(features[1]));
                    pClass.add(Integer.valueOf(features[2]));
                    sex.add(features[5]);
                    age.add(Float.valueOf(features[6]));
                    sibsp.add(Integer.valueOf(features[7]));
                    parch.add(Integer.valueOf(features[8]));
                }

            }
        }else{
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] features = line.split(",");
                
               if (features[5].isEmpty()) {
                    //Skips the line if the age feature has missing values
                } else {
                    //Adds each feature to its own ArrayList in its apropriate datatype
                    pClass.add(Integer.valueOf(features[1]));
                    sex.add(features[4]);
                    age.add(Float.valueOf(features[5]));
                    sibsp.add(Integer.valueOf(features[6]));
                    parch.add(Integer.valueOf(features[7]));
                }

            }
        }
        //Adds each feature list to the dataset
        dataset.put("Survived", survived);
        dataset.put("Class", pClass);
        dataset.put("Sex", sex);
        dataset.put("Age", age);
        dataset.put("Sibsp", sibsp);
        dataset.put("Parch", parch);
        scanner.close();

        //  System.out.println(dataset.get("Sex").get(1));
        return dataset;
    }

}
