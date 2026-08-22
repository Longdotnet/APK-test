package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import com.facebook.ProfileCache;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatEmojiTextHelper {
    public final ProfileCache mEmojiTextViewHelper;
    public final TextView mView;

    public AppCompatEmojiTextHelper(TextView textView) {
        this.mView = textView;
        this.mEmojiTextViewHelper = new ProfileCache(textView);
    }

    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setAllCaps(boolean z) {
        ((Okio) this.mEmojiTextViewHelper.sharedPreferences).setAllCaps(z);
    }

    public final void setEnabled(boolean z) {
        ((Okio) this.mEmojiTextViewHelper.sharedPreferences).setEnabled(z);
    }
}
