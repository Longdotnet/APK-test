package androidx.fragment.app.strictmode;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentStrictMode {
    public static final Policy defaultPolicy = Policy.LAX;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: loaded from: classes.dex */
    public final class Flag {
        public static final /* synthetic */ Flag[] $VALUES;
        public static final Flag DETECT_FRAGMENT_REUSE;
        public static final Flag DETECT_FRAGMENT_TAG_USAGE;
        public static final Flag DETECT_RETAIN_INSTANCE_USAGE;
        public static final Flag DETECT_SET_USER_VISIBLE_HINT;
        public static final Flag DETECT_TARGET_FRAGMENT_USAGE;
        public static final Flag DETECT_WRONG_FRAGMENT_CONTAINER;

        /* JADX INFO: Fake field, exist only in values array */
        Flag EF8;

        static {
            Flag flag = new Flag("PENALTY_LOG", 0);
            Flag flag2 = new Flag("PENALTY_DEATH", 1);
            Flag flag3 = new Flag("DETECT_FRAGMENT_REUSE", 2);
            DETECT_FRAGMENT_REUSE = flag3;
            Flag flag4 = new Flag("DETECT_FRAGMENT_TAG_USAGE", 3);
            DETECT_FRAGMENT_TAG_USAGE = flag4;
            Flag flag5 = new Flag("DETECT_RETAIN_INSTANCE_USAGE", 4);
            DETECT_RETAIN_INSTANCE_USAGE = flag5;
            Flag flag6 = new Flag("DETECT_SET_USER_VISIBLE_HINT", 5);
            DETECT_SET_USER_VISIBLE_HINT = flag6;
            Flag flag7 = new Flag("DETECT_TARGET_FRAGMENT_USAGE", 6);
            DETECT_TARGET_FRAGMENT_USAGE = flag7;
            Flag flag8 = new Flag("DETECT_WRONG_FRAGMENT_CONTAINER", 7);
            DETECT_WRONG_FRAGMENT_CONTAINER = flag8;
            $VALUES = new Flag[]{flag, flag2, flag3, flag4, flag5, flag6, flag7, flag8};
        }

        public static Flag valueOf(String str) {
            return (Flag) Enum.valueOf(Flag.class, str);
        }

        public static Flag[] values() {
            return (Flag[]) $VALUES.clone();
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class Policy {
        public static final Policy LAX;

        static {
            Policy policy = new Policy();
            new LinkedHashMap();
            LAX = policy;
        }
    }

    public static void logIfDebuggingEnabled(Violation violation) {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(violation.fragment.getClass().getName()), violation);
        }
    }

    public static Policy getNearestPolicy(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                Intrinsics.checkNotNullExpressionValue(fragment.getParentFragmentManager(), YcVWhnLsj.YIFqYdZE);
            }
            fragment = fragment.getParentFragment();
        }
        return defaultPolicy;
    }

    public static final void onFragmentReuse(Fragment fragment, String previousFragmentId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(previousFragmentId, "previousFragmentId");
        logIfDebuggingEnabled(new FragmentReuseViolation(fragment, "Attempting to reuse fragment " + fragment + RDFWIi.azHnA + previousFragmentId));
        getNearestPolicy(fragment).getClass();
    }
}
