package org.selcuk.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {
    public static String generateCurrentDateAndTime() {
        return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
    }
}
