package agents;

import java.sql.*;
import java.util.*;

public class StorageAgent { //root@localhost 
    private static final String URL = "jdbc:mysql://localhost:3306/recruitmentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "alluMysql@071"; // Ensure this is set correctly

    public void saveCandidates(Map<String, LinkedHashMap<String, Object>> candidates) {
        String sql = "INSERT INTO storeuser (username, email, jobTitle, score) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            connection.setAutoCommit(true);

            for (Map.Entry<String, LinkedHashMap<String, Object>> emt : candidates.entrySet()) {
                LinkedHashMap<String, Object> eachResumeData = emt.getValue();

                // Declare variables to store all fields
                String name = "", email = "", jobTitle = "";
                double score = 0.0;

                for (Map.Entry<String, Object> ERD : eachResumeData.entrySet()) {
                    if (ERD.getKey().equals("name")) {
                        name = (String) ERD.getValue();
                    } else if (ERD.getKey().equals("email")) {
                        email = (String) ERD.getValue();
                    } else if (ERD.getKey().equals("jobTitle")) {
                        jobTitle = (String) ERD.getValue();
                    } else {
                        score = (double) ERD.getValue();
                    }
                }

                // Ensure all 4 values are assigned
                pstmt.setString(1, name);
                // String Email = convetEmail(email);
                StringBuilder Email = new StringBuilder();
                Email.append(email.substring(0, email.length()-8));
                Email.append("@gmail.com");
                pstmt.setString(2, Email.toString());
                pstmt.setString(3, jobTitle);
                pstmt.setDouble(4, score);

                pstmt.executeUpdate();
            }

            System.out.println(candidates.size() + " users shortlisted for interview!");

        } catch (SQLException e) {
            System.out.println("Shortlisted candidates already added in DataBase");
        }
    }
}
