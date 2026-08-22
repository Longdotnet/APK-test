package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxh extends zzayk {
    private final Activity zzh;
    private final View zzi;

    public zzaxh(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, View view, Activity activity) {
        super(zzawxVar, "YX3pd3fZ/j0e82Z3yXv98nYqAI3nsN+d0YAKVHjoLLbjd+BRZ45hNatoujYNmZM/", "2IfMUy5zOuVT1ilWAqZrt9PNbHCY94WGDxwYlYOFZTM=", zzastVar, i, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        View view = this.zzi;
        if (view == null) {
            return;
        }
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcS);
        boolean zBooleanValue = bool.booleanValue();
        Object[] objArr = (Object[]) this.zze.invoke(null, view, this.zzh, bool);
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            try {
                zzastVar.zzc(((Long) objArr[0]).longValue());
                zzastVar.zze(((Long) objArr[1]).longValue());
                if (zBooleanValue) {
                    zzastVar.zzd((String) objArr[2]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
