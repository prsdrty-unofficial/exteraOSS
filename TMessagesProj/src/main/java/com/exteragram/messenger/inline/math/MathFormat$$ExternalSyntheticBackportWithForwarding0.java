package com.exteragram.messenger.inline.math;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes4.dex */
public abstract /* synthetic */ class MathFormat$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ BigDecimal m(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}
