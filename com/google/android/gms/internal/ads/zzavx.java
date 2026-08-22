package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzavx {
    private final ListenableFuture zza;

    public zzavx(final Context context, Executor executor) {
        this.zza = zzgdn.zzj(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzavw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = context;
                try {
                    return zzfoq.zza(context2, context2.getPackageName(), Integer.toString(context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode));
                } catch (Throwable unused) {
                    return null;
                }
            }
        }, executor);
    }

    public final ListenableFuture zza() {
        return this.zza;
    }
}
