package ca.jrvs.apps.grep;



public class RegexExcImp implements RegexExc {

    @Override
    public boolean matchJpeg(String filename) {
        String regex = "([^\\s]+(\\.(?i)jpeg)$)";
        System.out.println("hanj hanji"+filename + "g   " + filename.toLowerCase());
        return filename.matches(regex);
    }

    @Override
    public boolean matchIp(String ip) {
        String regex = "^(?:[0-9]{1,3}\\.){3}([0-9]{1,3})$";
        return ip.matches(regex);
    }

    @Override
    public boolean isEmptyLine(String line) {
        String regex = "^\\s*$";
        return line.matches(regex);
    }
}
