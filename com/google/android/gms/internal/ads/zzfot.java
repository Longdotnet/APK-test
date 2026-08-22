package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class zzfot {
    private final Context zza;
    private final Looper zzb;

    public zzfot(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfpe zzfpeVarZza = zzfph.zza();
        Context context = this.zza;
        zzfpeVarZza.zza(context.getPackageName());
        zzfpeVarZza.zzc(2);
        zzfpb zzfpbVarZza = zzfpd.zza();
        zzfpbVarZza.zza(str);
        zzfpbVarZza.zzb(2);
        zzfpeVarZza.zzb(zzfpbVarZza);
        new zzfou(context, this.zzb, (zzfph) zzfpeVarZza.zzbr()).zza();
    }
}
