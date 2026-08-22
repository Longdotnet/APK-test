package androidx.fragment.app.strictmode;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentTagUsageViolation extends Violation {
    public final ViewGroup parentContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTagUsageViolation(Fragment fragment, ViewGroup viewGroup, int i) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        switch (i) {
            case 1:
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                super(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
                this.parentContainer = viewGroup;
                break;
            default:
                this.parentContainer = viewGroup;
                break;
        }
    }
}
