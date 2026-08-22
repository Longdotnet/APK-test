package androidx.appcompat.widget;

import android.content.Context;
import android.os.Bundle;
import androidx.room.RoomOpenHelper;
import com.facebook.GraphRequest;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.firebase.auth.zzaa;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class TooltipPopup implements Factory {
    public Object mContentView;
    public Object mContext;
    public Object mLayoutParams;
    public Object mMessageView;
    public Object mTmpAnchorPos;
    public Object mTmpAppPos;
    public Object mTmpDisplayFrame;

    public static void zzv(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzbb zzbbVar = zzbb.zzb;
        zzf zzfVar = zzbbVar.zzc;
        String str2 = zzbbVar.zzf.afmaVersion;
        zzfVar.getClass();
        zzf.zzB(context, str2, bundle, new RoomOpenHelper(zzfVar, context, 27, false));
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new Uploader((Context) ((InstanceFactory) this.mContext).instance, (MetadataBackendRegistry) ((Provider) this.mContentView).get(), (EventStore) ((Provider) this.mMessageView).get(), (JobInfoScheduler) ((zzaa) this.mLayoutParams).get(), (Executor) ((Provider) this.mTmpDisplayFrame).get(), (SynchronizationGuard) ((Provider) this.mTmpAnchorPos).get(), new GraphRequest.Companion(18), new GraphRequest.Companion(17), (ClientHealthMetricsStore) ((Provider) this.mTmpAppPos).get());
    }
}
