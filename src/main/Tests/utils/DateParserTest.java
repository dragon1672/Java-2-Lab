package utils;

import org.junit.Assert;
import org.junit.Test;
import utils.FunctionInterfaces.Functions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anthony on 5/20/2015.
 */
public class DateParserTest {
    @Test
    public void testParse() throws Exception {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");


        Assert.assertEquals(DateParser.parse("Potato"), null);
        c.clear(); c.set(1994,4,14);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("05.14.1994")));
        c.clear(); c.set(1994,4,14);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("05.14.94")));
        c.clear(); c.set(2015,4,14);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("05.14.15")));
        c.clear(); c.set(2015,0,23);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("1/23/2015")));
        c.clear(); c.set(2015,0,23);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("01-23-2015")));
        c.clear(); c.set(2015,0,23);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("Jan 23 2015")));
        c.clear(); c.set(2015,0,23);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("Jan 23, 2015")));
        c.clear(); c.set(2015,0,23);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("January 23, 2015")));
        c.clear(); c.set(2015,0,23);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("January 23 2015")));
        c.clear(); c.set(2015,0, 1);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("1-2015")));
        c.clear(); c.set(2015,0, 1);	Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("1-2015")));

        //tomorrow
        c.setTimeInMillis(DateParser.getNowPlusDuration(0,0,0,0,1,0,0).getTime());
        Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("tomorrow")));
        //next month
        c.setTimeInMillis(DateParser.getNowPlusDuration(0,0,0,0,0,1,0).getTime());
        Assert.assertEquals(formatter.format(c.getTime()),formatter.format(DateParser.parse("next month")));

        final Map<Integer,String> DateToString = new HashMap<>();
        DateToString.put(Calendar.MONDAY,   "Monday");
        DateToString.put(Calendar.TUESDAY,  "Tuesday");
        DateToString.put(Calendar.WEDNESDAY,"Wednesday");
        DateToString.put(Calendar.THURSDAY, "Thursday");
        DateToString.put(Calendar.FRIDAY,   "Friday");
        DateToString.put(Calendar.SATURDAY, "Saturday");
        DateToString.put(Calendar.SUNDAY,   "Sunday");
        final int CurrentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        Functions.Function1<String,Integer> weekDay = a -> {
            return DateToString.get(((CurrentDay - 1) + a) % 7 + 1); // +1 because Calendar is 1 based :( jerks;
        };

        for(int daysToAdd = 1; daysToAdd < 8; daysToAdd++) {
            c.setTimeInMillis(DateParser.getNowPlusDuration(0, 0, 0, 0, daysToAdd, 0, 0).getTime());
            Assert.assertEquals(formatter.format(c.getTime()), formatter.format(DateParser.parse("next " + weekDay.Invoke(daysToAdd))));
        }
        int daysToAdd = 1;
        c.setTimeInMillis(DateParser.parse("next " + weekDay.Invoke(daysToAdd) + " morning").getTime());
        Assert.assertTrue(c.get(Calendar.HOUR_OF_DAY) < 12);

        c.setTimeInMillis(DateParser.parse("next " + weekDay.Invoke(daysToAdd) + " evening").getTime());
        c.setTimeInMillis(DateParser.parse("next " + weekDay.Invoke(daysToAdd) + " evening").getTime());
        Assert.assertTrue(c.get(Calendar.HOUR_OF_DAY) > 12);
    }

    @Test
    public void testFormat() throws Exception {
        Assert.assertFalse(DateParser.format(Calendar.getInstance().getTime()).equals(""));
    }

    @Test
    public void testFormatTimeUntil() throws Exception {
        Assert.assertEquals("",                                          DateParser.formatTimeUntil(DateParser.getNowPlusDuration(100,  0,  0,  0,  0,  0,   0)).trim());
        Assert.assertEquals("1 Second",                                  DateParser.formatTimeUntil(DateParser.getNowPlusDuration(100,  1,  0,  0,  0,  0,   0)).trim());
        Assert.assertEquals("1 Min 1 Second",                            DateParser.formatTimeUntil(DateParser.getNowPlusDuration(100,  1,  1,  0,  0,  0,   0)).trim());
        Assert.assertEquals("1 Hour 2 Mins 1 Second",                    DateParser.formatTimeUntil(DateParser.getNowPlusDuration(100,  1,  2,  1,  0,  0,   0)).trim());
        Assert.assertEquals("1 Hour 1 Second",                           DateParser.formatTimeUntil(DateParser.getNowPlusDuration(100,  1,  0,  1,  0,  0,   0)).trim());
        Assert.assertEquals("1 Hour 1 Second",                           DateParser.formatTimeUntil(DateParser.getNowPlusDuration(100,  1,  0,  1,  0,  0,   0)).trim());
        Assert.assertEquals("1 Month 10 Days 1 Hour 1 Second",           DateParser.formatTimeUntil(DateParser.getNowPlusDuration(100,  1,  0,  1, 10,  1,   0)).trim());
        Assert.assertEquals("100 Years 1 Month 10 Days 1 Hour 1 Second", DateParser.formatTimeUntil(DateParser.getNowPlusDuration(100,  1,  0,  1, 10,  1, 100)).trim());
    }
}