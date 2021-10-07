
**NOTE: This project only has the support for chrome browser version 94.** 

The drivers are already included in the base path for 3 different OS:
1. Windows
2. Linux
3. Mac

### Overview:
This project will run the automation tests against this project:
https://github.com/srishti0190/task-management-app-ui

## To Build: 
1. Give executable permission to the driver files present in the root
   ex: `chmod +x chromedriver_mac` 
2. `mvn clean compile assembly:single`
   
## To Run
`java -jar target/ui-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar`


