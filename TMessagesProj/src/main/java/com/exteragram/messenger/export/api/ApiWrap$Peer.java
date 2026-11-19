package com.exteragram.messenger.export.api;

import okio.Segment$$ExternalSyntheticBUOutline1;
import org.telegram.tgnet.TLRPC;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes4.dex */
public class ApiWrap$Peer {
    public ApiWrap$Chat chat;
    public ApiWrap$User user;

    public ApiWrap$Peer(ApiWrap$User apiWrap$User) {
        this.user = apiWrap$User;
    }

    public ApiWrap$Peer(ApiWrap$Chat apiWrap$Chat) {
        this.chat = apiWrap$Chat;
    }

    public TLRPC.InputPeer getInput() {
        ApiWrap$User apiWrap$User = this.user;
        if (apiWrap$User != null) {
            TLRPC.InputUser inputUser = apiWrap$User.input;
            if (inputUser instanceof TLRPC.TL_inputUser) {
                TLRPC.TL_inputUser tL_inputUser = (TLRPC.TL_inputUser) inputUser;
                TLRPC.TL_inputPeerUser tL_inputPeerUser = new TLRPC.TL_inputPeerUser();
                tL_inputPeerUser.user_id = tL_inputUser.user_id;
                tL_inputPeerUser.access_hash = tL_inputUser.access_hash;
                return tL_inputPeerUser;
            }
        }
        return this.chat.input;
    }

    public String name() {
        ApiWrap$User apiWrap$User = this.user;
        if (apiWrap$User != null) {
            return apiWrap$User.name();
        }
        ApiWrap$Chat apiWrap$Chat = this.chat;
        if (apiWrap$Chat != null) {
            return apiWrap$Chat.title;
        }
        android.support.v4.media.session.MediaSessionCompat$$ExternalSyntheticThrowCCEIfNotNull0.m(new Object[]{"both user and chat are null"});
        return null;
    }

    public int colorIndex() {
        ApiWrap$User apiWrap$User = this.user;
        if (apiWrap$User != null) {
            return apiWrap$User.colorIndex;
        }
        ApiWrap$Chat apiWrap$Chat = this.chat;
        if (apiWrap$Chat != null) {
            return apiWrap$Chat.colorIndex;
        }
        android.support.v4.media.session.MediaSessionCompat$$ExternalSyntheticThrowCCEIfNotNull0.m(new Object[]{"both user and chat are null"});
        return 0;
    }

    public long id() {
        ApiWrap$User apiWrap$User = this.user;
        if (apiWrap$User != null) {
            return apiWrap$User.info.userId.longValue();
        }
        ApiWrap$Chat apiWrap$Chat = this.chat;
        if (apiWrap$Chat != null) {
            return apiWrap$Chat.bareId;
        }
        android.support.v4.media.session.MediaSessionCompat$$ExternalSyntheticThrowCCEIfNotNull0.m(new Object[]{"both user and chat are null"});
        return 0L;
    }
}
