package ca.jrvs.apps.grep;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaGrepLambdaImp extends JavaGrepImp {

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Usage: Three important arguments required to run the app ");
        }
        JavaGrepLambdaImp javaGrepLambdaImp = new JavaGrepLambdaImp();
        javaGrepLambdaImp.setRegex(args[0]);
        javaGrepLambdaImp.setOutFile(args[2]);
        javaGrepLambdaImp.setRootPath(args[1]);

        try {
            javaGrepLambdaImp.process();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Implementing the listFiles using lamdas
     *
     * @params File
     */
    @Override
    public List < File > listFiles(String rootDir) {
        List < File > files = null;
        try {
            Stream < Path > stream = Files.walk(Paths.get(rootDir));
            files = stream.filter(Files::isRegularFile).map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }
    /**
     * Implementing the readlines method using lamdas
     *
     * @params File
     */
    @Override
    public List < String > readLines(File inputfile) {
        List < String > lines = null;
        try {
            lines = Files.lines(Paths.get(inputfile.toString())).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}