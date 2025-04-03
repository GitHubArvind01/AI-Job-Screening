package agents;
import java.util.*;

public class MatchingAgent {

    private static final Set<String> IMPORTANT_KEYWORDS = new HashSet<>(
            Arrays.asList("java", "c++", "python", "sql", "cloud", "developer", "engineer", "javascript", "react", "aws"));
    private static final Map<String, String> SYNONYMS = new HashMap<>();

    static {
        SYNONYMS.put("developer", "programmer");
        SYNONYMS.put("engineer", "developer");
        SYNONYMS.put("javascript", "js");
        SYNONYMS.put("sql", "database");
    }

    public Map<String, LinkedHashMap<String, Object>> matchCandidates(Map<String, String[]> resumes, Map<String, String> jobs) {
        Map<String, LinkedHashMap<String, Object>> topCandidates = new HashMap<>();
        for (Map.Entry<String, String[]> resumeEntry : resumes.entrySet()) {
            String[] resumeWords = processText(resumeEntry.getValue());
            String candidateName = "", candidateEmail = "";
            double maxScore = 0;
            String bestJobTitle = "";
            
            for (int i = 0; i < resumeWords.length - 1; i++) {
                if (resumeWords[i].equals("name") && i + 2 < resumeWords.length) {
                    candidateName = resumeWords[i + 1] + " " + resumeWords[i + 2];
                } else if (resumeWords[i].equals("email") && i + 1 < resumeWords.length) {
                    candidateEmail = resumeWords[i + 1];
                }
            }
            
            for (Map.Entry<String, String> jobEntry : jobs.entrySet()) {
                String jobTitle = jobEntry.getKey();
                String[] jobWords = processText(jobEntry.getValue().split("\\s+"));
                
                double score = calculateTFIDFCosineSimilarity(resumeWords, jobWords);
                score += boostKeywordMatch(resumeWords, jobWords);
                
                if (Arrays.asList(resumeWords).contains(jobTitle.toLowerCase())) {
                    score += 5;
                }
                
                if (score > 100) {
                    score = 100; // Cap score at 100
                }
                
                if (score > maxScore) {
                    maxScore = score;
                    bestJobTitle = jobTitle;
                }
            }
            
            if (maxScore>=80.0) {
                LinkedHashMap<String, Object> candidateData = new LinkedHashMap<>();
                candidateData.put("name", candidateName);
                candidateData.put("email", candidateEmail);
                candidateData.put("jobTitle", bestJobTitle);
                candidateData.put("score", maxScore);
                
                topCandidates.put(candidateEmail, candidateData);
            }
        }
        return topCandidates;
    }

    private double calculateTFIDFCosineSimilarity(String[] words1, String[] words2) {
        Map<String, Integer> freq1 = getWordFrequency(words1);
        Map<String, Integer> freq2 = getWordFrequency(words2);
        
        double dotProduct = 0.0, magnitude1 = 0.0, magnitude2 = 0.0;
        for (String word : freq1.keySet()) {
            double tfidf1 = computeTFIDF(freq1.get(word), freq1.size());
            double tfidf2 = freq2.containsKey(word) ? computeTFIDF(freq2.get(word), freq2.size()) : 0.0;
            
            dotProduct += tfidf1 * tfidf2;
            magnitude1 += tfidf1 * tfidf1;
        }
        
        for (double value : freq2.values()) {
            double tfidf2 = computeTFIDF(value, freq2.size());
            magnitude2 += tfidf2 * tfidf2;
        }
        
        magnitude1 = Math.sqrt(magnitude1);
        magnitude2 = Math.sqrt(magnitude2);
        
        return (magnitude1 == 0 || magnitude2 == 0) ? 0.0 : (dotProduct / (magnitude1 * magnitude2)) * 100;
    }

    private double boostKeywordMatch(String[] resumeWords, String[] jobWords) {
        double boost = 0.0;
        for (String word : resumeWords) {
            if (IMPORTANT_KEYWORDS.contains(word)) {
                boost += 10;
            }
            if (SYNONYMS.containsKey(word) && Arrays.asList(jobWords).contains(SYNONYMS.get(word))) {
                boost += 5;
            }
        }
        return boost;
    }

    private Map<String, Integer> getWordFrequency(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    private double computeTFIDF(double value, int totalWords) {
        return (value / (double) totalWords) * 2.0;
    }

    private String[] processText(String[] words) {
        List<String> processedWords = new ArrayList<>();
        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                processedWords.add(word);
            }
        }
        return processedWords.toArray(new String[0]);
    }
}