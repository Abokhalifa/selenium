ℹ️ Overview:

This is a web test automation project done in Selenium, Java, Maven, and TestNG.


🌟Features:
1. The project is designed in the Page Object Model (POM) to facilitate test maintenance.
2. The framework is data driven i.e. it takes data from different data sources such as Excel, Json, and plain text.
3. The tests can be executed from the command line, so it is easy to integrate with CI/CD pipelines. 



🌟Prerequisites:
1. Install java 26.
2. Install maven.


🌟Run tests:
1. Clone the project using this command --> git clone https://github.com/Abokhalifa/selenium.git
2. Navigate to the root directory of the project.
3. Run the tests using this command --> mvn test

🌟Troubleshooting:
1. How to know the java version on the host machine? Run this command --> java --version
2. If the host machine already have Java i.e. say java 25 that does not match the java required for this project, then
go to the pom.xml file and replace the java source and destination to match the java the host machine has.
This is the entry one should change for the version compatibility:
   <maven.compiler.source>26</maven.compiler.source>
   <maven.compiler.target>26</maven.compiler.target>