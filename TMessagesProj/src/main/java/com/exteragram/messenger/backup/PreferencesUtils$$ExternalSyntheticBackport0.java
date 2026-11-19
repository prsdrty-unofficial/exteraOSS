package com.exteragram.messenger.backup;

import com.sun.jna.Native$$ExternalSyntheticBUOutline5;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes.dex */
public abstract /* synthetic */ class PreferencesUtils$$ExternalSyntheticBackport0 {
    public static /* synthetic */ Set m(Object[] objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
            if (!hashSet.add(obj)) {
                android.support.v4.media.session.MediaSessionCompat$$ExternalSyntheticThrowCCEIfNotNull0.m(new Object[]{"duplicate element: ", obj});
                return null;
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
