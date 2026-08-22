package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzfln {
    private final zzfly zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzflo zzg;

    private zzfln(zzfly zzflyVar, WebView webView, String str, List list, String str2, String str3, zzflo zzfloVar) {
        this.zza = zzflyVar;
        this.zzb = webView;
        this.zzg = zzfloVar;
        this.zzf = str2;
        this.zze = str3;
    }

    public static zzfln zzb(zzfly zzflyVar, WebView webView, String str, String str2) {
        if (str2 != null) {
            zzfni.zzd(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new zzfln(zzflyVar, webView, null, null, str, str2, zzflo.HTML);
    }

    public static zzfln zzc(zzfly zzflyVar, WebView webView, String str, String str2) {
        zzfni.zzd("", 256, "CustomReferenceData is greater than 256 characters");
        return new zzfln(zzflyVar, webView, null, null, str, "", zzflo.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzflo zzd() {
        return this.zzg;
    }

    public final zzfly zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
