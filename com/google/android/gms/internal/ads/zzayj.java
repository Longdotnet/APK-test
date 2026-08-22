package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzayj {
    private final zzawx zza;
    private final String zzb;
    private final String zzc;
    private final Class[] zze;
    private volatile Method zzd = null;
    private final CountDownLatch zzf = new CountDownLatch(1);

    public zzayj(zzawx zzawxVar, String str, String str2, Class... clsArr) {
        this.zza = zzawxVar;
        this.zzb = str;
        this.zzc = str2;
        this.zze = clsArr;
        zzawxVar.zzj().submit(new zzayi(this));
    }

    public static /* bridge */ /* synthetic */ void zzb(zzayj zzayjVar) {
        try {
            zzawx zzawxVar = zzayjVar.zza;
            Class<?> clsLoadClass = zzawxVar.zzh().loadClass(zzayjVar.zzc(zzawxVar.zzs(), zzayjVar.zzb));
            if (clsLoadClass != null) {
                zzayjVar.zzd = clsLoadClass.getMethod(zzayjVar.zzc(zzawxVar.zzs(), zzayjVar.zzc), zzayjVar.zze);
            }
        } catch (zzawb | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } finally {
            zzayjVar.zzf.countDown();
        }
    }

    private final String zzc(byte[] bArr, String str) {
        return new String(this.zza.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zzd != null) {
            return this.zzd;
        }
        try {
            if (this.zzf.await(2L, TimeUnit.SECONDS)) {
                return this.zzd;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
