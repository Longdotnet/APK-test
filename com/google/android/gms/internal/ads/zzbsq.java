package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbsq implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbsr zza;

    public zzbsq(zzbsr zzbsrVar) {
        Objects.requireNonNull(zzbsrVar);
        this.zza = zzbsrVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("User canceled the download.");
    }
}
