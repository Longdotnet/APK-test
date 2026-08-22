package com.google.android.gms.common.data;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.zzah;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class EntityBuffer extends AbstractDataBuffer {
    public boolean zaa;
    public ArrayList zab;

    @Override // com.google.android.gms.common.data.DataBuffer
    @ResultIgnorabilityUnspecified
    public final Object get(int i) {
        int iIntValue;
        int iIntValue2;
        zab();
        int iZaa = zaa(i);
        int i2 = 0;
        if (i >= 0 && i != this.zab.size()) {
            if (i == this.zab.size() - 1) {
                DataHolder dataHolder = this.mDataHolder;
                zzah.checkNotNull(dataHolder);
                iIntValue = dataHolder.zad;
                iIntValue2 = ((Integer) this.zab.get(i)).intValue();
            } else {
                iIntValue = ((Integer) this.zab.get(i + 1)).intValue();
                iIntValue2 = ((Integer) this.zab.get(i)).intValue();
            }
            int i3 = iIntValue - iIntValue2;
            if (i3 == 1) {
                int iZaa2 = zaa(i);
                DataHolder dataHolder2 = this.mDataHolder;
                zzah.checkNotNull(dataHolder2);
                int windowIndex = dataHolder2.getWindowIndex(iZaa2);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || this.mDataHolder.getString(iZaa2, windowIndex, childDataMarkerColumn) != null) {
                    i2 = 1;
                }
            } else {
                i2 = i3;
            }
        }
        return getEntry(iZaa, i2);
    }

    public String getChildDataMarkerColumn() {
        return null;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        zab();
        return this.zab.size();
    }

    public abstract Object getEntry(int i, int i2);

    public abstract String getPrimaryDataMarkerColumn();

    public final int zaa(int i) {
        if (i < 0 || i >= this.zab.size()) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Position ", " is out of bounds for this buffer"));
        }
        return ((Integer) this.zab.get(i)).intValue();
    }

    public final void zab() {
        synchronized (this) {
            try {
                if (!this.zaa) {
                    DataHolder dataHolder = this.mDataHolder;
                    zzah.checkNotNull(dataHolder);
                    int i = dataHolder.zad;
                    ArrayList arrayList = new ArrayList();
                    this.zab = arrayList;
                    if (i > 0) {
                        arrayList.add(0);
                        String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                        String string = this.mDataHolder.getString(0, this.mDataHolder.getWindowIndex(0), primaryDataMarkerColumn);
                        for (int i2 = 1; i2 < i; i2++) {
                            int windowIndex = this.mDataHolder.getWindowIndex(i2);
                            String string2 = this.mDataHolder.getString(i2, windowIndex, primaryDataMarkerColumn);
                            if (string2 == null) {
                                throw new NullPointerException("Missing value for markerColumn: " + primaryDataMarkerColumn + ", at row: " + i2 + ", for window: " + windowIndex);
                            }
                            if (!string2.equals(string)) {
                                this.zab.add(Integer.valueOf(i2));
                                string = string2;
                            }
                        }
                    }
                    this.zaa = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
