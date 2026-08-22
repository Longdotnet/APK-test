package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzack extends IOException {
    public zzack() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzack(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    public zzack(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
