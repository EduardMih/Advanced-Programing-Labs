//Hamza Eduard-Mihail, 2A4
package com;

import app.LocaleExplorer;

import java.util.Locale;

public class DisplayLocale implements Command{
    public void run(String param)
    {
        Locale available [] = Locale.getAvailableLocales();

        System.out.println(LocaleExplorer.messages.getString("locales"));
        for(Locale locale : available)
        {
            System.out.println(locale.getDisplayCountry() + " -> " + locale.getDisplayLanguage() + ": " + locale.toLanguageTag());
        }
    }

}
