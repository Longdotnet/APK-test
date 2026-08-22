package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes.dex */
public class Response<T extends Result> {
    public Result zza;

    public Response() {
    }

    public T getResult() {
        return (T) this.zza;
    }

    public void setResult(T t) {
        this.zza = t;
    }

    public Response(T t) {
        this.zza = t;
    }
}
