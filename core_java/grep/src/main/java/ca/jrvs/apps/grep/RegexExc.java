package ca.jrvs.apps.grep;

public interface RegexExc {
    /*
    * return true if filename extention is jpg
    * @param filename
    * @retrun
    * */
    public boolean matchJpeg(String filename);

    /*
     * return true if ip is valid
     * range of ip address is from 0.0.0.0 to 999.999.999.999
     * @param ip
     * @retrun
     * */
    public boolean matchIp(String ip);

    /*
     * return true if line is empty(tabs,space, etc)
     * @param line
     * @retrun
     * */
    public boolean isEmptyLine(String line);


}
