/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kumar
 */



import agents.*;
import com.opencsv.exceptions.CsvException;
import java.util.*;
import com.opencsv.exceptions.CsvValidationException;

public class Main {
    public static void main(String[] args) throws CsvValidationException, CsvException{   
        
        //task1 : extract resume text
        
        ResumeProcessingAgent resumeAgent = new ResumeProcessingAgent();
        Map<String, String[]> resumesData = resumeAgent.extractResumeData("C:\\Users\\kumar\\Downloads\\Accenture Hackthon\\Code\\recruitment-system\\src\\main\\java\\resumes");

        //task2: extract csv data
        
        JobDataExtractionAgent jobAgent = new JobDataExtractionAgent();
        Map<String, String> jobs = jobAgent.extractJobData("C:\\Users\\kumar\\Downloads\\Accenture Hackthon\\Code\\recruitment-system\\src\\main\\java\\data\\job_description.csv");
        // System.out.println(jobs);
        
        
        //task3: matching resume data and job requirement
        MatchingAgent matchingAgent = new MatchingAgent();
        Map<String, LinkedHashMap<String, Object>> matchedCandidates = matchingAgent.matchCandidates(resumesData, jobs);

        // task4: shortlisted resume store in data
        StorageAgent storageAgent = new StorageAgent();
        storageAgent.saveCandidates(matchedCandidates);

    }
}
