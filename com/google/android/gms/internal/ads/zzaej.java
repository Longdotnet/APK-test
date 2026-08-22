package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaej {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            String str2 = zzex.zza;
            int i = Integer.parseInt(strGroup, 16);
            int i2 = Integer.parseInt(matcher.group(2), 16);
            if (i <= 0 && i2 <= 0) {
                return false;
            }
            this.zza = i;
            this.zzb = i2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzav zzavVar) {
        for (int i = 0; i < zzavVar.zza(); i++) {
            zzau zzauVarZzb = zzavVar.zzb(i);
            boolean z = zzauVarZzb instanceof zzaha;
            String str = TSDAbK.xIIKwucBlka;
            if (z) {
                zzaha zzahaVar = (zzaha) zzauVarZzb;
                if (str.equals(zzahaVar.zzb) && zzc(zzahaVar.zzc)) {
                    return true;
                }
            } else if (zzauVarZzb instanceof zzahh) {
                zzahh zzahhVar = (zzahh) zzauVarZzb;
                if ("com.apple.iTunes".equals(zzahhVar.zza) && str.equals(zzahhVar.zzb) && zzc(zzahhVar.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
