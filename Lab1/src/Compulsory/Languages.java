//Hamza Eduard-Mihail, 2A4

package Compulsory;


public class Languages {
    private String[] languages = {"C", "C++", "C#", "Python", "GO", "Rust",
            "JavaScript", "PHP", "Swift", "Java"};

    public String getLang() //compute index and return the corresponding string
    {
        int index;

        index = computeIndex();

        return languages[index];

    }

    private int doMath() //generate random n and perform calculations
    {
        int n = (int) (Math.random() * 1000000);

        n = n * 3;

        n = n + 0B10101;
        n = n + 0xFF;
        n = n * 6;

        return n;

    }

    private int computeIndex() //uses doMath method to compute value of n and after that
    {                          //compute the sum of its digits until the result has only one digit
        int n, s=10;

        n = doMath();

        while(s > 9)
        {
            s = 0;

            while(n != 0)
            {
                s = s + n % 10;
                n = n / 10;
            }
            n = s;
        }

        return s;

    }
}
