package sfk.bbs.admin.formatter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class sfkbbsFormatterRegistrar implements FormatterRegistrar
{
    private String datePattern;

    public sfkbbsFormatterRegistrar(String datePattern)
    {
        this.datePattern = datePattern;
    }
    @Override
    public void registerFormatters(FormatterRegistry registry)
    {
        registry.addFormatter(new DateFormatter(datePattern));
        //register more formatters here
        //在这里可以注册多个formatters
        
    }

}
