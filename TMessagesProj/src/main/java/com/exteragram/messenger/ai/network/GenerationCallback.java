package com.exteragram.messenger.ai.network;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes.dex */
public interface GenerationCallback {
    void onChunk(String str);

    void onError(int i, String str);

    void onResponse(String str);

    default void onThinking() {
    }
}
