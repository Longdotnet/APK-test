package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzelj {
    private final zzelo zza;
    private final String zzb;
    private com.google.android.gms.ads.internal.client.zzea zzc;

    public zzelj(zzelo zzeloVar, String str) {
        this.zza = zzeloVar;
        this.zzb = str;
    }

    public final synchronized String zza() {
        com.google.android.gms.ads.internal.client.zzea zzeaVar;
        try {
            zzeaVar = this.zzc;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return zzeaVar != null ? zzeaVar.zzg() : null;
    }

    public final synchronized String zzb() {
        com.google.android.gms.ads.internal.client.zzea zzeaVar;
        try {
            zzeaVar = this.zzc;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return zzeaVar != null ? zzeaVar.zzg() : null;
    }

    public final synchronized void zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, int i) {
        this.zzc = null;
        zzelp zzelpVar = new zzelp(i);
        zzeli zzeliVar = new zzeli(this);
        this.zza.zzb(zzmVar, this.zzb, zzelpVar, zzeliVar);
    }

    public final synchronized boolean zze() {
        return this.zza.zza();
    }
}
