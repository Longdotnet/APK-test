package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class Topic {
    public final long modelVersion;
    public final long taxonomyVersion;
    public final int topicId;

    public Topic(long j, long j2, int i) {
        this.taxonomyVersion = j;
        this.modelVersion = j2;
        this.topicId = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        return this.taxonomyVersion == topic.taxonomyVersion && this.modelVersion == topic.modelVersion && this.topicId == topic.topicId;
    }

    public final int hashCode() {
        long j = this.taxonomyVersion;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.modelVersion;
        return ((i + ((int) ((j2 >>> 32) ^ j2))) * 31) + this.topicId;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TaxonomyVersion=");
        sb.append(this.taxonomyVersion);
        sb.append(", ModelVersion=");
        sb.append(this.modelVersion);
        sb.append(", TopicCode=");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Topic { ", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.topicId, " }"));
    }
}
