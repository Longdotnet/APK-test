package androidx.privacysandbox.ads.adservices.topics;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class GetTopicsResponse {
    public final AbstractCollection topics;

    /* JADX WARN: Multi-variable type inference failed */
    public GetTopicsResponse(List topics) {
        Intrinsics.checkNotNullParameter(topics, "topics");
        this.topics = (AbstractCollection) topics;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractCollection, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.AbstractCollection, java.util.List] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        ?? r0 = this.topics;
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (r0.size() != getTopicsResponse.topics.size()) {
            return false;
        }
        return new HashSet((Collection) r0).equals(new HashSet(getTopicsResponse.topics));
    }

    public final int hashCode() {
        return Objects.hash(this.topics);
    }

    public final String toString() {
        return "Topics=" + this.topics;
    }
}
