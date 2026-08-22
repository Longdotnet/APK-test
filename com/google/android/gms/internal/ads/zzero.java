package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzero implements zzeuc {
    private final zzgdy zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzero(zzgdy zzgdyVar, ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzgdyVar;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public static zzerp zzc(zzero zzeroVar) {
        zzbcv zzbcvVar = zzbde.zzgg;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && zzeroVar.zzb != null && zzeroVar.zzd.contains("banner")) {
            return new zzerp(Boolean.valueOf(zzeroVar.zzb.isHardwareAccelerated()));
        }
        boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzgh)).booleanValue();
        Boolean boolValueOf = null;
        if (zBooleanValue && zzeroVar.zzd.contains("native")) {
            Context context = zzeroVar.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        boolValueOf = Boolean.valueOf((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    boolValueOf = Boolean.TRUE;
                }
                return new zzerp(boolValueOf);
            }
        }
        return new zzerp(null);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 22;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzern
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzero.zzc(this.zza);
            }
        });
    }
}
