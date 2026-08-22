package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvr extends com.google.android.gms.ads.internal.client.zzdz {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzedr zzh;
    private final Bundle zzi;
    private final double zzj;

    public zzcvr(zzfca zzfcaVar, String str, zzedr zzedrVar, zzfcd zzfcdVar, String str2) {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
        String string = null;
        this.zzb = zzfcaVar == null ? null : zzfcaVar.zzab;
        this.zzc = str2;
        this.zzd = zzfcdVar == null ? null : zzfcdVar.zzb;
        if (("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) && zzfcaVar != null) {
            try {
                string = zzfcaVar.zzv.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = string != null ? string : str;
        this.zze = zzedrVar.zzc();
        this.zzh = zzedrVar;
        this.zzj = zzfcaVar == null ? 0.0d : zzfcaVar.zzaz;
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zzf = System.currentTimeMillis() / 1000;
        zzbcv zzbcvVar = zzbde.zzgY;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() || zzfcdVar == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzfcdVar.zzk;
        }
        this.zzg = (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzjG)).booleanValue() || zzfcdVar == null || TextUtils.isEmpty(zzfcdVar.zzi)) ? "" : zzfcdVar.zzi;
    }

    public final double zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final Bundle zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final com.google.android.gms.ads.internal.client.zzv zzf() {
        zzedr zzedrVar = this.zzh;
        if (zzedrVar != null) {
            return zzedrVar.zza();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final String zzg() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final String zzh() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final String zzi() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzg;
    }

    public final String zzl() {
        return this.zzd;
    }
}
