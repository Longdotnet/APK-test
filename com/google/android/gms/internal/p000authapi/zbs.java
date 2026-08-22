package com.google.android.gms.internal.p000authapi;

import android.os.IInterface;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public interface zbs extends IInterface {
    void zbb(Status status, Credential credential);

    void zbc(Status status);

    void zbd(Status status, String str);
}
