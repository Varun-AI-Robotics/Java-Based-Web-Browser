![image](https://github.com/user-attachments/assets/8c4c231c-153f-4368-841f-c7bb923d9fb4)![image](https://github.com/user-attachments/assets/fcfb5a79-f781-4bf8-b736-1e8f6cfe51d8)# Java-Based-Web-Browser
A simple Java-based web browser using Swing or JavaFX that supports URL input, page loading, back/forward navigation, and HTML rendering with a user-friendly interface.

How to execute code:
1.Check you javaFX SDK lib Path
  for example: "V:\openjfx-21.0.7_windows-x64_bin-sdk\javafx-sdk-21.0.7\lib"
2.Then goto src or Main folder.
  for example: "V:\Final Project\Simple Web Browser\SimpleWebBrowserJavaFX\src"
3.Then complile the code with this command in Command Prompt:
   "javac --module-path "V:\openjfx-21.0.7_windows-x64_bin-sdk\javafx-sdk-21.0.7\lib" --add-modules javafx.controls,javafx.web ^ -cp "lib\mysql-connector-java-8.0.33.jar" ^ -d out ^ src\SimpleWebBrowser.java src\model\HistoryEntry.java src\dao\HistoryDAO.java src\util\DBUtil.java"
4. Then last Run your code with this command in Command Prompt:
    "java --module-path "V:\openjfx-21.0.7_windows-x64_bin-sdk\javafx-sdk-21.0.7\lib" --add-modules javafx.controls,javafx.web -cp "../out;..\lib\mysql-connector-java-8.0.33.jar"     SimpleWebBrowser"

Note: Replace your JavaFX SDK lib Path in these given compile and Run Command in command prompt



![image alt](https://github.com/Varun-AI-Robotics/Java-Based-Web-Browser/blob/main/Screenshot%202025-05-25%20163824.png?raw=true)
