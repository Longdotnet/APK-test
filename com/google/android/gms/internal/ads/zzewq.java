package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzewq implements zzhgr {
    public static zzeuf zza(Context context, zzbzg zzbzgVar, zzbzh zzbzhVar, Object obj, zzevi zzeviVar, zzewc zzewcVar, zzhgl zzhglVar, zzhgl zzhglVar2, zzhgl zzhglVar3, zzhgl zzhglVar4, zzhgl zzhglVar5, zzhgl zzhglVar6, zzhgl zzhglVar7, Executor executor, zzfhu zzfhuVar, zzdsj zzdsjVar) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzevv) obj);
        hashSet.add(zzeviVar);
        hashSet.add(zzewcVar);
        zzbcv zzbcvVar = zzbde.zzgb;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            hashSet.add((zzeuc) zzhglVar.zzb());
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzgc)).booleanValue()) {
            hashSet.add((zzeuc) zzhglVar2.zzb());
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzge)).booleanValue()) {
            hashSet.add((zzeuc) zzhglVar4.zzb());
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzgf)).booleanValue()) {
            hashSet.add((zzeuc) zzhglVar5.zzb());
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzdn)).booleanValue()) {
            hashSet.add((zzeuc) zzhglVar7.zzb());
        }
        return new zzeuf(context, executor, hashSet, zzfhuVar, zzdsjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
