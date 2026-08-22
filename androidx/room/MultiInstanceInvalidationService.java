package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.loader.app.gv.DYYbQc;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {
    public int mMaxClientId = 0;
    public final HashMap mClientNames = new HashMap();
    public final AnonymousClass1 mCallbackList = new RemoteCallbackList() { // from class: androidx.room.MultiInstanceInvalidationService.1
        @Override // android.os.RemoteCallbackList
        public final void onCallbackDied(IInterface iInterface, Object obj) {
            HashMap map = MultiInstanceInvalidationService.this.mClientNames;
            Integer num = (Integer) obj;
            num.intValue();
            map.remove(num);
        }
    };
    public final AnonymousClass2 mBinder = new AnonymousClass2();

    /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationService$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes2.dex */
    public final class AnonymousClass2 extends Binder implements IInterface {
        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        public final void broadcastInvalidation(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                try {
                    String str = (String) MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(i));
                    if (str == null) {
                        Log.w("ROOM", "Remote invalidation client ID not registered");
                        return;
                    }
                    int iBeginBroadcast = beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                        try {
                            Integer num = (Integer) getBroadcastCookie(i2);
                            int iIntValue = num.intValue();
                            String str2 = (String) MultiInstanceInvalidationService.this.mClientNames.get(num);
                            if (i != iIntValue && str.equals(str2)) {
                                try {
                                    ((IMultiInstanceInvalidationCallback$Stub$Proxy) getBroadcastItem(i2)).onInvalidation(strArr);
                                } catch (RemoteException e) {
                                    Log.w("ROOM", "Error invoking a remote callback", e);
                                }
                            }
                        } catch (Throwable th) {
                            finishBroadcast();
                            throw th;
                        }
                    }
                    finishBroadcast();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IMultiInstanceInvalidationCallback$Stub$Proxy iMultiInstanceInvalidationCallback$Stub$Proxy = null;
            if (i == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationCallback$Stub$Proxy)) {
                        iMultiInstanceInvalidationCallback$Stub$Proxy = new IMultiInstanceInvalidationCallback$Stub$Proxy();
                        iMultiInstanceInvalidationCallback$Stub$Proxy.mRemote = strongBinder;
                    } else {
                        iMultiInstanceInvalidationCallback$Stub$Proxy = (IMultiInstanceInvalidationCallback$Stub$Proxy) iInterfaceQueryLocalInterface;
                    }
                }
                int iRegisterCallback = registerCallback(iMultiInstanceInvalidationCallback$Stub$Proxy, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iRegisterCallback);
                return true;
            }
            if (i != 2) {
                if (i == 3) {
                    parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                    broadcastInvalidation(parcel.readInt(), parcel.createStringArray());
                    return true;
                }
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof IMultiInstanceInvalidationCallback$Stub$Proxy)) {
                    iMultiInstanceInvalidationCallback$Stub$Proxy = new IMultiInstanceInvalidationCallback$Stub$Proxy();
                    iMultiInstanceInvalidationCallback$Stub$Proxy.mRemote = strongBinder2;
                } else {
                    iMultiInstanceInvalidationCallback$Stub$Proxy = (IMultiInstanceInvalidationCallback$Stub$Proxy) iInterfaceQueryLocalInterface2;
                }
            }
            int i3 = parcel.readInt();
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                unregister(iMultiInstanceInvalidationCallback$Stub$Proxy);
                MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(i3));
            }
            parcel2.writeNoException();
            return true;
        }

        public final int registerCallback(IMultiInstanceInvalidationCallback$Stub$Proxy iMultiInstanceInvalidationCallback$Stub$Proxy, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                try {
                    MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                    int i = multiInstanceInvalidationService.mMaxClientId + 1;
                    multiInstanceInvalidationService.mMaxClientId = i;
                    if (multiInstanceInvalidationService.mCallbackList.register(iMultiInstanceInvalidationCallback$Stub$Proxy, Integer.valueOf(i))) {
                        MultiInstanceInvalidationService.this.mClientNames.put(Integer.valueOf(i), str);
                        return i;
                    }
                    MultiInstanceInvalidationService.this.mMaxClientId--;
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public AnonymousClass2() {
            attachInterface(this, DYYbQc.aPSpKWdz);
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
