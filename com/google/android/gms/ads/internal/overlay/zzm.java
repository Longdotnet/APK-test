package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import androidx.work.Worker;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zzbt;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbsu;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcwl;
import com.google.android.gms.internal.ads.zzded;
import com.google.android.gms.internal.ads.zzdsi;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzecm;
import com.google.android.gms.internal.ads.zzecn;
import com.google.android.gms.internal.ads.zzedf;
import com.google.android.gms.internal.ads.zzedh;
import com.google.android.gms.internal.ads.zzfwg;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzm extends zzbtp {
    public static final int zza = Color.argb(0, 0, 0, 0);
    public final Activity zzb;
    public AdOverlayInfoParcel zzc;
    public zzcfg zzd;
    public zzbt zze;
    public zzu zzf;
    public FrameLayout zzh;
    public WebChromeClient.CustomViewCallback zzi;
    public zzh zzl;
    public Worker.AnonymousClass1 zzq;
    public boolean zzr;
    public boolean zzs;
    public Toolbar zzw;
    public boolean zzg = false;
    public boolean zzj = false;
    public boolean zzk = false;
    public boolean zzm = false;
    public int zzn = 1;
    public final Object zzo = new Object();
    public final androidx.appcompat.widget.Toolbar.AnonymousClass4 zzp = new androidx.appcompat.widget.Toolbar.AnonymousClass4(this);
    public boolean zzt = false;
    public boolean zzu = false;
    public boolean zzv = true;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    public static final void zzL(View view, zzedh zzedhVar) {
        if (zzedhVar == null || view == null) {
            return;
        }
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzfB)).booleanValue() && zzedhVar.zzb()) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zza.zzz.zzj(zzedhVar.zza(), view);
    }

    public final void zzA(int i) {
        Activity activity = this.zzb;
        int i2 = activity.getApplicationInfo().targetSdkVersion;
        zzbcv zzbcvVar = zzbde.zzgk;
        zzbd zzbdVar = zzbd.zza;
        if (i2 >= ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue()) {
            if (activity.getApplicationInfo().targetSdkVersion <= ((Integer) zzbdVar.zzd.zzb(zzbde.zzgl)).intValue()) {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= ((Integer) zzbdVar.zzd.zzb(zzbde.zzgm)).intValue()) {
                    if (i3 <= ((Integer) zzbdVar.zzd.zzb(zzbde.zzgn)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            activity.setRequestedOrientation(i);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th, "AdOverlay.setRequestedOrientation");
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r2v57 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v57 ??, new type: android.widget.Toolbar
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v57 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v57 ??, new type: android.widget.Toolbar
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v57 ??, new type: android.view.View
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public final void zzD(boolean r45) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
            Method dump skipped, instruction units count: 756
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzD(boolean):void");
    }

    public final void zzE() {
        synchronized (this.zzo) {
            try {
                this.zzr = true;
                Worker.AnonymousClass1 anonymousClass1 = this.zzq;
                if (anonymousClass1 != null) {
                    zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.zza;
                    zzfVar.removeCallbacks(anonymousClass1);
                    zzfVar.post(this.zzq);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzr zzrVar;
        if (!this.zzb.isFinishing() || this.zzt) {
            return;
        }
        this.zzt = true;
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar != null) {
            zzcfgVar.zzZ(this.zzn - 1);
            synchronized (this.zzo) {
                try {
                    if (!this.zzr && this.zzd.zzaC()) {
                        zzbcv zzbcvVar = zzbde.zzfn;
                        zzbd zzbdVar = zzbd.zza;
                        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && !this.zzu && (adOverlayInfoParcel = this.zzc) != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
                            zzrVar.zzds();
                        }
                        Worker.AnonymousClass1 anonymousClass1 = new Worker.AnonymousClass1(this, 26);
                        this.zzq = anonymousClass1;
                        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(anonymousClass1, ((Long) zzbdVar.zzd.zzb(zzbde.zzbk)).longValue());
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final boolean zzH() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzjp)).booleanValue() && this.zzd.canGoBack()) {
            this.zzd.goBack();
            return false;
        }
        boolean zZzaH = this.zzd.zzaH();
        if (!zZzaH) {
            this.zzd.zzd("onbackblocked", Collections.emptyMap());
        }
        return zZzaH;
    }

    public final void zzJ(View view) {
        zzedh zzedhVarZzQ;
        zzedf zzedfVarZzP;
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar == null) {
            return;
        }
        zzbcv zzbcvVar = zzbde.zzfC;
        zzbd zzbdVar = zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && (zzedfVarZzP = zzcfgVar.zzP()) != null) {
            zzedfVarZzP.zza(view);
        } else if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzfB)).booleanValue() && (zzedhVarZzQ = zzcfgVar.zzQ()) != null && zzedhVarZzQ.zzb()) {
            com.google.android.gms.ads.internal.zzv.zza.zzz.zzg(zzedhVarZzQ.zza(), view);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:17:0x0036 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    public final void zzK(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzl zzlVar;
        int i;
        zzl zzlVar2;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || (zzlVar2 = adOverlayInfoParcel2.zzo) == null || !zzlVar2.zzb) ? false : true;
        com.google.android.gms.ads.internal.util.zzt zztVar = com.google.android.gms.ads.internal.zzv.zza.zzg;
        Activity activity = this.zzb;
        boolean zZzd = zztVar.zzd(activity, configuration);
        if (!this.zzk || z3) {
            if (zZzd) {
                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzaT)).booleanValue()) {
                    z = false;
                }
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel != null && (zzlVar = adOverlayInfoParcel.zzo) != null && zzlVar.zzg) {
                z2 = true;
            }
        } else if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzaU)).booleanValue()) {
            if (zZzd) {
                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzaT)).booleanValue()) {
                    z = false;
                }
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel != null) {
                z2 = true;
            }
        } else {
            z = false;
        }
        Window window = activity.getWindow();
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzbr)).booleanValue()) {
            View decorView = window.getDecorView();
            if (z) {
                i = z2 ? 5894 : 5380;
            } else {
                i = 256;
            }
            decorView.setSystemUiVisibility(i);
            return;
        }
        if (!z) {
            window.addFlags(2048);
            window.clearFlags(1024);
            return;
        }
        window.addFlags(1024);
        window.clearFlags(2048);
        if (z2) {
            window.getDecorView().setSystemUiVisibility(4098);
        }
    }

    public final void zzb() {
        this.zzn = 3;
        Activity activity = this.zzb;
        activity.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzk != 5) {
            return;
        }
        activity.overridePendingTransition(0, 0);
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar != null) {
            zzcfgVar.zzai(null);
        }
    }

    public final void zzc() {
        zzcfg zzcfgVar;
        zzr zzrVar;
        if (this.zzu) {
            return;
        }
        this.zzu = true;
        zzcfg zzcfgVar2 = this.zzd;
        if (zzcfgVar2 != null) {
            this.zzl.removeView(zzcfgVar2.zzF());
            zzbt zzbtVar = this.zze;
            if (zzbtVar != null) {
                this.zzd.zzan((Context) zzbtVar.zzd);
                this.zzd.zzaq(false);
                if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zznc)).booleanValue() && this.zzd.getParent() != null) {
                    ((ViewGroup) this.zzd.getParent()).removeView(this.zzd.zzF());
                }
                ViewGroup viewGroup = (ViewGroup) this.zze.zzb;
                View viewZzF = this.zzd.zzF();
                zzbt zzbtVar2 = this.zze;
                viewGroup.addView(viewZzF, zzbtVar2.zzc, (ViewGroup.LayoutParams) zzbtVar2.zza);
                this.zze = null;
            } else {
                Activity activity = this.zzb;
                if (activity.getApplicationContext() != null) {
                    this.zzd.zzan(activity.getApplicationContext());
                }
            }
            this.zzd = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdw(this.zzn);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        if (adOverlayInfoParcel2 == null || (zzcfgVar = adOverlayInfoParcel2.zzd) == null) {
            return;
        }
        zzL(this.zzc.zzd.zzF(), zzcfgVar.zzQ());
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzs = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzi() {
        this.zzn = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzk(IObjectWrapper iObjectWrapper) {
        zzK((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public void zzl(Bundle bundle) {
        boolean z = this.zzs;
        Activity activity = this.zzb;
        if (!z) {
            activity.requestWindowFeature(1);
        }
        this.zzj = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(activity.getIntent());
            this.zzc = adOverlayInfoParcelZza;
            if (adOverlayInfoParcelZza == null) {
                throw new zzg("Could not get info for ad overlay.");
            }
            if (adOverlayInfoParcelZza.zzw) {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.setShowWhenLocked(true);
                } else {
                    activity.getWindow().addFlags(524288);
                }
            }
            if (this.zzc.zzm.clientJarVersion > 7500000) {
                this.zzn = 4;
            }
            if (activity.getIntent() != null) {
                this.zzv = activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            zzl zzlVar = adOverlayInfoParcel.zzo;
            int i = adOverlayInfoParcel.zzk;
            if (zzlVar != null) {
                boolean z2 = zzlVar.zza;
                this.zzk = z2;
                if (z2) {
                    if (i != 5 && zzlVar.zzf != -1) {
                        new com.google.android.gms.ads.internal.util.zzc(this).zzb();
                    }
                }
            } else if (i == 5) {
                this.zzk = true;
                if (i != 5) {
                    new com.google.android.gms.ads.internal.util.zzc(this).zzb();
                }
            } else {
                this.zzk = false;
            }
            if (bundle == null) {
                if (this.zzv) {
                    zzcwl zzcwlVar = this.zzc.zzt;
                    if (zzcwlVar != null) {
                        zzcwlVar.zzb();
                    }
                    zzr zzrVar = this.zzc.zzc;
                    if (zzrVar != null) {
                        zzrVar.zzdt();
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                if (adOverlayInfoParcel2.zzk != 1) {
                    zza zzaVar = adOverlayInfoParcel2.zzb;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                    }
                    zzded zzdedVar = this.zzc.zzu;
                    if (zzdedVar != null) {
                        zzdedVar.zzdf();
                    }
                }
            }
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
            zzh zzhVar = new zzh(activity, adOverlayInfoParcel3.zzn, adOverlayInfoParcel3.zzm.afmaVersion, adOverlayInfoParcel3.zzs);
            this.zzl = zzhVar;
            zzhVar.setId(1000);
            com.google.android.gms.ads.internal.zzv.zza.zzg.zzl(activity);
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            int i2 = adOverlayInfoParcel4.zzk;
            if (i2 == 1) {
                zzD(false);
                return;
            }
            if (i2 == 2) {
                this.zze = new zzbt(adOverlayInfoParcel4.zzd);
                zzD(false);
            } else if (i2 == 3) {
                zzD(true);
            } else {
                if (i2 != 5) {
                    throw new zzg("Could not determine ad overlay type.");
                }
                zzD(false);
            }
        } catch (zzg e) {
            String message = e.getMessage();
            int i3 = zze.$r8$clinit;
            zzo.zzj(message);
            this.zzn = 4;
            activity.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzm() {
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar != null) {
            try {
                this.zzl.removeView(zzcfgVar.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzo() {
        zzr zzrVar;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdk();
        }
        if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzfp)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzp(int i, String[] strArr, int[] iArr) {
        if (i == 12345) {
            zzecm zzecmVarZze = zzecn.zze();
            zzecmVarZze.zza(this.zzb);
            zzecmVarZze.zzb(this.zzc.zzk == 5 ? this : null);
            try {
                this.zzc.zzv.zzf(strArr, iArr, new ObjectWrapper(zzecmVarZze.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzr() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzd();
        }
        zzK(this.zzb.getResources().getConfiguration());
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzfp)).booleanValue()) {
            return;
        }
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar != null && !zzcfgVar.zzaE()) {
            this.zzd.onResume();
        } else {
            int i = zze.$r8$clinit;
            zzo.zzj("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzt() {
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzfp)).booleanValue()) {
            zzcfg zzcfgVar = this.zzd;
            if (zzcfgVar != null && !zzcfgVar.zzaE()) {
                this.zzd.onResume();
            } else {
                int i = zze.$r8$clinit;
                zzo.zzj("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzu() {
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzfp)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzv() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzrVar.zzdv();
    }

    public final void zzw(boolean z) {
        if (this.zzc.zzw) {
            return;
        }
        zzbcv zzbcvVar = zzbde.zzfs;
        zzbd zzbdVar = zzbd.zza;
        int iIntValue = ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue();
        boolean z2 = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzbn)).booleanValue() || z;
        zzt zztVar = new zzt();
        zztVar.zza = 0;
        zztVar.zzb = 0;
        zztVar.zzc = 0;
        zztVar.zzd = 50;
        zztVar.zza = true != z2 ? 0 : iIntValue;
        zztVar.zzb = true != z2 ? iIntValue : 0;
        zztVar.zzc = iIntValue;
        this.zzf = new zzu(this.zzb, zztVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z2 ? 9 : 11);
        zzy(z, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
        zzJ(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzx() {
        this.zzs = true;
    }

    public final void zzy(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzl zzlVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        zzl zzlVar2;
        zzbcv zzbcvVar = zzbde.zzbl;
        zzbd zzbdVar = zzbd.zza;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && (adOverlayInfoParcel2 = this.zzc) != null && (zzlVar2 = adOverlayInfoParcel2.zzo) != null && zzlVar2.zzh;
        boolean z5 = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzbm)).booleanValue() && (adOverlayInfoParcel = this.zzc) != null && (zzlVar = adOverlayInfoParcel.zzo) != null && zzlVar.zzi;
        if (z && z2 && z4 && !z5) {
            new zzbsu(this.zzd, "useCustomClose").zzh("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzu zzuVar = this.zzf;
        if (zzuVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            ImageButton imageButton = zzuVar.zza;
            if (!z3) {
                imageButton.setVisibility(0);
                return;
            }
            imageButton.setVisibility(8);
            if (((Long) zzbdVar.zzd.zzb(zzbde.zzbp)).longValue() > 0) {
                imageButton.animate().cancel();
                imageButton.clearAnimation();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzh(int i, int i2, Intent intent) {
        zzdsj zzdsjVarZze;
        AdOverlayInfoParcel adOverlayInfoParcel;
        if (i == 236) {
            zzbcv zzbcvVar = zzbde.zzny;
            zzbd zzbdVar = zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                zze.zza("Callback from intent launch with requestCode: 236 and resultCode: " + i2);
                zzcfg zzcfgVar = this.zzd;
                if (zzcfgVar == null || zzcfgVar.zzN() == null || (zzdsjVarZze = zzcfgVar.zzN().zze()) == null || (adOverlayInfoParcel = this.zzc) == null || !((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    return;
                }
                zzdsi zzdsiVarZza = zzdsjVarZze.zza();
                zzdsiVarZza.zzb("action", "hilca");
                zzdsiVarZza.zzb("gqi", zzfwg.zzc(adOverlayInfoParcel.zzq));
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                zzdsiVarZza.zzb("hilr", sb.toString());
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra(QTaELkFI.NmwCgJQEDGSYvpg);
                    String stringExtra2 = intent.getStringExtra("loadingStage");
                    if (stringExtra != null) {
                        zzdsiVarZza.zzb("hilcp", stringExtra);
                    }
                    if (stringExtra2 != null) {
                        zzdsiVarZza.zzb("hills", stringExtra2);
                    }
                }
                zzdsiVarZza.zzi();
            }
        }
    }
}
