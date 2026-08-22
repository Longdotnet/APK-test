package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new FragmentState.AnonymousClass1(8);
    public int audioStream;
    public int controlType;
    public int currentVolume;
    public int maxVolume;
    public int volumeType;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.volumeType);
        parcel.writeInt(this.controlType);
        parcel.writeInt(this.maxVolume);
        parcel.writeInt(this.currentVolume);
        parcel.writeInt(this.audioStream);
    }
}
