package ir.mehrdadseyfi.a7habit.Vista;

import com.orm.SugarRecord;

/**
 * Created by admin on 8/26/2017.
 */

public class FGdatabase extends SugarRecord<FGdatabase> {
    String name;
    String detial;
    String role;
    String iconGoal;

    public FGdatabase() {
    }

    public FGdatabase(String name, String detial,String role, String iconGoal) {

        this.name = name;
        this.detial = detial;
        this.iconGoal = iconGoal;
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIconGoal() {
        return iconGoal;
    }

    public void setIconGoal(String iconGoal) {
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


}
