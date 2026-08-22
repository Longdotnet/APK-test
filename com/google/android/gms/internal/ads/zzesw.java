package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzesw implements zzeuc {
    private final Context zza;
    private final zzgdy zzb;
    private final zzfcw zzc;
    private final VersionInfoParcel zzd;

    public zzesw(Context context, zzgdy zzgdyVar, zzfcw zzfcwVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzgdyVar;
        this.zzc = zzfcwVar;
        this.zzd = versionInfoParcel;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x0047 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007f, B:18:0x0091, B:20:0x00a5, B:22:0x00ae, B:27:0x00d0, B:29:0x00ec, B:30:0x0110, B:32:0x011b, B:25:0x00c0, B:13:0x0047), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0059 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007f, B:18:0x0091, B:20:0x00a5, B:22:0x00ae, B:27:0x00d0, B:29:0x00ec, B:30:0x0110, B:32:0x011b, B:25:0x00c0, B:13:0x0047), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x00c0 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007f, B:18:0x0091, B:20:0x00a5, B:22:0x00ae, B:27:0x00d0, B:29:0x00ec, B:30:0x0110, B:32:0x011b, B:25:0x00c0, B:13:0x0047), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00d0 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007f, B:18:0x0091, B:20:0x00a5, B:22:0x00ae, B:27:0x00d0, B:29:0x00ec, B:30:0x0110, B:32:0x011b, B:25:0x00c0, B:13:0x0047), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ec A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:10:0x0033, B:15:0x0059, B:16:0x007f, B:18:0x0091, B:20:0x00a5, B:22:0x00ae, B:27:0x00d0, B:29:0x00ec, B:30:0x0110, B:32:0x011b, B:25:0x00c0, B:13:0x0047), top: B:36:0x0000 }] */
    public static zzesx zzc(zzesw zzeswVar) {
        zzfsa zzfsaVar;
        boolean z;
        boolean zZze;
        zzfsf zzfsfVarZzi;
        zzfsb zzfsbVarZza;
        try {
            Context context = zzeswVar.zza;
            boolean zZza = zzeswVar.zzc.zza();
            zzfsa zzfsaVar2 = new zzfsa();
            zzfsa zzfsaVar3 = new zzfsa();
            boolean zZzd = true;
            if (zZza) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzds)).booleanValue()) {
                    return new zzesx(true);
                }
            }
            if (!zZza) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdo)).booleanValue()) {
                    zzfsaVar2 = zzfse.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdz)).longValue(), ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzN());
                } else if (zZza) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdq)).booleanValue()) {
                        zzfsaVar2 = zzfse.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdz)).longValue(), ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzN());
                    }
                }
            } else if (zZza) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdq)).booleanValue()) {
                    zzfsaVar2 = zzfse.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdz)).longValue(), ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzN());
                }
            }
            zzbcv zzbcvVar = zzbde.zzdw;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                if (zzeswVar.zzd.clientJarVersion < ((Integer) zzbdVar.zzd.zzb(zzbde.zzdv)).intValue()) {
                    zzfsf.zzi(context).zzj();
                }
            }
            if (zZza) {
                if (zZza) {
                    if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzdr)).booleanValue()) {
                        zzfsfVarZzi = zzfsf.zzi(context);
                        zzfsbVarZza = zzfsb.zza(context);
                        if (zzeswVar.zzd.clientJarVersion >= ((Integer) zzbdVar.zzd.zzb(zzbde.zzdv)).intValue()) {
                            zzfsaVar3 = zzfsfVarZzi.zzh(((Long) zzbdVar.zzd.zzb(zzbde.zzdA)).longValue(), ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzN());
                            zZzd = zzfsbVarZza.zzd();
                        }
                        zZze = zzfsbVarZza.zze();
                        zzfsaVar = zzfsaVar3;
                        z = zZzd;
                    }
                }
                zzfsaVar = zzfsaVar3;
                z = true;
                zZze = true;
            } else {
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzdp)).booleanValue()) {
                    zzfsfVarZzi = zzfsf.zzi(context);
                    zzfsbVarZza = zzfsb.zza(context);
                    if (zzeswVar.zzd.clientJarVersion >= ((Integer) zzbdVar.zzd.zzb(zzbde.zzdv)).intValue()) {
                        zzfsaVar3 = zzfsfVarZzi.zzh(((Long) zzbdVar.zzd.zzb(zzbde.zzdA)).longValue(), ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzN());
                        zZzd = zzfsbVarZza.zzd();
                    }
                    zZze = zzfsbVarZza.zze();
                    zzfsaVar = zzfsaVar3;
                    z = zZzd;
                } else {
                    if (zZza) {
                        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzdr)).booleanValue()) {
                            zzfsfVarZzi = zzfsf.zzi(context);
                            zzfsbVarZza = zzfsb.zza(context);
                            if (zzeswVar.zzd.clientJarVersion >= ((Integer) zzbdVar.zzd.zzb(zzbde.zzdv)).intValue()) {
                                zzfsaVar3 = zzfsfVarZzi.zzh(((Long) zzbdVar.zzd.zzb(zzbde.zzdA)).longValue(), ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzN());
                                zZzd = zzfsbVarZza.zzd();
                            }
                            zZze = zzfsbVarZza.zze();
                            zzfsaVar = zzfsaVar3;
                            z = zZzd;
                        }
                    }
                    zzfsaVar = zzfsaVar3;
                    z = true;
                    zZze = true;
                }
            }
            return new zzesx(zzfsaVar2, zzfsaVar, z, zZze, zZza);
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "PerAppIdSignal");
            return new zzesx(zzeswVar.zzc.zza());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 53;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesv
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzesw.zzc(this.zza);
            }
        });
    }
}
