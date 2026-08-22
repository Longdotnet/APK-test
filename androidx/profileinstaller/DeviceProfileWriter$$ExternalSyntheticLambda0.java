package androidx.profileinstaller;

import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DeviceProfileWriter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ DeviceProfileWriter$$ExternalSyntheticLambda0(Object obj, int i, int i2, Object obj2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((DeviceProfileWriter) this.f$0).mDiagnostics.onResultReceived(this.f$1, (Serializable) this.f$2);
                break;
            case 1:
                ComponentActivity$activityResultRegistry$1 this$0 = (ComponentActivity$activityResultRegistry$1) this.f$0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Object obj = ((InstanceFactory) this.f$2).instance;
                String str = (String) this$0.rcToKey.get(Integer.valueOf(this.f$1));
                if (str != null) {
                    ActivityResultRegistry.CallbackAndContract callbackAndContract = (ActivityResultRegistry.CallbackAndContract) this$0.keyToCallback.get(str);
                    if ((callbackAndContract != null ? callbackAndContract.callback : null) != null) {
                        ActivityResultCallback activityResultCallback = callbackAndContract.callback;
                        Intrinsics.checkNotNull(activityResultCallback, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
                        if (this$0.launchedKeys.remove(str)) {
                            activityResultCallback.onActivityResult(obj);
                        }
                    } else {
                        this$0.pendingResults.remove(str);
                        this$0.parsedPendingResults.put(str, obj);
                    }
                    break;
                }
                break;
            default:
                ComponentActivity$activityResultRegistry$1 this$1 = (ComponentActivity$activityResultRegistry$1) this.f$0;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                IntentSender.SendIntentException e = (IntentSender.SendIntentException) this.f$2;
                Intrinsics.checkNotNullParameter(e, "$e");
                this$1.dispatchResult(this.f$1, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", e));
                break;
        }
    }
}
