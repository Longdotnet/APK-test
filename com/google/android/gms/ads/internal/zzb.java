package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.ads.zzbuy;
import com.google.android.gms.internal.ads.zzbya;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzb {
    public final Context zza;
    public boolean zzb;
    public final zzbya zzc;
    public final zzbuy zzd = new zzbuy(false, Collections.emptyList());

    public zzb(Context context, zzbya zzbyaVar) {
        this.zza = context;
        this.zzc = zzbyaVar;
    }

    public final boolean zzc() {
        zzbya zzbyaVar = this.zzc;
        return ((zzbyaVar == null || !zzbyaVar.zza().zzf) && !this.zzd.zza) || this.zzb;
    }

    public final void zzb(String str) {
        List<String> list;
        zzbuy zzbuyVar = this.zzd;
        zzbya zzbyaVar = this.zzc;
        if ((zzbyaVar == null || !zzbyaVar.zza().zzf) && !zzbuyVar.zza) {
            return;
        }
        String str2 = oKjScaD.EUifcZLe;
        if (str == null) {
            str = str2;
        }
        if (zzbyaVar != null) {
            zzbyaVar.zze(str, null, 3);
            return;
        }
        if (!zzbuyVar.zza || (list = zzbuyVar.zzb) == null) {
            return;
        }
        for (String str3 : list) {
            if (!TextUtils.isEmpty(str3)) {
                String strReplace = str3.replace("{NAVIGATION_URL}", Uri.encode(str));
                zzs zzsVar = zzv.zza.zzd;
                new zzbw(this.zza, str2, strReplace, null).zzb();
            }
        }
    }
}
