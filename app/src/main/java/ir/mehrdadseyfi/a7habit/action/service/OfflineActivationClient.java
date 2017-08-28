package  ir.mehrdadseyfi.a7habit.action.service;

import java.math.BigInteger;

import ir.co21.service.DecoderUtility;
import ir.co21.service.PlainActivation;
import ir.co21.service.PlainSerial;

/**
 * @author Sam
 * @version 1.0
 */
public class OfflineActivationClient implements ActivationService {

    public OfflineActivationClient() {
    }

    @Override
    public PlainActivation activate(String metaId, String subId, String deviceId, String serialCode) {
        throw new UnsupportedOperationException("Cannot activate offline.");
    }

    @Override
    public PlainActivation validate(String metaId, String subId, String deviceId, String serialCode, String activationCode) {

        long activationCodeHash = CryptoUtility.createActivationCodeHash(serialCode, deviceId, metaId, subId);
        BigInteger decrypted = DecoderUtility.decrypt(new BigInteger(activationCode));
        if(Long.parseLong(decrypted.toString()) != activationCodeHash) {
            throw new RuntimeException(Error.INVALID_LICENSE.toString());
        }

        PlainActivation activation = new PlainActivation();
        activation.setDeviceId(deviceId);
        PlainSerial serial = new PlainSerial();
        serial.setSerialCode(serialCode);
        activation.setSerial(serial);
        activation.setActivationCode(activationCode);

        return activation;
    }
}
