package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public class BaseImplementation {

    public interface ResultHolder<R> {
        void setFailedResult(Status status);

        void setResult(R r);
    }

    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
        private final Api<?> api;
        private final Api.AnyClientKey<A> clientKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public ApiMethodImpl(Api.AnyClientKey<A> anyClientKey, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            zzah.checkNotNull(googleApiClient, "GoogleApiClient must not be null");
            zzah.checkNotNull(anyClientKey);
            this.clientKey = anyClientKey;
            this.api = null;
        }

        public abstract void doExecute(A a);

        public final Api<?> getApi() {
            return this.api;
        }

        public final Api.AnyClientKey<A> getClientKey() {
            return this.clientKey;
        }

        public void onSetFailedResult(R r) {
        }

        public final void run(A a) throws DeadObjectException {
            try {
                doExecute(a);
            } catch (DeadObjectException e) {
                setFailedResult(new Status(8, e.getLocalizedMessage(), (PendingIntent) null));
                throw e;
            } catch (RemoteException e2) {
                setFailedResult(new Status(8, e2.getLocalizedMessage(), (PendingIntent) null));
            }
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        public final void setFailedResult(Status status) {
            zzah.checkArgument(!status.isSuccess(), "Failed result must not be success");
            R rCreateFailedResult = createFailedResult(status);
            setResult((Result) rCreateFailedResult);
            onSetFailedResult(rCreateFailedResult);
        }

        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((Result) obj);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApiMethodImpl(Api<?> api, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            zzah.checkNotNull(googleApiClient, "GoogleApiClient must not be null");
            zzah.checkNotNull(api, "Api must not be null");
            this.clientKey = api.zab();
            this.api = api;
        }

        public ApiMethodImpl(BasePendingResult.CallbackHandler<R> callbackHandler) {
            super(callbackHandler);
            this.clientKey = new Api.AnyClientKey<>();
            this.api = null;
        }
    }
}
