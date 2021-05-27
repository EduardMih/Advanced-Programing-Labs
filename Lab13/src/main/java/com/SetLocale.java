//Hamza Eduard-Mihail, 2A4
package com;

import app.LocaleExplorer;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale implements Command{
    public void run(String param)
    {
        Locale.setDefault(Locale.forLanguageTag(param));
        LocaleExplorer.messages = ResourceBundle.getBundle("Messages", Locale.getDefault());

        System.out.println(new MessageFormat(
                LocaleExplorer.messages.getString("locale.set"))
                .format(new Object[] {Locale.getDefault()}));

    }
}
