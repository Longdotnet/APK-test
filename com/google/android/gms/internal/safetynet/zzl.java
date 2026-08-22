package com.google.android.gms.internal.safetynet;

import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
final class zzl extends zzk.zzb {
    private final /* synthetic */ byte[] zzw;
    private final /* synthetic */ String zzx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzl(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        super(googleApiClient);
        this.zzw = bArr;
        this.zzx = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        zzx zzxVar = (zzx) anyClient;
        zzg zzgVar = this.zzaf;
        byte[] bArr = this.zzw;
        String strZzb = this.zzx;
        if (TextUtils.isEmpty(strZzb)) {
            strZzb = zzxVar.zzb("com.google.android.safetynet.ATTEST_API_KEY");
        }
        ((zzi) zzxVar.getService()).zza(zzgVar, bArr, strZzb);
    }
}
