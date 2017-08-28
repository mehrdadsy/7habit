package ir.mehrdadseyfi.a7habit.action.service;

import ir.co21.service.PlainActivation;

public interface ActivationService {
    PlainActivation activate(
            String productId,
            String subId,
            String deviceId,
            String serialCode);

    PlainActivation validate(
            String productId,
            String subId,
            String deviceId,
            String serialCode,
            String activationKey);
}
