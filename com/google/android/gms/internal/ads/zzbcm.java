package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.Callable;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcm {
    private final Context zza;

    public zzbcm(Context context) {
        com.google.android.gms.common.internal.zzah.checkNotNull(context, "Context can not be null");
        this.zza = context;
    }

    public final boolean zza(Intent intent) {
        com.google.android.gms.common.internal.zzah.checkNotNull(intent, "Intent can not be null");
        return !this.zza.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public final boolean zzb() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    public final boolean zzc() {
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzbcl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
            }
        };
        Context context = this.zza;
        return ((Boolean) MapsKt__MapsKt.zza(context, callable)).booleanValue() && Wrappers.packageManager(context).val$context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
