package ir.mehrdadseyfi.a7habit;

import com.orm.SugarRecord;

/**
 * Created by admin on 8/18/2017.
 */

public class BadHabitDB extends SugarRecord<BadHabitDB> {
    String habitTitle;
    String habitdetails;
    String upgradeHabit;

    public String getUpgradeHabit() {
        return upgradeHabit;
    }

    public void setUpgradeHabit(String upgradeHabit) {
        this.upgradeHabit = upgradeHabit;
    }

    public BadHabitDB(String habitTitle, String habitdetails, String upgradeHabit) {
        this.habitTitle = habitTitle;
        this.habitdetails = habitdetails;
        this.upgradeHabit=upgradeHabit;

    }

    public BadHabitDB() {

    }

    public String getHabitTitle() {
        return habitTitle;
    }

    public void setHabitTitle(String habitTitle) {
        this.habitTitle = habitTitle;
    }

    public String getHabitdetails() {
        return habitdetails;
    }

    public void setHabitdetails(String habitdetails) {
        this.habitdetails = habitdetails;
    }
}
