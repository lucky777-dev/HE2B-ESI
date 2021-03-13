/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td02;

/**
 * Moment object that represents a time in the day using integers, viewed as
 * hours:minutes:seconds
 *
 * @author g56935
 */
public class Moment {

    private int hour;
    private int minute;
    private int second;

    /**
     * Creates a Moment object with 0 hour, 0 minute and 0 second
     */
    public Moment() {
        this(0, 0, 0);
    }

    /**
     * Creates a Moment object with a number of hours, minutes and seconds
     *
     * @param hour An integer for the number of hours
     * @param minute An integer for the number of minutes
     * @param second An integer for the number of seconds
     * @throws IllegalArgumentException if hour isn't between 0 and 23, or
     * minute isn't between 0 and 59, or second isn't between 0 and 59
     */
    public Moment(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("<error> 'Hour' value invalid ! (must be 0 to 23) : " + hour);
        } else if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("<error> 'Minute' value invalid ! (must be 0 to 59) : " + minute);
        } else if (second < 0 || second > 59) {
            throw new IllegalArgumentException("<error> 'Second' value invalid ! (must be 0 to 59) : " + second);
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * Compares two 'Moment' objects to find out which one is before the other
     *
     * @param other the other instance of 'Moment' to which we want to compare
     * @return the number of seconds of this object, minus the number of seconds
     * of the other object. So 0 is they are the same, negative if this object
     * is before the other, and positive if this object is after the other
     */
    public int compareTo(Moment other) {
        return (this.toSeconds() - other.toSeconds());
    }

    /**
     * Convert the 'hh:mm:ss' time to 'seconds'. So hh*3600 + mm*60 + ss
     *
     * @return an integer with the total number of seconds
     */
    public int toSeconds() {
        return (this.hour * 3600) + (this.minute * 60) + this.second;
    }

    /**
     * Compare two 'Moment' objects to see if they are the same or not
     *
     * @param other the other instance of 'Moment' to which we want to compare
     * @return true if they are the same, false if not
     */
    public boolean equals(Moment other) {
        return (this.hour == other.hour && this.minute == other.minute && this.second == other.second);
    }

    /**
     * Diplays the current object's hours, minutes and seconds using this
     * format: "hh:mm:ss"
     *
     * @return a String with the time of the current object (hh:mm:ss)
     */
    public String toString() {
        String result = "";
        if (this.hour < 10) {
            result += "0" + this.hour + ":";
        } else {
            result += this.hour + ":";
        }

        if (this.minute < 10) {
            result += "0" + this.minute + ":";
        } else {
            result += this.minute + ":";
        }

        if (this.second < 10) {
            result += "0" + this.second;
        } else {
            result += "" + this.second;
        }

        return result;
    }

    /**
     * Hour getter for Moment
     *
     * @return an integer that represents the hours of the current object
     */
    public int getHour() {
        return this.hour;
    }

    /**
     * Minute getter for Moment
     *
     * @return an integer that represents the minutes of the current object
     */
    public int getMinute() {
        return this.minute;
    }

    /**
     * Second getter for Moment
     *
     * @return an integer that represents the seconds of the current object
     */
    public int getSecond() {
        return this.second;
    }
}