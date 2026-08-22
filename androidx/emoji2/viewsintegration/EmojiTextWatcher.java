package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiTextWatcher implements TextWatcher {
    public final EditText mEditText;
    public boolean mEnabled = true;
    public InitCallbackImpl mInitCallback;

    public final class InitCallbackImpl extends EmojiCompat.InitCallback {
        public final WeakReference mViewRef;

        public InitCallbackImpl(EditText editText) {
            this.mViewRef = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void onInitialized() {
            EmojiTextWatcher.processTextOnEnablingEvent((EditText) this.mViewRef.get(), 1);
        }
    }

    public EmojiTextWatcher(EditText editText) {
        this.mEditText = editText;
    }

    public static void processTextOnEnablingEvent(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (editableText == null) {
                length = 0;
            } else {
                emojiCompat.getClass();
                length = editableText.length();
            }
            emojiCompat.process(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText = this.mEditText;
        if (editText.isInEditMode() || !this.mEnabled || EmojiCompat.sInstance == null || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            if (loadState == 1) {
                EmojiCompat.get().process((Spannable) charSequence, i, i3 + i);
                return;
            } else if (loadState != 3) {
                return;
            }
        }
        EmojiCompat emojiCompat = EmojiCompat.get();
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(editText);
        }
        emojiCompat.registerInitCallback(this.mInitCallback);
    }
}
