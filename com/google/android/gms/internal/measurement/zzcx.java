package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* JADX INFO: loaded from: classes.dex */
final class zzcx extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzef zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcx(zzef zzefVar, String str, String str2, Context context, Bundle bundle) {
        super(zzefVar, true);
        this.zze = zzefVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        String str;
        String str2;
        String str3;
        try {
            if (this.zze.zzW(this.zza, this.zzb)) {
                str3 = this.zzb;
                str2 = this.zza;
                str = this.zze.zzd;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            com.google.android.gms.common.internal.zzah.checkNotNull(this.zzc);
            zzef zzefVar = this.zze;
            zzefVar.zzj = zzefVar.zzf(this.zzc, true);
            if (this.zze.zzj == null) {
                Log.w(this.zze.zzd, "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(this.zzc, ModuleDescriptor.MODULE_ID);
            int iZza = DynamiteModule.zza(this.zzc, ModuleDescriptor.MODULE_ID, false);
            zzcl zzclVar = new zzcl(74029L, Math.max(localVersion, iZza), iZza < localVersion, str, str2, str3, this.zzd, com.google.android.gms.measurement.internal.zzg.zza(this.zzc));
            zzcc zzccVar = this.zze.zzj;
            com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
            zzccVar.initialize(new ObjectWrapper(this.zzc), zzclVar, this.zzh);
        } catch (Exception e) {
            this.zze.zzT(e, true, false);
        }
    }
}
