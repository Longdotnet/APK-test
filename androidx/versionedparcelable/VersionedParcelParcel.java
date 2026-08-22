package androidx.versionedparcelable;

import android.os.Parcel;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class VersionedParcelParcel extends VersionedParcel {
    public int mCurrentField;
    public final int mEnd;
    public int mFieldId;
    public int mNextRead;
    public final int mOffset;
    public final Parcel mParcel;
    public final SparseIntArray mPositionLookup;
    public final String mPrefix;

    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final VersionedParcelParcel createSubParcel() {
        Parcel parcel = this.mParcel;
        int iDataPosition = parcel.dataPosition();
        int i = this.mNextRead;
        if (i == this.mOffset) {
            i = this.mEnd;
        }
        return new VersionedParcelParcel(parcel, iDataPosition, i, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder(), this.mPrefix, "  "), this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean readField(int i) {
        while (this.mNextRead < this.mEnd) {
            int i2 = this.mFieldId;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i3 = this.mNextRead;
            Parcel parcel = this.mParcel;
            parcel.setDataPosition(i3);
            int i4 = parcel.readInt();
            this.mFieldId = parcel.readInt();
            this.mNextRead += i4;
        }
        return this.mFieldId == i;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void setOutputField(int i) {
        int i2 = this.mCurrentField;
        SparseIntArray sparseIntArray = this.mPositionLookup;
        Parcel parcel = this.mParcel;
        if (i2 >= 0) {
            int i3 = sparseIntArray.get(i2);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i3);
            parcel.writeInt(iDataPosition - i3);
            parcel.setDataPosition(iDataPosition);
        }
        this.mCurrentField = i;
        sparseIntArray.put(i, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i);
    }

    public VersionedParcelParcel(Parcel parcel, int i, int i2, String str, ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mFieldId = -1;
        this.mParcel = parcel;
        this.mOffset = i;
        this.mEnd = i2;
        this.mNextRead = i;
        this.mPrefix = str;
    }
}
