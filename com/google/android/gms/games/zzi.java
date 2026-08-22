package com.google.android.gms.games;

import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzi implements Api.ApiOptions.Optional {
    public final int zze;
    public final ArrayList zzg;
    public final String zzm;
    public final com.google.android.gms.games.internal.zzi zzn;
    public final boolean zza = false;
    public final boolean zzb = true;
    public final int zzc = 17;
    public final boolean zzd = false;
    public final String zzf = null;
    public final boolean zzh = false;
    public final boolean zzi = false;
    public final boolean zzj = false;
    public final String zzk = null;
    public final int zzl = 9;
    public final boolean zzo = false;

    public /* synthetic */ zzi(int i, ArrayList arrayList, String str, com.google.android.gms.games.internal.zzi zziVar) {
        this.zze = i;
        this.zzg = arrayList;
        this.zzm = str;
        this.zzn = zziVar;
    }

    public static zzh zza() {
        return new zzh();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzi) {
            zzi zziVar = (zzi) obj;
            boolean z = zziVar.zza;
            if (this.zze == zziVar.zze && this.zzg.equals(zziVar.zzg) && TextUtils.equals(null, null) && zzah.equal(this.zzm, zziVar.zzm)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzg.hashCode() + ((this.zze + 486741695) * 961);
        String str = this.zzm;
        return ((((iHashCode * 887503681) + 9) * 31) + (str == null ? 0 : str.hashCode())) * 31;
    }
}
