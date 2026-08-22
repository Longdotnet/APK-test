package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zae extends zai {
    protected final BaseImplementation.ApiMethodImpl zaa;

    public zae(int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        super(i);
        zzah.checkNotNull(apiMethodImpl, "Null methods are not runnable.");
        this.zaa = apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(Status status) {
        try {
            this.zaa.setFailedResult(status);
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        try {
            this.zaa.run(zabqVar.zaf());
        } catch (RuntimeException e) {
            zae(e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zag(zaad zaadVar, boolean z) {
        BaseImplementation.ApiMethodImpl apiMethodImpl = this.zaa;
        zaadVar.zaa.put(apiMethodImpl, Boolean.valueOf(z));
        apiMethodImpl.addStatusListener(new zaab(zaadVar, apiMethodImpl));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(Exception exc) {
        try {
            this.zaa.setFailedResult(new Status(10, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(exc.getClass().getSimpleName(), ": ", exc.getLocalizedMessage())));
        } catch (IllegalStateException e) {
            Log.w(ygoi.wCERGKMOSNwCyG, "Exception reporting failure", e);
        }
    }
}
