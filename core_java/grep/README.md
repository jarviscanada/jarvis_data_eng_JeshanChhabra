# Introduction
This project is designed to implement the grep command using JAVA classes and functions.
This app searches the given string or regex expression in the file system and the matching output is stored 
on the provided output file path. Technologies used in the application are: core-java, Lamdas , Stream API's, Docker, Intellij(IDE), LINUX.

# Quick Start

First we need to install via maven with help of mvn install command. This will install the dependencies required to run the project.
Then the app can be run by running the main class(JavaGrepLamdasImp) in the IDE or using the cmd line and compile
using the jar file in the target folder (target/grep-1.0-SNAPSHOT.jar) and providing the cli arguments (the search string, the file to be searched path, the output file path)

# Implementation
## Pseudocode
 matchedLines = []
for file in listFilesRecursively(rootDir)
  for line in readLines(file)
      if containsPattern(line)
        matchedLines.add(line)
writeToFile(matchedLines)

First, it will loop through each file in the listFiles method and then for every file, each line would be looped through and will match 
with the regex provided. If it matches with the regex, then the line is written to the output file.

## Performance Issue
Memory issue.

# Test

# Deployment
The app is build into docker image and has been pushed into the docker hub. (jeshan26/grep). 
We can pull the image and use it to run the program. 
