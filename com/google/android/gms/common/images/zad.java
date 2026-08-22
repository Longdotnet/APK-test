package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zad {
    public final Uri zaa;

    public zad(Uri uri) {
        this.zaa = uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zad) {
            return zzah.equal(((zad) obj).zaa, this.zaa);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zaa});
    }
}
