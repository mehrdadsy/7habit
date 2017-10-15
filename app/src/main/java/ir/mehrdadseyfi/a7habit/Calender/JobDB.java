package ir.mehrdadseyfi.a7habit.Calender;

import com.google.android.gms.common.annotation.KeepName;
import com.orm.SugarRecord;

/**
 * Created by admin on 8/29/2017.
 */

@KeepName
public class JobDB extends SugarRecord<JobDB> {
    String name;
    String detail;
    String goal;
    String year;
    String mount;
    String day;
    String shours;
    String sminutes;
    String ehours;
    String eminutes;
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

    public String getyear() {
        return year;
    }

    public void setyear(String year) {
        this.year = year;
    }

    public String getmount() {
        return mount;
    }

    public void setmount(String mount) {
        this.mount = mount;
    }

    public String getday() {
        return day;
    }

    public void setday(String day) {
        this.day = day;
    }

    public String getshours() {
        return shours;
    }

    public void setshours(String shours) {
        shours = shours;
    }

    public String getsminutes() {
        return sminutes;
    }

    public void setsminutes(String sminutes) {
        sminutes = sminutes;
    }

    public String getehours() {
        return ehours;
    }

    public void setehours(String ehours) {
        ehours = ehours;
    }

    public String geteminutes() {
        return eminutes;
    }

    public void seteminutes(String eminutes) {
        eminutes = eminutes;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }




    public JobDB(String name, String detail, String goal, String year, String mount, String day, String shours, String sminutes, String ehours, String eminutes, String repeat ) {
        this.name = name;
        this.detail = detail;
        this.goal = goal;
        this.year = year;
        this.mount = mount;
        this.day = day;
        this.shours = shours;
        this.sminutes = sminutes;
        this.ehours = ehours;
        this.eminutes = eminutes;
        this.repeat = repeat;

    }
}
