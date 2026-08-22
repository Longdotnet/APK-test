package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpz {
    private final zzfds zza;
    private final zzdpw zzb;

    public zzdpz(zzfds zzfdsVar, zzdpw zzdpwVar) {
        this.zza = zzfdsVar;
        this.zzb = zzdpwVar;
    }

    public final zzbpq zza() throws RemoteException {
        zzbpq zzbpqVarZzb = this.zza.zzb();
        if (zzbpqVarZzb != null) {
            return zzbpqVarZzb;
        }
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final zzbrp zzb(String str) {
        zzbrp zzbrpVarZzc = zza().zzc(str);
        this.zzb.zzd(str, zzbrpVarZzc);
        return zzbrpVarZzc;
    }

    public final zzfdu zzc(String str, JSONObject jSONObject) {
        zzbpt zzbptVarZzb;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzbptVarZzb = new zzbqr(new AdMobAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzbptVarZzb = new zzbqr(new zzbsi());
            } else {
                zzbpq zzbpqVarZza = zza();
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                    try {
                        String string = jSONObject.getString("class_name");
                        if (zzbpqVarZza.zze(string)) {
                            zzbptVarZzb = zzbpqVarZza.zzb("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                        } else {
                            zzbptVarZzb = zzbpqVarZza.zzd(string) ? zzbpqVarZza.zzb(string) : zzbpqVarZza.zzb("com.google.ads.mediation.customevent.CustomEventAdapter");
                        }
                    } catch (JSONException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Invalid custom event.", e);
                        zzbptVarZzb = zzbpqVarZza.zzb(str);
                    }
                } else {
                    zzbptVarZzb = zzbpqVarZza.zzb(str);
                }
            }
            zzfdu zzfduVar = new zzfdu(zzbptVarZzb);
            this.zzb.zzc(str, zzfduVar);
            return zzfduVar;
        } catch (Throwable th) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjM)).booleanValue()) {
                this.zzb.zzc(str, null);
            }
            throw new zzfdd(th);
        }
    }

    public final boolean zzd() {
        return this.zza.zzb() != null;
    }
}
