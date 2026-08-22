package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcfl implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbya zza;
    final /* synthetic */ zzcfo zzb;

    public zzcfl(zzcfo zzcfoVar, zzbya zzbyaVar) {
        this.zza = zzbyaVar;
        Objects.requireNonNull(zzcfoVar);
        this.zzb = zzcfoVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzac(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
