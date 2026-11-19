package com.exteragram.messenger.plugins.catalog.db;

import com.google.android.gms.cast.MediaTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.url._UrlKt;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0017\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u001aR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001d¨\u0006'"}, d2 = {"Lcom/exteragram/messenger/plugins/catalog/db/CatalogEntryEntity;", _UrlKt.FRAGMENT_ENCODE_SET, "repositoryId", _UrlKt.FRAGMENT_ENCODE_SET, "entryId", _UrlKt.FRAGMENT_ENCODE_SET, "date", "documentId", "fileName", _UrlKt.FRAGMENT_ENCODE_SET, "size", MediaTrack.ROLE_CAPTION, "message", _UrlKt.FRAGMENT_ENCODE_SET, "views", "updatedAt", "fileUrl", "sha256", "<init>", "(JIIJLjava/lang/String;JLjava/lang/String;[BIILjava/lang/String;Ljava/lang/String;)V", "getRepositoryId", "()J", "getEntryId", "()I", "getDate", "setDate", "(I)V", "getDocumentId", "getFileName", "()Ljava/lang/String;", "getSize", "getCaption", "getMessage", "()[B", "getViews", "getUpdatedAt", "setUpdatedAt", "getFileUrl", "getSha256", "TMessagesProj"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CatalogEntryEntity {
    private final String caption;
    private int date;
    private final long documentId;
    private final int entryId;
    private final String fileName;
    private final String fileUrl;
    private final byte[] message;
    private final long repositoryId;
    private final String sha256;
    private final long size;
    private int updatedAt;
    private final int views;

    public CatalogEntryEntity(long j, int i, int i2, long j2, String str, long j3, String str2, byte[] bArr, int i3, int i4, String str3, String str4) {
        this.repositoryId = j;
        this.entryId = i;
        this.date = i2;
        this.documentId = j2;
        this.fileName = str;
        this.size = j3;
        this.caption = str2;
        this.message = bArr;
        this.views = i3;
        this.updatedAt = i4;
        this.fileUrl = str3;
        this.sha256 = str4;
    }

    public /* synthetic */ CatalogEntryEntity(long j, int i, int i2, long j2, String str, long j3, String str2, byte[] bArr, int i3, int i4, String str3, String str4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, i2, j2, str, j3, str2, bArr, (i5 & 256) != 0 ? 0 : i3, (i5 & 512) != 0 ? i2 : i4, (i5 & 1024) != 0 ? null : str3, (i5 & 2048) != 0 ? null : str4);
    }

    public final long getRepositoryId() {
        return this.repositoryId;
    }

    public final int getEntryId() {
        return this.entryId;
    }

    public final int getDate() {
        return this.date;
    }

    public final void setDate(int i) {
        this.date = i;
    }

    public final long getDocumentId() {
        return this.documentId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final byte[] getMessage() {
        return this.message;
    }

    public final int getViews() {
        return this.views;
    }

    public final int getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(int i) {
        this.updatedAt = i;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final String getSha256() {
        return this.sha256;
    }
}
