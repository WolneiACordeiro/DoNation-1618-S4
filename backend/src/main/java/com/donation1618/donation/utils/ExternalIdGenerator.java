package com.donation1618.donation.utils;

import java.util.UUID;

public class ExternalIdGenerator {
    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
