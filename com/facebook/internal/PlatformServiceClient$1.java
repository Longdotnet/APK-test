package com.facebook.internal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.room.RoomOpenHelper;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.GetTokenClient;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PlatformServiceClient$1 extends Handler {
    public final /* synthetic */ int $r8$classId = 1;
    public Object this$0;

    public /* synthetic */ PlatformServiceClient$1() {
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int size;
        RoomOpenHelper[] roomOpenHelperArr;
        switch (this.$r8$classId) {
            case 0:
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        Intrinsics.checkNotNullParameter(message, "message");
                        GetTokenClient getTokenClient = (GetTokenClient) this.this$0;
                        getTokenClient.getClass();
                        if (message.what == getTokenClient.replyMessage) {
                            Bundle data = message.getData();
                            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                                getTokenClient.callback(null);
                            } else {
                                getTokenClient.callback(data);
                            }
                            try {
                                getTokenClient.context.unbindService(getTokenClient);
                                return;
                            } catch (IllegalArgumentException unused) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(this, th);
                        return;
                    }
                    CrashShieldHandler.handleThrowable(this, th);
                    return;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(this, th2);
                    return;
                }
            case 1:
                int i = message.what;
                if (i == -3 || i == -2 || i == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.this$0).get(), message.what);
                    return;
                } else {
                    if (i != 1) {
                        return;
                    }
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
            default:
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                LocalBroadcastManager localBroadcastManager = (LocalBroadcastManager) this.this$0;
                while (true) {
                    synchronized (localBroadcastManager.mReceivers) {
                        try {
                            size = localBroadcastManager.mPendingBroadcasts.size();
                            if (size <= 0) {
                                return;
                            }
                            roomOpenHelperArr = new RoomOpenHelper[size];
                            localBroadcastManager.mPendingBroadcasts.toArray(roomOpenHelperArr);
                            localBroadcastManager.mPendingBroadcasts.clear();
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        RoomOpenHelper roomOpenHelper = roomOpenHelperArr[i2];
                        int size2 = ((ArrayList) roomOpenHelper.mDelegate).size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            LocalBroadcastManager.ReceiverRecord receiverRecord = (LocalBroadcastManager.ReceiverRecord) ((ArrayList) roomOpenHelper.mDelegate).get(i3);
                            if (!receiverRecord.dead) {
                                receiverRecord.receiver.onReceive(localBroadcastManager.mAppContext, (Intent) roomOpenHelper.mConfiguration);
                            }
                        }
                    }
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformServiceClient$1(LocalBroadcastManager localBroadcastManager, Looper looper) {
        super(looper);
        this.this$0 = localBroadcastManager;
    }

    public PlatformServiceClient$1(GetTokenClient getTokenClient) {
        this.this$0 = getTokenClient;
    }
}
