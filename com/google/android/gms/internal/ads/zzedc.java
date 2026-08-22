package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public interface zzedc {
    zzedh zza(String str, WebView webView, String str2, String str3, String str4, zzede zzedeVar, zzedd zzeddVar, String str5);

    zzedh zzb(String str, WebView webView, String str2, String str3, String str4, String str5, zzede zzedeVar, zzedd zzeddVar, String str6);

    zzflw zze(VersionInfoParcel versionInfoParcel, WebView webView, boolean z);

    String zzf(Context context);

    void zzg(zzfll zzfllVar, View view);

    void zzh(zzflw zzflwVar, View view);

    void zzi(zzfll zzfllVar);

    void zzj(zzfll zzfllVar, View view);

    void zzk(zzfll zzfllVar);

    boolean zzl(Context context);

    void zzm(zzflw zzflwVar, zzcfx zzcfxVar);
}
