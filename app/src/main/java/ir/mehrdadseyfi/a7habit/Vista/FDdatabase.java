package ir.mehrdadseyfi.a7habit.Vista;

import com.orm.SugarRecord;

/**
 * Created by admin on 8/26/2017.
 */

public class FDdatabase extends SugarRecord<FDdatabase> {
    String name;
    String detial;
    String iconDream;

    public FDdatabase() {
    }

    public FDdatabase(String name, String detial, String iconDream) {

        this.name = name;
        this.detial = detial;
        this.iconDream = iconDream;
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

    public String getIconDream() {
        return iconDream;
    }

    public void setIconDream(String iconDream) {
        this.iconDream = iconDream;
    }
}
