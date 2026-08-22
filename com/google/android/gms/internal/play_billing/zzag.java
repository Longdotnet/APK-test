package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzag extends zzac {
    private final zzai zza;

    public zzag(zzai zzaiVar, int i) {
        super(zzaiVar.size(), i);
        this.zza = zzaiVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
