package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzetz implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;

    public zzetz(zzgdy zzgdyVar, Context context) {
        this.zza = zzgdyVar;
        this.zzb = context;
    }

    public static zzety zzc(zzetz zzetzVar) {
        return new zzety(StringsKt__IndentKt.zzb(zzetzVar.zzb, (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgr)));
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 37;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzetz.zzc(this.zza);
            }
        });
    }
}
