package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.browser.customtabs.CustomTabsClient;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public interface ICustomTabsService extends IInterface {
    public static final String DESCRIPTOR = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    public abstract class Stub extends Binder implements ICustomTabsService {
        public static final /* synthetic */ int $r8$clinit = 0;

        public final class Proxy implements ICustomTabsService {
            public IBinder mRemote;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean newSession(CustomTabsClient.AnonymousClass2 anonymousClass2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(anonymousClass2);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public final int postMessage(CustomTabsClient.AnonymousClass2 anonymousClass2, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(anonymousClass2);
                    parcelObtain.writeString(str);
                    StringsKt__IndentKt.writeTypedObject(parcelObtain, bundle);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public final boolean requestPostMessageChannel(CustomTabsClient.AnonymousClass2 anonymousClass2, Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(anonymousClass2);
                    StringsKt__IndentKt.writeTypedObject(parcelObtain, uri);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public final boolean requestPostMessageChannelWithExtras(CustomTabsClient.AnonymousClass2 anonymousClass2, Uri uri, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(anonymousClass2);
                    StringsKt__IndentKt.writeTypedObject(parcelObtain, uri);
                    StringsKt__IndentKt.writeTypedObject(parcelObtain, bundle);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public final boolean warmup() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.DESCRIPTOR);
                    parcelObtain.writeLong(0L);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
