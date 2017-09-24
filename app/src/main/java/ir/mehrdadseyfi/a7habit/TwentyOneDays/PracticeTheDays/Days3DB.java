package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import com.orm.SugarRecord;

/**
 * Created by admin on 8/26/2017.
 */

public class Days3DB extends SugarRecord<Days3DB> {
    String name;
    String detial;
    String halghe;

    public Days3DB() {
    }

    public Days3DB(String name, String detial, String halghe) {

        this.name = name;
        this.detial = detial;
        this.halghe = halghe;
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

    public String gethalghe() {
        return halghe;
    }

    public void setHalghe(String halghe) {
        this.halghe = halghe;
    }
}
