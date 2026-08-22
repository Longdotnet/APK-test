package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzgn implements zzcw {
    static final zzcw zza = new zzgn();

    private zzgn() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzcw
    public final boolean zza(int i) {
        zzgo zzgoVar;
        zzgo zzgoVar2 = zzgo.BROADCAST_ACTION_UNSPECIFIED;
        if (i == 0) {
            zzgoVar = zzgo.BROADCAST_ACTION_UNSPECIFIED;
        } else if (i == 1) {
            zzgoVar = zzgo.PURCHASES_UPDATED_ACTION;
        } else if (i != 2) {
            zzgoVar = i != 3 ? null : zzgo.ALTERNATIVE_BILLING_ACTION;
        } else {
            zzgoVar = zzgo.LOCAL_PURCHASES_UPDATED_ACTION;
        }
        return zzgoVar != null;
    }
}
