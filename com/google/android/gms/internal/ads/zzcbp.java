package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.ads.jY.UUFMQdNK;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbp extends FrameLayout implements zzcbg {
    final zzccd zza;
    private final zzccb zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbdt zze;
    private final long zzf;
    private final zzcbh zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcbp(Context context, zzccb zzccbVar, int i, boolean z, zzbdt zzbdtVar, zzcca zzccaVar, zzdsj zzdsjVar) {
        super(context);
        this.zzb = zzccbVar;
        this.zze = zzbdtVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccbVar.zzj());
        zzcbt zzcbtVar = zzccbVar.zzj().zza;
        zzccc zzcccVar = new zzccc(context, zzccbVar.zzm(), zzccbVar.zzs(), zzbdtVar, zzccbVar.zzk());
        zzcbh zzcevVar = i == 3 ? new zzcev(context, zzcccVar) : i == 2 ? new zzcct(context, zzcccVar, zzccbVar, z, zzcbi.zza(zzccbVar), zzccaVar, zzdsjVar) : new zzcbf(context, zzccbVar, z, zzcbi.zza(zzccbVar), zzccaVar, new zzccc(context, zzccbVar.zzm(), zzccbVar.zzs(), zzbdtVar, zzccbVar.zzk()), zzdsjVar);
        this.zzg = zzcevVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzcevVar, new FrameLayout.LayoutParams(-1, -1, 17));
        zzbcv zzbcvVar = zzbde.zzX;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzU)).booleanValue()) {
            zzp();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) zzbdVar.zzd.zzb(zzbde.zzZ)).longValue();
        boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzW)).booleanValue();
        this.zzk = zBooleanValue;
        if (zzbdtVar != null) {
            zzbdtVar.zzd("spinner_used", true != zBooleanValue ? "0" : "1");
        }
        this.zza = new zzccd(this);
        zzcevVar.zzr(this);
    }

    private final void zzJ() {
        zzccb zzccbVar = this.zzb;
        if (zzccbVar.zzi() == null || !this.zzi || this.zzj) {
            return;
        }
        zzccbVar.zzi().getWindow().clearFlags(128);
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap map = new HashMap();
        Integer numZzl = zzl();
        if (numZzl != null) {
            map.put("playerId", numZzl.toString());
        }
        map.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", map);
    }

    private final boolean zzL() {
        return this.zzq.getParent() != null;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzcbh zzcbhVar = this.zzg;
            if (zzcbhVar != null) {
                zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbj
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcbhVar.zzt();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcbg
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zza.zzb();
            z = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z = false;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbo(this, z));
    }

    public final void zzA(int i) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzz(i);
    }

    public final void zzB(int i) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzA(i);
    }

    public final void zzC(int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzX)).booleanValue()) {
            this.zzc.setBackgroundColor(i);
            this.zzd.setBackgroundColor(i);
        }
    }

    public final void zzD(int i) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzB(i);
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i, int i2, int i3, int i4) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Set video bounds to x:", i, ";y:", i2, ";w:");
            sbM.append(i3);
            sbM.append(";h:");
            sbM.append(i4);
            com.google.android.gms.ads.internal.util.zze.zza(sbM.toString());
        }
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzc.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzG(float f) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzb.zze(f);
        zzcbhVar.zzn();
    }

    public final void zzH(float f, float f2) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar != null) {
            zzcbhVar.zzu(f, f2);
        }
    }

    public final void zzI() {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzb.zzd(false);
        zzcbhVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzce)).booleanValue()) {
            this.zza.zza();
        }
        zzK("ended", new String[0]);
        zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzb(String str, String str2) {
        zzK("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzc(String str, String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzce)).booleanValue()) {
            this.zza.zzb();
        }
        zzccb zzccbVar = this.zzb;
        if (zzccbVar.zzi() != null && !this.zzi) {
            boolean z = (zzccbVar.zzi().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z;
            if (!z) {
                zzccbVar.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzg() {
        this.zzd.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzK("firstFrameRendered", new String[0]);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzh() {
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbm(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            ImageView imageView = this.zzq;
            imageView.setImageBitmap(this.zzp);
            imageView.invalidate();
            FrameLayout frameLayout = this.zzc;
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(imageView);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcbn(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzj(int i, int i2) {
        if (this.zzk) {
            zzbcv zzbcvVar = zzbde.zzY;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            int iMax = Math.max(i / ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue(), 1);
            int iMax2 = Math.max(i2 / ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == iMax && this.zzp.getHeight() == iMax2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null || this.zzp == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar.zzl.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (zzcbhVar.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        zzvVar.zzl.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Spinner frame grab took " + jElapsedRealtime2 + "ms");
        }
        if (jElapsedRealtime2 > this.zzf) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
            this.zzk = false;
            this.zzp = null;
            zzbdt zzbdtVar = this.zze;
            if (zzbdtVar != null) {
                zzbdtVar.zzd("spinner_jank", Long.toString(jElapsedRealtime2));
            }
        }
    }

    public final Integer zzl() {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar != null) {
            return zzcbhVar.zzw();
        }
        return null;
    }

    public final void zzq() {
        this.zza.zza();
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar != null) {
            zzcbhVar.zzt();
        }
        zzJ();
    }

    public final void zzr(Integer num) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzn)) {
            zzK("no_src", new String[0]);
        } else {
            zzcbhVar.zzC(this.zzn, this.zzo, num);
        }
    }

    public final void zzs() {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzb.zzd(true);
        zzcbhVar.zzn();
    }

    public final void zzt() {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        long jZza = zzcbhVar.zza();
        if (this.zzl == jZza || jZza <= 0) {
            return;
        }
        float f = jZza / 1000.0f;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcc)).booleanValue()) {
            String strValueOf = String.valueOf(f);
            String strValueOf2 = String.valueOf(zzcbhVar.zzh());
            String strValueOf3 = String.valueOf(zzcbhVar.zzf());
            String strValueOf4 = String.valueOf(zzcbhVar.zzg());
            String strValueOf5 = String.valueOf(zzcbhVar.zzb());
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzK("timeupdate", "time", strValueOf, "totalBytes", strValueOf2, "qoeCachedBytes", strValueOf3, "qoeLoadedBytes", strValueOf4, "droppedFrames", strValueOf5, "reportTime", String.valueOf(System.currentTimeMillis()));
        } else {
            zzK("timeupdate", "time", String.valueOf(f));
        }
        this.zzl = jZza;
    }

    public final void zzu() {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzo();
    }

    public final void zzv() {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzp();
    }

    public final void zzw(int i) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzq(i);
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzy(int i) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzx(i);
    }

    public final void zzz(int i) {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        zzcbhVar.zzy(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbg
    public final void zzf() {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar != null && this.zzm == 0) {
            zzK("canplaythrough", sgtsHsWT.OamiELlWjyAS, String.valueOf(zzcbhVar.zzc() / 1000.0f), "videoWidth", String.valueOf(zzcbhVar.zze()), "videoHeight", String.valueOf(zzcbhVar.zzd()));
        }
    }

    public final void zzp() {
        zzcbh zzcbhVar = this.zzg;
        if (zzcbhVar == null) {
            return;
        }
        TextView textView = new TextView(zzcbhVar.getContext());
        Resources resourcesZze = com.google.android.gms.ads.internal.zzv.zza.zzi.zze();
        textView.setText(String.valueOf(resourcesZze == null ? UUFMQdNK.uGzijnVYPM : resourcesZze.getString(R.string.watermark_label_prefix)).concat(zzcbhVar.zzj()));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        FrameLayout frameLayout = this.zzc;
        frameLayout.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        frameLayout.bringChildToFront(textView);
    }
}
