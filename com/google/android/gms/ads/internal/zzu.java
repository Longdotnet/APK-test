package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.android.billingclient.api.zzaz;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzbw;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcv;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzed;
import com.google.android.gms.ads.internal.client.zzeh;
import com.google.android.gms.ads.internal.client.zzgc;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzbaz;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbeq;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbuc;
import com.google.android.gms.internal.ads.zzbwi;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.Iterator;
import java.util.TreeMap;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Request;

/* JADX INFO: loaded from: classes2.dex */
public final class zzu extends zzbw {
    public final VersionInfoParcel zza;
    public final com.google.android.gms.ads.internal.client.zzr zzb;
    public final ListenableFuture zzc = zzcaf.zza.zzb(new zzaz(this));
    public final Context zzd;
    public final Request zze;
    public WebView zzf;
    public zzbk zzg;
    public zzavu zzh;
    public AsyncTask zzi;

    public zzu(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, VersionInfoParcel versionInfoParcel) {
        this.zzd = context;
        this.zza = versionInfoParcel;
        this.zzb = zzrVar;
        this.zzf = new WebView(context);
        this.zze = new Request(context, str);
        zzX(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient(new zzo(this));
        this.zzf.setOnTouchListener(new zzp(this));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzA() {
        zzah.checkMainThread$1("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzB() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzC() {
        zzah.checkMainThread$1("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzD(zzbh zzbhVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzE(zzbk zzbkVar) {
        this.zzg = zzbkVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzF(zzcb zzcbVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzG(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzH(zzco zzcoVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzI(zzbaz zzbazVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzJ(zzx zzxVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzK(zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzL(zzeh zzehVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzM(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzN(zzbtz zzbtzVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzO(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzQ(zzdt zzdtVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzR(long j) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzS(zzbuc zzbucVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzT(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzU(zzbwi zzbwiVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzV(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzW(zzgc zzgcVar) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzX(int i) {
        if (this.zzf == null) {
            return;
        }
        this.zzf.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzY(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzZ() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzaa() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzab() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzac() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzad(zzm zzmVar) {
        TreeMap treeMap;
        zzah.checkNotNull(this.zzf, "This Search Ad has already been torn down");
        Request request = this.zze;
        request.getClass();
        request.headers = zzmVar.zzj.zza;
        Bundle bundle = zzmVar.zzm;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 != null) {
            String str = (String) zzbeq.zzc.zze();
            Iterator<String> it = bundle2.keySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                treeMap = (TreeMap) request.url;
                if (!zHasNext) {
                    break;
                }
                String next = it.next();
                if (str.equals(next)) {
                    request.body = bundle2.getString(next);
                } else if (next.startsWith("csa_")) {
                    treeMap.put(next.substring(4), bundle2.getString(next));
                }
            }
            treeMap.put("SDKVersion", this.zza.afmaVersion);
            if (((Boolean) zzbeq.zza.zze()).booleanValue()) {
                Bundle bundleZzb = StringsKt__IndentKt.zzb((Context) request.lazyCacheControl, (String) zzbeq.zzb.zze());
                for (String str2 : bundleZzb.keySet()) {
                    treeMap.put(str2, bundleZzb.get(str2).toString());
                }
            }
        }
        this.zzi = new zzr(this).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzae(zzcs zzcsVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long zzc() {
        return 0L;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zze() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzr zzh() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzbk zzj() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzco zzk() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzea zzl() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzed zzm() {
        return null;
    }

    public final String zzr() {
        String str = (String) this.zze.body;
        if (true == TextUtils.isEmpty(str)) {
            str = "www.google.com";
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("https://", str, (String) zzbeq.zzd.zze());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzs() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzt() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzu() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzy() {
        zzah.checkMainThread$1("destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(false);
        this.zzf.destroy();
        this.zzf = null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzz(zzm zzmVar, zzbn zzbnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzP(zzbdz zzbdzVar) {
        throw new IllegalStateException(TSDAbK.RAw);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzo() {
        zzah.checkMainThread$1(jIKWv.FSyZdg);
        return new ObjectWrapper(this.zzf);
    }
}
