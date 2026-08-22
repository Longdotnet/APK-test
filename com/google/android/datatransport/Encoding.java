package com.google.android.datatransport;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class Encoding {
    public final String name;

    public Encoding(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.name.equals(((Encoding) obj).name);
    }

    public final int hashCode() {
        return this.name.hashCode() ^ 1000003;
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder("Encoding{name=\""), this.name, "\"}");
    }
}
