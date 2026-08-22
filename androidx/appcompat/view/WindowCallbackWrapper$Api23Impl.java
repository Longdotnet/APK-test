package androidx.appcompat.view;

import android.view.SearchEvent;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class WindowCallbackWrapper$Api23Impl {
    public static boolean onSearchRequested(Window.Callback callback, SearchEvent searchEvent) {
        return callback.onSearchRequested(searchEvent);
    }

    public static android.view.ActionMode onWindowStartingActionMode(Window.Callback callback, android.view.ActionMode.Callback callback2, int i) {
        return callback.onWindowStartingActionMode(callback2, i);
    }
}
