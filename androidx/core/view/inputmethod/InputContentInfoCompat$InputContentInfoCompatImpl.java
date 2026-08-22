package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public interface InputContentInfoCompat$InputContentInfoCompatImpl {
    Uri getContentUri();

    ClipDescription getDescription();

    Object getInputContentInfo();

    Uri getLinkUri();

    void requestPermission();
}
