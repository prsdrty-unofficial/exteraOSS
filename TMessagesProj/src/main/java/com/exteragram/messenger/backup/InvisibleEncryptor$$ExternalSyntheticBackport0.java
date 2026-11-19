package com.exteragram.messenger.backup;

import c.f$$ExternalSyntheticBUOutline2;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes4.dex */
public abstract /* synthetic */ class InvisibleEncryptor$$ExternalSyntheticBackport0 {
    public static /* synthetic */ String m(CharSequence charSequence, CharSequence[] charSequenceArr) {
        if (charSequence == null) {
            android.support.v4.media.session.MediaSessionCompat$$ExternalSyntheticThrowCCEIfNotNull0.m(new Object[]{"delimiter"});
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (charSequenceArr.length > 0) {
            sb.append(charSequenceArr[0]);
            for (int i = 1; i < charSequenceArr.length; i++) {
                sb.append(charSequence);
                sb.append(charSequenceArr[i]);
            }
        }
        return sb.toString();
    }
}
