package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfyo extends zzfwp {
    private final zzfyq zza;

    public zzfyo(zzfyq zzfyqVar, int i) {
        super(zzfyqVar.size(), i);
        this.zza = zzfyqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfwp
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
