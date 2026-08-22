package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnb extends zzbhd {
    private final String zza;
    private final zzdio zzb;
    private final zzdit zzc;

    public zzdnb(String str, zzdio zzdioVar, zzdit zzditVar) {
        this.zza = str;
        this.zzb = zzdioVar;
        this.zzc = zzditVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final double zzb() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final Bundle zzc() {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final com.google.android.gms.ads.internal.client.zzed zzd() {
        return this.zzc.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final zzbgi zze() {
        return this.zzc.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final zzbgp zzf() {
        return this.zzc.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final IObjectWrapper zzg() {
        return this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final IObjectWrapper zzh() {
        return new ObjectWrapper(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzi() {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzj() {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzk() {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzl() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzm() {
        return this.zzc.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final String zzn() {
        return this.zzc.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final List zzo() {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final void zzp() {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final void zzq(Bundle bundle) {
        this.zzb.zzH(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final void zzr(Bundle bundle) {
        this.zzb.zzN(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final boolean zzs(Bundle bundle) {
        return this.zzb.zzaa(bundle);
    }
}
