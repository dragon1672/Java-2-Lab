package utils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anthony on 1/29/2015.
 */
@SuppressWarnings("unchecked")
public class DateParser {
    static private DateParser CodeCoverageHack = new DateParser();

    private DateParser() {
    }

    public static final String datePatternRegex = "(\\w+|\\d{2}|\\d)[\\-\\.\\s/]+(?:(\\d{2}|\\d)?[\\-\\.\\s/,]+)?(\\d{2,4})";
    private static final Pattern datePattern = Pattern.compile(datePatternRegex);
    private static SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
    private static final HashMap<String, Integer> strToMonth;

    static {
        strToMonth = new HashMap<>();
        strToMonth.put("jan", 1);
        strToMonth.put("january", 1);
        strToMonth.put("feb", 2);
        strToMonth.put("february", 2);
        strToMonth.put("mar", 3);
        strToMonth.put("march", 3);
        strToMonth.put("apr", 4);
        strToMonth.put("april", 4);
        strToMonth.put("ma", 5);
        strToMonth.put("may", 5);
        strToMonth.put("jun", 6);
        strToMonth.put("june", 6);
        strToMonth.put("jul", 7);
        strToMonth.put("july", 7);
        strToMonth.put("aug", 8);
        strToMonth.put("august", 8);
        strToMonth.put("sept", 9);
        strToMonth.put("september", 9);
        strToMonth.put("oct", 10);
        strToMonth.put("october", 10);
        strToMonth.put("nov", 11);
        strToMonth.put("november", 11);
        strToMonth.put("dec", 12);
        strToMonth.put("december", 12);
    }

    private static final HashMap<String, Integer> WeekDays;

    static {
        WeekDays = new HashMap<>();
        WeekDays.put("mon", Calendar.MONDAY);
        WeekDays.put("monday", Calendar.MONDAY);
        WeekDays.put("tue", Calendar.TUESDAY);
        WeekDays.put("tuesday", Calendar.TUESDAY);
        WeekDays.put("wed", Calendar.WEDNESDAY);
        WeekDays.put("wednesday", Calendar.WEDNESDAY);
        WeekDays.put("thu", Calendar.THURSDAY);
        WeekDays.put("thursday", Calendar.THURSDAY);
        WeekDays.put("fri", Calendar.FRIDAY);
        WeekDays.put("friday", Calendar.FRIDAY);
        WeekDays.put("sat", Calendar.SATURDAY);
        WeekDays.put("saturday", Calendar.SATURDAY);
        WeekDays.put("sun", Calendar.SUNDAY);
        WeekDays.put("sunday", Calendar.SUNDAY);
    }

    private static final String WeekDayRegex;

    static {
        StringBuilder sb = new StringBuilder();
        String dlim = "";
        List<String> keys = new ArrayList<>(WeekDays.keySet());
        Collections.sort(keys, (o1, o2) -> o2.length() - o1.length());
        for (String s : keys) {
            sb.append(dlim).append(s);
            dlim = "|";
        }
        WeekDayRegex = sb.toString();
    }

    private static final Pattern NextWeekdayPattern = Pattern.compile("next (" + WeekDayRegex + ")\\s?(morning|evening)?");

    private static Date parseSpecials(String toParse) {
        toParse = toParse.toLowerCase();
        if (toParse.equals("tomorrow")) return getNowPlusDuration(0, 0, 0, 0, 1, 0, 0);
        if (toParse.equals("next month")) return getNowPlusDuration(0, 0, 0, 0, 0, 1, 0);
        Matcher specialMatch = NextWeekdayPattern.matcher(toParse);
        if (specialMatch.matches()) {
            String proposedDateSir = specialMatch.group(1);
            String proposedDateTime = specialMatch.group(2);

            if (proposedDateSir == null || !WeekDays.containsKey(proposedDateSir)) return null;

            //((proposedDate-currentDate)+7) mod 7 returns days between
            // + 7 keeps it out of the negatives, and the mod keeps number as tight as possible
            int currentDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
            int proposedDate = WeekDays.get(proposedDateSir);
            int daysToAdd = ((proposedDate - currentDayOfWeek) + 7) % 7;
            if (daysToAdd == 0) daysToAdd = 7;
            Calendar ret = Calendar.getInstance();
            ret.setTimeInMillis(getNowPlusDuration(0, 0, 0, 0, daysToAdd, 0, 0).getTime());
            if (proposedDateTime != null) {
                if (proposedDateTime.equals("morning")) {
                    ret.set(Calendar.HOUR_OF_DAY, 7); // 7am
                    ret.set(Calendar.MINUTE, 0);
                } else if (proposedDateTime.equals("evening")) {
                    ret.set(Calendar.HOUR_OF_DAY, 7 + 12); // 7pm
                    ret.set(Calendar.MINUTE, 0);
                }
            }
            return ret.getTime();
        }
        return null;
    }

