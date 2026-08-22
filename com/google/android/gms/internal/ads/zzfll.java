package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfll {
    public static zzfll zza(zzflm zzflmVar, zzfln zzflnVar) {
        zzfni.zza();
        return new zzflp(zzflmVar, zzflnVar, UUID.randomUUID().toString());
    }

    public abstract void zzb(View view, zzfls zzflsVar, String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();
}
