package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentRuntime$$ExternalSyntheticLambda0 implements Provider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ComponentRegistrar f$0;

    public /* synthetic */ ComponentRuntime$$ExternalSyntheticLambda0(ComponentRegistrar componentRegistrar, int i) {
        this.$r8$classId = i;
        this.f$0 = componentRegistrar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return ComponentRuntime.lambda$toProviders$1(this.f$0);
            default:
                return ComponentRuntime.Builder.lambda$addComponentRegistrar$0(this.f$0);
        }
    }
}
