package com.google.zxing;

/* JADX INFO: loaded from: classes3.dex */
public final class FormatException extends ReaderException {
    public static final FormatException INSTANCE;

    static {
        FormatException formatException = new FormatException();
        INSTANCE = formatException;
        formatException.setStackTrace(ReaderException.NO_TRACE);
    }
}
