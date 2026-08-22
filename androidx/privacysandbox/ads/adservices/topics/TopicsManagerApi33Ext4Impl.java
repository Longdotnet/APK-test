package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.TopicsManager;
import com.google.android.gms.internal.ads.zzro$$ExternalSyntheticApiModelOutline1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class TopicsManagerApi33Ext4Impl extends TopicsManagerImplCommon {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopicsManagerApi33Ext4Impl(TopicsManager topicsManager, int i) {
        super(topicsManager);
        this.$r8$classId = i;
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    public android.adservices.topics.GetTopicsRequest convertRequest$ads_adservices_release(GetTopicsRequest request) {
        switch (this.$r8$classId) {
            case 1:
                Intrinsics.checkNotNullParameter(request, "request");
                android.adservices.topics.GetTopicsRequest getTopicsRequestBuild = zzro$$ExternalSyntheticApiModelOutline1.m().setAdsSdkName("com.google.android.gms.ads").setShouldRecordObservation(request.shouldRecordObservation).build();
                Intrinsics.checkNotNullExpressionValue(getTopicsRequestBuild, "Builder()\n            .s…ion)\n            .build()");
                return getTopicsRequestBuild;
            default:
                return super.convertRequest$ads_adservices_release(request);
        }
    }
}
