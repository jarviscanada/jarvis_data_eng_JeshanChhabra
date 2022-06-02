package ca.jrvs.apps.grep;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
//import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaGrepImp implements JavaGrep{
     final Logger logger = LoggerFactory.getLogger(JavaGrep.class);
private String regex;
private String rootPath;
private String outFile;


    public static void main(String[] args) {
//   if (args.length != 3){
//    throw new IllegalArgumentException("USAGE: regex rootpath outFile");
//   }

  // BasicConfigurator.configure();
        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);
//        javaGrepImp.setRegex(".*Romeo.*Juliet.*");
//        javaGrepImp.setRootPath("./data");
//        javaGrepImp.setOutFile("./out/text.txt");

    try{
        javaGrepImp.process();
    }catch(Exception e){
        javaGrepImp.logger.error(e.getMessage(),e);
    }


    }

    @Override
    public void process() throws IOException {
        List<String> matchedLines = new ArrayList<>();
        for (File file : listFiles(getRootPath())) {

            for (String line : readlines(file)) {
                if (containsPattern(line))
                    matchedLines.add(line);
            }
        }

        writeToFile(matchedLines);
    }

    @Override
    public List<File> listFiles(String rootDir) {
     List<File> files = new ArrayList<>();
     File dir = new File(rootDir);
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                files.addAll(listFiles(file.getPath()));
            } else {
                files.add(file);
            }
        }
        return files;
    }

    @Override
    public List<String> readlines(File inputfile) {
        // throw error if not file
        if (!inputfile.isFile()){
            throw new IllegalArgumentException("Not a file");
        }

        List<String> lines = new ArrayList<>();
        try {
            FileReader fr = new FileReader(inputfile);
            BufferedReader br = new BufferedReader(fr);
            String l; // line to be read by buffer
            while((l = br.readLine() )!= null){
                lines.add(l);
            }
        }catch(IOException e){
            /**
             *
             * logging when get error
             */
            this.logger.error(e.getMessage(),e);
        }
        return lines;
    }

    @Override
    public boolean containsPattern(String line) {
        return line.matches(getRegex());
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        FileOutputStream fs = new FileOutputStream(getOutFile());
        OutputStreamWriter ow = new OutputStreamWriter(fs);
        BufferedWriter bw = new BufferedWriter(ow);
        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    @Override
    public String getRootPath() {
        return this.rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
this.rootPath = rootPath;
    }

    @Override
    public String getRegex() {
        return this.regex;
    }

    @Override
    public void setRegex(String regex) {
this.regex = regex;
    }

    @Override
    public String getOutFile() {
        return  this.outFile;
    }

    @Override
    public void setOutFile(String outFile) {
     this.outFile = outFile;
    }
}
