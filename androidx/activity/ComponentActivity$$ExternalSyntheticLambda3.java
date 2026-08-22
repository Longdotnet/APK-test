package androidx.activity;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda3 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda3(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.$r8$classId) {
            case 0:
                return ComponentActivity.m1$r8$lambda$xTL2e_8xZHyLBqzsfEVlyFwLP0((ComponentActivity) this.f$0);
            default:
                return SavedStateHandle.$r8$lambda$eeLDsk5Qp_lgSAYrhUViF2PFB0k((SavedStateHandle) this.f$0);
        }
    }
}
