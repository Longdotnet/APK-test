package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public final class InputContentInfoCompat$InputContentInfoCompatApi25Impl implements InputContentInfoCompat$InputContentInfoCompatImpl {
    public final InputContentInfo mObject;

    public InputContentInfoCompat$InputContentInfoCompatApi25Impl(Object obj) {
        this.mObject = (InputContentInfo) obj;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public final Uri getContentUri() {
        return this.mObject.getContentUri();
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public final ClipDescription getDescription() {
        return this.mObject.getDescription();
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public final Object getInputContentInfo() {
        return this.mObject;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public final Uri getLinkUri() {
        return this.mObject.getLinkUri();
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public final void requestPermission() {
        this.mObject.requestPermission();
    }

    public InputContentInfoCompat$InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.mObject = new InputContentInfo(uri, clipDescription, uri2);
    }
}
