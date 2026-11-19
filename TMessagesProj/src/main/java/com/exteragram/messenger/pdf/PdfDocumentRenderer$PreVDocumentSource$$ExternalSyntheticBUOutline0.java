package com.exteragram.messenger.pdf;

import android.graphics.pdf.PdfRendererPreV;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes4.dex */
public abstract /* synthetic */ class PdfDocumentRenderer$PreVDocumentSource$$ExternalSyntheticBUOutline0 {
    public static /* synthetic */ PdfRendererPreV m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            return new PdfRendererPreV(parcelFileDescriptor);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
