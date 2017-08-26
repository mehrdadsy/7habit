package ir.mehrdadseyfi.a7habit.Vista;

import com.orm.SugarRecord;

/**
 * Created by admin on 8/26/2017.
 */

public class FGdatabase extends SugarRecord<FGdatabase> {
    String name;
    String detial;
    String iconGoal;

    public FGdatabase() {
    }

    public FGdatabase(String name, String detial, String iconGoal) {

        this.name = name;
        this.detial = detial;
        this.iconGoal = iconGoal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetial() {
        return detial;
    }

    public void setDetial(String detial) {
        this.detial = detial;
    }

    public String geticonGoal() {
        return iconGoal;
    }

    public void seticonGoal(String iconGoal) {
        this.iconGoal = iconGoal;
    }
}
