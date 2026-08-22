package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class zzeq {
    public final /* synthetic */ zzew zza;
    public final String zzb;
    public final boolean zzc;
    public boolean zzd;
    public boolean zze;

    public zzeq(zzew zzewVar, String str, boolean z) {
        this.zza = zzewVar;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = z;
    }

    public final void zza(boolean z) {
        SharedPreferences.Editor editorEdit = this.zza.zza().edit();
        editorEdit.putBoolean(this.zzb, z);
        editorEdit.apply();
        this.zze = z;
    }

    public final boolean zzb() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }
}
