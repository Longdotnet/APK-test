package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdbu {
    private final Set zza = new HashSet();
    private final Set zzb = new HashSet();
    private final Set zzc = new HashSet();
    private final Set zzd = new HashSet();
    private final Set zze = new HashSet();
    private final Set zzf = new HashSet();
    private final Set zzg = new HashSet();
    private final Set zzh = new HashSet();
    private final Set zzi = new HashSet();
    private final Set zzj = new HashSet();
    private final Set zzk = new HashSet();
    private final Set zzl = new HashSet();
    private final Set zzm = new HashSet();
    private final Set zzn = new HashSet();
    private zzezo zzo;

    public final zzdbu zza(com.google.android.gms.ads.internal.client.zza zzaVar, Executor executor) {
        this.zzc.add(new zzddv(zzaVar, executor));
        return this;
    }

    public final zzdbu zzb(zzcwb zzcwbVar, Executor executor) {
        this.zzi.add(new zzddv(zzcwbVar, executor));
        return this;
    }

    public final zzdbu zzc(zzcwo zzcwoVar, Executor executor) {
        this.zzl.add(new zzddv(zzcwoVar, executor));
        return this;
    }

    public final zzdbu zzd(zzcws zzcwsVar, Executor executor) {
        this.zzf.add(new zzddv(zzcwsVar, executor));
        return this;
    }

    public final zzdbu zze(zzcvy zzcvyVar, Executor executor) {
        this.zze.add(new zzddv(zzcvyVar, executor));
        return this;
    }

    public final zzdbu zzf(zzcxm zzcxmVar, Executor executor) {
        this.zzh.add(new zzddv(zzcxmVar, executor));
        return this;
    }

    public final zzdbu zzg(zzcxx zzcxxVar, Executor executor) {
        this.zzg.add(new zzddv(zzcxxVar, executor));
        return this;
    }

    public final zzdbu zzh(com.google.android.gms.ads.internal.overlay.zzr zzrVar, Executor executor) {
        this.zzn.add(new zzddv(zzrVar, executor));
        return this;
    }

    public final zzdbu zzi(zzcyk zzcykVar, Executor executor) {
        this.zzm.add(new zzddv(zzcykVar, executor));
        return this;
    }

    public final zzdbu zzj(zzcza zzczaVar, Executor executor) {
        this.zzb.add(new zzddv(zzczaVar, executor));
        return this;
    }

    public final zzdbu zzk(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzddv(appEventListener, executor));
        return this;
    }

    public final zzdbu zzl(zzded zzdedVar, Executor executor) {
        this.zzd.add(new zzddv(zzdedVar, executor));
        return this;
    }

    public final zzdbu zzm(zzezo zzezoVar) {
        this.zzo = zzezoVar;
        return this;
    }

    public final zzdbw zzn() {
        return new zzdbw(this, null);
    }
}
