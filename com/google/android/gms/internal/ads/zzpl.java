package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzpl extends ContentObserver {
    final /* synthetic */ zzpo zza;
    private final ContentResolver zzb;
    private final Uri zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpl(zzpo zzpoVar, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        Objects.requireNonNull(zzpoVar);
        this.zza = zzpoVar;
        this.zzb = contentResolver;
        this.zzc = uri;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzpo zzpoVar = this.zza;
        zzpoVar.zzk(zzpj.zzc(zzpoVar.zza, zzpoVar.zzh, zzpoVar.zzg));
    }

    public final void zza() {
        this.zzb.registerContentObserver(this.zzc, false, this);
    }

    public final void zzb() {
        this.zzb.unregisterContentObserver(this);
    }
}
