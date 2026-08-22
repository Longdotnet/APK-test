package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
final class zzhn implements zzhk {
    private static zzhn zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzhn() {
        this.zzb = null;
        this.zzc = null;
    }

    public static zzhn zza(Context context) {
        zzhn zzhnVar;
        synchronized (zzhn.class) {
            try {
                if (zza == null) {
                    zza = RangesKt.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzhn(context) : new zzhn();
                }
                zzhnVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhnVar;
    }

    public static synchronized void zze() {
        Context context;
        try {
            zzhn zzhnVar = zza;
            if (zzhnVar != null && (context = zzhnVar.zzb) != null && zzhnVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhk
    /* JADX INFO: renamed from: zzc */
    public final String zzb(final String str) {
        Context context = this.zzb;
        if (context != null && !zzhb.zza(context)) {
            try {
                return (String) zzhi.zza(new zzhj() { // from class: com.google.android.gms.internal.measurement.zzhl
                    @Override // com.google.android.gms.internal.measurement.zzhj
                    public final Object zza() {
                        return this.zza.zzd(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            }
        }
        return null;
    }

    public final /* synthetic */ String zzd(String str) {
        return zzha.zza(this.zzb.getContentResolver(), str, null);
    }

    private zzhn(Context context) {
        this.zzb = context;
        zzhm zzhmVar = new zzhm(this, null);
        this.zzc = zzhmVar;
        context.getContentResolver().registerContentObserver(zzha.zza, true, zzhmVar);
    }
}
