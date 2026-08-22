package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import com.facebook.AccessTokenCache;
import com.facebook.AccessTokenManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatReceiveContentHelper$OnDropApi24Impl {
    public static boolean onDropForTextView(DragEvent dragEvent, TextView textView, Activity activity) {
        ContentInfoCompat.BuilderCompat accessTokenCache;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                accessTokenCache = new AccessTokenCache(clipData, 3);
            } else {
                AccessTokenManager.RefreshResult refreshResult = new AccessTokenManager.RefreshResult(1);
                refreshResult.accessToken = clipData;
                refreshResult.expiresAt = 3;
                accessTokenCache = refreshResult;
            }
            ViewCompat.performReceiveContent(textView, accessTokenCache.build());
            return true;
        } finally {
            textView.endBatchEdit();
        }
    }

    public static boolean onDropForView(DragEvent dragEvent, View view, Activity activity) {
        ContentInfoCompat.BuilderCompat accessTokenCache;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            accessTokenCache = new AccessTokenCache(clipData, 3);
        } else {
            AccessTokenManager.RefreshResult refreshResult = new AccessTokenManager.RefreshResult(1);
            refreshResult.accessToken = clipData;
            refreshResult.expiresAt = 3;
            accessTokenCache = refreshResult;
        }
        ViewCompat.performReceiveContent(view, accessTokenCache.build());
        return true;
    }
}
