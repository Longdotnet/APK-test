package com.google.common.collect;

import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ImmutableList$$ExternalSyntheticLambda0 implements IntFunction {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ImmutableCollection f$0;

    public /* synthetic */ ImmutableList$$ExternalSyntheticLambda0(ImmutableCollection immutableCollection, int i) {
        this.$r8$classId = i;
        this.f$0 = immutableCollection;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.$r8$classId) {
            case 0:
                return ((ImmutableList) this.f$0).get(i);
            default:
                return ((JdkBackedImmutableSet) this.f$0).get(i);
        }
    }
}
