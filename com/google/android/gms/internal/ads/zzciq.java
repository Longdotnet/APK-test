package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzciq implements zzcof {
    private final zzcio zza;
    private zzezv zzb;
    private zzeyy zzc;
    private zzdbw zzd;
    private zzcvh zze;

    public /* synthetic */ zzciq(zzcio zzcioVar, zzcjs zzcjsVar) {
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

    @Override // com.google.android.gms.internal.ads.zzcof
    public final /* bridge */ /* synthetic */ zzcof zzc(zzdbw zzdbwVar) {
        this.zzd = zzdbwVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcof
    public final /* bridge */ /* synthetic */ zzcof zzd(zzcvh zzcvhVar) {
        this.zze = zzcvhVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvd
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzcog zzh() {
        zzhgz.zzc(this.zzd, zzdbw.class);
        zzhgz.zzc(this.zze, zzcvh.class);
        return new zzcir(this.zza, new zzcsg(), new zzfeb(), new zzcuh(), new zzdsy(), this.zzd, this.zze, zzehm.zza(), null, this.zzb, this.zzc);
    }
}
