package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbst extends zzbsu implements zzbkf {
    DisplayMetrics zza;
    int zzb;
    int zzc;
    int zzd;
    int zze;
    int zzf;
    int zzg;
    private final zzcfg zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbcm zzk;
    private float zzl;
    private int zzm;

    public zzbst(zzcfg zzcfgVar, Context context, zzbcm zzbcmVar) {
        super(zzcfgVar, "");
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = -1;
        this.zze = -1;
        this.zzf = -1;
        this.zzg = -1;
        this.zzh = zzcfgVar;
        this.zzi = context;
        this.zzk = zzbcmVar;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0061 A[PHI: r4
  0x0061: PHI (r4v2 int) = (r4v1 int), (r4v6 int) binds: [B:11:0x0040, B:17:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    public final void zzb(int i, int i2) {
        int i3;
        Context context = this.zzi;
        int i4 = 0;
        if (context instanceof Activity) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            i3 = com.google.android.gms.ads.internal.util.zzs.zzS((Activity) context)[0];
        } else {
            i3 = 0;
        }
        zzcfg zzcfgVar = this.zzh;
        if (zzcfgVar.zzO() == null || !zzcfgVar.zzO().zzi()) {
            int width = zzcfgVar.getWidth();
            int height = zzcfgVar.getHeight();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzai)).booleanValue()) {
                if (width == 0) {
                    width = zzcfgVar.zzO() != null ? zzcfgVar.zzO().zzb : 0;
                }
                if (height != 0) {
                    i4 = height;
                } else if (zzcfgVar.zzO() != null) {
                    i4 = zzcfgVar.zzO().zza;
                }
            } else {
                i4 = height;
            }
            com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.zzb;
            this.zzf = zzbbVar.zzc.zzb(context, width);
            this.zzg = zzbbVar.zzc.zzb(context, i4);
        }
        zzg(i, i2 - i3, this.zzf, this.zzg);
        zzcfgVar.zzN().zzE(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        JSONObject jSONObjectPut;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = Math.round(displayMetrics.widthPixels / displayMetrics.density);
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = Math.round(displayMetrics2.heightPixels / displayMetrics2.density);
        zzcfg zzcfgVar = this.zzh;
        Activity activityZzi = zzcfgVar.zzi();
        if (activityZzi == null || activityZzi.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            int[] iArrZzR = com.google.android.gms.ads.internal.util.zzs.zzR(activityZzi);
            this.zzd = Math.round(iArrZzR[0] / this.zza.density);
            this.zze = Math.round(iArrZzR[1] / this.zza.density);
        }
        if (zzcfgVar.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            zzcfgVar.measure(0, 0);
        }
        zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbss zzbssVar = new zzbss();
        zzbcm zzbcmVar = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbssVar.zze(zzbcmVar.zza(intent));
        Intent intent2 = new Intent(FKidOcdAYt.GxCyOvrcFLQdrON);
        intent2.setData(Uri.parse("sms:"));
        zzbssVar.zzc(zzbcmVar.zza(intent2));
        zzbssVar.zza(zzbcmVar.zzb());
        zzbssVar.zzd(zzbcmVar.zzc());
        zzbssVar.zzb(true);
        boolean z = zzbssVar.zza;
        boolean z2 = zzbssVar.zzb;
        boolean z3 = zzbssVar.zzc;
        try {
            jSONObjectPut = new JSONObject().put("sms", z).put(ZRqOdXiy.sqS, z2).put("calendar", z3).put("storePicture", zzbssVar.zzd).put(MnHfHMYQDPUO.MPHHIhNOWmoQ, zzbssVar.zze);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObjectPut = null;
        }
        zzcfgVar.zze("onDeviceFeaturesReceived", jSONObjectPut);
        int[] iArr = new int[2];
        zzcfgVar.getLocationOnScreen(iArr);
        Context context = this.zzi;
        com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.zzb;
        zzb(zzbbVar.zzc.zzb(context, iArr[0]), zzbbVar.zzc.zzb(context, iArr[1]));
        if (com.google.android.gms.ads.internal.util.client.zzo.zzm(2)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Dispatching Ready Event.");
        }
        zzi(zzcfgVar.zzm().afmaVersion);
    }
}
