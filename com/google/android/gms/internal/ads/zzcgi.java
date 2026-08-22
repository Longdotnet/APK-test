package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.auth.IJ.gZrKCJ;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.internal.Jbo.ygoi;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcgi extends com.google.android.gms.ads.internal.client.zzec {
    private final zzccb zza;
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    private com.google.android.gms.ads.internal.client.zzeg zzf;
    private boolean zzg;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbhx zzn;
    private final Object zzb = new Object();
    private boolean zzh = true;

    public zzcgi(zzccb zzccbVar, float f, boolean z, boolean z2) {
        this.zza = zzccbVar;
        this.zzi = f;
        this.zzc = z;
        this.zzd = z2;
    }

    public static /* synthetic */ void zzd(zzcgi zzcgiVar, int i, int i2, boolean z, boolean z2) {
        int i3;
        boolean z3;
        boolean z4;
        com.google.android.gms.ads.internal.client.zzeg zzegVar;
        com.google.android.gms.ads.internal.client.zzeg zzegVar2;
        com.google.android.gms.ads.internal.client.zzeg zzegVar3;
        synchronized (zzcgiVar.zzb) {
            try {
                boolean z5 = zzcgiVar.zzg;
                if (z5 || i2 != 1) {
                    i3 = i2;
                    z3 = false;
                } else {
                    i2 = 1;
                    i3 = 1;
                    z3 = true;
                }
                boolean z6 = i != i2;
                if (z6 && i3 == 1) {
                    z4 = true;
                    i3 = 1;
                } else {
                    z4 = false;
                }
                boolean z7 = z6 && i3 == 2;
                boolean z8 = z6 && i3 == 3;
                zzcgiVar.zzg = z5 || z3;
                if (z3) {
                    try {
                        com.google.android.gms.ads.internal.client.zzeg zzegVar4 = zzcgiVar.zzf;
                        if (zzegVar4 != null) {
                            zzegVar4.zzi();
                        }
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
                if (z4 && (zzegVar3 = zzcgiVar.zzf) != null) {
                    zzegVar3.zzh();
                }
                if (z7 && (zzegVar2 = zzcgiVar.zzf) != null) {
                    zzegVar2.zzg();
                }
                if (z8) {
                    com.google.android.gms.ads.internal.client.zzeg zzegVar5 = zzcgiVar.zzf;
                    if (zzegVar5 != null) {
                        zzegVar5.zze();
                    }
                    zzcgiVar.zza.zzw();
                }
                if (z != z2 && (zzegVar = zzcgiVar.zzf) != null) {
                    zzegVar.zzf(z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzw(final int i, final int i2, final boolean z, final boolean z2) {
        zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgh
            @Override // java.lang.Runnable
            public final void run() {
                zzcgi.zzd(this.zza, i, i2, z, z2);
            }
        });
    }

    private final void zzx(String str, Map map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.zzd("pubVideoCmd", map2);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zze() {
        float f;
        synchronized (this.zzb) {
            f = this.zzk;
        }
        return f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzf() {
        float f;
        synchronized (this.zzb) {
            f = this.zzj;
        }
        return f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzg() {
        float f;
        synchronized (this.zzb) {
            f = this.zzi;
        }
        return f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzh() {
        int i;
        synchronized (this.zzb) {
            i = this.zze;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final com.google.android.gms.ads.internal.client.zzeg zzi() {
        com.google.android.gms.ads.internal.client.zzeg zzegVar;
        synchronized (this.zzb) {
            zzegVar = this.zzf;
        }
        return zzegVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzj(boolean z) {
        zzx(true != z ? "unmute" : "mute", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzk() {
        zzx("pause", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzl() {
        zzx("play", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzm(com.google.android.gms.ads.internal.client.zzeg zzegVar) {
        synchronized (this.zzb) {
            this.zzf = zzegVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzn() {
        zzx("stop", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzo() {
        boolean z;
        Object obj = this.zzb;
        boolean zZzp = zzp();
        synchronized (obj) {
            z = false;
            if (!zZzp) {
                try {
                    if (this.zzm && this.zzd) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzp() {
        boolean z;
        synchronized (this.zzb) {
            try {
                z = false;
                if (this.zzc && this.zzl) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzq() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzh;
        }
        return z;
    }

    public final void zzr(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (this.zzb) {
            try {
                z2 = true;
                if (f2 == this.zzi && f3 == this.zzk) {
                    z2 = false;
                }
                this.zzi = f2;
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzni)).booleanValue()) {
                    this.zzj = f;
                }
                z3 = this.zzh;
                this.zzh = z;
                i2 = this.zze;
                this.zze = i;
                float f4 = this.zzk;
                this.zzk = f3;
                if (Math.abs(f3 - f4) > 1.0E-4f) {
                    this.zza.zzF().invalidate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            try {
                zzbhx zzbhxVar = this.zzn;
                if (zzbhxVar != null) {
                    zzbhxVar.zze();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        zzw(i2, i, z3, z);
    }

    public final void zzt(float f) {
        synchronized (this.zzb) {
            this.zzj = f;
        }
    }

    public final void zzu() {
        boolean z;
        int i;
        synchronized (this.zzb) {
            z = this.zzh;
            i = this.zze;
            this.zze = 3;
        }
        zzw(i, 3, z, z);
    }

    public final void zzv(zzbhx zzbhxVar) {
        synchronized (this.zzb) {
            this.zzn = zzbhxVar;
        }
    }

    public final void zzs(com.google.android.gms.ads.internal.client.zzgc zzgcVar) {
        Object obj = this.zzb;
        boolean z = zzgcVar.zzb;
        boolean z2 = zzgcVar.zzc;
        synchronized (obj) {
            this.zzl = z;
            this.zzm = z2;
        }
        boolean z3 = zzgcVar.zza;
        String str = true != z ? "0" : "1";
        String str2 = true != z2 ? "0" : gZrKCJ.YFymil;
        String str3 = true != z3 ? ygoi.VvlRSpelbnn : "1";
        String str4 = mnwSv.wqZCEymUWgg;
        ArrayMap arrayMap = new ArrayMap(3);
        arrayMap.put("muteStart", str3);
        arrayMap.put(str4, str);
        arrayMap.put("clickToExpandRequested", str2);
        zzx("initialState", Collections.unmodifiableMap(arrayMap));
    }
}
