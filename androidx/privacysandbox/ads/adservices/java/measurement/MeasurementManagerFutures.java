package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo$Extensions30Impl;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager$Api33Ext5Impl;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public abstract class MeasurementManagerFutures {

    public final class Api33Ext5JavaImpl extends MeasurementManagerFutures {
        public final MeasurementManager$Api33Ext5Impl mMeasurementManager;

        public Api33Ext5JavaImpl(MeasurementManager$Api33Ext5Impl measurementManager$Api33Ext5Impl) {
            this.mMeasurementManager = measurementManager$Api33Ext5Impl;
        }

        public ListenableFuture deleteRegistrationsAsync(DeletionRequest deletionRequest) {
            Intrinsics.checkNotNullParameter(deletionRequest, "deletionRequest");
            throw null;
        }

        public ListenableFuture getMeasurementApiStatusAsync() {
            return Headers.Companion.asListenableFuture$default(BuildersKt.async$default(BuildersKt.CoroutineScope(Dispatchers.Default), new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, null)));
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        public ListenableFuture registerSourceAsync(Uri attributionSource, InputEvent inputEvent) {
            Intrinsics.checkNotNullParameter(attributionSource, "attributionSource");
            return Headers.Companion.asListenableFuture$default(BuildersKt.async$default(BuildersKt.CoroutineScope(Dispatchers.Default), new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, attributionSource, inputEvent, null)));
        }

        public ListenableFuture registerTriggerAsync(Uri trigger) {
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            return Headers.Companion.asListenableFuture$default(BuildersKt.async$default(BuildersKt.CoroutineScope(Dispatchers.Default), new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, trigger, null)));
        }

        public ListenableFuture registerWebSourceAsync(WebSourceRegistrationRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            throw null;
        }

        public ListenableFuture registerWebTriggerAsync(WebTriggerRegistrationRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            throw null;
        }
    }

    public static final Api33Ext5JavaImpl from(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb = new StringBuilder("AdServicesInfo.version=");
        int i = Build.VERSION.SDK_INT;
        AdServicesInfo$Extensions30Impl adServicesInfo$Extensions30Impl = AdServicesInfo$Extensions30Impl.INSTANCE;
        sb.append(i >= 30 ? adServicesInfo$Extensions30Impl.getAdServicesVersion() : 0);
        Log.d("MeasurementManager", sb.toString());
        MeasurementManager$Api33Ext5Impl measurementManager$Api33Ext5Impl = (i >= 30 ? adServicesInfo$Extensions30Impl.getAdServicesVersion() : 0) >= 5 ? new MeasurementManager$Api33Ext5Impl(context) : null;
        if (measurementManager$Api33Ext5Impl != null) {
            return new Api33Ext5JavaImpl(measurementManager$Api33Ext5Impl);
        }
        return null;
    }

    public abstract ListenableFuture registerSourceAsync(Uri uri, InputEvent inputEvent);
}
