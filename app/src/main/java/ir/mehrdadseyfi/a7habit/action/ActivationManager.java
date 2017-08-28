package  ir.mehrdadseyfi.a7habit.action;

/**
 * @author Sam
 * @version 1.0
 */
public interface ActivationManager {
    boolean isActive();

    void activate();

    void setSerialCodeOfUser();

    String getSerialCodeOfUser();

    boolean haveSerialCode();

    boolean inSmsStatus();


    void offlineActivate();

    void setUserActivationCode(String userActivationCode);

    String getUserActivationCode();

    void setSerialId(String serialId);

    String getSerialId();

    void setSmsStatus(boolean smsStatus);
}
