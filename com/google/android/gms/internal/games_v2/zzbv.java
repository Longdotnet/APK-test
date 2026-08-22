package com.google.android.gms.internal.games_v2;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzbv {
    private final String zza;
    private final Status zzb;

    private zzbv(Status status, String str) {
        this.zzb = status;
        this.zza = str;
    }

    public static zzbv zza(String str) {
        return new zzbv(Status.RESULT_SUCCESS, str);
    }

    public static zzbv zzb(Status status) {
        com.google.android.gms.common.internal.zzah.checkArgument(!status.isSuccess());
        return new zzbv(status, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbv)) {
            return false;
        }
        zzbv zzbvVar = (zzbv) obj;
        return com.google.android.gms.common.internal.zzah.equal(this.zzb, zzbvVar.zzb) && com.google.android.gms.common.internal.zzah.equal(this.zza, zzbvVar.zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zza});
    }

    public final String toString() {
        com.google.firebase.auth.zzz zzzVar = new com.google.firebase.auth.zzz(this);
        zzzVar.add(this.zzb, "status");
        zzzVar.add(this.zza, "gameRunToken");
        return zzzVar.toString();
    }

    public final boolean zzc() {
        return this.zzb.isSuccess();
    }

    public final String zzd() {
        return this.zza;
    }

    public final PendingIntent zze() {
        return this.zzb.getResolution();
    }
}
