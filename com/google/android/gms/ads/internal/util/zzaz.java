package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.ads.zzapz;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzaqz;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbmc;
import com.google.android.gms.internal.ads.zzfqs;
import com.google.android.gms.internal.ads.zzfqt;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz extends zzaqs {
    public final Context zzb;

    public zzaz(Context context, zzare zzareVar) {
        super(zzareVar);
        this.zzb = context;
    }

    public static zzaqg zzb(Context context) {
        zzaqg zzaqgVar = new zzaqg(new zzaqz(new File(zzfqt.zza(zzfqs.zza(), context.getCacheDir(), "admob_volley")), 20971520), new zzaz(context, new zzare(null, null)), 4);
        zzaqgVar.zzd();
        return zzaqgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqs, com.google.android.gms.internal.ads.zzapw
    public final zzapz zza(zzaqd zzaqdVar) throws zzaqm {
        if (zzaqdVar.zza() == 0) {
            if (Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeK), zzaqdVar.zzk())) {
                com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.zza;
                Context context = this.zzb;
                if (googleApiAvailabilityLight.isGooglePlayServicesAvailable(context, 13400000) == 0) {
                    zzapz zzapzVarZza = new zzbmc(context).zza(zzaqdVar);
                    if (zzapzVarZza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzaqdVar.zzk())));
                        return zzapzVarZza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzaqdVar.zzk())));
                }
            }
        }
        return super.zza(zzaqdVar);
    }
}
