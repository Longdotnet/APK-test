package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.drive.zza;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zza(1);
    public final int zaa;
    public Bundle zab;
    public int[] zac;
    public int zad;
    public boolean zae = false;
    public final String[] zag;
    public final CursorWindow[] zah;
    public final int zai;
    public final Bundle zaj;

    static {
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.zaa = i;
        this.zag = strArr;
        this.zah = cursorWindowArr;
        this.zai = i2;
        this.zaj = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            try {
                if (!this.zae) {
                    this.zae = true;
                    int i = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.zah;
                        if (i >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i].close();
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            if (this.zah.length > 0 && !isClosed()) {
                close();
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean getBoolean(int i, int i2, String str) {
        zae(i, str);
        return this.zah[i2].getLong(i, this.zab.getInt(str)) == 1;
    }

    public final String getString(int i, int i2, String str) {
        zae(i, str);
        return this.zah[i2].getString(i, this.zab.getInt(str));
    }

    public final int getWindowIndex(int i) {
        int length;
        int i2 = 0;
        zzah.checkState$1(i >= 0 && i < this.zad);
        while (true) {
            int[] iArr = this.zac;
            length = iArr.length;
            if (i2 >= length) {
                break;
            }
            if (i < iArr[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == length ? i2 - 1 : i2;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.zae;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeStringArray(parcel, 1, this.zag, false);
        CloseableKt.writeTypedArray(parcel, 2, this.zah, i);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zai);
        CloseableKt.writeBundle(parcel, 4, this.zaj, false);
        CloseableKt.zzc(parcel, 1000, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.zzb(parcel, iZza);
        if ((i & 1) != 0) {
            close();
        }
    }

    public final void zae(int i, String str) {
        Bundle bundle = this.zab;
        if (bundle == null || !bundle.containsKey(str)) {
            throw new IllegalArgumentException("No such column: ".concat(String.valueOf(str)));
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= this.zad) {
            throw new CursorIndexOutOfBoundsException(i, this.zad);
        }
    }
}
