package com.google.android.gms.internal.auth;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
final class zzcn implements zzck {
    private static zzcn zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzcn() {
        this.zzb = null;
        this.zzc = null;
    }

    public static zzcn zza(Context context) {
        zzcn zzcnVar;
        synchronized (zzcn.class) {
            try {
                if (zza == null) {
                    zza = RangesKt.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcn(context) : new zzcn();
                }
                zzcnVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzcnVar;
    }

    public static synchronized void zze() {
        Context context;
        try {
            zzcn zzcnVar = zza;
            if (zzcnVar != null && (context = zzcnVar.zzb) != null && zzcnVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.auth.zzck
    /* JADX INFO: renamed from: zzc */
    public final String zzb(final String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzci.zza(new zzcj() { // from class: com.google.android.gms.internal.auth.zzcl
                @Override // com.google.android.gms.internal.auth.zzcj
                public final Object zza() {
                    return this.zza.zzd(str);
                }
            });
        } catch (IllegalStateException | SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    public final /* synthetic */ String zzd(String str) {
        return zzcb.zza(this.zzb.getContentResolver(), str, null);
    }

    private zzcn(Context context) {
        this.zzb = context;
        zzcm zzcmVar = new zzcm(this, null);
        this.zzc = zzcmVar;
        context.getContentResolver().registerContentObserver(zzcb.zza, true, zzcmVar);
    }
}
