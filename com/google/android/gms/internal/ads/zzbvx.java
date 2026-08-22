package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvx {
    private final WeakHashMap zza = new WeakHashMap();

    public final Future zzb(Context context) {
        return zzcaf.zza.zzb(new zzbvv(this, context));
    }
}
