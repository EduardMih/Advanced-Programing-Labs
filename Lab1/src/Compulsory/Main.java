//Hamza Eduard-Mihail, 2A4

package Compulsory;

public class Main {
    public static void main(String[] args)
    {
        int n;
        Languages lang= new Languages();
        greet();
        System.out.println("Willy-nilly, this semester I will learn " + lang.getLang());
    }

    public static void greet()
    {
        System.out.println("Hello World!");
    }

}
