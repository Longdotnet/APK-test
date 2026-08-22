package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class DataBufferRef {
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    public int zaa;

    public DataBufferRef(DataHolder dataHolder, int i) {
        zzah.checkNotNull(dataHolder);
        this.mDataHolder = dataHolder;
        zaa(i);
    }

    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        int i = this.mDataRow;
        int i2 = this.zaa;
        DataHolder dataHolder = this.mDataHolder;
        dataHolder.zae(i, str);
        dataHolder.zah[i2].copyStringToBuffer(i, dataHolder.zab.getInt(str), charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (zzah.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) && zzah.equal(Integer.valueOf(dataBufferRef.zaa), Integer.valueOf(this.zaa)) && dataBufferRef.mDataHolder == this.mDataHolder) {
                return true;
            }
        }
        return false;
    }

    public boolean getBoolean(String str) {
        return this.mDataHolder.getBoolean(this.mDataRow, this.zaa, str);
    }

    public byte[] getByteArray(String str) {
        int i = this.mDataRow;
        int i2 = this.zaa;
        DataHolder dataHolder = this.mDataHolder;
        dataHolder.zae(i, str);
        return dataHolder.zah[i2].getBlob(i, dataHolder.zab.getInt(str));
    }

    public int getDataRow() {
        return this.mDataRow;
    }

    public double getDouble(String str) {
        int i = this.mDataRow;
        int i2 = this.zaa;
        DataHolder dataHolder = this.mDataHolder;
        dataHolder.zae(i, str);
        return dataHolder.zah[i2].getDouble(i, dataHolder.zab.getInt(str));
    }

    public float getFloat(String str) {
        int i = this.mDataRow;
        int i2 = this.zaa;
        DataHolder dataHolder = this.mDataHolder;
        dataHolder.zae(i, str);
        return dataHolder.zah[i2].getFloat(i, dataHolder.zab.getInt(str));
    }

    public int getInteger(String str) {
        int i = this.mDataRow;
        int i2 = this.zaa;
        DataHolder dataHolder = this.mDataHolder;
        dataHolder.zae(i, str);
        return dataHolder.zah[i2].getInt(i, dataHolder.zab.getInt(str));
    }

    public long getLong(String str) {
        int i = this.mDataRow;
        int i2 = this.zaa;
        DataHolder dataHolder = this.mDataHolder;
        dataHolder.zae(i, str);
        return dataHolder.zah[i2].getLong(i, dataHolder.zab.getInt(str));
    }

    public String getString(String str) {
        return this.mDataHolder.getString(this.mDataRow, this.zaa, str);
    }

    public boolean hasColumn(String str) {
        return this.mDataHolder.zab.containsKey(str);
    }

    public boolean hasNull(String str) {
        int i = this.mDataRow;
        int i2 = this.zaa;
        DataHolder dataHolder = this.mDataHolder;
        dataHolder.zae(i, str);
        return dataHolder.zah[i2].isNull(i, dataHolder.zab.getInt(str));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mDataRow), Integer.valueOf(this.zaa), this.mDataHolder});
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    public Uri parseUri(String str) {
        String string = this.mDataHolder.getString(this.mDataRow, this.zaa, str);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public final void zaa(int i) {
        boolean z = false;
        if (i >= 0 && i < this.mDataHolder.zad) {
            z = true;
        }
        zzah.checkState$1(z);
        this.mDataRow = i;
        this.zaa = this.mDataHolder.getWindowIndex(i);
    }
}
