package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.internal.util.client.zzo;

/* JADX INFO: loaded from: classes.dex */
public final class zzdk implements MuteThisAdReason {
    public final String zza;
    public final zzdj zzb;

    public zzdk(zzdj zzdjVar) {
        String strZze;
        this.zzb = zzdjVar;
        try {
            strZze = zzdjVar.zze();
        } catch (RemoteException e) {
            zzo.zzh("", e);
            strZze = null;
        }
        this.zza = strZze;
    }

    public final String toString() {
        return this.zza;
    }
}
