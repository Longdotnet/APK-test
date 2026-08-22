package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import java.nio.ByteBuffer;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class TypefaceEmojiSpan extends ReplacementSpan {
    public final TypefaceEmojiRasterizer mRasterizer;
    public TextPaint mWorkingPaint;
    public final Paint.FontMetricsInt mTmpFontMetrics = new Paint.FontMetricsInt();
    public short mWidth = -1;
    public float mRatio = 1.0f;

    public TypefaceEmojiSpan(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        GamepadHandler_API19.checkNotNull(typefaceEmojiRasterizer, "rasterizer cannot be null");
        this.mRasterizer = typefaceEmojiRasterizer;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Paint paint2 = paint;
        TextPaint textPaint = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i, i2, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint2 = this.mWorkingPaint;
                    if (textPaint2 == null) {
                        textPaint2 = new TextPaint();
                        this.mWorkingPaint = textPaint2;
                    }
                    textPaint = textPaint2;
                    textPaint.set(paint2);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        characterStyle.updateDrawState(textPaint);
                    }
                } else if (paint2 instanceof TextPaint) {
                    textPaint = (TextPaint) paint2;
                }
            } else if (paint2 instanceof TextPaint) {
                textPaint = (TextPaint) paint2;
            }
        } else if (paint2 instanceof TextPaint) {
            textPaint = (TextPaint) paint2;
        }
        if (textPaint != null && textPaint.bgColor != 0) {
            int color = textPaint.getColor();
            Paint.Style style = textPaint.getStyle();
            textPaint.setColor(textPaint.bgColor);
            textPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, i3, f + this.mWidth, i5, textPaint);
            textPaint.setStyle(style);
            textPaint.setColor(color);
        }
        EmojiCompat.get().getClass();
        float f2 = i4;
        if (textPaint != null) {
            paint2 = textPaint;
        }
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.mRasterizer;
        Dispatcher dispatcher = typefaceEmojiRasterizer.mMetadataRepo;
        Typeface typeface = (Typeface) dispatcher.runningSyncCalls;
        Typeface typeface2 = paint2.getTypeface();
        paint2.setTypeface(typeface);
        canvas.drawText((char[]) dispatcher.readyAsyncCalls, typefaceEmojiRasterizer.mIndex * 2, 2, f, f2, paint2);
        paint2.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.mTmpFontMetrics;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.mRasterizer;
        MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
        int i__offset = metadataItem.__offset(14);
        this.mRatio = fAbs / (i__offset != 0 ? ((ByteBuffer) metadataItem.bb).getShort(i__offset + metadataItem.bb_pos) : (short) 0);
        MetadataItem metadataItem2 = typefaceEmojiRasterizer.getMetadataItem();
        int i__offset2 = metadataItem2.__offset(14);
        if (i__offset2 != 0) {
            ((ByteBuffer) metadataItem2.bb).getShort(i__offset2 + metadataItem2.bb_pos);
        }
        MetadataItem metadataItem3 = typefaceEmojiRasterizer.getMetadataItem();
        int i__offset3 = metadataItem3.__offset(12);
        short s = (short) ((i__offset3 != 0 ? ((ByteBuffer) metadataItem3.bb).getShort(i__offset3 + metadataItem3.bb_pos) : (short) 0) * this.mRatio);
        this.mWidth = s;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s;
    }
}
