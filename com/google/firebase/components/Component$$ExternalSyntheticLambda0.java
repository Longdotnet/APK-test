package com.google.firebase.components;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Component$$ExternalSyntheticLambda0 implements ComponentFactory {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Component$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.$r8$classId) {
            case 0:
                return Component.lambda$intoSet$2(this.f$0, componentContainer);
            case 1:
                return Component.lambda$of$0(this.f$0, componentContainer);
            default:
                return Component.lambda$of$1(this.f$0, componentContainer);
        }
    }
}
