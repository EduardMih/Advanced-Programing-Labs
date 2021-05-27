//Hamza Eduard-Mihail, 2A4
package app;

import com.Command;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplorer {
    public static ResourceBundle messages = ResourceBundle.getBundle("Messages");

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String command, param;
        Class clazz;
        Command myCommand;

        while(true)
        {
            System.out.println(messages.getString("prompt"));
            command = scanner.next();

            if("exit".equals(command))
                break;

            param = scanner.nextLine();

            if(param.length() > 1)
                param = param.substring(1);

            else

                param = null;

            try
            {
                clazz = Class.forName("com." + command);

                myCommand = (Command) (clazz.newInstance());
                myCommand.run(param);
            }
            catch(ClassNotFoundException | InstantiationException | IllegalAccessException e)
            {
                System.out.println(LocaleExplorer.messages.getString("invalid"));
            }
        }
    }
}
