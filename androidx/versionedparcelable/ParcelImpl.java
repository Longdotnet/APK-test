package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;

/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new FragmentState.AnonymousClass1(19);
    public final VersionedParcelable mParcel;

    public ParcelImpl(Parcel parcel) {
        this.mParcel = new VersionedParcelParcel(parcel).readVersionedParcelable();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new VersionedParcelParcel(parcel).writeVersionedParcelable$1(this.mParcel);
    }
}
