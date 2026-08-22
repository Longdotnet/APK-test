package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbac extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzazt zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;

    public zzbac() {
        zzazt zzaztVar = new zzazt();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzaztVar;
        this.zzc = new Object();
        this.zzf = ((Long) zzbev.zzd.zze()).intValue();
        this.zzg = ((Long) zzbev.zza.zze()).intValue();
        this.zzh = ((Long) zzbev.zze.zze()).intValue();
        this.zzi = ((Long) zzbev.zzc.zze()).intValue();
        zzbcv zzbcvVar = zzbde.zzak;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        this.zzj = ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue();
        this.zzk = ((Integer) zzbdVar.zzd.zzb(zzbde.zzal)).intValue();
        this.zzl = ((Integer) zzbdVar.zzd.zzb(zzbde.zzam)).intValue();
        this.zze = ((Long) zzbev.zzf.zze()).intValue();
        this.zzm = (String) zzbdVar.zzd.zzb(zzbde.zzao);
        this.zzn = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzap)).booleanValue();
        this.zzo = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzaq)).booleanValue();
        ((Boolean) zzbdVar.zzd.zzb(zzbde.zzar)).getClass();
        setName("ContentFetchTask");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00f7 */
    /* JADX WARN: Code duplicated, block: B:64:0x00e8 A[EXC_TOP_SPLITTER, LOOP:1: B:64:0x00e8->B:73:0x00e8, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbac.run():void");
    }

    public final zzbab zza(View view, zzazs zzazsVar) {
        if (view == null) {
            return new zzbab(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzbab(this, 0, 0);
            }
            zzazsVar.zzh(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzbab(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzcfg)) {
            WebView webView = (WebView) view;
            zzazsVar.zzf();
            webView.post(new zzbaa(this, zzazsVar, webView, globalVisibleRect));
            return new zzbab(this, 0, 1);
        }
        if (!(view instanceof ViewGroup)) {
            return new zzbab(this, 0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            zzbab zzbabVarZza = zza(viewGroup.getChildAt(i3), zzazsVar);
            i += zzbabVarZza.zza;
            i2 += zzbabVarZza.zzb;
        }
        return new zzbab(this, i, i2);
    }

    public final void zzb(View view) {
        try {
            zzazs zzazsVar = new zzazs(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context contextZzb = com.google.android.gms.ads.internal.zzv.zza.zzh.zzb();
            if (contextZzb != null) {
                String str = this.zzm;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = (String) view.getTag(contextZzb.getResources().getIdentifier((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzan), "id", contextZzb.getPackageName()));
                    if (str2 != null && str2.equals(str)) {
                        return;
                    }
                }
            }
            zzbab zzbabVarZza = zza(view, zzazsVar);
            zzazsVar.zzj();
            if (zzbabVarZza.zza == 0 && zzbabVarZza.zzb == 0) {
                return;
            }
            int i = zzbabVarZza.zzb;
            if (i != 0) {
                if (i == 0) {
                }
                this.zzd.zza(zzazsVar);
            } else if (zzazsVar.zzb() == 0) {
                return;
            }
            if (this.zzd.zzc(zzazsVar)) {
                return;
            }
            this.zzd.zza(zzazsVar);
        } catch (Exception e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception in fetchContentOnUIThread", e);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzc(zzazs zzazsVar, WebView webView, String str, boolean z) {
        zzazsVar.zze();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzazsVar.zzi(strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzazsVar.zzi(webView.getTitle() + "\n" + strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzazsVar.zzl()) {
                this.zzd.zzb(zzazsVar);
            }
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Json string may be malformed.");
        } catch (Throwable th) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zzd() {
        synchronized (this.zzc) {
            try {
                if (this.zza) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Content hash thread already started, quitting...");
                } else {
                    this.zza = true;
                    start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            this.zzb = true;
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("ContentFetchThread: paused, pause = true");
        }
    }
}
