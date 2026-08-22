package androidx.fragment.app;

import android.view.View;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentTransition {
    public static final FragmentTransitionCompat21 PLATFORM_IMPL = new FragmentTransitionCompat21();
    public static final FragmentTransitionCompat21 SUPPORT_IMPL;

    public static void setViewVisibility(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i);
        }
    }

    static {
        FragmentTransitionCompat21 fragmentTransitionCompat21 = null;
        try {
            fragmentTransitionCompat21 = (FragmentTransitionCompat21) Class.forName(jIKWv.BIHsFxSDAxFquB).getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        SUPPORT_IMPL = fragmentTransitionCompat21;
    }
}
