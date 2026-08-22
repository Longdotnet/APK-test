package com.google.android.gms.common;

/* JADX INFO: loaded from: classes.dex */
public final class zzv extends zzx {
    public final zze zze;

    public /* synthetic */ zzv(zze zzeVar) {
        super(false, null, null);
        this.zze = zzeVar;
    }

    @Override // com.google.android.gms.common.zzx
    public final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
