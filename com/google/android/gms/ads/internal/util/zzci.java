package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzci {
    public final Object zza;
    public final Object zzb;
    public boolean zzc;
    public boolean zzd;
    public Object zze;

    public zzci() {
        this.zzc = false;
        this.zzb = new WeakHashMap();
        this.zza = new zzq(this);
    }

    public int[] getTablesToSync() {
        synchronized (this) {
            try {
                if (this.zzc && !this.zzd) {
                    int length = ((long[]) this.zza).length;
                    int i = 0;
                    while (true) {
                        int i2 = 1;
                        if (i >= length) {
                            this.zzd = true;
                            this.zzc = false;
                            return (int[]) this.zze;
                        }
                        boolean z = ((long[]) this.zza)[i] > 0;
                        boolean[] zArr = (boolean[]) this.zzb;
                        if (z != zArr[i]) {
                            int[] iArr = (int[]) this.zze;
                            if (!z) {
                                i2 = 2;
                            }
                            iArr[i] = i2;
                        } else {
                            ((int[]) this.zze)[i] = 0;
                        }
                        zArr[i] = z;
                        i++;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void zzb(Context context) {
        try {
            if (this.zzc) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            this.zze = applicationContext;
            if (applicationContext == null) {
                this.zze = context;
            }
            zzbde.zza((Context) this.zze);
            zzbcv zzbcvVar = zzbde.zzee;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            this.zzd = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzlv)).booleanValue() || Build.VERSION.SDK_INT < 33) {
                ((Context) this.zze).registerReceiver((zzq) this.zza, intentFilter);
            } else {
                ((Context) this.zze).registerReceiver((zzq) this.zza, intentFilter, 4);
            }
            this.zzc = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void zzd(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzd) {
            ((WeakHashMap) this.zzb).remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    public zzci(int i) {
        long[] jArr = new long[i];
        this.zza = jArr;
        boolean[] zArr = new boolean[i];
        this.zzb = zArr;
        this.zze = new int[i];
        Arrays.fill(jArr, 0L);
        Arrays.fill(zArr, false);
    }
}
