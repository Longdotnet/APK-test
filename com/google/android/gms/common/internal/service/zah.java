package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.GmsClient;

/* JADX INFO: loaded from: classes.dex */
public final class zah extends GmsClient {
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        return iInterfaceQueryLocalInterface instanceof zal ? (zal) iInterfaceQueryLocalInterface : new zal(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.service.START";
    }
}
