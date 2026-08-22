package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfdo {
    private final Pattern zza;

    public zzfdo() {
        Pattern patternCompile;
        try {
            patternCompile = Pattern.compile((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhb));
        } catch (PatternSyntaxException unused) {
            patternCompile = null;
        }
        this.zza = patternCompile;
    }

    public final String zza(String str) {
        Pattern pattern = this.zza;
        if (pattern == null || str == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
