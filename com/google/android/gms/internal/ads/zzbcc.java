package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbcc {
    private final zzbci zza;
    private final zzbcj.zzt.zza zzb;
    private final boolean zzc;

    private zzbcc() {
        this.zzb = zzbcj.zzt.zzj();
        this.zzc = false;
        this.zza = new zzbci();
    }

    public static zzbcc zza() {
        return new zzbcc();
    }

    private final synchronized void zze(int i) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(zzfqt.zza(zzfqs.zza(), externalStorageDirectory, "clearcut_events.txt")), true);
            try {
                fileOutputStream.write(zzd(i).getBytes());
            } catch (IOException unused) {
                com.google.android.gms.ads.internal.util.zze.zza("Could not write Clearcut to file.");
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                    com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                }
            }
        } catch (FileNotFoundException unused3) {
            com.google.android.gms.ads.internal.util.zze.zza("Could not find file for Clearcut");
        }
    }

    private final synchronized void zzf(int i) {
        zzbcj.zzt.zza zzaVar = this.zzb;
        zzaVar.zzq();
        zzaVar.zzj(com.google.android.gms.ads.internal.util.zzs.zzd());
        zzbcg zzbcgVar = new zzbcg(this.zza, zzaVar.zzbr().zzaV(), null);
        int i2 = i - 1;
        zzbcgVar.zza(i2);
        zzbcgVar.zzc();
        com.google.android.gms.ads.internal.util.zze.zza("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i2, 10))));
    }

    public final synchronized void zzb(zzbcb zzbcbVar) {
        if (this.zzc) {
            try {
                zzbcbVar.zza(this.zzb);
            } catch (NullPointerException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i) {
        if (this.zzc) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfu)).booleanValue()) {
                zze(i);
            } else {
                zzf(i);
            }
        }
    }

    private final synchronized String zzd(int i) {
        StringBuilder sb;
        zzbcj.zzt.zza zzaVar = this.zzb;
        String strZzah = zzaVar.zzah();
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strEncodeToString = Base64.encodeToString(zzaVar.zzbr().zzaV(), 3);
        sb = new StringBuilder("id=");
        sb.append(strZzah);
        sb.append(",timestamp=");
        sb.append(jElapsedRealtime);
        sb.append(",event=");
        sb.append(i - 1);
        sb.append(FKidOcdAYt.JKzpCr);
        sb.append(strEncodeToString);
        sb.append("\n");
        return sb.toString();
    }

    public zzbcc(zzbci zzbciVar) {
        this.zzb = zzbcj.zzt.zzj();
        this.zza = zzbciVar;
        this.zzc = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzft)).booleanValue();
    }
}
