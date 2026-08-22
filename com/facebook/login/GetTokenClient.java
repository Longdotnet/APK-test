package com.facebook.login;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.facebook.ProfileCache;
import com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda0;
import com.facebook.internal.PlatformServiceClient$1;
import com.facebook.internal.Utility;
import com.google.firebase.auth.zzaa;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class GetTokenClient implements ServiceConnection {
    public final String applicationId;
    public final Context context;
    public final PlatformServiceClient$1 handler;
    public CodelessManager$$ExternalSyntheticLambda0 listener;
    public final String nonce;
    public final int protocolVersion;
    public final int replyMessage;
    public final int requestMessage;
    public boolean running;
    public Messenger sender;

    public GetTokenClient(Context context, LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String applicationId = request.applicationId;
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext != null ? applicationContext : context;
        this.requestMessage = 65536;
        this.replyMessage = 65537;
        this.applicationId = applicationId;
        this.protocolVersion = 20121101;
        this.nonce = request.nonce;
        this.handler = new PlatformServiceClient$1(this);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        this.sender = new Messenger(service);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.applicationId);
        String str = this.nonce;
        if (str != null) {
            bundle.putString("com.facebook.platform.extra.NONCE", str);
        }
        Message messageObtain = Message.obtain((Handler) null, this.requestMessage);
        messageObtain.arg1 = this.protocolVersion;
        messageObtain.setData(bundle);
        messageObtain.replyTo = new Messenger(this.handler);
        try {
            Messenger messenger = this.sender;
            if (messenger == null) {
                return;
            }
            messenger.send(messageObtain);
        } catch (RemoteException unused) {
            callback(null);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.sender = null;
        try {
            this.context.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        callback(null);
    }

    public final void callback(Bundle bundle) {
        if (this.running) {
            this.running = false;
            CodelessManager$$ExternalSyntheticLambda0 codelessManager$$ExternalSyntheticLambda0 = this.listener;
            if (codelessManager$$ExternalSyntheticLambda0 == null) {
                return;
            }
            GetTokenLoginMethodHandler this$0 = (GetTokenLoginMethodHandler) codelessManager$$ExternalSyntheticLambda0.f$0;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LoginClient.Request request = (LoginClient.Request) codelessManager$$ExternalSyntheticLambda0.f$1;
            Intrinsics.checkNotNullParameter(request, "$request");
            GetTokenClient getTokenClient = this$0.getTokenClient;
            if (getTokenClient != null) {
                getTokenClient.listener = null;
            }
            this$0.getTokenClient = null;
            ProfileCache profileCache = this$0.getLoginClient().backgroundProcessingListener;
            String str = sgtsHsWT.EVkhceoJrlQo;
            if (profileCache != null) {
                View view = ((LoginFragment) profileCache.sharedPreferences).progressBar;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    throw null;
                }
                view.setVisibility(8);
            }
            if (bundle != null) {
                List stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
                if (stringArrayList == null) {
                    stringArrayList = EmptyList.INSTANCE;
                }
                Set<String> set = request.permissions;
                if (set == null) {
                    set = EmptySet.INSTANCE;
                }
                String string = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
                if (set.contains("openid") && (string == null || string.length() == 0)) {
                    this$0.getLoginClient().tryNextHandler();
                    return;
                }
                if (stringArrayList.containsAll(set)) {
                    String string2 = bundle.getString("com.facebook.platform.extra.USER_ID");
                    if (string2 != null && string2.length() != 0) {
                        this$0.onComplete(request, bundle);
                        return;
                    }
                    ProfileCache profileCache2 = this$0.getLoginClient().backgroundProcessingListener;
                    if (profileCache2 != null) {
                        View view2 = ((LoginFragment) profileCache2.sharedPreferences).progressBar;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str);
                            throw null;
                        }
                        view2.setVisibility(0);
                    }
                    String string3 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
                    if (string3 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    Utility.getGraphMeRequestWithCacheAsync(new zzaa(bundle, this$0, request, 12), string3);
                    return;
                }
                HashSet hashSet = new HashSet();
                for (String str2 : set) {
                    if (!stringArrayList.contains(str2)) {
                        hashSet.add(str2);
                    }
                }
                if (!hashSet.isEmpty()) {
                    this$0.addLoggingExtra("new_permissions", TextUtils.join(",", hashSet));
                }
                request.permissions = hashSet;
            }
            this$0.getLoginClient().tryNextHandler();
        }
    }
}
