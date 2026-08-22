package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzetm implements zzeuc {
    private final zzbyo zza;
    private final zzgdy zzb;
    private final Context zzc;

    public zzetm(zzbyo zzbyoVar, zzgdy zzgdyVar, Context context) {
        this.zza = zzbyoVar;
        this.zzb = zzgdyVar;
        this.zzc = context;
    }

    public static zzetn zzc(zzetm zzetmVar) {
        zzbyo zzbyoVar = zzetmVar.zza;
        Context context = zzetmVar.zzc;
        if (!zzbyoVar.zzp(context)) {
            return new zzetn(null, null, null, null, null);
        }
        String strZze = zzbyoVar.zze(context);
        String str = strZze == null ? "" : strZze;
        String strZzc = zzbyoVar.zzc(context);
        String str2 = strZzc == null ? "" : strZzc;
        String strZzb = zzbyoVar.zzb(context);
        String str3 = strZzb == null ? "" : strZzb;
        boolean zZzp = zzbyoVar.zzp(context);
        Long l = null;
        String str4 = true != zZzp ? null : "fa";
        if ("TIME_OUT".equals(str2)) {
            l = (Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzaz);
        }
        return new zzetn(str, str2, str3, str4 == null ? "" : str4, l);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 34;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzetm.zzc(this.zza);
            }
        });
    }
}
