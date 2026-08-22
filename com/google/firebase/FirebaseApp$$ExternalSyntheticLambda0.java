package com.google.firebase;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FirebaseApp$$ExternalSyntheticLambda0 implements Provider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ FirebaseApp$$ExternalSyntheticLambda0(Context context, String str) {
        this.$r8$classId = 2;
        this.f$1 = context;
        this.f$0 = str;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return ((FirebaseApp) this.f$0).lambda$new$0((Context) this.f$1);
            case 1:
                return ((ComponentRuntime) this.f$0).lambda$discoverComponents$0((Component) this.f$1);
            default:
                return DefaultHeartBeatController.lambda$new$3((Context) this.f$1, (String) this.f$0);
        }
    }

    public /* synthetic */ FirebaseApp$$ExternalSyntheticLambda0(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
