package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Batch extends BasePendingResult<BatchResult> {
    public int zae;
    public boolean zaf;
    public boolean zag;
    public final PendingResult[] zah;
    public final Object zai;

    public static final class Builder {
        public final ArrayList zaa = new ArrayList();
        public final GoogleApiClient zab;

        public Builder(GoogleApiClient googleApiClient) {
            this.zab = googleApiClient;
        }

        @ResultIgnorabilityUnspecified
        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            ArrayList arrayList = this.zaa;
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(arrayList.size());
            arrayList.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zaa, this.zab);
        }
    }

    public /* synthetic */ Batch(ArrayList arrayList, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zai = new Object();
        int size = arrayList.size();
        this.zae = size;
        PendingResult[] pendingResultArr = new PendingResult[size];
        this.zah = pendingResultArr;
        if (arrayList.isEmpty()) {
            setResult(new BatchResult(Status.RESULT_SUCCESS, pendingResultArr));
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            PendingResult pendingResult = (PendingResult) arrayList.get(i);
            this.zah[i] = pendingResult;
            pendingResult.addStatusListener(new zab(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        int i = 0;
        while (true) {
            PendingResult[] pendingResultArr = this.zah;
            if (i >= pendingResultArr.length) {
                return;
            }
            pendingResultArr[i].cancel();
            i++;
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zah);
    }
}
