

package Compulsory;

public class main {

    public static void main(String[] args)
    {
        int n;
        languages lang = new languages();
        greet();
        System.out.println("Willy-nilly, this semester I will learn " + lang.getLang());
    }

    public static void greet()
    {
        System.out.println("Hello World!");
    }


}
