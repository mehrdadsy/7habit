package ir.mehrdadseyfi.a7habit.Calender;

import com.orm.SugarRecord;

/**
 * Created by admin on 8/29/2017.
 */

public class JobDB extends SugarRecord<JobDB> {
    String name;
    String detail;
    String calenderYear;
    String calenderMount;
    String calenderday;
    String Shours;
    String Sminutes;
    String Ehours;
    String Eminutes;
    String repeat;

    public JobDB() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCalenderYear() {
        return calenderYear;
    }

    public void setCalenderYear(String calenderYear) {
        this.calenderYear = calenderYear;
    }

    public String getCalenderMount() {
        return calenderMount;
    }

    public void setCalenderMount(String calenderMount) {
        this.calenderMount = calenderMount;
    }

    public String getCalenderday() {
        return calenderday;
    }

    public void setCalenderday(String calenderday) {
        this.calenderday = calenderday;
    }

    public String getShours() {
        return Shours;
    }

    public void setShours(String shours) {
        Shours = shours;
    }

    public String getSminutes() {
        return Sminutes;
    }

    public void setSminutes(String sminutes) {
        Sminutes = sminutes;
    }

    public String getEhours() {
        return Ehours;
    }

    public void setEhours(String ehours) {
        Ehours = ehours;
    }

    public String getEminutes() {
        return Eminutes;
    }

    public void setEminutes(String eminutes) {
        Eminutes = eminutes;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public JobDB(String name, String detail, String calenderYear, String calenderMount, String calenderday, String shours, String sminutes, String ehours, String eminutes, String repeat) {
        this.name = name;
        this.detail = detail;
        this.calenderYear = calenderYear;
        this.calenderMount = calenderMount;
        this.calenderday = calenderday;
        this.repeat=repeat;

        Shours = shours;
        Sminutes = sminutes;
        Ehours = ehours;
        Eminutes = eminutes;
    }
}
