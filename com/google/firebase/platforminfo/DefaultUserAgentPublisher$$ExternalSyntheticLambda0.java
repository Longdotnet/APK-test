package com.google.firebase.platforminfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultUserAgentPublisher$$ExternalSyntheticLambda0 implements ComponentFactory {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ DefaultUserAgentPublisher$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.$r8$classId) {
            case 0:
                return DefaultUserAgentPublisher.lambda$component$0(componentContainer);
            case 1:
                return DefaultHeartBeatController.lambda$component$4(componentContainer);
            default:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
        }
    }
}
