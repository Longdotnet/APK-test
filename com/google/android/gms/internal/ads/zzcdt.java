package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdt extends zzcdn implements zzhj {
    private static final AtomicInteger zzd = new AtomicInteger(0);
    private String zze;
    private final zzcca zzf;
    private boolean zzg;
    private final zzcds zzh;
    private final zzccx zzi;
    private ByteBuffer zzj;
    private boolean zzk;
    private final Object zzl;
    private final String zzm;
    private final int zzn;
    private boolean zzo;

    public zzcdt(zzccb zzccbVar, zzcca zzccaVar) {
        super(zzccbVar);
        this.zzf = zzccaVar;
        this.zzh = new zzcds();
        this.zzi = new zzccx();
        this.zzl = new Object();
        this.zzm = (String) zzfvn.zzd(zzccbVar != null ? zzccbVar.zzr() : null).zzb("");
        this.zzn = zzccbVar != null ? zzccbVar.zzf() : 0;
        zzd.incrementAndGet();
    }

    public static int zzi() {
        return zzd.get();
    }

    public static final String zzv(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.zzE(str, "MD5")));
    }

    private final void zzx() {
        int iZza = (int) this.zzh.zza();
        int iZza2 = (int) this.zzi.zza(this.zzj);
        int iPosition = this.zzj.position();
        int iRound = Math.round((iPosition / iZza) * iZza2);
        int iZzs = zzcbs.zzs();
        int iZzu = zzcbs.zzu();
        String str = this.zze;
        zzn(str, zzv(str), iPosition, iZza, iRound, iZza2, iRound > 0, iZzs, iZzu);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzd.decrementAndGet();
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zza(zzgj zzgjVar, zzgo zzgoVar, boolean z, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzb(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzc(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzd(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
        if (zzgjVar instanceof zzgw) {
            this.zzh.zzb((zzgw) zzgjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzf() {
        this.zzg = true;
    }

    public final String zzk() {
        return this.zze;
    }

    public final ByteBuffer zzl() {
        synchronized (this.zzl) {
            try {
                ByteBuffer byteBuffer = this.zzj;
                if (byteBuffer != null && !this.zzk) {
                    byteBuffer.flip();
                    this.zzk = true;
                }
                this.zzg = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.zzj;
    }

    public final boolean zzm() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzt(String str) {
        this.zze = str;
        String strZzv = zzv(str);
        try {
            zzgr zzgrVar = new zzgr();
            zzgrVar.zzf(this.zzb);
            zzcca zzccaVar = this.zzf;
            zzgrVar.zzc(zzccaVar.zzd);
            zzgrVar.zzd(zzccaVar.zze);
            boolean z = true;
            zzgrVar.zzb(true);
            zzgrVar.zze(this);
            zzgj zzgjVarZza = zzgrVar.zza();
            if (zzccaVar.zzi) {
                zzgjVarZza = new zzccv(this.zza, zzgjVarZza, this.zzm, this.zzn, null, null);
            }
            zzgjVarZza.zzb(new zzgo(Uri.parse(str), 0L, -1L, null));
            zzccb zzccbVar = (zzccb) this.zzc.get();
            if (zzccbVar != null) {
                zzccbVar.zzt(strZzv, this);
            }
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzbcv zzbcvVar = zzbde.zzQ;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            long jLongValue = ((Long) zzbdVar.zzd.zzb(zzbcvVar)).longValue();
            long jLongValue2 = ((Long) zzbdVar.zzd.zzb(zzbde.zzP)).longValue();
            this.zzj = ByteBuffer.allocate(zzccaVar.zzc);
            int i = 8192;
            byte[] bArr = new byte[8192];
            long j = jCurrentTimeMillis;
            while (true) {
                int iZza = zzgjVarZza.zza(bArr, 0, Math.min(this.zzj.remaining(), i));
                if (iZza == -1) {
                    this.zzo = z;
                    zzj(str, strZzv, (int) this.zzi.zza(this.zzj));
                    return z;
                }
                synchronized (this.zzl) {
                    try {
                        if (!this.zzg) {
                            this.zzj.put(bArr, 0, iZza);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (this.zzj.remaining() <= 0) {
                    zzx();
                    return true;
                }
                if (this.zzg) {
                    throw new IOException("Precache abort at " + this.zzj.limit() + " bytes");
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 - j >= jLongValue) {
                    zzx();
                    j = jCurrentTimeMillis2;
                }
                if (jCurrentTimeMillis2 - jCurrentTimeMillis > 1000 * jLongValue2) {
                    throw new IOException("Timeout exceeded. Limit: " + jLongValue2 + " sec");
                }
                z = true;
                i = 8192;
            }
        } catch (Exception e) {
            String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(e.getClass().getCanonicalName(), ":", e.getMessage());
            String strM2 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Failed to preload url ", str, " Exception: ", strM);
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strM2);
            zzg(str, strZzv, "error", strM);
            return false;
        }
    }
}
