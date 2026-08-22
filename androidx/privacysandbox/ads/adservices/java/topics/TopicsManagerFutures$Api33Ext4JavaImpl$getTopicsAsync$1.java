package androidx.privacysandbox.ads.adservices.java.topics;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public final class TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ GetTopicsRequest $request;
    public int label;
    public final /* synthetic */ TopicsManagerFutures$Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1(TopicsManagerFutures$Api33Ext4JavaImpl topicsManagerFutures$Api33Ext4JavaImpl, GetTopicsRequest getTopicsRequest, Continuation continuation) {
        super(continuation);
        this.this$0 = topicsManagerFutures$Api33Ext4JavaImpl;
        this.$request = getTopicsRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1) create((Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            StringsKt__IndentKt.throwOnFailure(obj);
            TopicsManagerImplCommon topicsManagerImplCommon = this.this$0.mTopicsManager;
            this.label = 1;
            obj = topicsManagerImplCommon.getTopics(this.$request, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            StringsKt__IndentKt.throwOnFailure(obj);
        }
        return obj;
    }
}
