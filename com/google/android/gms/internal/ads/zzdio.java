package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdio extends zzcra {
    public static final zzfyq zzc = zzfyq.zzs("3010", "3008", "1005", "1009", "2011", "2007");
    private final List zzA;
    private final Executor zzd;
    private final zzdit zze;
    private final zzdjb zzf;
    private final zzdjt zzg;
    private final zzdiy zzh;
    private final zzdje zzi;
    private final zzhgl zzj;
    private final zzhgl zzk;
    private final zzhgl zzl;
    private final zzhgl zzm;
    private final zzhgl zzn;
    private zzdkr zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private final zzbyk zzt;
    private final zzavu zzu;
    private final VersionInfoParcel zzv;
    private final Context zzw;
    private final zzdiq zzx;
    private final zzelb zzy;
    private final Map zzz;

    public zzdio(zzcqz zzcqzVar, Executor executor, zzdit zzditVar, zzdjb zzdjbVar, zzdjt zzdjtVar, zzdiy zzdiyVar, zzdje zzdjeVar, zzhgl zzhglVar, zzhgl zzhglVar2, zzhgl zzhglVar3, zzhgl zzhglVar4, zzhgl zzhglVar5, zzbyk zzbykVar, zzavu zzavuVar, VersionInfoParcel versionInfoParcel, Context context, zzdiq zzdiqVar, zzelb zzelbVar, zzazf zzazfVar) {
        super(zzcqzVar);
        this.zzd = executor;
        this.zze = zzditVar;
        this.zzf = zzdjbVar;
        this.zzg = zzdjtVar;
        this.zzh = zzdiyVar;
        this.zzi = zzdjeVar;
        this.zzj = zzhglVar;
        this.zzk = zzhglVar2;
        this.zzl = zzhglVar3;
        this.zzm = zzhglVar4;
        this.zzn = zzhglVar5;
        this.zzt = zzbykVar;
        this.zzu = zzavuVar;
        this.zzv = versionInfoParcel;
        this.zzw = context;
        this.zzx = zzdiqVar;
        this.zzy = zzelbVar;
        this.zzz = new HashMap();
        this.zzA = new ArrayList();
    }

    public static boolean zzZ(View view) {
        zzbcv zzbcvVar = zzbde.zzla;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point());
        }
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        long jZzx = com.google.android.gms.ads.internal.util.zzs.zzx(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point())) {
            if (jZzx >= ((Integer) zzbdVar.zzd.zzb(zzbde.zzlb)).intValue()) {
                return true;
            }
        }
        return false;
    }

    private final synchronized View zzab(Map map) {
        if (map != null) {
            zzfyq zzfyqVar = zzc;
            int size = zzfyqVar.size();
            int i = 0;
            while (i < size) {
                WeakReference weakReference = (WeakReference) map.get((String) zzfyqVar.get(i));
                i++;
                if (weakReference != null) {
                    return (View) weakReference.get();
                }
            }
        }
        return null;
    }

    private final synchronized ImageView.ScaleType zzac() {
        zzdkr zzdkrVar = this.zzo;
        if (zzdkrVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper iObjectWrapperZzj = zzdkrVar.zzj();
        if (iObjectWrapperZzj != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzj);
        }
        return zzdjt.zza;
    }

    private final void zzad(String str, boolean z) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfG)).booleanValue()) {
            zzf("Google", true);
            return;
        }
        ListenableFuture listenableFutureZzw = this.zze.zzw();
        if (listenableFutureZzw == null) {
            return;
        }
        zzgdn.zzr(listenableFutureZzw, new zzdim(this, "Google", true), this.zzd);
    }

    private final synchronized void zzae(View view, Map map, Map map2) {
        View viewZzab;
        if (!this.zzr && (viewZzab = zzab(map)) != null) {
            zzbcv zzbcvVar = zzbde.zznM;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                Rect rect = new Rect();
                if (viewZzab.getGlobalVisibleRect(rect, new Point()) && viewZzab.getHeight() == rect.height() && viewZzab.getWidth() == rect.width()) {
                    this.zzf.zzr(view, map, map2, zzac());
                    this.zzr = true;
                }
            } else if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zznN)).booleanValue()) {
                zzbcv zzbcvVar2 = zzbde.zznO;
                if (((Float) zzbdVar.zzd.zzb(zzbcvVar2)).floatValue() > 0.0d) {
                    double dFloatValue = ((Float) zzbdVar.zzd.zzb(zzbcvVar2)).floatValue();
                    Rect rect2 = new Rect();
                    if (viewZzab.getGlobalVisibleRect(rect2, new Point())) {
                        if (rect2.height() * rect2.width() >= ((double) (viewZzab.getHeight() * viewZzab.getWidth())) * (dFloatValue / 100.0d)) {
                            this.zzf.zzr(view, map, map2, zzac());
                            this.zzr = true;
                        }
                    }
                }
            } else if (zzZ(viewZzab)) {
                this.zzf.zzr(view, map, map2, zzac());
                this.zzr = true;
            }
        }
    }

    private final synchronized void zzaf(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzt(view, map, map2, zzac());
        this.zzq = true;
    }

    public final void zzag(View view, zzedh zzedhVar) {
        zzcfg zzcfgVarZzr = this.zze.zzr();
        if (!this.zzh.zzd() || zzedhVar == null || zzcfgVarZzr == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zza.zzz.zzj(zzedhVar.zza(), view);
    }

    public final synchronized void zzah(zzdkr zzdkrVar) {
        Iterator itKeys;
        View view;
        zzavp zzavpVarZzc;
        try {
            if (!this.zzp) {
                this.zzo = zzdkrVar;
                this.zzg.zze(zzdkrVar);
                this.zzf.zzB(zzdkrVar.zzf(), zzdkrVar.zzm(), zzdkrVar.zzn(), zzdkrVar, zzdkrVar);
                zzbcv zzbcvVar = zzbde.zzcT;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && (zzavpVarZzc = this.zzu.zzc()) != null) {
                    zzavpVarZzc.zzo(zzdkrVar.zzf());
                }
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzbW)).booleanValue()) {
                    zzfca zzfcaVar = this.zzb;
                    if (zzfcaVar.zzak && (itKeys = zzfcaVar.zzaj.keys()) != null) {
                        while (itKeys.hasNext()) {
                            String str = (String) itKeys.next();
                            zzdkr zzdkrVar2 = this.zzo;
                            WeakReference weakReference = zzdkrVar2 == null ? null : (WeakReference) zzdkrVar2.zzl().get(str);
                            this.zzz.put(str, Boolean.FALSE);
                            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                                zzaze zzazeVar = new zzaze(this.zzw, view);
                                this.zzA.add(zzazeVar);
                                zzazeVar.zzd(new zzdil(this, str));
                            }
                        }
                    }
                }
                if (zzdkrVar.zzi() != null) {
                    zzdkrVar.zzi().zzd(this.zzt);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void zzai(zzdkr zzdkrVar) {
        this.zzf.zzC(zzdkrVar.zzf(), zzdkrVar.zzl());
        if (zzdkrVar.zzh() != null) {
            zzdkrVar.zzh().setClickable(false);
            zzdkrVar.zzh().removeAllViews();
        }
        if (zzdkrVar.zzi() != null) {
            zzdkrVar.zzi().zze(this.zzt);
        }
        this.zzo = null;
    }

    public static /* synthetic */ void zzt(zzdio zzdioVar, boolean z) {
        zzdkr zzdkrVar = zzdioVar.zzo;
        if (zzdkrVar != null) {
            zzdioVar.zzf.zzq(null, zzdkrVar.zzf(), zzdioVar.zzo.zzl(), zzdioVar.zzo.zzm(), z, zzdioVar.zzac(), 0);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        }
    }

    public static /* synthetic */ void zzu(zzdio zzdioVar) {
        try {
            zzdit zzditVar = zzdioVar.zze;
            int iZzc = zzditVar.zzc();
            if (iZzc == 1) {
                zzbhq zzbhqVarZzb = zzdioVar.zzi.zzb();
                if (zzbhqVarZzb != null) {
                    zzdioVar.zzad("Google", true);
                    zzbhqVarZzb.zze((zzbhg) zzdioVar.zzj.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 2) {
                zzbhn zzbhnVarZza = zzdioVar.zzi.zza();
                if (zzbhnVarZza != null) {
                    zzdioVar.zzad("Google", true);
                    zzbhnVarZza.zze((zzbhe) zzdioVar.zzk.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 3) {
                zzbhw zzbhwVarZzd = zzdioVar.zzi.zzd(zzditVar.zzA());
                if (zzbhwVarZzd != null) {
                    if (zzditVar.zzs() != null) {
                        zzdioVar.zzf("Google", true);
                    }
                    zzbhwVarZzd.zze((zzbhj) zzdioVar.zzn.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 6) {
                zzbid zzbidVarZzf = zzdioVar.zzi.zzf();
                if (zzbidVarZzf != null) {
                    zzdioVar.zzad("Google", true);
                    zzbidVarZzf.zze((zzbij) zzdioVar.zzl.zzb());
                    return;
                }
                return;
            }
            if (iZzc != 7) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Wrong native template id!");
            } else {
                zzbmy zzbmyVarZzg = zzdioVar.zzi.zzg();
                if (zzbmyVarZzg != null) {
                    zzbmyVarZzg.zzg((zzbms) zzdioVar.zzm.zzb());
                }
            }
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }

    public static /* synthetic */ void zzw(zzdio zzdioVar) {
        zzdioVar.zzf.zzk();
        zzdioVar.zze.zzI();
    }

    public final void zzA(View view) {
        zzedh zzedhVarZzu = this.zze.zzu();
        if (!this.zzh.zzd() || zzedhVarZzu == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zza.zzz.zzg(zzedhVarZzu.zza(), view);
    }

    public final synchronized void zzB() {
        this.zzf.zzj();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a A[Catch: all -> 0x000a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:12:0x001f, B:14:0x0025, B:15:0x002f, B:17:0x0035, B:21:0x004a, B:24:0x005e, B:25:0x0066, B:27:0x006c, B:29:0x0080, B:31:0x0086, B:36:0x008d), top: B:41:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x006c A[Catch: all -> 0x000a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:12:0x001f, B:14:0x0025, B:15:0x002f, B:17:0x0035, B:21:0x004a, B:24:0x005e, B:25:0x0066, B:27:0x006c, B:29:0x0080, B:31:0x0086, B:36:0x008d), top: B:41:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x008d A[Catch: all -> 0x000a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:12:0x001f, B:14:0x0025, B:15:0x002f, B:17:0x0035, B:21:0x004a, B:24:0x005e, B:25:0x0066, B:27:0x006c, B:29:0x0080, B:31:0x0086, B:36:0x008d), top: B:41:0x0001 }] */
    public final synchronized void zzC(View view, Map map, Map map2, boolean z) {
        Iterator it;
        View view2;
        if (this.zzq) {
            zzae(view, map, map2);
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbW)).booleanValue() && this.zzb.zzak) {
            Map map3 = this.zzz;
            Iterator it2 = map3.keySet().iterator();
            while (it2.hasNext()) {
                if (!((Boolean) map3.get((String) it2.next())).booleanValue()) {
                }
            }
            if (!z) {
                zzaf(view, map, map2);
                zzae(view, map, map2);
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeh)).booleanValue()) {
                it = map.entrySet().iterator();
                while (it.hasNext()) {
                    view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                    if (view2 == null) {
                    }
                }
            }
        } else {
            if (!z) {
                zzaf(view, map, map2);
                zzae(view, map, map2);
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeh)).booleanValue() && map != null) {
                it = map.entrySet().iterator();
                while (it.hasNext()) {
                    view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                    if (view2 == null && zzZ(view2)) {
                        zzaf(view, map, map2);
                        return;
                    }
                }
            }
        }
    }

    public final synchronized void zzD(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        this.zzf.zzl(zzdjVar);
    }

    public final synchronized void zzE(View view, View view2, Map map, Map map2, boolean z) {
        zzcfg zzcfgVarZzs;
        this.zzg.zzc(this.zzo);
        this.zzf.zzm(view, view2, map, map2, z, zzac());
        if (this.zzs) {
            zzdit zzditVar = this.zze;
            if (zzditVar.zzs() != null && (zzcfgVarZzs = zzditVar.zzs()) != null) {
                zzcfgVarZzs.zzd("onSdkAdUserInteractionClick", new ArrayMap());
            }
        }
    }

    public final synchronized void zzF(final View view, final int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlW)).booleanValue()) {
            zzdkr zzdkrVar = this.zzo;
            if (zzdkrVar == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                final boolean z = zzdkrVar instanceof zzdjn;
                this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdii
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdio.zzv(this.zza, view, z, i);
                    }
                });
            }
        }
    }

    public final synchronized void zzG(String str) {
        this.zzf.zzn(str);
    }

    public final synchronized void zzH(Bundle bundle) {
        this.zzf.zzo(bundle);
    }

    public final synchronized void zzI() {
        zzdkr zzdkrVar = this.zzo;
        if (zzdkrVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = zzdkrVar instanceof zzdjn;
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdik
                @Override // java.lang.Runnable
                public final void run() {
                    zzdio.zzt(this.zza, z);
                }
            });
        }
    }

    public final void zzJ(Bundle bundle) {
        final zzcfg zzcfgVarZzs = this.zze.zzs();
        if (zzcfgVarZzs == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Video webview is null");
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject();
            for (String str : bundle.keySet()) {
                jSONObject.put(str, bundle.get(str));
            }
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdih
                @Override // java.lang.Runnable
                public final void run() {
                    zzfyq zzfyqVar = zzdio.zzc;
                    zzcfgVarZzs.zze("onVideoEvent", jSONObject);
                }
            });
        } catch (JSONException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error reading event signals", e);
        }
    }

    public final synchronized void zzK() {
        if (this.zzq) {
            return;
        }
        this.zzf.zzu();
    }

    public final void zzL(View view) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfG)).booleanValue()) {
            zzdit zzditVar = this.zze;
            if (zzditVar.zzc() != 3) {
                zzcak zzcakVarZzp = zzditVar.zzp();
                if (zzcakVarZzp == null) {
                    return;
                }
                zzgdn.zzr(zzcakVarZzp, new zzdin(this, view), this.zzd);
                return;
            }
        }
        zzag(view, this.zze.zzu());
    }

    public final synchronized void zzM(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzv(view, motionEvent, view2);
    }

    public final synchronized void zzN(Bundle bundle) {
        this.zzf.zzw(bundle);
    }

    public final synchronized void zzO(View view) {
        this.zzf.zzx(view);
    }

    public final synchronized void zzP() {
        this.zzf.zzy();
    }

    public final synchronized void zzQ(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        this.zzf.zzz(zzdfVar);
    }

    public final synchronized void zzR(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        this.zzy.zza(zzdtVar);
    }

    public final synchronized void zzS(zzbig zzbigVar) {
        this.zzf.zzA(zzbigVar);
    }

    public final synchronized void zzT(final zzdkr zzdkrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbU)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdid
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzah(zzdkrVar);
                }
            });
        } else {
            zzah(zzdkrVar);
        }
    }

    public final synchronized void zzU(final zzdkr zzdkrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbU)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdie
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzai(zzdkrVar);
                }
            });
        } else {
            zzai(zzdkrVar);
        }
    }

    public final boolean zzV() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzW() {
        return this.zzf.zzD();
    }

    public final synchronized boolean zzX() {
        return this.zzf.zzE();
    }

    public final boolean zzY() {
        return this.zzh.zzd();
    }

    public final synchronized int zza() {
        return this.zzf.zza();
    }

    public final synchronized boolean zzaa(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zZzF = this.zzf.zzF(bundle);
        this.zzq = zZzF;
        return zZzF;
    }

    @Override // com.google.android.gms.internal.ads.zzcra
    public final synchronized void zzb() {
        this.zzp = true;
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdij
            @Override // java.lang.Runnable
            public final void run() {
                zzdio.zzw(this.zza);
            }
        });
        super.zzb();
    }

    public final zzdiq zzc() {
        return this.zzx;
    }

    public final zzedh zzf(String str, boolean z) {
        boolean z2;
        String str2;
        zzedd zzeddVar;
        zzede zzedeVar;
        String str3;
        zzdiy zzdiyVar = this.zzh;
        if (zzdiyVar.zzd() && !TextUtils.isEmpty(str)) {
            zzdit zzditVar = this.zze;
            zzcfg zzcfgVarZzr = zzditVar.zzr();
            zzcfg zzcfgVarZzs = zzditVar.zzs();
            if (zzcfgVarZzr == null && zzcfgVarZzs == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid display and video webview are null. Skipping initialization.");
                return null;
            }
            zzdiyVar.zza();
            int iZzc = zzdiyVar.zza().zzc();
            int i2 = iZzc - 1;
            boolean z3 = false;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (iZzc != 1) {
                        str3 = iZzc != 2 ? "UNKNOWN" : "DISPLAY";
                    } else {
                        str3 = "VIDEO";
                    }
                    String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Unknown omid media type: ", str3, ". Not initializing Omid.");
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj(strM$1);
                    return null;
                }
                if (zzcfgVarZzr == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid media type was display but there was no display webview.");
                    return null;
                }
                z2 = false;
                z3 = true;
            } else if (zzcfgVarZzs != null) {
                z2 = true;
            } else {
                int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid media type was video but there was no video webview.");
            }
            if (z3) {
                str2 = null;
            } else {
                str2 = "javascript";
                zzcfgVarZzr = zzcfgVarZzs;
            }
            if (zzcfgVarZzr == null) {
                int i6 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Webview is null in InternalNativeAd");
                return null;
            }
            Context context = this.zzw;
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            if (!zzvVar.zzz.zzl(context)) {
                int i7 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to initialize omid in InternalNativeAd");
                return null;
            }
            VersionInfoParcel versionInfoParcel = this.zzv;
            String str4 = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
            if (z2) {
                zzeddVar = zzedd.VIDEO;
                zzedeVar = zzede.DEFINED_BY_JAVASCRIPT;
            } else {
                zzeddVar = zzedd.NATIVE_DISPLAY;
                zzedeVar = zzditVar.zzc() == 3 ? zzede.UNSPECIFIED : zzede.ONE_PIXEL;
            }
            zzedh zzedhVarZzb = zzvVar.zzz.zzb(str4, zzcfgVarZzr.zzG(), "", "javascript", str2, str, zzedeVar, zzeddVar, this.zzb.zzal);
            if (zzedhVarZzb == null) {
                int i8 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to create omid session in InternalNativeAd");
                return null;
            }
            zzditVar.zzW(zzedhVarZzb);
            zzcfgVarZzr.zzat(zzedhVarZzb);
            zzedb zzedbVar = zzvVar.zzz;
            if (z2) {
                zzfll zzfllVarZza = zzedhVarZzb.zza();
                if (zzcfgVarZzs != null) {
                    zzedbVar.zzj(zzfllVarZza, zzcfgVarZzs.zzF());
                }
                this.zzs = true;
            }
            if (z) {
                zzedbVar.zzk(zzedhVarZzb.zza());
                zzcfgVarZzr.zzd("onSdkLoaded", new ArrayMap());
            }
            return zzedhVarZzb;
        }
        return null;
    }

    public final String zzg() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zzf.zzf(view, map, map2, zzac());
    }

    public final synchronized JSONObject zzj(View view, Map map, Map map2) {
        return this.zzf.zzg(view, map, map2, zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzcra
    public final void zzk() {
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdif
            @Override // java.lang.Runnable
            public final void run() {
                zzdio.zzu(this.zza);
            }
        };
        Executor executor = this.zzd;
        executor.execute(runnable);
        if (this.zze.zzc() != 7) {
            final zzdjb zzdjbVar = this.zzf;
            Objects.requireNonNull(zzdjbVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdig
                @Override // java.lang.Runnable
                public final void run() {
                    zzdjbVar.zzs();
                }
            });
        }
        super.zzk();
    }

    public static /* synthetic */ void zzv(zzdio zzdioVar, View view, boolean z, int i) {
        zzdkr zzdkrVar = zzdioVar.zzo;
        if (zzdkrVar != null) {
            zzdioVar.zzf.zzq(view, zzdkrVar.zzf(), zzdioVar.zzo.zzl(), zzdioVar.zzo.zzm(), z, zzdioVar.zzac(), i);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze(sgtsHsWT.wiW);
        }
    }
}
