# 🌐 Java-Based Web Browser

A simple yet functional **Java-based web browser** built using **JavaFX or Swing**. It supports:

- ✅ URL input  
- 🔄 Page loading  
- 🔙 Back/Forward navigation  
- 🧾 HTML rendering  
- 👤 User-friendly interface  

---

## 🚀 How to Run the Project

### 🛠️ Prerequisites
Ensure you have:
- Java JDK installed
- JavaFX SDK downloaded and extracted
- MySQL JDBC Connector (if using database features)

---

### 📁 Step 1: Set JavaFX SDK Path

Locate your JavaFX SDK `lib` directory.


  For example: "V:\openjfx-21.0.7_windows-x64_bin-sdk\javafx-sdk-21.0.7\lib"



---

### 📂 Step 2: Navigate to the Source Folder

Go to the folder containing the Java source files. For example:


  "V:\Final Project\Simple Web Browser\SimpleWebBrowserJavaFX\src"



---


---

### ⚙️ Step 3: Compile the Code

Run the following command in Command Prompt:

```bash
javac --module-path "V:\openjfx-21.0.7_windows-x64_bin-sdk\javafx-sdk-21.0.7\lib" --add-modules javafx.controls,javafx.web -cp "..\lib\mysql-connector-java-8.0.33.jar" -d ../out SimpleWebBrowser.java model\HistoryEntry.java dao\HistoryDAO.java util\DBUtil.java


```

▶️ Step 4: Run the Application
```bash
java --module-path "V:\openjfx-21.0.7_windows-x64_bin-sdk\javafx-sdk-21.0.7\lib" --add-modules javafx.controls,javafx.web -cp "../out;..\lib\mysql-connector-java-8.0.33.jar" SimpleWebBrowser
```
### ⚠️ NOTE:
Replace the JavaFX SDK lib path with your local path in the compile and run commands above.

## 📸 Screenshot:
![image alt](https://github.com/Varun-AI-Robotics/Java-Based-Web-Browser/blob/main/Screenshot%202025-05-25%20163824.png?raw=true)
