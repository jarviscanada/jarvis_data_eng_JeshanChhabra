package ca.jrvs.apps.grep;

class HelloWorld {

    // Your program begins with a call to main().
    // Prints "Hello, World" to the terminal window.
    public static void main(String args[]) {
        RegexExcImp test = new RegexExcImp();
        System.out.println(test.matchJpeg(".jpeg"));
        System.out.println("Hello, World");
    }
}