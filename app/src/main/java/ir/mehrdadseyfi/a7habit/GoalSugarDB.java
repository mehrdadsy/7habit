package ir.mehrdadseyfi.a7habit;

import com.orm.SugarRecord;

/**
 * Created by admin on 8/17/2017.
 */

public class GoalSugarDB extends SugarRecord<GoalSugarDB> {
    String name;
    String date;
    String catPhoto;

    public GoalSugarDB(String name, String date, String catPhoto) {
        this.name = name;
        this.date = date;
        this.catPhoto = catPhoto;
    }

    public GoalSugarDB() {


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCatPhoto() {
        return catPhoto;
    }

    public void setCatPhoto(String catPhoto) {
        this.catPhoto = catPhoto;
    }
}
