package kotlinx.coroutines.internal;

import android.text.TextUtils;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.TypefaceEmojiRasterizer;

/* JADX INFO: loaded from: classes3.dex */
public final class Symbol implements EmojiProcessor$EmojiProcessCallback {
    public final /* synthetic */ int $r8$classId;
    public final String symbol;

    public /* synthetic */ Symbol(String str, int i) {
        this.$r8$classId = i;
        this.symbol = str;
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.symbol)) {
            return true;
        }
        typefaceEmojiRasterizer.mCache = (typefaceEmojiRasterizer.mCache & 3) | 4;
        return false;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "<" + this.symbol + '>';
            default:
                return super.toString();
        }
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public Object getResult() {
        return this;
    }
}
