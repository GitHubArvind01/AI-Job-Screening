/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//package agents;
//import java.io.*;
//import java.util.*;
//import com.opencsv.*;
///**
// *
// * @author kumar
// */
//public class JobDataExtractionAgent {
//    
//    
//    public Map<String,String> extractJobData(String csvFilePath){
//
//        Map<String,String> jobdata = new HashMap<>();
//        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
//            String[] line;
//            reader.readNext(); // Skip Header
//
//            while ((line = reader.readNext()) != null) {
//                jobData.put(line[0], line[1]); // Job Title → Job Description
//            }
//        } catch (IOException e) {
//            System.out.println("Error reading job data: " + e.getMessage());
//        }
//        return jobdata;
//    }
//}

package agents;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
public class JobDataExtractionAgent {
       //this is csv work and this is step 2  
     //it called automatically when step 1 done
    public Map<String, String> extractJobData(String csvFilePath) throws CsvValidationException, CsvException {
        Map<String, String> jobData = new LinkedHashMap<>(); // Maintain order

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> allLines = reader.readAll(); // Read all lines at once

            for (int i = 1; i < allLines.size(); i++) { // Skip header
                String[] line = allLines.get(i);
                if (line.length < 2) continue; // Skip empty lines

                String jobTitle = line[0].trim();
                String jobDescription = line[1].trim().replace("\n", " ").replace("\r", " "); // Handle newlines

                jobData.put(jobTitle, jobDescription); // Store in HashMap
            }
        } catch (IOException e) {
            System.out.println("Error reading job data: " + e.getMessage());
        }

        return jobData;
    }
}

