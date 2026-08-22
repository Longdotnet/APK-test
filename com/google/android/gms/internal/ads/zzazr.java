package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;

/* JADX INFO: loaded from: classes2.dex */
public final class zzazr extends com.google.android.gms.ads.internal.client.zzcn {
    private final AppEventListener zza;

    public final AppEventListener zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzc(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }

    public zzazr(AppEventListener appEventListener) {
        super(QTaELkFI.iwIdyl);
        this.zza = appEventListener;
    }
}
