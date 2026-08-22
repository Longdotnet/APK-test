package com.google.common.collect;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CollectSpliterators$1WithCharacteristics$$ExternalSyntheticLambda6 implements IntConsumer {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Consumer f$0;
    public final /* synthetic */ IntFunction f$1;

    public /* synthetic */ CollectSpliterators$1WithCharacteristics$$ExternalSyntheticLambda6(Consumer consumer, IntFunction intFunction, int i) {
        this.$r8$classId = i;
        this.f$0 = consumer;
        this.f$1 = intFunction;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.accept(this.f$1.apply(i));
                break;
            default:
                this.f$0.accept(this.f$1.apply(i));
                break;
        }
    }
}
