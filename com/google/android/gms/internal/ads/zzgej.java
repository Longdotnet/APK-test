package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
final class zzgej extends TimeoutException {
    public /* synthetic */ zzgej(String str, zzgek zzgekVar) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
