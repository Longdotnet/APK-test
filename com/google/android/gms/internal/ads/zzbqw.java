package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqw implements NativeMediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final zzbge zzg;
    private final boolean zzi;
    private final List zzh = new ArrayList();
    private final Map zzj = new HashMap();

    public zzbqw(Date date, int i, Set set, Location location, boolean z, int i2, zzbge zzbgeVar, List list, boolean z2, int i3, String str) {
        this.zza = date;
        this.zzb = i;
        this.zzc = set;
        this.zze = location;
        this.zzd = z;
        this.zzf = i2;
        this.zzg = zzbgeVar;
        this.zzi = z2;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.startsWith("custom:")) {
                    String[] strArrSplit = str2.split(":", 3);
                    if (strArrSplit.length == 3) {
                        if ("true".equals(strArrSplit[2])) {
                            this.zzj.put(strArrSplit[1], Boolean.TRUE);
                        } else if ("false".equals(strArrSplit[2])) {
                            this.zzj.put(strArrSplit[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.zzh.add(str2);
                }
            }
        }
    }

    public final float getAdVolume() {
        float fZze;
        com.google.android.gms.ads.internal.client.zzey zzeyVarZzf = com.google.android.gms.ads.internal.client.zzey.zzf();
        synchronized (zzeyVarZzf.zzk) {
            com.google.android.gms.ads.internal.client.zzdb zzdbVar = zzeyVarZzf.zzl;
            fZze = 1.0f;
            if (zzdbVar != null) {
                try {
                    fZze = zzdbVar.zze();
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to get app volume.", e);
                }
            }
        }
        return fZze;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        Parcelable.Creator<zzbge> creator = zzbge.CREATOR;
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        zzbge zzbgeVar = this.zzg;
        if (zzbgeVar == null) {
            return new NativeAdOptions(builder);
        }
        int i = zzbgeVar.zza;
        if (i == 2) {
            builder.zzf = zzbgeVar.zze;
        } else {
            if (i != 3) {
                if (i == 4) {
                    builder.zzg = zzbgeVar.zzg;
                    builder.zzc = zzbgeVar.zzh;
                }
            }
            com.google.android.gms.ads.internal.client.zzgc zzgcVar = zzbgeVar.zzf;
            if (zzgcVar != null) {
                builder.zze = new VideoOptions(zzgcVar);
            }
            builder.zzf = zzbgeVar.zze;
        }
        builder.zza = zzbgeVar.zzb;
        builder.zzb = zzbgeVar.zzc;
        builder.zzd = zzbgeVar.zzd;
        return new NativeAdOptions(builder);
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzbge.zza(this.zzg);
    }

    public final boolean isAdMuted() {
        boolean zZzv;
        com.google.android.gms.ads.internal.client.zzey zzeyVarZzf = com.google.android.gms.ads.internal.client.zzey.zzf();
        synchronized (zzeyVarZzf.zzk) {
            com.google.android.gms.ads.internal.client.zzdb zzdbVar = zzeyVarZzf.zzl;
            zZzv = false;
            if (zzdbVar != null) {
                try {
                    zZzv = zzdbVar.zzv();
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to get app mute state.", e);
                }
            }
        }
        return zZzv;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        return this.zzh.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map zza() {
        return this.zzj;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzb() {
        return this.zzh.contains("3");
    }
}
