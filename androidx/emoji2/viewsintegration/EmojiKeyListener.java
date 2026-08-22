package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.work.InputMergerFactory$1;
import com.google.firebase.auth.zzaa;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiKeyListener implements KeyListener {
    public final InputMergerFactory$1 mEmojiCompatHandleKeyDownHelper;
    public final KeyListener mKeyListener;

    public EmojiKeyListener(KeyListener keyListener) {
        InputMergerFactory$1 inputMergerFactory$1 = new InputMergerFactory$1(13);
        this.mKeyListener = keyListener;
        this.mEmojiCompatHandleKeyDownHelper = inputMergerFactory$1;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.mKeyListener.clearMetaKeyState(view, editable, i);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.mKeyListener.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        boolean zDelete;
        boolean z;
        this.mEmojiCompatHandleKeyDownHelper.getClass();
        if (i != 67) {
            zDelete = i != 112 ? false : zzaa.delete(editable, keyEvent, true);
        } else {
            zDelete = zzaa.delete(editable, keyEvent, false);
        }
        if (zDelete) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z = true;
        } else {
            z = false;
        }
        return z || this.mKeyListener.onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyUp(view, editable, i, keyEvent);
    }
}
