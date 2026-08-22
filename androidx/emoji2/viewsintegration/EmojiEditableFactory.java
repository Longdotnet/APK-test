package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiEditableFactory extends Editable.Factory {
    public static final Object INSTANCE_LOCK = new Object();
    public static volatile EmojiEditableFactory sInstance;
    public static Class sWatcherClass;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = sWatcherClass;
        return cls != null ? new SpannableBuilder(charSequence, cls) : super.newEditable(charSequence);
    }
}
