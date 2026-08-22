package androidx.savedstate;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LegacySavedStateHandleController$OnRecreation;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistry {
    public boolean attached;
    public final SafeIterableMap components = new SafeIterableMap();
    public boolean isAllowingSavingState = true;
    public boolean isRestored;
    public AppCompatActivity.AnonymousClass1 recreatorProvider;
    public Bundle restoredState;

    public interface AutoRecreated {
    }

    public interface SavedStateProvider {
        Bundle saveState();
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        if (!this.isRestored) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.restoredState;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.restoredState = null;
        }
        return bundle2;
    }

    public final SavedStateProvider getSavedStateProvider() {
        String str;
        SavedStateProvider savedStateProvider;
        Iterator it = this.components.iterator();
        do {
            SafeIterableMap.AscendingIterator ascendingIterator = (SafeIterableMap.AscendingIterator) it;
            if (!ascendingIterator.hasNext()) {
                return null;
            }
            Map.Entry components = (Map.Entry) ascendingIterator.next();
            Intrinsics.checkNotNullExpressionValue(components, "components");
            str = (String) components.getKey();
            savedStateProvider = (SavedStateProvider) components.getValue();
        } while (!Intrinsics.areEqual(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return savedStateProvider;
    }

    public final void registerSavedStateProvider(String str, SavedStateProvider provider) {
        Object obj;
        Intrinsics.checkNotNullParameter(provider, "provider");
        SafeIterableMap safeIterableMap = this.components;
        SafeIterableMap.Entry entry = safeIterableMap.get(str);
        if (entry != null) {
            obj = entry.mValue;
        } else {
            SafeIterableMap.Entry entry2 = new SafeIterableMap.Entry(str, provider);
            safeIterableMap.mSize++;
            SafeIterableMap.Entry entry3 = safeIterableMap.mEnd;
            if (entry3 == null) {
                safeIterableMap.mStart = entry2;
                safeIterableMap.mEnd = entry2;
            } else {
                entry3.mNext = entry2;
                entry2.mPrevious = entry3;
                safeIterableMap.mEnd = entry2;
            }
            obj = null;
        }
        if (((SavedStateProvider) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void runOnNextRecreation() {
        if (!this.isAllowingSavingState) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        AppCompatActivity.AnonymousClass1 anonymousClass1 = this.recreatorProvider;
        if (anonymousClass1 == null) {
            anonymousClass1 = new AppCompatActivity.AnonymousClass1(this);
        }
        this.recreatorProvider = anonymousClass1;
        try {
            LegacySavedStateHandleController$OnRecreation.class.getDeclaredConstructor(null);
            AppCompatActivity.AnonymousClass1 anonymousClass2 = this.recreatorProvider;
            if (anonymousClass2 != null) {
                ((LinkedHashSet) anonymousClass2.this$0).add(LegacySavedStateHandleController$OnRecreation.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + LegacySavedStateHandleController$OnRecreation.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
