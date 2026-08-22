package androidx.emoji2.viewsintegration;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.work.InputMergerFactory$1;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiInputConnection extends InputConnectionWrapper {
    public final InputMergerFactory$1 mEmojiCompatDeleteHelper;
    public final EditText mTextView;

    public EmojiInputConnection(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        InputMergerFactory$1 inputMergerFactory$1 = new InputMergerFactory$1(12);
        super(inputConnection, false);
        this.mTextView = editText;
        this.mEmojiCompatDeleteHelper = inputMergerFactory$1;
        if (EmojiCompat.sInstance != null) {
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (emojiCompat.getLoadState() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            EmojiCompat.CompatInternal19 compatInternal19 = emojiCompat.mHelper;
            compatInternal19.getClass();
            Bundle bundle = editorInfo.extras;
            MetadataList metadataList = (MetadataList) compatInternal19.mMetadataRepo.executorServiceOrNull;
            int i__offset = metadataList.__offset(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", i__offset != 0 ? ((ByteBuffer) metadataList.bb).getInt(i__offset + metadataList.bb_pos) : 0);
            Bundle bundle2 = editorInfo.extras;
            compatInternal19.mEmojiCompat.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        Editable editableText = this.mTextView.getEditableText();
        this.mEmojiCompatDeleteHelper.getClass();
        return InputMergerFactory$1.handleDeleteSurroundingText(this, editableText, i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        Editable editableText = this.mTextView.getEditableText();
        this.mEmojiCompatDeleteHelper.getClass();
        return InputMergerFactory$1.handleDeleteSurroundingText(this, editableText, i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }
}
