package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzetq implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final String zzd;

    public zzetq(zzgdy zzgdyVar, Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zza = zzgdyVar;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = str;
    }

    public static zzetr zzc(zzetq zzetqVar) {
        Context context = zzetqVar.zzb;
        boolean zIsCallerInstantApp = Wrappers.packageManager(context).isCallerInstantApp();
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        boolean zZzF = com.google.android.gms.ads.internal.util.zzs.zzF(context);
        String str = zzetqVar.zzc.afmaVersion;
        int iMyUid = Process.myUid();
        boolean z = iMyUid == 0 || iMyUid == 1000;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return new zzetr(zIsCallerInstantApp, zZzF, str, z, applicationInfo == null ? 0 : applicationInfo.targetSdkVersion, DynamiteModule.zza(context, ModuleDescriptor.MODULE_ID, false), DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID), zzetqVar.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 35;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzetq.zzc(this.zza);
            }
        });
    }
}
