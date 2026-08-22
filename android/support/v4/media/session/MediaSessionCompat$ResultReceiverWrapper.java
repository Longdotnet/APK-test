package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.fragment.app.FragmentState;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionCompat$ResultReceiverWrapper implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$ResultReceiverWrapper> CREATOR = new FragmentState.AnonymousClass1(6);
    public ResultReceiver mResultReceiver;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        this.mResultReceiver.writeToParcel(parcel, i);
    }
}
