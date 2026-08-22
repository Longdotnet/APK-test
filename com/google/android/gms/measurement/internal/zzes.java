package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class zzes {
    public final /* synthetic */ zzew zza;
    public final String zzb;
    public final long zzc;
    public boolean zzd;
    public long zze;

    public zzes(zzew zzewVar, String str, long j) {
        this.zza = zzewVar;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j;
    }

    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long j) {
        SharedPreferences.Editor editorEdit = this.zza.zza().edit();
        editorEdit.putLong(this.zzb, j);
        editorEdit.apply();
        this.zze = j;
    }
}
