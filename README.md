LOC Counting
Juan Sebastian Velandia
12/06/2025

This is a little java program that counts the Lines of Code of a source file, with two options, the physical lines, i mean, all the lines of the document, including comments and void lines, by otherside, the LOC counts just the logical and meaningful lines.
The LOC/h to this little proyect, counting test and more, roound about 15 LOC/h

#  LineCounter

A Java command-line program to count the number of lines of code (LOC) in source files, including support for counting physical lines or logical LOC (excluding comments and blank lines), with recursive directory traversal and wildcard support.

---

##  Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

---

##  Prerequisites

You will need the following installed on your system:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Apache Maven](https://maven.apache.org/install.html)
- [Git](https://git-scm.com/)

### Example for Debian/Ubuntu:
sudo apt update
sudo apt install openjdk-17-jdk maven git
---

For run the program you yust need to execute the comand mvn clean compile, and then, according to your needs:
## For Count physical lines:
java -cp target/classes edu.escuelaing.arsw.ASE.app.LineCounter phy src/main/java/edu/escuelaing/arsw/ASE/app/LineCounter.java

## For count logical lines:
java -cp target/classes edu.escuelaing.arsw.ASE.app.LineCounter loc src/main/java/edu/escuelaing/arsw/ASE/app/LineCounter.java

#  Running the test
For the tests, we have to tests files, Test1.java and Test2.java; Thanks to the tool junit, we runs 4 tests that shows the correct operation of the program.
Let's see throug the mvn test command:
![alt image](resources.png)
And it´s working perfectly



