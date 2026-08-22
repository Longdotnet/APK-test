package com.google.firebase.platforminfo;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_LibraryVersion extends LibraryVersion {
    public final String libraryName;
    public final String version;

    public AutoValue_LibraryVersion(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.libraryName = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.version = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        return this.libraryName.equals(((AutoValue_LibraryVersion) libraryVersion).libraryName) && this.version.equals(((AutoValue_LibraryVersion) libraryVersion).version);
    }

    public final int hashCode() {
        return ((this.libraryName.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.libraryName);
        sb.append(", version=");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.version, "}");
    }
}
