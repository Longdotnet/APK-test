package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzavi {
    public static final String zza(Context context, String str, long j, boolean z) {
        try {
            zzatz zzatzVarZza = zzaua.zza();
            zzatzVarZza.zzb(str);
            zzatzVarZza.zza("0.460000000");
            zzatzVarZza.zzc(context.getPackageName());
            zzatzVarZza.zze((System.currentTimeMillis() - j) / 1000);
            zzatzVarZza.zzd(System.currentTimeMillis() / 1000);
            try {
                zzatzVarZza.zzf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                zzatzVarZza.zzf(-1L);
            }
            zzaug zzaugVarZza = zzaus.zza(((zzaua) zzatzVarZza.zzbr()).zzaV(), null);
            zzaugVarZza.zzd(5);
            zzaugVarZza.zzc(2);
            return Base64.encodeToString(((zzauh) zzaugVarZza.zzbr()).zzaV(), 11);
        } catch (UnsupportedEncodingException | GeneralSecurityException unused2) {
            return Integer.toString(7);
        }
    }
}
