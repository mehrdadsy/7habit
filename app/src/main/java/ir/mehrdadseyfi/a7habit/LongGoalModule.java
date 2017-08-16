package ir.mehrdadseyfi.a7habit;

/**
 * Created by Mehrdad on 8/16/2017.
 */

public class LongGoalModule {
    String name;
    String cat;
    String date;

    public LongGoalModule() {
    }

    public LongGoalModule(String name, String cat, String date) {

        this.name = name;
        this.cat = cat;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
