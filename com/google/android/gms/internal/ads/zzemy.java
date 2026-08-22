package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzemy implements zzeuc {
    private final zzgdy zza;
    private final zzdpz zzb;
    private final zzdun zzc;
    private final zzena zzd;

    public zzemy(zzgdy zzgdyVar, zzdpz zzdpzVar, zzdun zzdunVar, zzena zzenaVar) {
        this.zza = zzgdyVar;
        this.zzb = zzdpzVar;
        this.zzc = zzdunVar;
        this.zzd = zzenaVar;
    }

    public static zzemz zzc(zzemy zzemyVar) {
        List<String> listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbD)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : listAsList) {
            try {
                zzfdu zzfduVarZzc = zzemyVar.zzb.zzc(str, new JSONObject());
                zzfduVarZzc.zzC();
                boolean zZzt = zzemyVar.zzc.zzt();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmb)).booleanValue() || zZzt) {
                    try {
                        zzbse zzbseVarZzf = zzfduVarZzc.zzf();
                        if (zzbseVarZzf != null) {
                            bundle2.putString("sdk_version", zzbseVarZzf.toString());
                        }
                    } catch (zzfdd unused) {
                    }
                }
                try {
                    zzbse zzbseVarZze = zzfduVarZzc.zze();
                    if (zzbseVarZze != null) {
                        bundle2.putString("adapter_version", zzbseVarZze.toString());
                    }
                } catch (zzfdd unused2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzfdd unused3) {
            }
        }
        zzemz zzemzVar = new zzemz(bundle);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmb)).booleanValue()) {
            zzemyVar.zzd.zzb(zzemzVar);
        }
        return zzemzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzbcv zzbcvVar = zzbde.zzmb;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzena zzenaVar = this.zzd;
            if (zzenaVar.zza() != null) {
                zzemz zzemzVarZza = zzenaVar.zza();
                zzemzVarZza.getClass();
                return zzgdn.zzh(zzemzVarZza);
            }
        }
        if (zzfwg.zzd((String) zzbdVar.zzd.zzb(zzbde.zzbD)) || (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && (this.zzd.zzd() || !this.zzc.zzt()))) {
            return zzgdn.zzh(new zzemz(new Bundle()));
        }
        this.zzd.zzc(true);
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzemx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzemy.zzc(this.zza);
            }
        });
    }
}
