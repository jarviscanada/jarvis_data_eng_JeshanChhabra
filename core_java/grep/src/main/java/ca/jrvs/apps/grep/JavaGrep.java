package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JavaGrep {

    /**
     * Top level search workflow
     *
     * @throws IOException
     */
void process() throws IOException;

/**
 * Traverse a given directory and return all files
 * @param rootDir input Dir
 *
 * @return files under the rootDir
 */

List<File> listFiles(String rootDir) throws IOException;

/**
 * Read a file and return all the lines
 * @param inputfile
 *
 * @return lines
 * @throws IllegalArgumentException if a given input fiw is not a file
 */

List<String> readLines(File inputfile);

/**
 * check if line contains the regex pattern
 *
 * @param line input string
 * @return true if there is a match
 */

boolean containsPattern(String line);

/**
 * Writes line to a file
 *
 * @param lines matched line
 * throws IOException if write failed
 */

void writeToFile(List<String> lines) throws IOException;

String getRootPath();

void setRootPath(String rootPath);

String getRegex();
void setRegex(String regex);

String getOutFile();
void setOutFile(String outFile);


}
