package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzbm {
    public final int zza;
    public final String zzb;
    public final int zzc;
    private final zzz[] zzd;
    private int zze;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzbm(String str, zzz... zzzVarArr) {
        int length = zzzVarArr.length;
        int i = 1;
        zzdd.zzd(length > 0);
        this.zzb = str;
        this.zzd = zzzVarArr;
        this.zza = length;
        int iZzb = zzay.zzb(zzzVarArr[0].zzo);
        this.zzc = iZzb == -1 ? zzay.zzb(zzzVarArr[0].zzn) : iZzb;
        String strZzc = zzc(zzzVarArr[0].zzd);
        int i2 = zzzVarArr[0].zzf | 16384;
        while (true) {
            zzz[] zzzVarArr2 = this.zzd;
            if (i >= zzzVarArr2.length) {
                return;
            }
            if (!strZzc.equals(zzc(zzzVarArr2[i].zzd))) {
                zzz[] zzzVarArr3 = this.zzd;
                zzd("languages", zzzVarArr3[0].zzd, zzzVarArr3[i].zzd, i);
                return;
            } else {
                zzz[] zzzVarArr4 = this.zzd;
                if (i2 != (zzzVarArr4[i].zzf | 16384)) {
                    zzd("role flags", Integer.toBinaryString(zzzVarArr4[0].zzf), Integer.toBinaryString(this.zzd[i].zzf), i);
                    return;
                }
                i++;
            }
        }
    }

    private static String zzc(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static void zzd(String str, String str2, String str3, int i) {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Different ", str, " combined in one TrackGroup: '", str2, "' (track 0) and '");
        sbM22m.append(str3);
        sbM22m.append("' (track ");
        sbM22m.append(i);
        sbM22m.append(")");
        zzea.zzd("TrackGroup", "", new IllegalStateException(sbM22m.toString()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbm.class == obj.getClass()) {
            zzbm zzbmVar = (zzbm) obj;
            if (this.zzb.equals(zzbmVar.zzb) && Arrays.equals(this.zzd, zzbmVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zzb.hashCode() + 527;
        int iHashCode2 = Arrays.hashCode(this.zzd) + (iHashCode * 31);
        this.zze = iHashCode2;
        return iHashCode2;
    }

    public final String toString() {
        return Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(), this.zzb, ": ", Arrays.toString(this.zzd));
    }

    public final int zza(zzz zzzVar) {
        int i = 0;
        while (true) {
            zzz[] zzzVarArr = this.zzd;
            if (i >= zzzVarArr.length) {
                return -1;
            }
            if (zzzVar == zzzVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final zzz zzb(int i) {
        return this.zzd[i];
    }
}
