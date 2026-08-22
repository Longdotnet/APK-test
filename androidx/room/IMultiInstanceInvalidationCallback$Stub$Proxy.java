package androidx.room;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.games.event.AfJ.oKjScaD;

/* JADX INFO: loaded from: classes2.dex */
public final class IMultiInstanceInvalidationCallback$Stub$Proxy implements IInterface {
    public IBinder mRemote;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final void onInvalidation(String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(oKjScaD.vrTmEXOIsuQ);
            parcelObtain.writeStringArray(strArr);
            this.mRemote.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
