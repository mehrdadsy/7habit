package  ir.mehrdadseyfi.a7habit.action.service;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import ir.co21.service.PlainActivation;

/**
 * @author Sam
 * @version 1.0
 */
public class CryptoUtility {
    public static String generateActivationKey(PlainActivation activation) {
        Long activateCodeNumber = Long.valueOf(activation.getActivationCode());
        int weekNumber = CommonUtility.getWeekNumber();
        activateCodeNumber = activateCodeNumber * weekNumber;
        byte[] bytes = ByteBuffer.allocate(8).putLong(activateCodeNumber).array();
        return CommonUtility.encryptBytes(bytes).toUpperCase().substring(8, 24);
    }

    public static String generateChecksum(PlainActivation activation) {
        return CommonUtility.deepEncryptString(activation.getActivationKey());
    }

    public static long createActivationCodeHash(String serialCode, String deviceId, String metaId, String subId) {
        BigInteger hash = new BigInteger(String.valueOf(serialCode.hashCode()));
        if (deviceId != null) {
            hash = hash.add(new BigInteger(String.valueOf(3 * deviceId.hashCode())));
        }
        if (metaId != null) {
            hash = hash.add(new BigInteger(String.valueOf(5 * metaId.hashCode())));
        }
        if (subId != null) {
            hash = hash.add(new BigInteger(String.valueOf(7 * subId.hashCode())));
        }
        hash = hash.pow(4);
        return Long.parseLong(hash.toString().substring(0, 12));
    }

}
