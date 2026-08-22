package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.AdFormat;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkj extends com.google.android.gms.ads.internal.client.zzcj {
    private final zzfkp zza;
    private final zzfkc zzb;

    public zzfkj(zzfkp zzfkpVar, zzfkc zzfkcVar) {
        super("com.google.android.gms.ads.internal.client.IAdPreloader");
        this.zza = zzfkpVar;
        this.zzb = zzfkcVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final int zze(int i, String str) {
        AdFormat adFormat = AdFormat.getAdFormat(i);
        if (adFormat == null) {
            return 0;
        }
        return this.zzb.zza(adFormat, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final Bundle zzf(int i) {
        Map mapZzf = this.zzb.zzf(i);
        Bundle bundle = new Bundle();
        for (Map.Entry entry : mapZzf.entrySet()) {
            String str = (String) entry.getKey();
            com.google.android.gms.ads.internal.client.zzfv zzfvVar = (com.google.android.gms.ads.internal.client.zzfv) entry.getValue();
            Parcel parcelObtain = Parcel.obtain();
            zzfvVar.writeToParcel(parcelObtain, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            bundle.putByteArray(str, bArrMarshall);
        }
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbaw zzg(String str) {
        return this.zzb.zzb(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbaw zzh(String str) {
        return this.zza.zza(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final com.google.android.gms.ads.internal.client.zzbx zzi(String str) {
        return this.zzb.zzc(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final com.google.android.gms.ads.internal.client.zzbx zzj(String str) {
        return this.zza.zzb(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final com.google.android.gms.ads.internal.client.zzfv zzk(int i, String str) {
        AdFormat adFormat = AdFormat.getAdFormat(i);
        if (adFormat == null) {
            return null;
        }
        return this.zzb.zzd(adFormat, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbwv zzl(String str) {
        return this.zzb.zze(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbwv zzm(String str) {
        return this.zza.zzc(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zzn(int i) {
        this.zzb.zzg(i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zzo(zzbpq zzbpqVar) {
        zzfkp zzfkpVar = this.zza;
        zzfkpVar.zzg(zzbpqVar);
        zzfkpVar.zzi();
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zzp(List list, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        this.zza.zzh(list, zzceVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzq(int i, String str) {
        AdFormat adFormat = AdFormat.getAdFormat(i);
        if (adFormat == null) {
            return false;
        }
        return this.zzb.zzh(adFormat, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzr(int i, String str) {
        AdFormat adFormat = AdFormat.getAdFormat(i);
        if (adFormat == null) {
            return false;
        }
        return this.zzb.zzi(adFormat, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzs(String str) {
        return this.zza.zzj(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzt(String str) {
        return this.zza.zzk(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzu(String str) {
        return this.zza.zzl(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzv(String str, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzch zzchVar) {
        return this.zzb.zzj(str, zzfvVar, zzchVar);
    }
}
