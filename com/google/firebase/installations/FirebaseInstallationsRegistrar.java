package com.google.firebase.installations;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher$$ExternalSyntheticLambda0;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static /* synthetic */ FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseInstallations((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(HeartBeatController.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseInstallationsApi.class).name(LIBRARY_NAME).add(Dependency.required(FirebaseApp.class)).add(Dependency.optionalProvider(HeartBeatController.class)).factory(new DefaultUserAgentPublisher$$ExternalSyntheticLambda0(2)).build(), HeartBeatConsumerComponent.create(), LibraryVersionComponent.create(LIBRARY_NAME, "17.1.0"));
    }
}
