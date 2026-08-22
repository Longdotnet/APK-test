package com.google.firebase.components;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallations;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentDiscovery$$ExternalSyntheticLambda0 implements Provider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComponentDiscovery$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return ComponentDiscovery.instantiate((String) this.f$0);
            default:
                return FirebaseInstallations.lambda$new$0((FirebaseApp) this.f$0);
        }
    }
}
