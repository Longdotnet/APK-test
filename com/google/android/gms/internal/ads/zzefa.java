package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzefa implements zzdgn {
    final /* synthetic */ zzcak zza;
    final /* synthetic */ zzfca zzb;
    final /* synthetic */ zzefb zzc;

    public zzefa(zzefb zzefbVar, zzcak zzcakVar, zzfca zzfcaVar) {
        this.zza = zzcakVar;
        this.zzb = zzfcaVar;
        Objects.requireNonNull(zzefbVar);
        this.zzc = zzefbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) {
        try {
            GraphRequest.Companion companion = com.google.android.gms.ads.internal.zzv.zza.zzc;
            GraphRequest.Companion.zza(context, (AdOverlayInfoParcel) this.zza.get(), true, this.zzc.zze);
        } catch (Exception unused) {
        }
    }
}
