package com.facebook.internal.instrument.crashreport;

import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.GraphRequest;
import com.facebook.internal.instrument.InstrumentData;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final GraphRequest.Companion Companion = new GraphRequest.Companion(12);
    public static CrashHandler instance;
    public final Thread.UncaughtExceptionHandler previousHandler;

    public CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.previousHandler = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread t, Throwable e) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(e, "e");
        Throwable th = null;
        loop0: for (Throwable cause = e; cause != null && cause != th; cause = cause.getCause()) {
            StackTraceElement[] stackTrace = cause.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i = 0;
            while (i < length) {
                StackTraceElement element = stackTrace[i];
                i++;
                Intrinsics.checkNotNullExpressionValue(element, "element");
                if (Headers.Companion.isFromFbOrMeta(element)) {
                    MapsKt__MapsKt.execute(e);
                    GamepadHandler_API19.build(e, InstrumentData.Type.CrashReport).save();
                    break loop0;
                }
            }
            th = cause;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(t, e);
    }
}
