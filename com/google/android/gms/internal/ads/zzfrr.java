package com.google.android.gms.internal.ads;

import android.net.Network;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class zzfrr extends zzfrf {
    private zzfwh<Integer> zza;
    private zzfwh<Integer> zzb;
    private zzfrq zzc;
    private HttpURLConnection zzd;

    public zzfrr(zzfwh<Integer> zzfwhVar, zzfwh<Integer> zzfwhVar2, zzfrq zzfrqVar) {
        this.zza = zzfwhVar;
        this.zzb = zzfwhVar2;
        this.zzc = zzfrqVar;
    }

    public static /* synthetic */ Integer zzf() {
        return -1;
    }

    public static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzfrg.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() {
        zzfrg.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfrq zzfrqVar = this.zzc;
        zzfrqVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfrqVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzfrq zzfrqVar, final int i, final int i2) {
        this.zza = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfrj
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzb = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfrk
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = zzfrqVar;
        return zzm();
    }

    public HttpURLConnection zzo(final Network network, final URL url, final int i, final int i2) {
        this.zza = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfrl
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzb = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfrm
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = new zzfrq() { // from class: com.google.android.gms.internal.ads.zzfrn
            @Override // com.google.android.gms.internal.ads.zzfrq
            public final URLConnection zza() {
                return network.openConnection(url);
            }
        };
        return zzm();
    }

    public URLConnection zzr(final URL url, final int i) {
        this.zza = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfro
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzc = new zzfrq() { // from class: com.google.android.gms.internal.ads.zzfrp
            @Override // com.google.android.gms.internal.ads.zzfrq
            public final URLConnection zza() {
                return url.openConnection();
            }
        };
        return zzm();
    }

    public zzfrr() {
        this(new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfrh
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return zzfrr.zzf();
            }
        }, new zzfwh() { // from class: com.google.android.gms.internal.ads.zzfri
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return zzfrr.zzg();
            }
        }, null);
    }
}
