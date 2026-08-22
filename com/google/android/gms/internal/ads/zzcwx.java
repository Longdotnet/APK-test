package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwx extends zzdbt {
    public zzcwx(Set set) {
        super(set);
    }

    public final void zza(final Context context) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcww
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcwt) obj).zzdj(context);
            }
        });
    }

    public final void zzb(final Context context) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcwu
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcwt) obj).zzdl(context);
            }
        });
    }

    public final void zzc(final Context context) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcwv
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcwt) obj).zzdm(context);
            }
        });
    }
}
