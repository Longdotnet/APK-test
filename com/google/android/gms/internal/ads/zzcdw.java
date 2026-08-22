package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdw extends zzcdn implements zzcbr {
    public static final /* synthetic */ int zzd = 0;
    private zzcbs zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcdf zzi;
    private long zzj;
    private long zzk;

    public zzcdw(zzccb zzccbVar, zzcca zzccaVar) {
        super(zzccbVar);
        zzceo zzceoVar = new zzceo(zzccbVar.getContext(), zzccaVar, (zzccb) this.zzc.get(), null);
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzceoVar;
        zzceoVar.zzL(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void zzb(zzcdw zzcdwVar) throws Throwable {
        String str;
        zzcdw zzcdwVar2;
        zzcdw zzcdwVar3;
        zzcdw zzcdwVar4;
        long j;
        String str2;
        zzcdw zzcdwVar5;
        long j2;
        String strZzc = zzc(zzcdwVar.zzf);
        try {
            zzbcv zzbcvVar = zzbde.zzP;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            long jLongValue = ((Long) zzbdVar.zzd.zzb(zzbcvVar)).longValue() * 1000;
            long jIntValue = ((Integer) zzbdVar.zzd.zzb(zzbde.zzu)).intValue();
            boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzcc)).booleanValue();
            try {
                synchronized (zzcdwVar) {
                    try {
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        if (System.currentTimeMillis() - zzcdwVar.zzj > jLongValue) {
                            throw new IOException("Timeout reached. Limit: " + jLongValue + " ms");
                        }
                        if (zzcdwVar.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!zzcdwVar.zzh) {
                            if (!zzcdwVar.zze.zzV()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long jZzz = zzcdwVar.zze.zzz();
                            if (jZzz > 0) {
                                long jZzv = zzcdwVar.zze.zzv();
                                if (jZzv != zzcdwVar.zzk) {
                                    try {
                                        str2 = strZzc;
                                        try {
                                            zzcdwVar.zzo(zzcdwVar.zzf, strZzc, jZzv, jZzz, jZzv > 0, zBooleanValue ? zzcdwVar.zze.zzA() : -1L, zBooleanValue ? zzcdwVar.zze.zzx() : -1L, zBooleanValue ? zzcdwVar.zze.zzB() : -1L, zzcbs.zzs(), zzcbs.zzu());
                                            zzcdwVar5 = zzcdwVar;
                                            j = jZzv;
                                            try {
                                                zzcdwVar5.zzk = j;
                                                j2 = jZzz;
                                                zzcdwVar5 = zzcdwVar5;
                                            } catch (Throwable th) {
                                                th = th;
                                                str = str2;
                                                zzcdwVar2 = zzcdwVar5;
                                                try {
                                                    throw th;
                                                } catch (Exception e) {
                                                    e = e;
                                                    String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Failed to preload url ", zzcdwVar2.zzf, " Exception: ", e.getMessage());
                                                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzj(strM);
                                                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(e, "VideoStreamExoPlayerCache.preload");
                                                    zzcdwVar.release();
                                                    zzcdwVar2.zzg(zzcdwVar2.zzf, str, "error", zzd("error", e));
                                                    zzcdwVar3 = zzcdwVar2;
                                                    com.google.android.gms.ads.internal.zzv.zza.zzD.zzc(zzcdwVar3.zzi);
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            zzcdwVar5 = zzcdwVar;
                                            str = str2;
                                            zzcdwVar2 = zzcdwVar5;
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str2 = strZzc;
                                        zzcdwVar5 = zzcdwVar;
                                    }
                                } else {
                                    j = jZzv;
                                    str2 = strZzc;
                                    zzcdwVar5 = zzcdwVar;
                                    j2 = jZzz;
                                }
                                if (j >= j2) {
                                    zzcdwVar5.zzj(zzcdwVar5.zzf, str2, j2);
                                    zzcdwVar3 = zzcdwVar5;
                                } else if (zzcdwVar5.zze.zzw() >= jIntValue && j > 0) {
                                    zzcdwVar3 = zzcdwVar5;
                                }
                            } else {
                                zzbdVar = zzbdVar;
                                zzcdwVar4 = zzcdwVar;
                            }
                            zzcdwVar4.zzx(((Long) zzbdVar.zzd.zzb(zzbde.zzQ)).longValue());
                            return;
                        }
                        zzcdwVar3 = zzcdwVar;
                        com.google.android.gms.ads.internal.zzv.zza.zzD.zzc(zzcdwVar3.zzi);
                    } catch (Throwable th4) {
                        th = th4;
                        str = strZzc;
                        zzcdwVar2 = zzcdwVar;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                zzcdwVar2 = zBooleanValue;
            }
        } catch (Exception e2) {
            e = e2;
            str = strZzc;
            zzcdwVar2 = zzcdwVar;
        }
    }

    public static final String zzc(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.zzE(str, "MD5")));
    }

    private static String zzd(String str, Exception exc) {
        return str + "/" + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzx(long j) {
        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdv
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                zzcdw.zzb(this.zza);
            }
        }, j);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcbs zzcbsVar = this.zze;
        if (zzcbsVar != null) {
            zzcbsVar.zzL(null);
            this.zze.zzH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzD(int i, int i2) {
    }

    public final zzcbs zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL(null);
        zzcbs zzcbsVar = this.zze;
        this.zze = null;
        return zzcbsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzi(final boolean z, final long j) {
        final zzccb zzccbVar = (zzccb) this.zzc.get();
        if (zzccbVar != null) {
            zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdu
                @Override // java.lang.Runnable
                public final void run() {
                    zzccbVar.zzv(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzk(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzk("Precache error", exc);
        com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzl(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzk("Precache exception", exc);
        com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzm(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzp(int i) {
        this.zze.zzJ(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzq(int i) {
        this.zze.zzK(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzr(int i) {
        this.zze.zzM(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzs(int i) {
        this.zze.zzN(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzv() {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzw(String str, String[] strArr, zzcdf zzcdfVar) {
        this.zzf = str;
        this.zzi = zzcdfVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzccb zzccbVar = (zzccb) this.zzc.get();
            if (zzccbVar != null) {
                zzccbVar.zzt(strZzc, this);
            }
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            this.zzj = System.currentTimeMillis();
            this.zzk = -1L;
            zzx(0L);
            return true;
        } catch (Exception e) {
            String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(oKjScaD.lXYoeOICYFrZxT, str, " Exception: ", e.getMessage());
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strM);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, strZzc, "error", zzd("error", e));
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.internal.ads.zzccb] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.android.gms.internal.ads.zzcdn, com.google.android.gms.internal.ads.zzcdw] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.google.android.gms.internal.ads.zzcdw] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzcdn] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzu(String str, String[] strArr) throws Throwable {
        ?? r6;
        String str2;
        ?? r5;
        long j;
        ?? r7;
        ?? r8;
        String str3;
        long j2;
        ?? r15 = this;
        ?? r13 = str;
        r15.zzf = r13;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            r15.zze.zzF(uriArr, r15.zzb);
            ?? r0 = (zzccb) r15.zzc.get();
            if (r0 != 0) {
                r0.zzt(strZzc, r15);
            }
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzbcv zzbcvVar = zzbde.zzQ;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            long jLongValue = ((Long) zzbdVar.zzd.zzb(zzbcvVar)).longValue();
            long jLongValue2 = ((Long) zzbdVar.zzd.zzb(zzbde.zzP)).longValue() * 1000;
            long jIntValue = ((Integer) zzbdVar.zzd.zzb(zzbde.zzu)).intValue();
            boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzcc)).booleanValue();
            long j3 = -1;
            long j4 = jIntValue;
            r13 = r13;
            r15 = r15;
            while (true) {
                synchronized (this) {
                    try {
                        if (System.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                            throw new IOException("Timeout reached. Limit: " + jLongValue2 + " ms");
                        }
                        if (r15.zzg) {
                            String str4 = wsbWxekY.sDbiwtMC;
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!r15.zzh) {
                            if (!r15.zze.zzV()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long jZzz = r15.zze.zzz();
                            if (jZzz > 0) {
                                long jZzv = r15.zze.zzv();
                                if (jZzv != j3) {
                                    try {
                                        long j5 = jZzz;
                                        str3 = strZzc;
                                        try {
                                            zzo(str, strZzc, jZzv, j5, jZzv > 0, zBooleanValue ? r15.zze.zzA() : -1L, zBooleanValue ? r15.zze.zzx() : -1L, zBooleanValue ? r15.zze.zzB() : -1L, zzcbs.zzs(), zzcbs.zzu());
                                            j3 = jZzv;
                                            j2 = jZzz;
                                            r7 = j5;
                                        } catch (Throwable th) {
                                            th = th;
                                            r5 = this;
                                            r6 = str;
                                            str2 = str3;
                                            try {
                                                throw th;
                                            } catch (Exception e) {
                                                e = e;
                                                String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Failed to preload url ", (String) r6, " Exception: ", e.getMessage());
                                                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzj(strM);
                                                com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(e, iafHZUfOuHNwvy.gCdxkyGilgBLcS);
                                                release();
                                                r5.zzg(r6, str2, "error", zzd("error", e));
                                                return false;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str3 = strZzc;
                                    }
                                } else {
                                    str3 = strZzc;
                                    j2 = jZzz;
                                    r7 = j4;
                                }
                                r8 = (jZzv > j2 ? 1 : (jZzv == j2 ? 0 : -1));
                                if (r8 >= 0) {
                                    zzj(str, str3, j2);
                                } else {
                                    try {
                                        zzcdw zzcdwVar = this;
                                        r7 = str;
                                        str2 = str3;
                                        if (zzcdwVar.zze.zzw() < j4 || jZzv <= 0) {
                                            r8 = zzcdwVar;
                                            j = j4;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        r5 = r8;
                                        r6 = r7;
                                        throw th;
                                    }
                                }
                            } else {
                                j = j4;
                                jLongValue2 = jLongValue2;
                                r7 = r13;
                                str2 = strZzc;
                                r8 = r15;
                            }
                            try {
                                r8.wait(jLongValue);
                            } catch (InterruptedException unused) {
                                throw new IOException("Wait interrupted.");
                            }
                        }
                        return true;
                    } catch (Throwable th4) {
                        th = th4;
                        r6 = r13;
                        str2 = strZzc;
                        r5 = r15;
                    }
                }
                return true;
                jLongValue = jLongValue;
                r15 = r8;
                r13 = r7;
                strZzc = str2;
                j4 = j;
                jLongValue2 = jLongValue2;
            }
        } catch (Exception e2) {
            e = e2;
            r6 = r13;
            str2 = strZzc;
            r5 = r15;
        }
    }
}