    public static Date parse(String toParse) {
        Calendar c = Calendar.getInstance(); // set to now
        if (toParse != null && !toParse.equals("")) {
            Date possibleRet = parseSpecials(toParse);
            if (possibleRet != null)
                return possibleRet;


            Matcher m = datePattern.matcher(toParse);
            if (m.matches()) {
                int month = strToMonth.containsKey(m.group(1).toLowerCase()) ? strToMonth.get(m.group(1).toLowerCase()) : Integer.parseInt(m.group(1));
                int day = m.group(2) != null ? Integer.parseInt(m.group(2)) : 1;
                int year = Integer.parseInt(m.group(3));
                int ourBase = 2000;

                if (year < 100) {
                    if (year + ourBase >= c.get(Calendar.YEAR) + 20) { // before 2,000
                        year += 1900;
                    } else { // after 2,000
                        year += 2000;
                    }
                }
                c.clear();
                //noinspection MagicConstant
                c.set(year, month - 1, day);
            } else {
                return null;
            }
        }

        return c.getTime();
    }

    public static String format(Date toFormat) {
        return formatter.format(toFormat);
    }

    private static Tuple<String, Long>[] timeParser(long milis, Tuple<String, Long>[] diffs) {
        if (diffs == null) return null;
        if (diffs.length == 0) return new Tuple[0];
        Tuple<String, Long>[] ret = new Tuple[diffs.length];
        ret[0] = new Tuple<>(diffs[0].First, milis);
        for (int i = 1; i < ret.length; i++) {
            ret[i] = new Tuple<>(diffs[i].First, ret[i - 1].Second / diffs[i].Second);
            ret[i - 1].Second %= diffs[i].Second;
        }
        return ret;
    }

    private static Tuple<String, Long>[] timeDiffs = new Tuple[]{
            new Tuple<>("Millisecond", 1L),
            new Tuple<>("Second", 1000L),
            new Tuple<>("Min", 60L),
            new Tuple<>("Hour", 60L),
            new Tuple<>("Day", 12L),
            new Tuple<>("Month", 30L),
            new Tuple<>("Year", 12L),
    };

    public static String formatTimeUntil(Date unti) {
        assert (unti.getTime() >= System.currentTimeMillis());
        return formatTimeBetween(unti, new Date());
    }

    public static String formatTimeSince(Date pastDate) {
        assert (pastDate.getTime() <= System.currentTimeMillis());
        return formatTimeBetween(pastDate, new Date());
    }

    public static String formatTimeSinceShort(Date pastDate) {
        long diff = Math.abs(System.currentTimeMillis() - pastDate.getTime());
        Tuple<String,Long> shortestTime = CollectionUtils.firstOrDefault(CollectionUtils.reverse(DateParser.timeBetweenBrokenUp(diff)), item -> item.Second != 0);
        if(shortestTime == null) {
            return "Just Now";
        }
        return String.format("%s %s%s ago",shortestTime.Second,shortestTime.First,(shortestTime.Second > 1 ? "s" : ""));
    }

    public static String formatTimeBetween(Date a, Date b) {
        StringBuilder ret = new StringBuilder();

        long diff = Math.abs(a.getTime() - b.getTime());

        Tuple<String, Long>[] result = timeParser(diff, timeDiffs);

        for (int i = result.length - 1; i > 0; i--) { // "> 0" to skip milliseconds
            if (result[i].Second > 0) {
                ret.append(result[i].Second);
                ret.append(" ");
                ret.append(result[i].First);
                if (result[i].Second > 1) {
                    ret.append('s');
                }
                ret.append(' ');
            }
        }

        return ret.toString();
    }

    /**
     * @param milis total milliseconds to break up into seconds, min, hours,days, months, years
     * @return collection of type and amount
     */
    public static Tuple<String, Long>[] timeBetweenBrokenUp(long milis) {
        return timeBetweenBrokenUp(milis, timeDiffs);
    }

    public static Tuple<String, Long>[] timeBetweenBrokenUp(long milis, Tuple<String, Long>[] diffs) {
        return timeParser(milis, diffs);
    }

    public static long getDurationInMilis(int milliseconds, int seconds, int minutes, int hours, int days, int months, int years) {
        Tuple<Integer, Integer>[] tmp = new Tuple[]{
                new Tuple<>(seconds, 1000),
                new Tuple<>(minutes, 60),
                new Tuple<>(hours, 60),
                new Tuple<>(days, 12),
                new Tuple<>(months, 30),
                new Tuple<>(years, 12),
        };
        long milis = milliseconds;
        long multiplier = 1;
        for (Tuple<Integer, Integer> aTmp : tmp) {
            multiplier *= aTmp.Second;
            milis += aTmp.First * multiplier;
        }
        return milis;
    }

    public static Date getDatePlusDuration(Date toAddTo, int milliseconds, int seconds, int minutes, int hours, int days, int months, int years) {
        long milis = getDurationInMilis(milliseconds, seconds, minutes, hours, days, months, years);
        return new Date(toAddTo.getTime() + milis);
    }

    public static Date getNowPlusDuration(int milliseconds, int seconds, int minutes, int hours, int days, int months, int years) {
        return getDatePlusDuration(new Date(System.currentTimeMillis()), milliseconds, seconds, minutes, hours, days, months, years);
    }

    public static String getNowStr() {
        return format(Calendar.getInstance().getTime());
    }
}