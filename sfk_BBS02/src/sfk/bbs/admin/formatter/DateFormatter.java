package sfk.bbs.admin.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date>
{
    private String datePattern;
    private SimpleDateFormat dateFormat;

    public DateFormatter(String dateFattern)
    {
        this.datePattern = dateFattern;
        dateFormat = new SimpleDateFormat(dateFattern);
        dateFormat.setLenient(false);
    }

    @Override
    public String print(Date date, Locale locale)
    {
        return dateFormat.format(date);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException
    {
        try
        {
            return dateFormat.parse(text);
        } catch (ParseException e)
        {
            throw new IllegalArgumentException("123 invalid date format . please use this pattern\""+datePattern+"\"");
        }
    }

}
