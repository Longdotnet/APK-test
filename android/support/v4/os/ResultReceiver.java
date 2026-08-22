package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;

/* JADX INFO: loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new FragmentState.AnonymousClass1(10);
    public IResultReceiver mReceiver;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public void onReceiveResult(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            try {
                if (this.mReceiver == null) {
                    this.mReceiver = new MyResultReceiver();
                }
                parcel.writeStrongBinder(this.mReceiver.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final class MyResultReceiver extends Binder implements IResultReceiver {
        public static final /* synthetic */ int $r8$clinit = 0;

        public MyResultReceiver() {
            attachInterface(this, IResultReceiver.DESCRIPTOR);
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = IResultReceiver.DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            int i3 = parcel.readInt();
            Object objCreateFromParcel = parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null;
            ResultReceiver resultReceiver = ResultReceiver.this;
            resultReceiver.getClass();
            resultReceiver.onReceiveResult(i3, (Bundle) objCreateFromParcel);
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}
