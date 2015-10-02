/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDataGenerator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author sebastiannielsen
 */
public class DataGenerator {

    static List<String> firstnames = new ArrayList() {
        {
            add("Sebastian");
            add("Ole");
            add("Birk");
            add("Jens");
            add("Niels");
            add("Peter");
            add("Hans");
            add("Kasper");
        }
    };

    static List<String> lastnames = new ArrayList() {
        {
            add("Nielsen");
            add("Jensen");
            add("Hansen");
            add("Petersen");
            add("Mortensen");
            add("Bro");
            add("Knudsen");
            add("Pedersen");

        }
    };

    static List<String> streets = new ArrayList() {
        {
            add("gade1");
            add("gade2");
            add("gade3");
            add("gade4");
            add("gade5");
            add("gade6");
            add("gade7");
            add("gade8");

        }
    };

    static List<String> cities = new ArrayList() {
        {
            add("Copenhagen");
            add("Olso");
            add("London");
            add("Stockholm");
            add("Aarhus");
            add("Aalborg");
            add("Odense");
            add("Herning");
        }
    };

    public static String getData(int amount, String inputProperties) {

        String[] properties = inputProperties.split(",");
        String res = ""; 
        JsonArray testdata = new JsonArray();

        for (int i = 0; i < amount; i++) {
            
            JsonObject person = new JsonObject();
            person.addProperty(properties[0], firstnames.get(ThreadLocalRandom.current().nextInt(1, firstnames.size())));
            
            if (properties.length > 1) 
                person.addProperty(properties[1], lastnames.get(ThreadLocalRandom.current().nextInt(1, lastnames.size())));
            
            if (properties.length > 2) 
                person.addProperty(properties[2], streets.get(ThreadLocalRandom.current().nextInt(1, streets.size())));
            
            if (properties.length > 3) 
                person.addProperty(properties[3], cities.get(ThreadLocalRandom.current().nextInt(1, cities.size())));
            
            
            testdata.add(person);
        }
        
        
//        if (properties.length == 4) {
//            for (int i = 0; i < amount; i++) {
//                JsonObject person = new JsonObject();
//                person.addProperty("fName", firstnames.get(ThreadLocalRandom.current().nextInt(1, firstnames.size())));
//                person.addProperty("lName", lastnames.get(ThreadLocalRandom.current().nextInt(1, firstnames.size())));
//                person.addProperty("street", streets.get(ThreadLocalRandom.current().nextInt(1, firstnames.size())));
//                person.addProperty("city", cities.get(ThreadLocalRandom.current().nextInt(1, firstnames.size())));
//                testdata.add(person);
//            }
//        }    
//        } else if (fname && lname && street) {
//            for (int i = 1; i < amount; i++) {
//                JsonObject person = new JsonObject();
//                person.addProperty("fName", firstnames.get((int) Math.ceil(Math.random() * (firstnames.size()))));
//                person.addProperty("lName", lastnames.get((int) Math.ceil(Math.random() * (lastnames.size()))));
//                person.addProperty("street", streets.get((int) Math.ceil(Math.random() * (streets.size()))));
//                testdata.add(person);
//            }
//
//        } else if (fname && lname) {
//            for (int i = 1; i < amount; i++) {
//                JsonObject person = new JsonObject();
//                person.addProperty("fName", firstnames.get((int) Math.ceil(Math.random() * (firstnames.size()))));
//                person.addProperty("lName", lastnames.get((int) Math.ceil(Math.random() * (lastnames.size()))));
//                testdata.add(person);
//            }
//        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        res = gson.toJson(testdata); 
        
        return res;

    }

}
