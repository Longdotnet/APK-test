package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class zzfcw {
    public final com.google.android.gms.ads.internal.client.zzgc zza;
    public final zzbmp zzb;
    public final zzeky zzc;
    public final com.google.android.gms.ads.internal.client.zzm zzd;
    public final com.google.android.gms.ads.internal.client.zzr zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbge zzi;
    public final com.google.android.gms.ads.internal.client.zzx zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final com.google.android.gms.ads.internal.client.zzco zzn;
    public final zzfcj zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final Bundle zzs;
    public final AtomicLong zzt;
    public final com.google.android.gms.ads.internal.client.zzcs zzu;

    public zzfcw(zzfcu zzfcuVar, zzfcv zzfcvVar) {
        this.zze = zzfcuVar.zzb;
        this.zzf = zzfcuVar.zzc;
        this.zzu = zzfcuVar.zzv;
        int i = zzfcuVar.zza.zza;
        long j = zzfcuVar.zza.zzb;
        Bundle bundle = zzfcuVar.zza.zzc;
        int i2 = zzfcuVar.zza.zzd;
        List list = zzfcuVar.zza.zze;
        boolean z = zzfcuVar.zza.zzf;
        int i3 = zzfcuVar.zza.zzg;
        boolean z2 = true;
        if (!zzfcuVar.zza.zzh && !zzfcuVar.zze) {
            z2 = false;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = new com.google.android.gms.ads.internal.client.zzm(i, j, bundle, i2, list, z, i3, z2, zzfcuVar.zza.zzi, zzfcuVar.zza.zzj, zzfcuVar.zza.zzk, zzfcuVar.zza.zzl, zzfcuVar.zza.zzm, zzfcuVar.zza.zzn, zzfcuVar.zza.zzo, zzfcuVar.zza.zzp, zzfcuVar.zza.zzq, zzfcuVar.zza.zzr, zzfcuVar.zza.zzs, zzfcuVar.zza.zzt, zzfcuVar.zza.zzu, zzfcuVar.zza.zzv, com.google.android.gms.ads.internal.util.zzs.zza(zzfcuVar.zza.zzw), zzfcuVar.zza.zzx, zzfcuVar.zza.zzy, zzfcuVar.zza.zzz, zzfcuVar.zza.zzA);
        this.zzd = zzmVar;
        this.zza = zzfcuVar.zzd != null ? zzfcuVar.zzd : zzfcuVar.zzh != null ? zzfcuVar.zzh.zzf : null;
        this.zzg = zzfcuVar.zzf;
        this.zzh = zzfcuVar.zzg;
        this.zzi = zzfcuVar.zzf == null ? null : zzfcuVar.zzh == null ? new zzbge(new NativeAdOptions(new NativeAdOptions.Builder())) : zzfcuVar.zzh;
        this.zzj = zzfcuVar.zzi;
        this.zzk = zzfcuVar.zzm;
        this.zzl = zzfcuVar.zzj;
        this.zzm = zzfcuVar.zzk;
        this.zzn = zzfcuVar.zzl;
        this.zzb = zzfcuVar.zzn;
        this.zzo = new zzfcj(zzfcuVar.zzo, null);
        this.zzp = zzfcuVar.zzp;
        this.zzq = zzfcuVar.zzq;
        this.zzc = zzfcuVar.zzr;
        this.zzr = zzfcuVar.zzs;
        this.zzs = zzfcuVar.zzt;
        long j2 = zzmVar.zzA;
        if (j2 != 0) {
            this.zzt = new AtomicLong(j2);
        } else {
            this.zzt = zzfcuVar.zzu;
        }
    }

    public final boolean zza() {
        return this.zzf.matches((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdx));
    }
}
