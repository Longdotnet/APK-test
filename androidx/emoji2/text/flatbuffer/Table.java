package androidx.emoji2.text.flatbuffer;

import android.os.Build;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.work.InputMergerFactory$1;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Table {
    public Object bb;
    public int bb_pos;
    public int vtable_size;
    public int vtable_start;

    public Table() {
        if (InputMergerFactory$1.DEFAULT == null) {
            InputMergerFactory$1.DEFAULT = new InputMergerFactory$1(11);
        }
    }

    public int __offset(int i) {
        if (i < this.vtable_size) {
            return ((ByteBuffer) this.bb).getShort(this.vtable_start + i);
        }
        return 0;
    }

    public abstract Object frameworkGet(View view);

    public abstract void frameworkSet(View view, Object obj);

    public void set(View view, Object obj) {
        Object tag;
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        if (Build.VERSION.SDK_INT >= this.vtable_start) {
            frameworkSet(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.vtable_start) {
            tag = frameworkGet(view);
        } else {
            tag = view.getTag(this.bb_pos);
            if (!((Class) this.bb).isInstance(tag)) {
                tag = null;
            }
        }
        if (shouldUpdate(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateInternal = ViewCompat.getAccessibilityDelegateInternal(view);
            if (accessibilityDelegateInternal == null) {
                accessibilityDelegateCompat = null;
            } else {
                accessibilityDelegateCompat = accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat : new AccessibilityDelegateCompat(accessibilityDelegateInternal);
            }
            if (accessibilityDelegateCompat == null) {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat();
            }
            ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
            view.setTag(this.bb_pos, obj);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.vtable_size);
        }
    }

    public abstract boolean shouldUpdate(Object obj, Object obj2);
}
