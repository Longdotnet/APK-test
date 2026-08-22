package com.google.firebase.tracing;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentMonitor$$ExternalSyntheticLambda0 implements ComponentFactory {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ComponentMonitor$$ExternalSyntheticLambda0(String str, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
        this.f$1 = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.$r8$classId) {
            case 0:
                return ComponentMonitor.lambda$processRegistrar$0(this.f$0, (Component) this.f$1, componentContainer);
            default:
                return LibraryVersionComponent.lambda$fromContext$0(this.f$0, (LibraryVersionComponent.VersionExtractor) this.f$1, componentContainer);
        }
    }
}
