package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
final class zzfvy extends zzfwc {
    final /* synthetic */ zzfva zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfvy(zzfwe zzfweVar, CharSequence charSequence, zzfva zzfvaVar) {
        super(zzfweVar, charSequence);
        this.zza = zzfvaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfwc
    public final int zzc(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzfwc
    public final int zzd(int i) {
        CharSequence charSequence = ((zzfwc) this).zzb;
        int length = charSequence.length();
        zzfvp.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (this.zza.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
