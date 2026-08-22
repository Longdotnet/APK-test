package com.google.android.gms.common.data;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.zzah;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class SingleRefDataBufferIterator extends DataBufferIterator {
    public Object zac;

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(this.zab, "Cannot advance the iterator beyond "));
        }
        int i = this.zab + 1;
        this.zab = i;
        if (i == 0) {
            Object obj = this.zaa.get(0);
            zzah.checkNotNull(obj);
            this.zac = obj;
            if (!(obj instanceof DataBufferRef)) {
                throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("DataBuffer reference of type ", String.valueOf(obj.getClass()), " is not movable"));
            }
        } else {
            Object obj2 = this.zac;
            zzah.checkNotNull(obj2);
            ((DataBufferRef) obj2).zaa(this.zab);
        }
        return this.zac;
    }
}
