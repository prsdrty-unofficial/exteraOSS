package com.exteragram.messenger.export.api;

import java.util.Objects;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes4.dex */
public abstract /* synthetic */ class ApiWrap$FileOrigin$$ExternalSyntheticRecord0 {
    public static /* synthetic */ int m(int i, int i2, int i3, long j, Object obj) {
        return (((((((i * 31) + i2) * 31) + i3) * 31) + Long.hashCode(j)) * 31) + Objects.hashCode(obj);
    }
}
