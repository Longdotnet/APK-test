package org.json;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class JSONException extends Exception {
    private static final long serialVersionUID = 0;
    public IOException cause;

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.cause;
    }
}
