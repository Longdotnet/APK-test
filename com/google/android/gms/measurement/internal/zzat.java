package com.google.android.gms.measurement.internal;

import com.facebook.login.vu.dLDI;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class zzat implements Iterator {
    public final Iterator zza;

    public zzat(zzau zzauVar) {
        this.zza = zzauVar.zza.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException(dLDI.mOTZPRCpwbI);
    }
}
