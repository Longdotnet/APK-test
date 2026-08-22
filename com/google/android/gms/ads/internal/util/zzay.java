package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzdvi;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzay {
    public zzdvi zzg;
    public final Object zzb = new Object();
    public String zzc = "";
    public String zzd = "";
    public boolean zze = false;
    public boolean zzf = false;
    public String zza = "";

    public static final String zzo(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put("User-Agent", com.google.android.gms.ads.internal.zzv.zza.zzd.zzc(context, str2));
        zzbk zzbkVarZzb = new zzbo(context).zzb(0, str, map, null);
        try {
            return (String) zzbkVarZzb.get(((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfl)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            String strValueOf = String.valueOf(str);
            int i = zze.$r8$clinit;
            zzo.zzh("Interrupted while retrieving a response from: ".concat(strValueOf), e);
            zzbkVarZzb.cancel(true);
            return null;
        } catch (TimeoutException e2) {
            String strValueOf2 = String.valueOf(str);
            int i2 = zze.$r8$clinit;
            zzo.zzh("Timeout while retrieving a response from: ".concat(strValueOf2), e2);
            zzbkVarZzb.cancel(true);
            return null;
        } catch (Exception e3) {
            String strValueOf3 = String.valueOf(str);
            int i3 = zze.$r8$clinit;
            zzo.zzh("Error retrieving a response from: ".concat(strValueOf3), e3);
            return null;
        }
    }

    public final void zzc(Context context) {
        zzdvi zzdviVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjE)).booleanValue() || (zzdviVar = this.zzg) == null) {
            return;
        }
        zzdviVar.zzh(new zzav(this, context), zzdvh.DEBUG_MENU);
    }

    public final void zzd(Context context, String str, String str2) {
        zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        zzs.zzV(context, zzp(context, (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfh), str, str2));
    }

    public final void zze(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = zzp(context, (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfk), str3, str).buildUpon();
        builderBuildUpon.appendQueryParameter("debugData", str2);
        zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        new zzbw(context, str, builderBuildUpon.build().toString(), null).zzb();
    }

    public final void zzf(boolean z) {
        synchronized (this.zzb) {
            try {
                this.zzf = z;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjE)).booleanValue()) {
                    ((zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzx(z);
                    zzdvi zzdviVar = this.zzg;
                    if (zzdviVar != null) {
                        zzdviVar.zzl(z);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzi(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            zzs.zza.post(new zzax(this, context, str, z, z2));
        } else {
            int i = zze.$r8$clinit;
            zzo.zzi("Can not create dialog without Activity Context");
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzf;
        }
        return z;
    }

    public final boolean zzm() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zze;
        }
        return z;
    }

    public final boolean zzn(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzm()) {
            return false;
        }
        int i = zze.$r8$clinit;
        zzo.zze("Sending troubleshooting signals to the server.");
        zze(context, str, str2, str3);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006f A[Catch: all -> 0x0032, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0013, B:7:0x0019, B:12:0x003d, B:14:0x0045, B:16:0x0056, B:19:0x0068, B:11:0x0034, B:20:0x006f, B:21:0x0071), top: B:26:0x000b, inners: #1, #2 }] */
    public final Uri zzp(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        synchronized (this.zzb) {
            if (TextUtils.isEmpty(this.zzc)) {
                zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                try {
                    FileInputStream fileInputStreamOpenFileInput = context.openFileInput("debug_signals_id.txt");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Hex.copyStream(fileInputStreamOpenFileInput, byteArrayOutputStream, true);
                    str5 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (IOException unused) {
                    int i = zze.$r8$clinit;
                    zzo.zze("Error reading from internal storage.");
                    str5 = "";
                }
                this.zzc = str5;
                if (TextUtils.isEmpty(str5)) {
                    zzs zzsVar2 = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    String string = UUID.randomUUID().toString();
                    this.zzc = string;
                    try {
                        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        fileOutputStreamOpenFileOutput.write(string.getBytes("UTF-8"));
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e) {
                        int i2 = zze.$r8$clinit;
                        zzo.zzh("Error writing to file in internal storage.", e);
                    }
                    str4 = this.zzc;
                } else {
                    str4 = this.zzc;
                }
            } else {
                str4 = this.zzc;
            }
            throw th;
        }
        builderBuildUpon.appendQueryParameter("linkedDeviceId", str4);
        builderBuildUpon.appendQueryParameter("adSlotPath", str2);
        builderBuildUpon.appendQueryParameter("afmaVersion", str3);
        return builderBuildUpon.build();
    }

    public final boolean zzj(Context context, String str, String str2) {
        zzbcv zzbcvVar = zzbde.zzfj;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        String strZzo = zzo(context, zzp(context, (String) zzbdVar.zzd.zzb(zzbcvVar), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strZzo)) {
            int i = zze.$r8$clinit;
            zzo.zze(JrbhsraGtto.eeopvqQtffd);
            return false;
        }
        try {
            boolean zEquals = "1".equals(new JSONObject(strZzo.trim()).optString("debug_mode"));
            zzf(zEquals);
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjE)).booleanValue()) {
                zzg zzgVarZzi = com.google.android.gms.ads.internal.zzv.zza.zzi.zzi();
                if (true != zEquals) {
                    str = "";
                }
                ((zzj) zzgVarZzi).zzw(str);
            }
            return zEquals;
        } catch (JSONException e) {
            int i2 = zze.$r8$clinit;
            zzo.zzk("Fail to get debug mode response json.", e);
            return false;
        }
    }
}
