package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzehu extends zzeiv {
    private final zzdem zza;

    public zzehu(zzcvw zzcvwVar, zzdeb zzdebVar, zzcwq zzcwqVar, zzcxf zzcxfVar, zzcxk zzcxkVar, zzcwl zzcwlVar, zzdaz zzdazVar, zzdey zzdeyVar, zzcye zzcyeVar, zzdem zzdemVar, zzdav zzdavVar) {
        super(zzcvwVar, zzdebVar, zzcwqVar, zzcxfVar, zzcxkVar, zzdazVar, zzcyeVar, zzdeyVar, zzdavVar, zzcwlVar);
        this.zza = zzdemVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeiv, com.google.android.gms.internal.ads.zzbpw
    public final void zzs(zzbwo zzbwoVar) {
        this.zza.zza(zzbwoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeiv, com.google.android.gms.internal.ads.zzbpw
    public final void zzt(zzbws zzbwsVar) {
        this.zza.zza(new zzbwo(zzbwsVar.zzf(), zzbwsVar.zze()));
    }

    @Override // com.google.android.gms.internal.ads.zzeiv, com.google.android.gms.internal.ads.zzbpw
    public final void zzu() {
        this.zza.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzeiv, com.google.android.gms.internal.ads.zzbpw
    public final void zzv() {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzeiv, com.google.android.gms.internal.ads.zzbpw
    public final void zzw() {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzeiv, com.google.android.gms.internal.ads.zzbpw
    public final void zzz() {
        this.zza.zzc();
    }
}
