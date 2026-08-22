package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmq implements zzfmj {
    private static zzfmq zza;
    private float zzb = 0.0f;
    private zzfme zzc;
    private zzfmi zzd;

    public zzfmq(zzfmf zzfmfVar, zzfmb zzfmbVar) {
    }

    public static zzfmq zzb() {
        if (zza == null) {
            zza = new zzfmq(new zzfmf(), new zzfmb());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfmj
    public final void zzc(boolean z) {
        if (z) {
            zzfns.zzd().zzi();
        } else {
            zzfns.zzd().zzh();
        }
    }

    public final void zzd(Context context) {
        this.zzc = new zzfme(new Handler(), context, new zzfma(), this);
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzd == null) {
            this.zzd = zzfmi.zza();
        }
        Iterator it = this.zzd.zzb().iterator();
        while (it.hasNext()) {
            ((zzflp) it.next()).zzg().zzl(f);
        }
    }

    public final void zzf() {
        zzfmh.zza().zze(this);
        zzfmh.zza().zzf();
        zzfns.zzd().zzi();
        this.zzc.zze();
    }

    public final void zzg() {
        zzfns.zzd().zzj();
        zzfmh.zza().zzg();
        this.zzc.zzf();
    }
}
