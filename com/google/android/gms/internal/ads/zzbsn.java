package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbsn implements View.OnClickListener {
    final /* synthetic */ zzbso zza;

    public zzbsn(zzbso zzbsoVar) {
        Objects.requireNonNull(zzbsoVar);
        this.zza = zzbsoVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zzb(true);
    }
}
