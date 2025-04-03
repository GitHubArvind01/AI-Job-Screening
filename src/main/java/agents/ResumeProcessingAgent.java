/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agents;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author kumar
 */

        //this is pdf work and this is step 1

        //it called first to extract resume data

        //here code wiill start
public class ResumeProcessingAgent {
    public Map<String, String[]> extractResumeData(String folderPath){
        HashMap<String,String[]> resumes  = new HashMap<>();
        //operation start here
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                try (PDDocument doc = PDDocument.load(file)) {
                    String text = new PDFTextStripper().getText(doc);
                    String[] words = text.split("\\s+"); // Splitting words for analysis
                    resumes.put(file.getName(), words);
                } catch (IOException e) {
                    System.out.println("Error reading: " + file.getName());
                }
            }
        }
        return resumes;
    }
}
