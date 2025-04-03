
# AI-Job-Screening
Automating the resume screening process by extracting job requirements from a CSV file, analyzing resumes from PDFs, and matching candidates based on their skills, education, and experience to shortlist potential candidates and schedule interviews automatically.
![image](https://github.com/user-attachments/assets/279e0ad5-8231-45fe-8552-eb0eb7a6d9bc)


# 🏆 AI-Powered Resume Screening System  
### Problem Statement 5: Enhancing Job Screening with AI and Data Intelligence  

🔍 **Problem Statement:**  
The traditional recruitment process is time-consuming and prone to human errors due to the manual review of numerous job descriptions (JDs) and resumes. This project aims to **automate the resume screening process** by leveraging AI and data intelligence to match candidates efficiently.  

## ✨ Key Features  
✅ **Automated Resume Screening** – Extracts job requirements and matches resumes  
✅ **AI-Powered Matching** – Uses **NLP & Machine Learning** for accuracy  
✅ **Fast & Scalable** – Processes thousands of resumes in seconds  
✅ **Shortlisting & Notifications** – Filters best candidates and sends emails  
✅ **SQL Database Integration** – Stores results for easy tracking  

---

## ⚙️ Tech Stack  
| Component            | Technology Used |
|----------------------|----------------|
| **PDF Extraction**  | Apache PDFBox  |
| **CSV Processing**  | OpenCSV        |
| **AI Matching**     | Apache OpenNLP + Custom Algorithm |
| **Database**        | MySQL          |
| **Email Automation**| JavaMail API   |
| **CLI Interaction** | Terminal-based Input/Output |

---

## 📂 Folder Structure  
📦 AI-Resume-Screening
│── 📁 data/ # Contains job descriptions (CSV) and resumes (PDFs)
│── 📁 src/ # Main project source code
│── 📄 job_descriptions.csv # Sample job description file
│── 📄 README.md # Project documentation
│── 📜 LICENSE # License information
│── 📜 config.properties # Configuration file (DB & Email settings)



---

## 🚀 How It Works  
1️⃣ **Read Job Descriptions** from a CSV file  
2️⃣ **Process & Extract Resume Data** from PDFs  
3️⃣ **Match Candidate Details** with Job Requirements using NLP  
4️⃣ **Shortlist Candidates** based on an 80% match threshold  
5️⃣ **Store Results** in a MySQL database  
6️⃣ **Send Email Notifications** to selected candidates  

---

## 🛠️ Installation & Setup  

### **1️⃣ Prerequisites**  
Ensure you have the following installed:  
- ✅ Java 11+  
- ✅ MySQL Database  
- ✅ Apache PDFBox & OpenCSV Libraries  
- ✅ JavaMail API for email automation  

### **2️⃣ Clone Repository**  
```sh
git clone https://github.com/your-username/AI-Job-Screening.git
```

cd AI-Resume-Screening

📊 AI Matching Algorithm
✅ Tokenization & Text Analysis – Extracts key details (skills, experience)
✅ Semantic Matching – Compares resume content with job descriptions
✅ Weighted Scoring – Assigns scores based on relevance
✅ Threshold-Based Shortlisting – Selects candidates with 80%+ match

📧 Email Automation
📩 JavaMail API is used to notify shortlisted candidates automatically with interview details.

🎥 Demo Video
🚀 Check out a live demo of the system in action:
link:

🙌 Contributors
👤 Arvind Kumarr – Lead Developer
👤 Avinash Kumar – NLP & CSV
🔗 Connect with us on LinkedIn or contribute to the project on GitHub!
📌 Connect with us on LinkedIn:  
- [Arvind Kumar](https://www.linkedin.com/in/arvind-kumar-589103274/)  
- [Avinash Kumar](https://www.linkedin.com/in/avinash-kumar-41aa90269/)  



🏆 Conclusion
This AI-powered recruitment system reduces hiring time, improves accuracy, and automates the screening process efficiently. With this tool, companies can focus on interviewing the best candidates rather than screening endless resumes. 🚀
