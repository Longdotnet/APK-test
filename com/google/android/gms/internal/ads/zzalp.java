package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.loader.app.gv.DYYbQc;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class zzalp {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzfyv zze = zzfyv.zzp("auto", "none");
    private static final zzfyv zzf = zzfyv.zzq(DYYbQc.bKoPtjZEjnOJkhe, "sesame", "circle");
    private static final zzfyv zzg = zzfyv.zzp(FKidOcdAYt.UQNBHsp, "open");
    private static final zzfyv zzh = zzfyv.zzq("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzalp(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    public static zzalp zza(String str) {
        byte b;
        int i;
        if (str == null) {
            return null;
        }
        String strZza = zzfuv.zza(str.trim());
        if (strZza.isEmpty()) {
            return null;
        }
        zzfyv zzfyvVarZzm = zzfyv.zzm(TextUtils.split(strZza, zzd));
        String str2 = (String) zzfyw.zza(zzgas.zzb(zzh, zzfyvVarZzm), "outside");
        int iHashCode = str2.hashCode();
        int i2 = -1;
        int i3 = 0;
        if (iHashCode != -1106037339) {
            if (iHashCode == 92734940 && str2.equals("after")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (str2.equals("outside")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            i = b != 1 ? 1 : -2;
        } else {
            i = 2;
        }
        zzgaq zzgaqVarZzb = zzgas.zzb(zze, zzfyvVarZzm);
        if (zzgaqVarZzb.isEmpty()) {
            zzgaq zzgaqVarZzb2 = zzgas.zzb(zzg, zzfyvVarZzm);
            zzgaq zzgaqVarZzb3 = zzgas.zzb(zzf, zzfyvVarZzm);
            if (!zzgaqVarZzb2.isEmpty() || !zzgaqVarZzb3.isEmpty()) {
                String str3 = (String) zzfyw.zza(zzgaqVarZzb2, "filled");
                int i4 = (str3.hashCode() == 3417674 && str3.equals("open")) ? 2 : 1;
                String str4 = (String) zzfyw.zza(zzgaqVarZzb3, "circle");
                int iHashCode2 = str4.hashCode();
                if (iHashCode2 != -905816648) {
                    if (iHashCode2 == 99657 && str4.equals("dot")) {
                        i2 = 0;
                    }
                } else if (str4.equals("sesame")) {
                    i2 = 1;
                }
                if (i2 == 0) {
                    i2 = 2;
                } else if (i2 != 1) {
                    i3 = i4;
                    i2 = 1;
                } else {
                    i2 = 3;
                }
                i3 = i4;
            }
        } else {
            String str5 = (String) zzgaqVarZzb.iterator().next();
            if (str5.hashCode() == 3387192 && str5.equals("none")) {
                i2 = 0;
            }
        }
        return new zzalp(i2, i3, i);
    }
}
