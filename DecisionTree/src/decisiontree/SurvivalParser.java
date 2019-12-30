/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Micke
 */
public class SurvivalParser {

   HashMap<String, ArrayList> survival = new HashMap<>();

    public HashMap<String, ArrayList> getSurvival(String file) throws FileNotFoundException {
        
        ArrayList<Integer> id = new ArrayList();
        ArrayList<Integer> survived = new ArrayList();
        
        Scanner scanner = new Scanner(new File(file));
        
        //Separates the header from the rest of the dataset
        String header = scanner.nextLine();
        
        //Adds the survival column to its own ArrayList
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] features = line.split(",");
            
            id.add(Integer.valueOf(features[0]));
            survived.add(Integer.valueOf(features[1]));
        }
        survival.put("ID", id);
        survival.put("Survived", survived);
        
        return survival;
    }
}
