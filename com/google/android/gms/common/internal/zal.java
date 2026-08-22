package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes.dex */
public final class zal {
    public final SparseIntArray zaa = new SparseIntArray();
    public final GoogleApiAvailabilityLight zab;

    public zal(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        zzah.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }

    public final int zab(Context context, Api.Client client) {
        zzah.checkNotNull(context);
        zzah.checkNotNull(client);
        int i = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        SparseIntArray sparseIntArray = this.zaa;
        int iIsGooglePlayServicesAvailable = sparseIntArray.get(minApkVersion, -1);
        if (iIsGooglePlayServicesAvailable == -1) {
            int i2 = 0;
            while (true) {
                if (i2 >= sparseIntArray.size()) {
                    i = -1;
                    break;
                }
                int iKeyAt = sparseIntArray.keyAt(i2);
                if (iKeyAt > minApkVersion && sparseIntArray.get(iKeyAt) == 0) {
                    break;
                }
                i2++;
            }
            iIsGooglePlayServicesAvailable = i == -1 ? this.zab.isGooglePlayServicesAvailable(context, minApkVersion) : i;
            sparseIntArray.put(minApkVersion, iIsGooglePlayServicesAvailable);
        }
        return iIsGooglePlayServicesAvailable;
    }
}
