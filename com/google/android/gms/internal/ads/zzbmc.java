package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmc implements zzapw {
    private volatile zzblp zza;
    private final Context zzb;

    public zzbmc(Context context) {
        this.zzb = context;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzbmc zzbmcVar) {
        if (zzbmcVar.zza == null) {
            return;
        }
        zzbmcVar.zza.disconnect();
        Binder.flushPendingCommands();
    }

    @Override // com.google.android.gms.internal.ads.zzapw
    public final zzapz zza(zzaqd zzaqdVar) throws zzaqm {
        Parcelable.Creator<zzblq> creator = zzblq.CREATOR;
        Map mapZzl = zzaqdVar.zzl();
        int size = mapZzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry entry : mapZzl.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr2[i] = (String) entry.getValue();
            i++;
        }
        zzblq zzblqVar = new zzblq(zzaqdVar.zzk(), strArr, strArr2);
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar.zzl.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            zzcak zzcakVar = new zzcak();
            this.zza = new zzblp(this.zzb, zzvVar.zzu.zzb(), new zzbma(this, zzcakVar), new zzbmb(this, zzcakVar));
            this.zza.checkAvailabilityAndConnect();
            zzbly zzblyVar = new zzbly(this, zzblqVar);
            zzgdy zzgdyVar = zzcaf.zza;
            ListenableFuture listenableFutureZzo = zzgdn.zzo(zzgdn.zzn(zzcakVar, zzblyVar, zzgdyVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeL)).intValue(), TimeUnit.MILLISECONDS, zzcaf.zzd);
            listenableFutureZzo.addListener(new zzblz(this), zzgdyVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) listenableFutureZzo.get();
            zzvVar.zzl.getClass();
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
            zzbls zzblsVar = (zzbls) new zzbvo(parcelFileDescriptor).zza(zzbls.CREATOR);
            if (zzblsVar == null) {
                return null;
            }
            if (zzblsVar.zza) {
                throw new zzaqm(zzblsVar.zzb);
            }
            String[] strArr3 = zzblsVar.zze;
            String[] strArr4 = zzblsVar.zzf;
            if (strArr3.length != strArr4.length) {
                return null;
            }
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < strArr3.length; i2++) {
                map.put(strArr3[i2], strArr4[i2]);
            }
            return new zzapz(zzblsVar.zzc, zzblsVar.zzd, map, zzblsVar.zzg, zzblsVar.zzh);
        } catch (InterruptedException | ExecutionException unused) {
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
            throw th;
        }
    }
}
