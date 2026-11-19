package com.exteragram.messenger.ai.network.backend;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes4.dex */
public interface BackendSink {
    boolean isActive();

    void onCancellable(Runnable runnable);

    void onChunk(String str);

    void onComplete(String str);

    void onError(int i, String str);

    void onThinking();
}
