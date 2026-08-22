package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiTextViewHelper$HelperInternal19 extends Okio {
    public final EmojiInputFilter mEmojiInputFilter;
    public boolean mEnabled = true;
    public final TextView mTextView;

    public EmojiTextViewHelper$HelperInternal19(TextView textView) {
        this.mTextView = textView;
        this.mEmojiInputFilter = new EmojiInputFilter(textView);
    }

    @Override // okio.Okio
    public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        if (!this.mEnabled) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArray.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i4 = 0;
        while (true) {
            EmojiInputFilter emojiInputFilter = this.mEmojiInputFilter;
            if (i4 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = emojiInputFilter;
                return inputFilterArr3;
            }
            if (inputFilterArr[i4] == emojiInputFilter) {
                return inputFilterArr;
            }
            i4++;
        }
    }

    @Override // okio.Okio
    public final void setAllCaps(boolean z) {
        if (z) {
            updateTransformationMethod();
        }
    }

    @Override // okio.Okio
    public final void setEnabled(boolean z) {
        this.mEnabled = z;
        updateTransformationMethod();
        TextView textView = this.mTextView;
        textView.setFilters(getFilters(textView.getFilters()));
    }

    public final void updateTransformationMethod() {
        TextView textView = this.mTextView;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (this.mEnabled) {
            if (!(transformationMethod instanceof EmojiTransformationMethod) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                transformationMethod = new EmojiTransformationMethod(transformationMethod);
            }
        } else if (transformationMethod instanceof EmojiTransformationMethod) {
            transformationMethod = ((EmojiTransformationMethod) transformationMethod).mTransformationMethod;
        }
        textView.setTransformationMethod(transformationMethod);
    }
}
