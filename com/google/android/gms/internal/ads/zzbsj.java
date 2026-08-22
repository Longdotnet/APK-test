package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbsj implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbsl zza;

    public zzbsj(zzbsl zzbslVar) {
        Objects.requireNonNull(zzbslVar);
        this.zza = zzbslVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbsl zzbslVar = this.zza;
        Intent intentZzb = zzbslVar.zzb();
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        com.google.android.gms.ads.internal.util.zzs.zzU(zzbslVar.zzb, intentZzb);
    }
}
