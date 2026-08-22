package com.google.firebase.heartbeatinfo;

import com.google.firebase.auth.zzr;
import com.google.firebase.components.Component;

/* JADX INFO: loaded from: classes.dex */
public class HeartBeatConsumerComponent {
    private HeartBeatConsumerComponent() {
    }

    public static Component<?> create() {
        return Component.intoSet(new zzr(7), HeartBeatConsumer.class);
    }
}
