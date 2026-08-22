package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.TopicsManager;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.core.os.ContinuationOutcomeReceiver;
import com.google.android.gms.internal.ads.zzro$$ExternalSyntheticApiModelOutline1;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public abstract class TopicsManagerImplCommon {
    public final TopicsManager mTopicsManager;

    /* JADX INFO: renamed from: androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public TopicsManagerImplCommon L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TopicsManagerImplCommon.getTopics$suspendImpl(TopicsManagerImplCommon.this, null, this);
        }
    }

    public TopicsManagerImplCommon(TopicsManager mTopicsManager) {
        Intrinsics.checkNotNullParameter(mTopicsManager, "mTopicsManager");
        this.mTopicsManager = mTopicsManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object getTopics$suspendImpl(TopicsManagerImplCommon topicsManagerImplCommon, GetTopicsRequest getTopicsRequest, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = topicsManagerImplCommon.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = topicsManagerImplCommon.new AnonymousClass1(continuation);
        }
        Object result = anonymousClass1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            StringsKt__IndentKt.throwOnFailure(result);
            android.adservices.topics.GetTopicsRequest getTopicsRequestConvertRequest$ads_adservices_release = topicsManagerImplCommon.convertRequest$ads_adservices_release(getTopicsRequest);
            anonymousClass1.L$0 = topicsManagerImplCommon;
            anonymousClass1.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(Protocol.Companion.intercepted(anonymousClass1));
            cancellableContinuationImpl.initCancellability();
            topicsManagerImplCommon.mTopicsManager.getTopics(getTopicsRequestConvertRequest$ads_adservices_release, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new ContinuationOutcomeReceiver(cancellableContinuationImpl));
            result = cancellableContinuationImpl.getResult();
            if (result == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            topicsManagerImplCommon = anonymousClass1.L$0;
            StringsKt__IndentKt.throwOnFailure(result);
        }
        android.adservices.topics.GetTopicsResponse response = zzro$$ExternalSyntheticApiModelOutline1.m88m(result);
        topicsManagerImplCommon.getClass();
        Intrinsics.checkNotNullParameter(response, "response");
        ArrayList arrayList = new ArrayList();
        Iterator it = response.getTopics().iterator();
        while (it.hasNext()) {
            android.adservices.topics.Topic topicM89m = zzro$$ExternalSyntheticApiModelOutline1.m89m(it.next());
            arrayList.add(new Topic(topicM89m.getTaxonomyVersion(), topicM89m.getModelVersion(), topicM89m.getTopicId()));
        }
        return new GetTopicsResponse(arrayList);
    }

    public android.adservices.topics.GetTopicsRequest convertRequest$ads_adservices_release(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        android.adservices.topics.GetTopicsRequest getTopicsRequestBuild = zzro$$ExternalSyntheticApiModelOutline1.m().setAdsSdkName("com.google.android.gms.ads").build();
        Intrinsics.checkNotNullExpressionValue(getTopicsRequestBuild, "Builder()\n            .s…ame)\n            .build()");
        return getTopicsRequestBuild;
    }

    public Object getTopics(GetTopicsRequest getTopicsRequest, Continuation continuation) {
        return getTopics$suspendImpl(this, getTopicsRequest, continuation);
    }
}
