package ir.mehrdadseyfi.a7habit.Vista;

import com.orm.SugarRecord;

/**
 * Created by admin on 8/26/2017.
 */

public class FRdatabase extends SugarRecord<FRdatabase> {
    String name;
    String iconRole;

    public FRdatabase() {
    }

    public FRdatabase(String name, String iconRole) {

        this.name = name;
   
        this.iconRole = iconRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String geticonRole() {
        return iconRole;
    }

    public void seticonRole(String iconRole) {
        this.iconRole = iconRole;
    }
}
