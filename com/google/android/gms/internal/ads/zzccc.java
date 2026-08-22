package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzccc {
    private static final boolean zza;
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    private final zzbdq zze;
    private final zzbdt zzf;
    private final com.google.android.gms.ads.internal.util.zzbh zzg;
    private final long[] zzh;
    private final String[] zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcbh zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;

    static {
        zza = com.google.android.gms.ads.internal.client.zzbb.zzb.zzg.nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznd)).intValue();
    }

    public zzccc(Context context, VersionInfoParcel versionInfoParcel, String str, zzbdt zzbdtVar, zzbdq zzbdqVar) {
        com.google.android.gms.ads.internal.util.zzbf zzbfVar = new com.google.android.gms.ads.internal.util.zzbf();
        zzbfVar.zza = new ArrayList();
        zzbfVar.zzb = new ArrayList();
        zzbfVar.zzc = new ArrayList();
        zzbfVar.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbfVar.zza("1_5", 1.0d, 5.0d);
        zzbfVar.zza("5_10", 5.0d, 10.0d);
        zzbfVar.zza("10_20", 10.0d, 20.0d);
        zzbfVar.zza("20_30", 20.0d, 30.0d);
        zzbfVar.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzg = new com.google.android.gms.ads.internal.util.zzbh(zzbfVar);
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzr = -1L;
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zzc = str;
        this.zzf = zzbdtVar;
        this.zze = zzbdqVar;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzS);
        if (str2 == null) {
            this.zzi = new String[0];
            this.zzh = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        int length = strArrSplit.length;
        this.zzi = new String[length];
        this.zzh = new long[length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.zzh[i] = Long.parseLong(strArrSplit[i]);
            } catch (NumberFormatException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to parse frame hash target time number.", e);
                this.zzh[i] = -1;
            }
        }
    }

    public final void zza(zzcbh zzcbhVar) {
        zzbdt zzbdtVar = this.zzf;
        zzbdl.zza(zzbdtVar, this.zze, "vpc2");
        this.zzj = true;
        zzbdtVar.zzd("vpn", zzcbhVar.zzj());
        this.zzo = zzcbhVar;
    }

    public final void zzb() {
        if (!this.zzj || this.zzk) {
            return;
        }
        zzbdl.zza(this.zzf, this.zze, "vfr2");
        this.zzk = true;
    }

    public final void zzc() {
        this.zzn = true;
        if (!this.zzk || this.zzl) {
            return;
        }
        zzbdl.zza(this.zzf, this.zze, "vfp2");
        this.zzl = true;
    }

    public final void zzd() {
        Bundle bundleZzb;
        if (!zza || this.zzp) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.zzc);
        bundle.putString("player", this.zzo.zzj());
        com.google.android.gms.ads.internal.util.zzbh zzbhVar = this.zzg;
        zzbhVar.getClass();
        String[] strArr = zzbhVar.zza;
        ArrayList<com.google.android.gms.ads.internal.util.zzbe> arrayList = new ArrayList(strArr.length);
        int i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            double d = zzbhVar.zzc[i];
            double d2 = zzbhVar.zzb[i];
            int i2 = zzbhVar.zzd[i];
            arrayList.add(new com.google.android.gms.ads.internal.util.zzbe(str, d, d2, ((double) i2) / ((double) zzbhVar.zze), i2));
            i++;
            bundle = bundle;
            zzbhVar = zzbhVar;
        }
        Bundle bundle2 = bundle;
        for (com.google.android.gms.ads.internal.util.zzbe zzbeVar : arrayList) {
            String str2 = zzbeVar.zza;
            String strValueOf = String.valueOf(str2);
            bundle2.putString("fps_c_".concat(strValueOf), Integer.toString(zzbeVar.zze));
            String strValueOf2 = String.valueOf(str2);
            bundle2.putString("fps_p_".concat(strValueOf2), Double.toString(zzbeVar.zzd));
        }
        int i3 = 0;
        while (true) {
            long[] jArr = this.zzh;
            if (i3 >= jArr.length) {
                break;
            }
            String str3 = this.zzi[i3];
            if (str3 != null) {
                bundle2.putString("fh_".concat(Long.valueOf(jArr[i3]).toString()), str3);
            }
            i3++;
        }
        final Context context = this.zzb;
        VersionInfoParcel versionInfoParcel = this.zzd;
        final com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        String str4 = versionInfoParcel.afmaVersion;
        zzsVar.getClass();
        bundle2.putString("device", com.google.android.gms.ads.internal.util.zzs.zzs());
        zzbcv zzbcvVar = zzbde.zza;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        bundle2.putString("eids", TextUtils.join(",", zzbdVar.zzb.zza()));
        if (bundle2.isEmpty()) {
            int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Empty or null bundle.");
        } else {
            final String str5 = (String) zzbdVar.zzd.zzb(zzbde.zzkX);
            boolean andSet = zzsVar.zze.getAndSet(true);
            AtomicReference atomicReference = zzsVar.zzd;
            if (!andSet) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.ads.internal.util.zzm
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str6) {
                        zzsVar.zzd.set(StringsKt__IndentKt.zzb(context, str5));
                    }
                };
                if (TextUtils.isEmpty(str5)) {
                    bundleZzb = Bundle.EMPTY;
                } else {
                    PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                    bundleZzb = StringsKt__IndentKt.zzb(context, str5);
                }
                atomicReference.set(bundleZzb);
            }
            bundle2.putAll((Bundle) atomicReference.get());
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        com.google.android.gms.ads.internal.util.client.zzf.zzB(context, str4, bundle2, new RoomOpenHelper(context, str4, 29, false));
        this.zzp = true;
    }

    public final void zze() {
        this.zzn = false;
    }

    public final void zzf(zzcbh zzcbhVar) {
        if (this.zzl && !this.zzm) {
            if (com.google.android.gms.ads.internal.util.zze.zzc() && !this.zzm) {
                com.google.android.gms.ads.internal.util.zze.zza("VideoMetricsMixin first frame");
            }
            zzbdl.zza(this.zzf, this.zze, "vff2");
            this.zzm = true;
        }
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        long jNanoTime = System.nanoTime();
        if (this.zzn && this.zzq && this.zzr != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            long j = jNanoTime - this.zzr;
            com.google.android.gms.ads.internal.util.zzbh zzbhVar = this.zzg;
            double d = nanos / j;
            zzbhVar.zze++;
            int i = 0;
            while (true) {
                double[] dArr = zzbhVar.zzc;
                if (i >= dArr.length) {
                    break;
                }
                double d2 = dArr[i];
                if (d2 <= d && d < zzbhVar.zzb[i]) {
                    int[] iArr = zzbhVar.zzd;
                    iArr[i] = iArr[i] + 1;
                }
                if (d < d2) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this.zzq = this.zzn;
        this.zzr = jNanoTime;
        long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzT)).longValue();
        long jZza = zzcbhVar.zza();
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzi;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null && jLongValue > Math.abs(jZza - this.zzh[i2])) {
                int i3 = 8;
                Bitmap bitmap = zzcbhVar.getBitmap(8, 8);
                long j2 = 63;
                int i4 = 0;
                long j3 = 0;
                while (i4 < i3) {
                    int i5 = 0;
                    while (i5 < i3) {
                        int pixel = bitmap.getPixel(i5, i4);
                        j3 |= (Color.green(pixel) + (Color.red(pixel) + Color.blue(pixel)) > 128 ? 1L : 0L) << ((int) j2);
                        j2--;
                        i5++;
                        i3 = 8;
                    }
                    i4++;
                    i3 = 8;
                }
                strArr[i2] = String.format("%016X", Long.valueOf(j3));
                return;
            }
            i2++;
        }
    }
}
