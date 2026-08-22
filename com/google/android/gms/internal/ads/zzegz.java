package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
final class zzegz implements zzgdj {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfcd zzb;
    final /* synthetic */ zzfca zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfju zze;
    final /* synthetic */ zzfcn zzf;
    final /* synthetic */ zzehb zzg;

    public zzegz(zzehb zzehbVar, long j, zzfcd zzfcdVar, zzfca zzfcaVar, String str, zzfju zzfjuVar, zzfcn zzfcnVar) {
        this.zza = j;
        this.zzb = zzfcdVar;
        this.zzc = zzfcaVar;
        this.zzd = str;
        this.zze = zzfjuVar;
        this.zzf = zzfcnVar;
        Objects.requireNonNull(zzehbVar);
        this.zzg = zzehbVar;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0067 A[PHI: r8
  0x0067: PHI (r8v1 int) = (r8v0 int), (r8v3 int), (r8v3 int), (r8v3 int) binds: [B:16:0x0034, B:21:0x004f, B:23:0x0053, B:25:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x0070 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:30:0x006a, B:32:0x0070, B:34:0x007c, B:38:0x0084, B:39:0x008c, B:41:0x009e, B:42:0x00b3, B:44:0x00b9, B:46:0x00bb, B:54:0x00f9, B:55:0x0100, B:49:0x00de, B:51:0x00e2, B:53:0x00ec), top: B:59:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:34:0x007c A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:30:0x006a, B:32:0x0070, B:34:0x007c, B:38:0x0084, B:39:0x008c, B:41:0x009e, B:42:0x00b3, B:44:0x00b9, B:46:0x00bb, B:54:0x00f9, B:55:0x0100, B:49:0x00de, B:51:0x00e2, B:53:0x00ec), top: B:59:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:41:0x009e A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:30:0x006a, B:32:0x0070, B:34:0x007c, B:38:0x0084, B:39:0x008c, B:41:0x009e, B:42:0x00b3, B:44:0x00b9, B:46:0x00bb, B:54:0x00f9, B:55:0x0100, B:49:0x00de, B:51:0x00e2, B:53:0x00ec), top: B:59:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b9 A[Catch: all -> 0x0081, DONT_GENERATE, TryCatch #0 {all -> 0x0081, blocks: (B:30:0x006a, B:32:0x0070, B:34:0x007c, B:38:0x0084, B:39:0x008c, B:41:0x009e, B:42:0x00b3, B:44:0x00b9, B:46:0x00bb, B:54:0x00f9, B:55:0x0100, B:49:0x00de, B:51:0x00e2, B:53:0x00ec), top: B:59:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00bb A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:30:0x006a, B:32:0x0070, B:34:0x007c, B:38:0x0084, B:39:0x008c, B:41:0x009e, B:42:0x00b3, B:44:0x00b9, B:46:0x00bb, B:54:0x00f9, B:55:0x0100, B:49:0x00de, B:51:0x00e2, B:53:0x00ec), top: B:59:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:59:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        Integer numValueOf;
        int i;
        com.google.android.gms.ads.internal.client.zze zzeVarZzb;
        com.google.android.gms.ads.internal.client.zze zzeVarZza;
        int i2;
        com.google.android.gms.ads.internal.client.zze zzeVar;
        zzehb zzehbVar = this.zzg;
        ((DefaultClock) zzehbVar.zza).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.zza;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzegj) {
            i = 3;
        } else {
            if (!(th instanceof CancellationException)) {
                if (th instanceof zzfdd) {
                    i = 5;
                } else {
                    int i3 = 6;
                    if (th instanceof zzdwm) {
                        i3 = zzfdx.zza(th).zza == 3 ? 1 : 6;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbO)).booleanValue() && (th instanceof zzedq) && (zzeVarZzb = ((zzedq) th).zzb()) != null) {
                            numValueOf = Integer.valueOf(zzeVarZzb.zza);
                        } else {
                            numValueOf = null;
                        }
                    } else {
                        numValueOf = null;
                    }
                    i = i3;
                }
                synchronized (zzehbVar) {
                    try {
                        if (zzehbVar.zze) {
                            zzehbVar.zzb.zza(this.zzb, this.zzc, i, th instanceof zzedq ? (zzedq) th : null, jElapsedRealtime);
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziK)).booleanValue()) {
                            zzfjy zzfjyVar = zzehbVar.zzc;
                            zzfju zzfjuVar = this.zze;
                            zzfcn zzfcnVar = this.zzf;
                            zzfca zzfcaVar = this.zzc;
                            zzfjyVar.zze(zzfjuVar.zzd(zzfcnVar, zzfcaVar, zzfcaVar.zzn), zzfcaVar.zzax);
                        }
                        if (zzehbVar.zzg) {
                            return;
                        }
                        LinkedHashMap linkedHashMap = zzehbVar.zzd;
                        zzfca zzfcaVar2 = this.zzc;
                        linkedHashMap.put(zzfcaVar2, new zzeha(this.zzd, zzfcaVar2.zzaf, i, jElapsedRealtime, numValueOf));
                        zzeVarZza = zzfdx.zza(th);
                        i2 = zzeVarZza.zza;
                        if ((i2 != 3 || i2 == 0) && (zzeVar = zzeVarZza.zzd) != null && !zzeVar.zzc.equals("com.google.android.gms.ads")) {
                        }
                        zzehbVar.zzf.zzf(zzfcaVar2, jElapsedRealtime, zzeVarZza);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            i = 4;
        }
        numValueOf = null;
        synchronized (zzehbVar) {
            if (zzehbVar.zze) {
                zzehbVar.zzb.zza(this.zzb, this.zzc, i, th instanceof zzedq ? (zzedq) th : null, jElapsedRealtime);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziK)).booleanValue()) {
                zzfjy zzfjyVar2 = zzehbVar.zzc;
                zzfju zzfjuVar2 = this.zze;
                zzfcn zzfcnVar2 = this.zzf;
                zzfca zzfcaVar3 = this.zzc;
                zzfjyVar2.zze(zzfjuVar2.zzd(zzfcnVar2, zzfcaVar3, zzfcaVar3.zzn), zzfcaVar3.zzax);
            }
            if (zzehbVar.zzg) {
                return;
            }
            LinkedHashMap linkedHashMap2 = zzehbVar.zzd;
            zzfca zzfcaVar4 = this.zzc;
            linkedHashMap2.put(zzfcaVar4, new zzeha(this.zzd, zzfcaVar4.zzaf, i, jElapsedRealtime, numValueOf));
            zzeVarZza = zzfdx.zza(th);
            i2 = zzeVarZza.zza;
            zzeVarZza = i2 != 3 ? zzfdx.zza(new zzedq(13, zzeVarZza.zzd)) : zzfdx.zza(new zzedq(13, zzeVarZza.zzd));
            zzehbVar.zzf.zzf(zzfcaVar4, jElapsedRealtime, zzeVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        zzehb zzehbVar = this.zzg;
        ((DefaultClock) zzehbVar.zza).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.zza;
        synchronized (zzehbVar) {
            try {
                if (zzehbVar.zze) {
                    zzehbVar.zzb.zza(this.zzb, this.zzc, 0, null, jElapsedRealtime);
                }
                if (zzehbVar.zzg) {
                    return;
                }
                zzfca zzfcaVar = this.zzc;
                if (zzehbVar.zzq(zzfcaVar)) {
                    ((zzeha) zzehbVar.zzd.get(zzfcaVar)).zzd = jElapsedRealtime;
                } else {
                    zzehbVar.zzd.put(zzfcaVar, new zzeha(this.zzd, zzfcaVar.zzaf, 0, jElapsedRealtime, null));
                }
                zzehbVar.zzf.zzg(zzfcaVar, jElapsedRealtime, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
