package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzeit implements zzedm {
    private final zzedo zza;
    private final zzeds zzb;
    private final zzfha zzc;
    private final zzgdy zzd;

    public zzeit(zzfha zzfhaVar, zzgdy zzgdyVar, zzedo zzedoVar, zzeds zzedsVar) {
        this.zzc = zzfhaVar;
        this.zzd = zzgdyVar;
        this.zzb = zzedsVar;
        this.zza = zzedoVar;
    }

    public static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        final zzedp zzedpVarZza;
        Iterator it = zzfcaVar.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzedpVarZza = null;
                break;
            }
            try {
                zzedpVarZza = this.zza.zza((String) it.next(), zzfcaVar.zzv);
                break;
            } catch (zzfdd unused) {
            }
        }
        if (zzedpVarZza == null) {
            return zzgdn.zzg(new zzegj("Unable to instantiate mediation adapter class."));
        }
        zzcak zzcakVar = new zzcak();
        zzedpVarZza.zzc.zza(new zzeis(this, zzedpVarZza, zzcakVar));
        if (zzfcaVar.zzM) {
            Bundle bundle = zzfcnVar.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfha zzfhaVar = this.zzc;
        zzfgu zzfguVar = zzfgu.ADAPTER_LOAD_AD_SYN;
        Objects.requireNonNull(zzfhaVar);
        return zzfgk.zzd(new zzfgf() { // from class: com.google.android.gms.internal.ads.zzeiq
            @Override // com.google.android.gms.internal.ads.zzfgf
            public final void zza() {
                this.zza.zzb.zzb(zzfcnVar, zzfcaVar, zzedpVarZza);
            }
        }, this.zzd, zzfguVar, zzfhaVar).zzb(zzfgu.ADAPTER_LOAD_AD_ACK).zzd(zzcakVar).zzb(zzfgu.ADAPTER_WRAP_ADAPTER).zze(new zzfge() { // from class: com.google.android.gms.internal.ads.zzeir
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                return this.zza.zzb.zza(zzfcnVar, zzfcaVar, zzedpVarZza);
            }
        }).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        return !zzfcaVar.zzt.isEmpty();
    }
}
