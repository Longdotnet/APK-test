package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyEvent;
import androidx.appcompat.view.ActionMode;
import androidx.room.RoomOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {
    public boolean closeOptionsMenu() {
        return false;
    }

    public abstract boolean collapseActionView();

    public abstract void dispatchMenuVisibilityChanged(boolean z);

    public abstract int getDisplayOptions();

    public abstract Context getThemedContext();

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public abstract void onConfigurationChanged();

    public void onDestroy() {
    }

    public abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    public abstract void setDefaultDisplayHomeAsUpEnabled(boolean z);

    public abstract void setShowHideAnimationEnabled(boolean z);

    public abstract void setWindowTitle(CharSequence charSequence);

    public ActionMode startActionMode(RoomOpenHelper roomOpenHelper) {
        return null;
    }
}
