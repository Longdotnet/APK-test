package com.facebook.ppml.receiver;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IReceiverService extends IInterface {

    public abstract class Stub extends Binder implements IReceiverService {
        public static final /* synthetic */ int $r8$clinit = 0;

        public final class Proxy implements IReceiverService {
            public IBinder mRemote;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int sendEvents(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.facebook.ppml.receiver.IReceiverService");
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = Stub.$r8$clinit;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static IReceiverService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.facebook.ppml.receiver.IReceiverService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IReceiverService)) {
                return (IReceiverService) iInterfaceQueryLocalInterface;
            }
            Proxy proxy = new Proxy();
            proxy.mRemote = iBinder;
            return proxy;
        }
    }
}
