package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prac {


    public static void main(String[] args) {
        String directory = "./data/text/shakespeare.txt";
        List<String> str = null;

        try {
            str =  Files.lines(Paths.get(directory.toString())).collect(Collectors.toList());

        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(str);
//try {
//
//
//    Stream<Path> stream = Files.walk(Paths.get(directory));
//    pathList = stream.filter(Files::isRegularFile).map(Path::toFile)
//            .collect(Collectors.toList());
//
//}catch(Exception e){}
//
//
//        System.out.println( pathList);
//
//
//
//    }
    }
}