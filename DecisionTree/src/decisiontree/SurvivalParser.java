/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Micke
 */
public class SurvivalParser {

    HashMap<Integer, Integer> survival = new HashMap<>();

    public HashMap<Integer, Integer> getSurvival(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] features = line.split(",");
            survival.put(Integer.valueOf(features[0]), Integer.valueOf(features[1]));

        }
        return survival;
    }
}
