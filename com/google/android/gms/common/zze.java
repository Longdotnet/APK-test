package com.google.android.gms.common;

import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zze implements Callable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzk zzc;

    public /* synthetic */ zze(boolean z, String str, zzk zzkVar) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzkVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        MessageDigest messageDigest;
        zzk zzkVar = this.zzc;
        boolean z = this.zza;
        String str = this.zzb;
        String str2 = (z || !zzn.zzh(str, zzkVar, true, false).zza) ? "not allowed" : "debug cert rejected";
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
                if (messageDigest != null) {
                    zzah.checkNotNull(messageDigest);
                    return str2 + ": pkg=" + str + YcVWhnLsj.BjsC + Hex.bytesToStringLowercase(messageDigest.digest(zzkVar.zza)) + ", atk=" + z + ", ver=12451000.false";
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        messageDigest = null;
        zzah.checkNotNull(messageDigest);
        return str2 + ": pkg=" + str + YcVWhnLsj.BjsC + Hex.bytesToStringLowercase(messageDigest.digest(zzkVar.zza)) + ", atk=" + z + ", ver=12451000.false";
    }
}
