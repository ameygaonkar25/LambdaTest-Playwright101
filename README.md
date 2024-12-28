1. Go to GitHub repository "https://github.com/anu-bartonde/LambdaTestTestNGCert"
2. Go to Chrome WebStore and Install gitpod extension for chrome Browser  
3. After Extension is installed, click on gitpod link available in git hub project to access it on gitpod
![image](https://github.com/user-attachments/assets/b26198d7-f317-4ccf-a81a-d3f2daa47fa4)   
4. Install Jetbrains gateway and access repo
5. gitpod.yml file is congigured to run tests when initialization starts
6. Can also run tests from gitpd command line using command "mvn test -D suite=<testXML file>".
   There are 2 xml files 1 for parallel execution with classes, 1 for parallel execution with tests 
    mvn test -D suite=testNGParallelTests.xml
    mvn test -D suite=testNGParallelClasses.xml
   


