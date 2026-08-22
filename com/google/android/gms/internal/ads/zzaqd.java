package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaqd implements Comparable {
    private final zzaqo zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzaqh zzf;
    private Integer zzg;
    private zzaqg zzh;
    private boolean zzi;
    private zzapm zzj;
    private zzaqc zzk;
    private final zzapr zzl;

    public zzaqd(int i, String str, zzaqh zzaqhVar) {
        Uri uri;
        String host;
        this.zza = zzaqo.zza ? new zzaqo() : null;
        this.zze = new Object();
        int iHashCode = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzaqhVar;
        this.zzl = new zzapr();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzd = iHashCode;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzaqd) obj).zzg.intValue();
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        return "[ ] " + this.zzc + " " + "0x".concat(strValueOf) + " NORMAL " + this.zzg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzapm zzd() {
        return this.zzj;
    }

    public final zzaqd zze(zzapm zzapmVar) {
        this.zzj = zzapmVar;
        return this;
    }

    public final zzaqd zzf(zzaqg zzaqgVar) {
        this.zzh = zzaqgVar;
        return this;
    }

    public final zzaqd zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    public abstract zzaqj zzh(zzapz zzapzVar);

    public final String zzj() {
        int i = this.zzb;
        String str = this.zzc;
        return i != 0 ? CoroutineAdapterKt$$ExternalSyntheticLambda0.m(Integer.toString(1), "-", str) : str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzaqo.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzaqm zzaqmVar) {
        zzaqh zzaqhVar;
        synchronized (this.zze) {
            zzaqhVar = this.zzf;
        }
        zzaqhVar.zza(zzaqmVar);
    }

    public abstract void zzo(Object obj);

    public final void zzp(String str) {
        zzaqg zzaqgVar = this.zzh;
        if (zzaqgVar != null) {
            zzaqgVar.zzb(this);
        }
        if (zzaqo.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzaqb(this, str, id));
                return;
            }
            zzaqo zzaqoVar = this.zza;
            zzaqoVar.zza(str, id);
            zzaqoVar.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    public final void zzr() {
        zzaqc zzaqcVar;
        synchronized (this.zze) {
            zzaqcVar = this.zzk;
        }
        if (zzaqcVar != null) {
            zzaqcVar.zza(this);
        }
    }

    public final void zzs(zzaqj zzaqjVar) {
        zzaqc zzaqcVar;
        synchronized (this.zze) {
            zzaqcVar = this.zzk;
        }
        if (zzaqcVar != null) {
            zzaqcVar.zzb(this, zzaqjVar);
        }
    }

    public final void zzt(int i) {
        zzaqg zzaqgVar = this.zzh;
        if (zzaqgVar != null) {
            zzaqgVar.zzc(this, i);
        }
    }

    public final void zzu(zzaqc zzaqcVar) {
        synchronized (this.zze) {
            this.zzk = zzaqcVar;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() {
        return null;
    }

    public final zzapr zzy() {
        return this.zzl;
    }
}
