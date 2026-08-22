package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcjg implements zzdge {
    private final zzcio zza;
    private zzezv zzb;
    private zzeyy zzc;
    private zzdbw zzd;
    private zzcvh zze;
    private zzejh zzf;

    public /* synthetic */ zzcjg(zzcio zzcioVar, zzcjs zzcjsVar) {
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

    @Override // com.google.android.gms.internal.ads.zzdge
    public final /* bridge */ /* synthetic */ zzdge zzc(zzejh zzejhVar) {
        this.zzf = zzejhVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final /* bridge */ /* synthetic */ zzdge zzd(zzdbw zzdbwVar) {
        this.zzd = zzdbwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final /* bridge */ /* synthetic */ zzdge zze(zzcvh zzcvhVar) {
        this.zze = zzcvhVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvd
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzdgf zzh() {
        zzhgz.zzc(this.zzd, zzdbw.class);
        zzhgz.zzc(this.zze, zzcvh.class);
        zzhgz.zzc(this.zzf, zzejh.class);
        return new zzcjh(this.zza, new zzcsg(), new zzfeb(), new zzcuh(), new zzdsy(), this.zzd, this.zze, zzehm.zza(), this.zzf, null, this.zzb, this.zzc);
    }
}
