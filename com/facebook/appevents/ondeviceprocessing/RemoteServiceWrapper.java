package com.facebook.appevents.ondeviceprocessing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.ppml.receiver.IReceiverService;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteServiceWrapper {
    public static final RemoteServiceWrapper INSTANCE = new RemoteServiceWrapper();
    public static Boolean isServiceAvailable;

    /* JADX INFO: loaded from: classes2.dex */
    public enum EventType {
        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS");

        public final String eventType;

        EventType(String str) {
            this.eventType = str;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static EventType[] valuesCustom() {
            return (EventType[]) Arrays.copyOf(values(), 2);
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.eventType;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class RemoteServiceConnection implements ServiceConnection {
        public IBinder binder;
        public final CountDownLatch latch = new CountDownLatch(1);

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.latch.countDown();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName name) {
            Intrinsics.checkNotNullParameter(name, "name");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder serviceBinder) {
            Intrinsics.checkNotNullParameter(componentName, iafHZUfOuHNwvy.xiozmwhlUpDto);
            Intrinsics.checkNotNullParameter(serviceBinder, "serviceBinder");
            this.binder = serviceBinder;
            this.latch.countDown();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: loaded from: classes2.dex */
    public final class ServiceResult {
        public static final /* synthetic */ ServiceResult[] $VALUES;
        public static final ServiceResult OPERATION_SUCCESS;
        public static final ServiceResult SERVICE_ERROR;
        public static final ServiceResult SERVICE_NOT_AVAILABLE;

        static {
            ServiceResult serviceResult = new ServiceResult("OPERATION_SUCCESS", 0);
            OPERATION_SUCCESS = serviceResult;
            ServiceResult serviceResult2 = new ServiceResult("SERVICE_NOT_AVAILABLE", 1);
            SERVICE_NOT_AVAILABLE = serviceResult2;
            ServiceResult serviceResult3 = new ServiceResult("SERVICE_ERROR", 2);
            SERVICE_ERROR = serviceResult3;
            $VALUES = new ServiceResult[]{serviceResult, serviceResult2, serviceResult3};
        }

        public static ServiceResult[] values() {
            return (ServiceResult[]) Arrays.copyOf($VALUES, 3);
        }

        public static ServiceResult valueOf(String str) {
            Intrinsics.checkNotNullParameter(str, bUqMCsuPSX.zdhgmzeCLGDtC);
            return (ServiceResult) Enum.valueOf(ServiceResult.class, str);
        }
    }

    public final Intent getVerifiedServiceIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Intent intent = new Intent("ReceiverService");
                intent.setPackage("com.facebook.katana");
                if (packageManager.resolveService(intent, 0) != null && FacebookSignatureValidator.validateSignature(context, "com.facebook.katana")) {
                    return intent;
                }
                Intent intent2 = new Intent("ReceiverService");
                intent2.setPackage("com.facebook.wakizashi");
                if (packageManager.resolveService(intent2, 0) != null && FacebookSignatureValidator.validateSignature(context, "com.facebook.wakizashi")) {
                    return intent2;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final ServiceResult sendEvents(EventType eventType, String str, List list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ServiceResult serviceResult = ServiceResult.SERVICE_NOT_AVAILABLE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            Intent verifiedServiceIntent = getVerifiedServiceIntent(applicationContext);
            if (verifiedServiceIntent == null) {
                return serviceResult;
            }
            RemoteServiceConnection remoteServiceConnection = new RemoteServiceConnection();
            boolean zBindService = applicationContext.bindService(verifiedServiceIntent, remoteServiceConnection, 1);
            ServiceResult serviceResult2 = ServiceResult.SERVICE_ERROR;
            try {
                if (zBindService) {
                    try {
                        remoteServiceConnection.latch.await(5L, TimeUnit.SECONDS);
                        IBinder iBinder = remoteServiceConnection.binder;
                        if (iBinder != null) {
                            IReceiverService iReceiverServiceAsInterface = IReceiverService.Stub.asInterface(iBinder);
                            Bundle bundleBuildEventsBundle = RemoteServiceParametersHelper.buildEventsBundle(eventType, str, list);
                            if (bundleBuildEventsBundle != null) {
                                ((IReceiverService.Stub.Proxy) iReceiverServiceAsInterface).sendEvents(bundleBuildEventsBundle);
                                Intrinsics.stringPlus(bundleBuildEventsBundle, "Successfully sent events to the remote service: ");
                            }
                            serviceResult = ServiceResult.OPERATION_SUCCESS;
                        }
                        applicationContext.unbindService(remoteServiceConnection);
                        return serviceResult;
                    } catch (RemoteException unused) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        applicationContext.unbindService(remoteServiceConnection);
                        return serviceResult2;
                    } catch (InterruptedException unused2) {
                        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                        applicationContext.unbindService(remoteServiceConnection);
                        return serviceResult2;
                    }
                }
                return serviceResult2;
            } catch (Throwable th) {
                applicationContext.unbindService(remoteServiceConnection);
                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                throw th;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return null;
        }
    }
}
