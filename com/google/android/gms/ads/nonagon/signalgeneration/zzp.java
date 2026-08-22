package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzdso;
import com.google.firebase.analytics.FirebaseAnalytics;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final class zzp extends QueryInfoGenerationCallback {
    public final zzo zza;
    public final zzdso zzb;
    public final boolean zzc;
    public final int zzd;
    public final long zze;
    public final Boolean zzf;

    public zzp(zzo zzoVar, boolean z, int i, Boolean bool, zzdso zzdsoVar) {
        this.zza = zzoVar;
        this.zzc = z;
        this.zzd = i;
        this.zzf = bool;
        this.zzb = zzdsoVar;
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zze = System.currentTimeMillis();
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        Pair pair = new Pair("sgf_reason", str);
        Pair pair2 = new Pair("se", "query_g");
        Pair pair3 = new Pair(FirebaseAnalytics.Param.AD_FORMAT, "BANNER");
        Pair pair4 = new Pair("rtype", Integer.toString(6));
        Pair pair5 = new Pair("scar", "true");
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar.zzl.getClass();
        Pair pair6 = new Pair("lat_ms", Long.toString(System.currentTimeMillis() - this.zze));
        int i = this.zzd;
        Pair pair7 = new Pair("sgpc_rn", Integer.toString(i));
        Pair pair8 = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        MediaType.Companion.zzd(this.zzb, "sgpcf", pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, new Pair("tpc", true != z ? "0" : "1"));
        zzvVar.zzl.getClass();
        this.zza.zzf(z, new zzq(null, str, ((Long) zzbfj.zzh.zze()).longValue() + System.currentTimeMillis(), i));
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        Pair pair = new Pair("se", "query_g");
        Pair pair2 = new Pair(FirebaseAnalytics.Param.AD_FORMAT, "BANNER");
        Pair pair3 = new Pair("rtype", Integer.toString(6));
        Pair pair4 = new Pair("scar", "true");
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar.zzl.getClass();
        Pair pair5 = new Pair("lat_ms", Long.toString(System.currentTimeMillis() - this.zze));
        int i = this.zzd;
        Pair pair6 = new Pair("sgpc_rn", Integer.toString(i));
        Pair pair7 = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        MediaType.Companion.zzd(this.zzb, "sgpcs", pair, pair2, pair3, pair4, pair5, pair6, pair7, new Pair("tpc", true != z ? "0" : "1"));
        zzvVar.zzl.getClass();
        this.zza.zzf(z, new zzq(queryInfo, "", System.currentTimeMillis() + ((Long) zzbfj.zzh.zze()).longValue(), i));
    }
}
