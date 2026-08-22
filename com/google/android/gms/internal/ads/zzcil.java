package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcil implements zzdha {
    private final zzcio zza;
    private zzezv zzb;
    private zzeyy zzc;
    private zzdbw zzd;
    private zzcvh zze;
    private zzdgw zzf;
    private zzcop zzg;

    public /* synthetic */ zzcil(zzcio zzcioVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvd
    public final /* synthetic */ zzcvd zza(zzeyy zzeyyVar) {
        this.zzc = zzeyyVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvd
    public final /* synthetic */ zzcvd zzb(zzezv zzezvVar) {
        this.zzb = zzezvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    public final /* bridge */ /* synthetic */ zzdha zzc(zzcop zzcopVar) {
        this.zzg = zzcopVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    public final /* bridge */ /* synthetic */ zzdha zzd(zzdgw zzdgwVar) {
        this.zzf = zzdgwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    public final /* bridge */ /* synthetic */ zzdha zze(zzdbw zzdbwVar) {
        this.zzd = zzdbwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    public final /* bridge */ /* synthetic */ zzdha zzf(zzcvh zzcvhVar) {
        this.zze = zzcvhVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvd
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzdhb zzh() {
        zzhgz.zzc(this.zzd, zzdbw.class);
        zzhgz.zzc(this.zze, zzcvh.class);
        zzhgz.zzc(this.zzf, zzdgw.class);
        zzhgz.zzc(this.zzg, zzcop.class);
        return new zzcim(this.zza, this.zzg, this.zzf, new zzcsg(), new zzfeb(), new zzcuh(), new zzdsy(), this.zzd, this.zze, zzehm.zza(), null, this.zzb, this.zzc);
    }
}
