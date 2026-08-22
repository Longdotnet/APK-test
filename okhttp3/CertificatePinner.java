package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT;
    public final ExceptionsKt certificateChainCleaner;
    public final Set pins;

    static {
        ArrayList arrayList = new ArrayList();
        EmptySet emptySet = EmptySet.INSTANCE;
        int size = arrayList.size();
        Set set = emptySet;
        if (size != 0) {
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(arrayList.size()));
                CollectionsKt.toCollection(arrayList, linkedHashSet);
                set = linkedHashSet;
            } else {
                Set setSingleton = Collections.singleton(arrayList.get(0));
                Intrinsics.checkNotNullExpressionValue(setSingleton, "singleton(element)");
                set = setSingleton;
            }
        }
        DEFAULT = new CertificatePinner(set, null);
    }

    public CertificatePinner(Set set, ExceptionsKt exceptionsKt) {
        this.pins = set;
        this.certificateChainCleaner = exceptionsKt;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Intrinsics.areEqual(certificatePinner.pins, this.pins) && Intrinsics.areEqual(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        ExceptionsKt exceptionsKt = this.certificateChainCleaner;
        return iHashCode + (exceptionsKt != null ? exceptionsKt.hashCode() : 0);
    }
}
