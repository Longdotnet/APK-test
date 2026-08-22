package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqg {
    final /* synthetic */ zzfqi zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    public /* synthetic */ zzfqg(zzfqi zzfqiVar, byte[] bArr, zzfqh zzfqhVar) {
        Objects.requireNonNull(zzfqiVar);
        this.zza = zzfqiVar;
        this.zzb = bArr;
    }

    public final zzfqg zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzfqg zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzfqi zzfqiVar = this.zza;
            if (zzfqiVar.zzb) {
                zzfql zzfqlVar = zzfqiVar.zza;
                zzfqlVar.zzj(this.zzb);
                zzfqlVar.zzi(this.zzc);
                zzfqlVar.zzg(this.zzd);
                zzfqlVar.zzh(null);
                zzfqlVar.zzf();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }
}
