package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.core.os.ContinuationOutcomeReceiver;
import com.google.android.gms.internal.ads.zzro$$ExternalSyntheticApiModelOutline1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class MeasurementManager$Api33Ext5Impl {
    public final MeasurementManager mMeasurementManager;

    public MeasurementManager$Api33Ext5Impl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService((Class<Object>) zzro$$ExternalSyntheticApiModelOutline1.m91m());
        Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService…:class.java\n            )");
        this.mMeasurementManager = zzro$$ExternalSyntheticApiModelOutline1.m(systemService);
    }

    public Object deleteRegistrations(DeletionRequest deletionRequest, Continuation continuation) {
        new CancellableContinuationImpl(Protocol.Companion.intercepted(continuation)).initCancellability();
        zzro$$ExternalSyntheticApiModelOutline1.m92m();
        throw null;
    }

    public Object getMeasurementApiStatus(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(Protocol.Companion.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        this.mMeasurementManager.getMeasurementApiStatus(new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new ContinuationOutcomeReceiver(cancellableContinuationImpl));
        return cancellableContinuationImpl.getResult();
    }

    public Object registerSource(Uri uri, InputEvent inputEvent, Continuation continuation) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(Protocol.Companion.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        this.mMeasurementManager.registerSource(uri, inputEvent, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new ContinuationOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.COROUTINE_SUSPENDED ? result : Unit.INSTANCE;
    }

    public Object registerTrigger(Uri uri, Continuation continuation) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(Protocol.Companion.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        this.mMeasurementManager.registerTrigger(uri, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new ContinuationOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.COROUTINE_SUSPENDED ? result : Unit.INSTANCE;
    }

    public Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, Continuation continuation) {
        new CancellableContinuationImpl(Protocol.Companion.intercepted(continuation)).initCancellability();
        zzro$$ExternalSyntheticApiModelOutline1.m93m$1();
        throw null;
    }

    public Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, Continuation continuation) {
        new CancellableContinuationImpl(Protocol.Companion.intercepted(continuation)).initCancellability();
        zzro$$ExternalSyntheticApiModelOutline1.m$2();
        throw null;
    }
}
