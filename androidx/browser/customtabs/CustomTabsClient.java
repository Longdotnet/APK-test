package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.util.Log;
import androidx.appcompat.widget.AppCompatTextHelper;
import com.yoyogames.runner.RunnerJNILib;
import java.util.ArrayList;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTabsClient {
    public final ICustomTabsService mService;
    public final ComponentName mServiceComponentName;

    public CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.mService = iCustomTabsService;
        this.mServiceComponentName = componentName;
    }

    public static String getPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList<String> arrayList = new ArrayList();
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://")), 0);
        if (resolveInfoResolveActivity != null) {
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            arrayList = arrayList2;
        }
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : arrayList) {
            intent.setPackage(str2);
            if (packageManager.resolveService(intent, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT >= 30) {
            Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        }
        return null;
    }

    public final CustomTabsSession newSession(CustomTabsCallback customTabsCallback) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(customTabsCallback);
        ICustomTabsService iCustomTabsService = this.mService;
        try {
            if (((ICustomTabsService.Stub.Proxy) iCustomTabsService).newSession(anonymousClass2)) {
                return new CustomTabsSession(iCustomTabsService, anonymousClass2, this.mServiceComponentName);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsClient$2 */
    public final class AnonymousClass2 extends Binder implements ICustomTabsCallback {
        public final Handler mHandler;
        public final /* synthetic */ CustomTabsCallback val$callback;

        /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsClient$2$2 */
        public final class RunnableC00002 implements Runnable {
            public final /* synthetic */ int $r8$classId;
            public final /* synthetic */ AnonymousClass2 this$1;
            public final /* synthetic */ Bundle val$args;
            public final /* synthetic */ String val$callbackName;

            public /* synthetic */ RunnableC00002(AnonymousClass2 anonymousClass2) {
                i = i;
                this.this$1 = anonymousClass2;
                str = str;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.this$1.val$callback.extraCallback(str, bundle);
                        break;
                    default:
                        this.this$1.val$callback.onPostMessage(str, bundle);
                        break;
                }
            }
        }

        /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsClient$2$3 */
        public final class AnonymousClass3 implements Runnable {
            public final /* synthetic */ int $r8$classId;
            public final /* synthetic */ AnonymousClass2 this$1;
            public final /* synthetic */ Bundle val$extras;

            public /* synthetic */ AnonymousClass3(AnonymousClass2 anonymousClass2) {
                i = i;
                this.this$1 = anonymousClass2;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.this$1.val$callback.onMessageChannelReady(bundle);
                        break;
                    case 1:
                        this.this$1.val$callback.onUnminimized(bundle);
                        break;
                    case 2:
                        this.this$1.val$callback.onWarmupCompleted(bundle);
                        break;
                    default:
                        this.this$1.val$callback.onMinimized(bundle);
                        break;
                }
            }
        }

        /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsClient$2$5 */
        public final class AnonymousClass5 implements Runnable {
            public final /* synthetic */ Bundle val$extras;
            public final /* synthetic */ int val$relation;
            public final /* synthetic */ Uri val$requestedOrigin;
            public final /* synthetic */ boolean val$result;

            public AnonymousClass5() {
                i = i;
                uri = uri;
                z = z;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnonymousClass2.this.val$callback.onRelationshipValidationResult(i, uri, z, bundle);
            }
        }

        /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsClient$2$8 */
        public final class AnonymousClass8 implements Runnable {
            public final /* synthetic */ int val$bottom;
            public final /* synthetic */ Bundle val$extras;
            public final /* synthetic */ int val$left;
            public final /* synthetic */ int val$right;
            public final /* synthetic */ int val$state;
            public final /* synthetic */ int val$top;

            public AnonymousClass8() {
                i = i;
                i = i;
                i = i;
                i = i;
                i = i;
                bundle = bundle;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnonymousClass2.this.val$callback.onActivityLayout(i, i, i, i, i, bundle);
            }
        }

        public AnonymousClass2(CustomTabsCallback customTabsCallback) {
            this.val$callback = customTabsCallback;
            attachInterface(this, ICustomTabsCallback.DESCRIPTOR);
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = ICustomTabsCallback.DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            Handler handler = this.mHandler;
            CustomTabsCallback customTabsCallback = this.val$callback;
            switch (i) {
                case 2:
                    int i3 = parcel.readInt();
                    Bundle bundle = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new AppCompatTextHelper.AnonymousClass2(this, i3, bundle, 1));
                    }
                    return true;
                case 3:
                    String string = parcel.readString();
                    Bundle bundle2 = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new Runnable(this) { // from class: androidx.browser.customtabs.CustomTabsClient.2.2
                            public final /* synthetic */ int $r8$classId;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ Bundle val$args;
                            public final /* synthetic */ String val$callbackName;

                            public /* synthetic */ RunnableC00002(AnonymousClass2 this) {
                                i = i;
                                this.this$1 = this;
                                str = string;
                                bundle = bundle2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i) {
                                    case 0:
                                        this.this$1.val$callback.extraCallback(str, bundle);
                                        break;
                                    default:
                                        this.this$1.val$callback.onPostMessage(str, bundle);
                                        break;
                                }
                            }
                        });
                    }
                    return true;
                case 4:
                    Bundle bundle3 = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new Runnable(this) { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                            public final /* synthetic */ int $r8$classId;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ Bundle val$extras;

                            public /* synthetic */ AnonymousClass3(AnonymousClass2 this) {
                                i = i;
                                this.this$1 = this;
                                bundle = bundle3;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i) {
                                    case 0:
                                        this.this$1.val$callback.onMessageChannelReady(bundle);
                                        break;
                                    case 1:
                                        this.this$1.val$callback.onUnminimized(bundle);
                                        break;
                                    case 2:
                                        this.this$1.val$callback.onWarmupCompleted(bundle);
                                        break;
                                    default:
                                        this.this$1.val$callback.onMinimized(bundle);
                                        break;
                                }
                            }
                        });
                    }
                    parcel2.writeNoException();
                    return true;
                case 5:
                    String string2 = parcel.readString();
                    Bundle bundle4 = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new Runnable(this) { // from class: androidx.browser.customtabs.CustomTabsClient.2.2
                            public final /* synthetic */ int $r8$classId;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ Bundle val$args;
                            public final /* synthetic */ String val$callbackName;

                            public /* synthetic */ RunnableC00002(AnonymousClass2 this) {
                                i = i;
                                this.this$1 = this;
                                str = string2;
                                bundle = bundle4;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i) {
                                    case 0:
                                        this.this$1.val$callback.extraCallback(str, bundle);
                                        break;
                                    default:
                                        this.this$1.val$callback.onPostMessage(str, bundle);
                                        break;
                                }
                            }
                        });
                    }
                    parcel2.writeNoException();
                    return true;
                case 6:
                    int i4 = parcel.readInt();
                    Uri uri = (Uri) ExceptionsKt.access$000(parcel, Uri.CREATOR);
                    boolean z = parcel.readInt() != 0;
                    Bundle bundle5 = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.5
                            public final /* synthetic */ Bundle val$extras;
                            public final /* synthetic */ int val$relation;
                            public final /* synthetic */ Uri val$requestedOrigin;
                            public final /* synthetic */ boolean val$result;

                            public AnonymousClass5() {
                                i = i4;
                                uri = uri;
                                z = z;
                                bundle = bundle5;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                AnonymousClass2.this.val$callback.onRelationshipValidationResult(i, uri, z, bundle);
                            }
                        });
                    }
                    return true;
                case 7:
                    Bundle bundleExtraCallbackWithResult = customTabsCallback == null ? null : customTabsCallback.extraCallbackWithResult(parcel.readString(), (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    if (bundleExtraCallbackWithResult != null) {
                        parcel2.writeInt(1);
                        bundleExtraCallbackWithResult.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    int i5 = parcel.readInt();
                    int i6 = parcel.readInt();
                    Bundle bundle6 = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new RunnerJNILib.AnonymousClass10(this, i5, i6, bundle6));
                    }
                    return true;
                case 9:
                    Bundle bundle7 = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new Runnable(this) { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                            public final /* synthetic */ int $r8$classId;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ Bundle val$extras;

                            public /* synthetic */ AnonymousClass3(AnonymousClass2 this) {
                                i = i;
                                this.this$1 = this;
                                bundle = bundle7;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i) {
                                    case 0:
                                        this.this$1.val$callback.onMessageChannelReady(bundle);
                                        break;
                                    case 1:
                                        this.this$1.val$callback.onUnminimized(bundle);
                                        break;
                                    case 2:
                                        this.this$1.val$callback.onWarmupCompleted(bundle);
                                        break;
                                    default:
                                        this.this$1.val$callback.onMinimized(bundle);
                                        break;
                                }
                            }
                        });
                    }
                    return true;
                case 10:
                    int i7 = parcel.readInt();
                    int i8 = parcel.readInt();
                    int i9 = parcel.readInt();
                    int i10 = parcel.readInt();
                    int i11 = parcel.readInt();
                    Bundle bundle8 = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.8
                            public final /* synthetic */ int val$bottom;
                            public final /* synthetic */ Bundle val$extras;
                            public final /* synthetic */ int val$left;
                            public final /* synthetic */ int val$right;
                            public final /* synthetic */ int val$state;
                            public final /* synthetic */ int val$top;

                            public AnonymousClass8() {
                                i = i7;
                                i = i8;
                                i = i9;
                                i = i10;
                                i = i11;
                                bundle = bundle8;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                AnonymousClass2.this.val$callback.onActivityLayout(i, i, i, i, i, bundle);
                            }
                        });
                    }
                    return true;
                case 11:
                    Bundle bundle9 = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new Runnable(this) { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                            public final /* synthetic */ int $r8$classId;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ Bundle val$extras;

                            public /* synthetic */ AnonymousClass3(AnonymousClass2 this) {
                                i = i;
                                this.this$1 = this;
                                bundle = bundle9;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i) {
                                    case 0:
                                        this.this$1.val$callback.onMessageChannelReady(bundle);
                                        break;
                                    case 1:
                                        this.this$1.val$callback.onUnminimized(bundle);
                                        break;
                                    case 2:
                                        this.this$1.val$callback.onWarmupCompleted(bundle);
                                        break;
                                    default:
                                        this.this$1.val$callback.onMinimized(bundle);
                                        break;
                                }
                            }
                        });
                    }
                    return true;
                case 12:
                    Bundle bundle10 = (Bundle) ExceptionsKt.access$000(parcel, Bundle.CREATOR);
                    if (customTabsCallback != null) {
                        handler.post(new Runnable(this) { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                            public final /* synthetic */ int $r8$classId;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ Bundle val$extras;

                            public /* synthetic */ AnonymousClass3(AnonymousClass2 this) {
                                i = i;
                                this.this$1 = this;
                                bundle = bundle10;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i) {
                                    case 0:
                                        this.this$1.val$callback.onMessageChannelReady(bundle);
                                        break;
                                    case 1:
                                        this.this$1.val$callback.onUnminimized(bundle);
                                        break;
                                    case 2:
                                        this.this$1.val$callback.onWarmupCompleted(bundle);
                                        break;
                                    default:
                                        this.this$1.val$callback.onMinimized(bundle);
                                        break;
                                }
                            }
                        });
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}
