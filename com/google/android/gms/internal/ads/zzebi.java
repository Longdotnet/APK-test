package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzebi implements zzfhb {
    private final zzeaw zza;
    private final zzeba zzb;

    public zzebi(zzeaw zzeawVar, zzeba zzebaVar) {
        this.zza = zzeawVar;
        this.zzb = zzebaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzd(zzfgu zzfguVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgv)).booleanValue() && zzfgu.RENDERER == zzfguVar) {
            zzeaw zzeawVar = this.zza;
            if (zzeawVar.zzc() != 0) {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                zzeawVar.zzf(SystemClock.elapsedRealtime() - zzeawVar.zzc());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdE(zzfgu zzfguVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdF(zzfgu zzfguVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgv)).booleanValue() && zzfgu.RENDERER == zzfguVar) {
            zzeaw zzeawVar = this.zza;
            if (zzeawVar.zzc() != 0) {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                zzeawVar.zzf(SystemClock.elapsedRealtime() - zzeawVar.zzc());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdG(zzfgu zzfguVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgv)).booleanValue()) {
            if (zzfgu.RENDERER == zzfguVar) {
                zzeaw zzeawVar = this.zza;
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                zzeawVar.zzg(SystemClock.elapsedRealtime());
            } else if (zzfgu.PRELOADED_LOADER == zzfguVar || zzfgu.SERVER_TRANSACTION == zzfguVar) {
                zzeaw zzeawVar2 = this.zza;
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                zzeawVar2.zzh(SystemClock.elapsedRealtime());
                final zzeba zzebaVar = this.zzb;
                final long jZzd = zzeawVar2.zzd();
                zzebaVar.zza.zza(new zzfge() { // from class: com.google.android.gms.internal.ads.zzeaz
                    @Override // com.google.android.gms.internal.ads.zzfge
                    public final Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzebaVar.zzf()) {
                            return null;
                        }
                        long j = jZzd;
                        zzbcj.zzaf.zza.C0003zza c0003zzaZzn = zzbcj.zzaf.zza.zzn();
                        c0003zzaZzn.zzP(j);
                        byte[] bArrZzaV = c0003zzaZzn.zzbr().zzaV();
                        zzebh.zzf(sQLiteDatabase, false, false);
                        zzebh.zzc(sQLiteDatabase, j, bArrZzaV);
                        return null;
                    }
                });
            }
        }
    }
}
