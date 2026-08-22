package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes.dex */
final class zzfvz extends zzfwc {
    final /* synthetic */ zzfvb zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfvz(zzfwe zzfweVar, CharSequence charSequence, zzfvb zzfvbVar) {
        super(zzfweVar, charSequence);
        this.zza = zzfvbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfwc
    public final int zzc(int i) {
        return ((zzfvf) this.zza).zza.end();
    }

    @Override // com.google.android.gms.internal.ads.zzfwc
    public final int zzd(int i) {
        Matcher matcher = ((zzfvf) this.zza).zza;
        if (matcher.find(i)) {
            return matcher.start();
        }
        return -1;
    }
}
