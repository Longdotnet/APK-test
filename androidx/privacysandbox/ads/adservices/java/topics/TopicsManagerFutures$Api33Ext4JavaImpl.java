package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import android.os.Build;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo$Extensions30Impl;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManagerApi33Ext4Impl;
import androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon;
import com.google.android.gms.internal.ads.zzro$$ExternalSyntheticApiModelOutline1;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public final class TopicsManagerFutures$Api33Ext4JavaImpl {
    public final TopicsManagerImplCommon mTopicsManager;

    public TopicsManagerFutures$Api33Ext4JavaImpl(TopicsManagerImplCommon topicsManagerImplCommon) {
        this.mTopicsManager = topicsManagerImplCommon;
    }

    public static final TopicsManagerFutures$Api33Ext4JavaImpl from(Context context) {
        TopicsManagerApi33Ext4Impl topicsManagerApi33Ext4Impl;
        Intrinsics.checkNotNullParameter(context, "context");
        int i = Build.VERSION.SDK_INT;
        AdServicesInfo$Extensions30Impl adServicesInfo$Extensions30Impl = AdServicesInfo$Extensions30Impl.INSTANCE;
        if ((i >= 30 ? adServicesInfo$Extensions30Impl.getAdServicesVersion() : 0) >= 5) {
            Object systemService = context.getSystemService((Class<Object>) zzro$$ExternalSyntheticApiModelOutline1.m$1());
            Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService…opicsManager::class.java)");
            topicsManagerApi33Ext4Impl = new TopicsManagerApi33Ext4Impl(zzro$$ExternalSyntheticApiModelOutline1.m90m(systemService), 1);
        } else {
            if ((i >= 30 ? adServicesInfo$Extensions30Impl.getAdServicesVersion() : 0) == 4) {
                Object systemService2 = context.getSystemService((Class<Object>) zzro$$ExternalSyntheticApiModelOutline1.m$1());
                Intrinsics.checkNotNullExpressionValue(systemService2, "context.getSystemService…opicsManager::class.java)");
                topicsManagerApi33Ext4Impl = new TopicsManagerApi33Ext4Impl(zzro$$ExternalSyntheticApiModelOutline1.m90m(systemService2), 0);
            } else {
                topicsManagerApi33Ext4Impl = null;
            }
        }
        if (topicsManagerApi33Ext4Impl != null) {
            return new TopicsManagerFutures$Api33Ext4JavaImpl(topicsManagerApi33Ext4Impl);
        }
        return null;
    }

    public ListenableFuture getTopicsAsync(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return Headers.Companion.asListenableFuture$default(BuildersKt.async$default(BuildersKt.CoroutineScope(MainDispatcherLoader.dispatcher), new TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1(this, request, null)));
    }
}
