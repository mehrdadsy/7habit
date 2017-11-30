package ir.mehrdadseyfi.a7habit;

import com.orm.SugarRecord;

/**
 * Created by Mehrdad on 11/30/2017.
 */

public class IsActive extends SugarRecord<IsActive> {
    boolean Active;

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public IsActive(boolean active) {
        Active = active;
    }
    public IsActive() {

    }
}
