package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnd extends zzbhf {
    private final String zza;
    private final zzdio zzb;
    private final zzdit zzc;

    public zzdnd(String str, zzdio zzdioVar, zzdit zzditVar) {
        this.zza = str;
        this.zzb = zzdioVar;
        this.zzc = zzditVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final Bundle zzb() {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final com.google.android.gms.ads.internal.client.zzed zzc() {
        return this.zzc.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final zzbgi zzd() {
        return this.zzc.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final zzbgp zze() {
        return this.zzc.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final IObjectWrapper zzf() {
        return this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final IObjectWrapper zzg() {
        return new ObjectWrapper(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzh() {
        return this.zzc.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzi() {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzj() {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzk() {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final String zzl() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final List zzm() {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final void zzn() {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final void zzo(Bundle bundle) {
        this.zzb.zzH(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final void zzp(Bundle bundle) {
        this.zzb.zzN(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhg
    public final boolean zzq(Bundle bundle) {
        return this.zzb.zzaa(bundle);
    }
}
