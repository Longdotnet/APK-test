package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzchf {
    private VersionInfoParcel zza;
    private Context zzb;
    private long zzc;
    private WeakReference zzd;

    public final zzchf zzd(long j) {
        this.zzc = j;
        return this;
    }

    public final zzchf zze(Context context) {
        this.zzd = new WeakReference(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzb = context;
        return this;
    }

    public final zzchf zzf(VersionInfoParcel versionInfoParcel) {
        this.zza = versionInfoParcel;
        return this;
    }
}
