//Hamza Eduard-Mihail, 2A4
package com;

import app.LocaleExplorer;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info implements Command{
    public void run(String param)
    {
        Locale locale = Locale.getDefault();
        Currency currency = Currency.getInstance(locale);
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);

        System.out.println(new MessageFormat(
                LocaleExplorer.messages.getString("info"))
                .format(new Object[] {Locale.getDefault()}));

        System.out.println(LocaleExplorer.messages.getString("country") + " " + locale.getDisplayCountry());
        System.out.println(LocaleExplorer.messages.getString("language") + " " + locale.getDisplayLanguage());
        System.out.println(LocaleExplorer.messages.getString("currency") + " " + currency.getCurrencyCode() + " (" + currency.getDisplayName() + ") " + currency.getSymbol());
        System.out.println(LocaleExplorer.messages.getString("week.days") + " " +  Arrays.toString(dateFormatSymbols.getWeekdays()));
        System.out.println(LocaleExplorer.messages.getString("months") + " " + Arrays.toString(dateFormatSymbols.getMonths()));
        System.out.println(LocaleExplorer.messages.getString("today") + " " + DateFormat.getDateInstance(DateFormat.FULL,locale).format(new Date()));
    }
}
