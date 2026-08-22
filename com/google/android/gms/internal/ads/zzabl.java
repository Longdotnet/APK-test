package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzabl implements zzca {
    private final zzby zza = new zzabk(false);

    public zzabl(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzca
    public final zzcc zza(Context context, zzk zzkVar, zzn zznVar, zzcb zzcbVar, Executor executor, zzbv zzbvVar, List list, long j, boolean z) {
        try {
            try {
                return ((zzca) Class.forName("androidx.media3.effect.SingleInputVideoGraph$Factory").getConstructor(zzby.class).newInstance(this.zza)).zza(context, zzkVar, zznVar, zzcbVar, executor, zzbvVar, list, 0L, false);
            } catch (Exception e) {
                e = e;
                throw new IllegalStateException(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
