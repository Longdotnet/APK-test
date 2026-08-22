package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.util.Hex;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class zzceb extends zzgc {
    private final Context zza;
    private final zzgj zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbbo zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private ListenableFuture zzo;
    private final AtomicLong zzp;
    private final zzcel zzq;

    public zzceb(Context context, zzgj zzgjVar, String str, int i, zzhj zzhjVar, zzcel zzcelVar) {
        super(false);
        this.zza = context;
        this.zzb = zzgjVar;
        this.zzq = zzcelVar;
        this.zzc = str;
        this.zzd = i;
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = 0L;
        this.zzp = new AtomicLong(-1L);
        this.zzo = null;
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcc)).booleanValue();
        zzf(zzhjVar);
    }

    public static Long zzm(zzceb zzcebVar) {
        return Long.valueOf(com.google.android.gms.ads.internal.zzv.zza.zzk.zza(zzcebVar.zzi));
    }

    private final boolean zzr() {
        if (!this.zze) {
            return false;
        }
        zzbcv zzbcvVar = zzbde.zzeG;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() || this.zzl) {
            return ((Boolean) zzbdVar.zzd.zzb(zzbde.zzeH)).booleanValue() && !this.zzm;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed GcacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        int iZza = inputStream != null ? inputStream.read(bArr, i, i2) : this.zzb.zza(bArr, i, i2);
        if (!this.zze || this.zzf != null) {
            zzg(iZza);
        }
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.ads.internal.zzv] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) throws Throwable {
        zzbbl zzbblVarZzb;
        Long l;
        boolean z;
        boolean z2;
        long jElapsedRealtime;
        StringBuilder sb;
        zzgo zzgoVarZze = zzgoVar;
        if (this.zzg) {
            throw new IOException("Attempt to open an already open GcacheDataSource.");
        }
        ?? r4 = 1;
        this.zzg = true;
        Uri uri = zzgoVarZze.zza;
        this.zzh = uri;
        boolean z3 = this.zze;
        if (!z3) {
            zzj(zzgoVar);
        }
        this.zzi = zzbbo.zza(uri);
        zzbcv zzbcvVar = zzbde.zzeD;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzgoVarZze.zze;
                this.zzi.zzi = zzfwg.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbblVarZzb = com.google.android.gms.ads.internal.zzv.zza.zzk.zzb(this.zzi);
            } else {
                zzbblVarZzb = null;
            }
            if (zzbblVarZzb != null && zzbblVarZzb.zze()) {
                this.zzj = zzbblVarZzb.zzd();
                this.zzl = zzbblVarZzb.zzg();
                this.zzm = zzbblVarZzb.zzf();
                this.zzn = zzbblVarZzb.zza();
                this.zzk = true;
                if (!zzr()) {
                    this.zzf = zzbblVarZzb.zzc();
                    if (!this.zze) {
                        return -1L;
                    }
                    zzj(zzgoVar);
                    return -1L;
                }
            }
        } else if (this.zzi != null) {
            this.zzi.zzh = zzgoVarZze.zze;
            this.zzi.zzi = zzfwg.zzc(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l = (Long) zzbdVar.zzd.zzb(zzbde.zzeF);
            } else {
                l = (Long) zzbdVar.zzd.zzb(zzbde.zzeE);
            }
            long jLongValue = l.longValue();
            ?? r5 = com.google.android.gms.ads.internal.zzv.zza;
            r5.zzl.getClass();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            Future futureZza = zzbbz.zza(this.zza, this.zzi);
            try {
                try {
                    zzbca zzbcaVar = (zzbca) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                    try {
                        this.zzj = zzbcaVar.zzd();
                        this.zzl = zzbcaVar.zzf();
                        this.zzm = zzbcaVar.zze();
                        this.zzn = zzbcaVar.zza();
                        if (!zzr()) {
                            this.zzf = zzbcaVar.zzc();
                            if (z3) {
                                zzj(zzgoVar);
                            }
                            r5.zzl.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                            zzceo.zzab(this.zzq.zza, true, jElapsedRealtime3);
                            this.zzk = true;
                            com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime3 + "ms");
                            return -1L;
                        }
                        r5.zzl.getClass();
                        long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        zzceo.zzab(this.zzq.zza, true, jElapsedRealtime4);
                        this.zzk = true;
                        sb = new StringBuilder("Cache connection took ");
                        sb.append(jElapsedRealtime4);
                    } catch (InterruptedException unused) {
                        z2 = true;
                        futureZza.cancel(true);
                        Thread.currentThread().interrupt();
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        zzceo.zzab(this.zzq.zza, z2, jElapsedRealtime);
                        this.zzk = z2;
                        sb = new StringBuilder("Cache connection took ");
                        r5 = z2;
                        sb.append(jElapsedRealtime);
                    } catch (ExecutionException | TimeoutException unused2) {
                        z = true;
                        futureZza.cancel(true);
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        zzceo.zzab(this.zzq.zza, z, jElapsedRealtime);
                        this.zzk = z;
                        sb = new StringBuilder("Cache connection took ");
                        r5 = z;
                        sb.append(jElapsedRealtime);
                    } catch (Throwable th) {
                        th = th;
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        zzceo.zzab(this.zzq.zza, r4, jElapsedRealtime5);
                        this.zzk = r4;
                        com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime5 + "ms");
                        throw th;
                    }
                } catch (InterruptedException unused3) {
                    z2 = false;
                } catch (ExecutionException | TimeoutException unused4) {
                    z = false;
                } catch (Throwable th2) {
                    th = th2;
                    r4 = 0;
                }
                sb.append("ms");
                com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
            } catch (Throwable th3) {
                th = th3;
                r4 = r5;
            }
        }
        this.zzk = false;
        if (this.zzi != null) {
            zzgm zzgmVarZza = zzgoVar.zza();
            zzgmVarZza.zzd(Uri.parse(this.zzi.zza));
            zzgoVarZze = zzgmVarZza.zze();
        }
        return this.zzb.zzb(zzgoVarZze);
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed GcacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        boolean z = (this.zze && this.zzf == null) ? false : true;
        InputStream inputStream = this.zzf;
        if (inputStream != null) {
            Hex.closeQuietly(inputStream);
            this.zzf = null;
        } else {
            this.zzb.zzd();
        }
        if (z) {
            zzh();
        }
    }

    public final long zzk() {
        return this.zzn;
    }

    public final long zzl() {
        if (this.zzi != null) {
            AtomicLong atomicLong = this.zzp;
            if (atomicLong.get() != -1) {
                return atomicLong.get();
            }
            synchronized (this) {
                try {
                    if (this.zzo == null) {
                        this.zzo = zzcaf.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcea
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return zzceb.zzm(this.zza);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.zzo.isDone()) {
                try {
                    this.zzp.compareAndSet(-1L, ((Long) this.zzo.get()).longValue());
                    return this.zzp.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
        }
        return -1L;
    }

    public final boolean zzn() {
        return this.zzj;
    }

    public final boolean zzo() {
        return this.zzm;
    }

    public final boolean zzp() {
        return this.zzl;
    }

    public final boolean zzq() {
        return this.zzk;
    }
}
