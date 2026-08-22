package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqu extends zzbpv {
    private final Adapter zza;
    private final zzbwn zzb;

    public zzbqu(Adapter adapter, zzbwn zzbwnVar) {
        this.zza = adapter;
        this.zzb = zzbwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zze() {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zze(new ObjectWrapper(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzf() {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzf(new ObjectWrapper(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzg(int i) {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzg(new ObjectWrapper(this.zza), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzi(int i, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzj(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzm() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzn() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzo() {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzi(new ObjectWrapper(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzp() {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzj(new ObjectWrapper(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzq(String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzr(zzbhj zzbhjVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzs(zzbwo zzbwoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzt(zzbws zzbwsVar) {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzm(new ObjectWrapper(this.zza), new zzbwo(zzbwsVar.zzf(), zzbwsVar.zze()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzu() {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzn(new ObjectWrapper(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzv() {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzo(new ObjectWrapper(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzw() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzx() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzy() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzz() {
        zzbwn zzbwnVar = this.zzb;
        if (zzbwnVar != null) {
            zzbwnVar.zzp(new ObjectWrapper(this.zza));
        }
    }
}
