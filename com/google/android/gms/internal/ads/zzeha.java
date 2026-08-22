package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzeha {
    final String zza;
    final String zzb;
    int zzc;
    long zzd;
    final Integer zze;

    public zzeha(String str, String str2, int i, long j, Integer num) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = j;
        this.zze = num;
    }

    public final String toString() {
        Integer num;
        String strM = this.zza + "." + this.zzc + "." + this.zzd;
        String str = this.zzb;
        if (!TextUtils.isEmpty(str)) {
            strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM, ".", str);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbO)).booleanValue() || (num = this.zze) == null || TextUtils.isEmpty(str)) {
            return strM;
        }
        return strM + "." + num;
    }
}
