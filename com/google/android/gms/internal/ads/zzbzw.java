package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzbzw implements zzazw {
    final zzbzt zza;
    private final com.google.android.gms.ads.internal.util.zzg zze;
    private final Object zzd = new Object();
    final HashSet zzb = new HashSet();
    final HashSet zzc = new HashSet();
    private boolean zzg = false;
    private final zzbzu zzf = new zzbzu();

    public zzbzw(String str, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = new zzbzt(str, zzgVar);
        this.zze = zzgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zza(boolean z) {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z) {
            com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) this.zze;
            if (jCurrentTimeMillis - zzjVar.zzd() > ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbh)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = zzjVar.zzc();
            }
            this.zzg = true;
            return;
        }
        com.google.android.gms.ads.internal.util.zzj zzjVar2 = (com.google.android.gms.ads.internal.util.zzj) this.zze;
        zzjVar2.zzR();
        synchronized (zzjVar2.zza) {
            try {
                if (zzjVar2.zzo != jCurrentTimeMillis) {
                    zzjVar2.zzo = jCurrentTimeMillis;
                    SharedPreferences.Editor editor = zzjVar2.zzg;
                    if (editor != null) {
                        editor.putLong("app_last_background_time_ms", jCurrentTimeMillis);
                        zzjVar2.zzg.apply();
                    }
                    zzjVar2.zzS();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzjVar2.zzG(this.zza.zzd);
    }

    public final int zzb() {
        int iZza;
        synchronized (this.zzd) {
            iZza = this.zza.zza();
        }
        return iZza;
    }

    public final zzbzl zzc(Clock clock, String str) {
        return new zzbzl(clock, this, this.zzf.zza(), str);
    }

    public final String zzd() {
        return this.zzf.zzb();
    }

    public final void zze(zzbzl zzbzlVar) {
        synchronized (this.zzd) {
            this.zzb.add(zzbzlVar);
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            this.zza.zzc();
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final void zzh() {
        synchronized (this.zzd) {
            this.zza.zze();
        }
    }

    public final void zzi() {
        synchronized (this.zzd) {
            this.zza.zzf();
        }
    }

    public final void zzj(com.google.android.gms.ads.internal.client.zzm zzmVar, long j) {
        synchronized (this.zzd) {
            this.zza.zzg(zzmVar, j);
        }
    }

    public final void zzk() {
        synchronized (this.zzd) {
            this.zza.zzh();
        }
    }

    public final void zzl(HashSet hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final boolean zzm() {
        return this.zzg;
    }

    public final Bundle zzn(Context context, zzfed zzfedVar) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            HashSet hashSet2 = this.zzb;
            hashSet.addAll(hashSet2);
            hashSet2.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zzb(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator it = this.zzc.iterator();
        if (it.hasNext()) {
            throw null;
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(((zzbzl) it2.next()).zza());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        zzfedVar.zzc(hashSet);
        return bundle;
    }
}
