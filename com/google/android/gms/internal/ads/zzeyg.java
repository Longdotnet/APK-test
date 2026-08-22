package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzeyg extends com.google.android.gms.ads.internal.client.zzbw implements com.google.android.gms.ads.internal.overlay.zzr, zzbaq {
    protected zzcom zza;
    private final zzche zzb;
    private final Context zzc;
    private final String zze;
    private final zzeya zzf;
    private final zzexy zzg;
    private final VersionInfoParcel zzh;
    private final zzdsj zzi;
    private zzcnz zzk;
    private AtomicBoolean zzd = new AtomicBoolean();
    private long zzj = -1;

    public zzeyg(zzche zzcheVar, Context context, String str, zzeya zzeyaVar, zzexy zzexyVar, VersionInfoParcel versionInfoParcel, zzdsj zzdsjVar) {
        this.zzb = zzcheVar;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzeyaVar;
        this.zzg = zzexyVar;
        this.zzh = versionInfoParcel;
        this.zzi = zzdsjVar;
        zzexyVar.zzm(this);
    }

    public final synchronized void zzq(int i) {
        try {
            if (this.zzd.compareAndSet(false, true)) {
                this.zzg.zzj();
                zzcnz zzcnzVar = this.zzk;
                if (zzcnzVar != null) {
                    com.google.android.gms.ads.internal.zzv.zza.zzh.zze(zzcnzVar);
                }
                if (this.zza != null) {
                    long jElapsedRealtime = -1;
                    if (this.zzj != -1) {
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        jElapsedRealtime = SystemClock.elapsedRealtime() - this.zzj;
                    }
                    this.zza.zze(jElapsedRealtime, i);
                }
                zzy();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzA() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzB() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzC() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzD(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzE(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzF(com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzG(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzH(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzI(zzbaz zzbazVar) {
        this.zzg.zzo(zzbazVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzJ(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzf.zzl(zzxVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzK(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzL(com.google.android.gms.ads.internal.client.zzeh zzehVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzM(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzN(zzbtz zzbtzVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzO(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzP(zzbdz zzbdzVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzQ(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzR(long j) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzS(zzbuc zzbucVar, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzT(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzU(zzbwi zzbwiVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzV(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzW(com.google.android.gms.ads.internal.client.zzgc zzgcVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzY(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzZ() {
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zza() {
        zzq(3);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzaa() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzab() {
        return this.zzf.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzac() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzad(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        boolean z;
        try {
            if (!zzmVar.zzb()) {
                if (((Boolean) zzbfc.zzd.zze()).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (this.zzh.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlF)).intValue() || !z) {
                    com.google.android.gms.common.internal.zzah.checkMainThread$1("loadAd must be called on the main UI thread.");
                }
            }
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            if (com.google.android.gms.ads.internal.util.zzs.zzI(this.zzc) && zzmVar.zzs == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load the ad because app ID is missing.");
                this.zzg.zzdD(zzfdx.zzd(4, null, null));
                return false;
            }
            if (zzab()) {
                return false;
            }
            this.zzd = new AtomicBoolean();
            return this.zzf.zzb(zzmVar, this.zze, new zzeye(this), new zzeyf(this));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzae(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long zzc() {
        return 0L;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzd() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdk() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdt() {
        if (this.zza != null) {
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            zzvVar.zzl.getClass();
            this.zzj = SystemClock.elapsedRealtime();
            int iZza = this.zza.zza();
            if (iZza > 0) {
                zzcnz zzcnzVar = new zzcnz(this.zzb.zzB(), zzvVar.zzl);
                this.zzk = zzcnzVar;
                zzcnzVar.zzd(iZza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyd
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeyg zzeygVar = this.zza;
                        zzeygVar.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyc
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzq(5);
                            }
                        });
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdv() {
        zzcom zzcomVar = this.zza;
        if (zzcomVar != null) {
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzcomVar.zze(SystemClock.elapsedRealtime() - this.zzj, 1);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw(int i) {
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            zzq(2);
            return;
        }
        if (i2 == 1) {
            zzq(4);
        } else if (i2 != 2) {
            zzq(6);
        } else {
            zzq(3);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zze() {
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzr zzh() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzbk zzj() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzco zzk() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzea zzl() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzed zzm() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzo() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzs() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzt() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzu() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzy() {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("destroy must be called on the main UI thread.");
        zzcom zzcomVar = this.zza;
        if (zzcomVar != null) {
            zzcomVar.zzb();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzz(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
    }
}
