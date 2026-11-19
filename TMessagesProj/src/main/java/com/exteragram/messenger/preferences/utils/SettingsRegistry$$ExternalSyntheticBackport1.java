package com.exteragram.messenger.preferences.utils;

import com.sun.jna.Native$$ExternalSyntheticBUOutline5;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes4.dex */
public abstract /* synthetic */ class SettingsRegistry$$ExternalSyntheticBackport1 {
    public static /* synthetic */ Map m(Map.Entry[] entryArr) {
        HashMap map = new HashMap(entryArr.length);
        for (Map.Entry entry : entryArr) {
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                android.support.v4.media.session.MediaSessionCompat$$ExternalSyntheticThrowCCEIfNotNull0.m(new Object[]{"duplicate key: ", key});
                return null;
            }
        }
        return Collections.unmodifiableMap(map);
    }
}
