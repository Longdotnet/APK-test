package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.collection.ArrayMap;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat$Api23Impl;
import androidx.work.WorkContinuation;
import com.google.common.base.Splitter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import okio.AsyncTimeout;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class VectorDrawableCompat extends VectorDrawableCommon {
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    public boolean mAllowCaching;
    public ColorFilter mColorFilter;
    public boolean mMutated;
    public PorterDuffColorFilter mTintFilter;
    public final Rect mTmpBounds;
    public final float[] mTmpFloats;
    public final Matrix mTmpMatrix;
    public VectorDrawableCompatState mVectorState;

    public final class VClipPath extends VPath {
    }

    public final class VFullPath extends VPath {
        public float mFillAlpha;
        public Splitter mFillColor;
        public float mStrokeAlpha;
        public Splitter mStrokeColor;
        public Paint.Cap mStrokeLineCap;
        public Paint.Join mStrokeLineJoin;
        public float mStrokeMiterlimit;
        public float mStrokeWidth;
        public float mTrimPathEnd;
        public float mTrimPathOffset;
        public float mTrimPathStart;

        public float getFillAlpha() {
            return this.mFillAlpha;
        }

        public int getFillColor() {
            return this.mFillColor.limit;
        }

        public float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        public int getStrokeColor() {
            return this.mStrokeColor.limit;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        public float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean isStateful() {
            return this.mFillColor.isStateful() || this.mStrokeColor.isStateful();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x001e  */
        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean onStateChanged(int[] iArr) {
            boolean z;
            Splitter splitter = this.mFillColor;
            boolean z2 = false;
            if (splitter.isStateful()) {
                ColorStateList colorStateList = (ColorStateList) splitter.strategy;
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (colorForState != splitter.limit) {
                    splitter.limit = colorForState;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            Splitter splitter2 = this.mStrokeColor;
            if (splitter2.isStateful()) {
                ColorStateList colorStateList2 = (ColorStateList) splitter2.strategy;
                int colorForState2 = colorStateList2.getColorForState(iArr, colorStateList2.getDefaultColor());
                if (colorForState2 != splitter2.limit) {
                    splitter2.limit = colorForState2;
                    z2 = true;
                }
            }
            return z | z2;
        }

        public void setFillAlpha(float f) {
            this.mFillAlpha = f;
        }

        public void setFillColor(int i) {
            this.mFillColor.limit = i;
        }

        public void setStrokeAlpha(float f) {
            this.mStrokeAlpha = f;
        }

        public void setStrokeColor(int i) {
            this.mStrokeColor.limit = i;
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
        }

        public void setTrimPathEnd(float f) {
            this.mTrimPathEnd = f;
        }

        public void setTrimPathOffset(float f) {
            this.mTrimPathOffset = f;
        }

        public void setTrimPathStart(float f) {
            this.mTrimPathStart = f;
        }
    }

    public abstract class VObject {
        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }
    }

    public final class VectorDrawableCompatState extends Drawable.ConstantState {
        public boolean mAutoMirrored;
        public boolean mCacheDirty;
        public boolean mCachedAutoMirrored;
        public Bitmap mCachedBitmap;
        public int mCachedRootAlpha;
        public ColorStateList mCachedTint;
        public PorterDuff.Mode mCachedTintMode;
        public int mChangingConfigurations;
        public Paint mTempPaint;
        public ColorStateList mTint;
        public PorterDuff.Mode mTintMode;
        public VPathRenderer mVPathRenderer;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }
    }

    public VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        VectorDrawableCompatState vectorDrawableCompatState = new VectorDrawableCompatState();
        vectorDrawableCompatState.mTint = null;
        vectorDrawableCompatState.mTintMode = DEFAULT_TINT_MODE;
        vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
        this.mVectorState = vectorDrawableCompatState;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) {
            return false;
        }
        DrawableCompat$Api21Impl.canApplyTheme(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.mTmpBounds;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.mColorFilter;
        if (colorFilter == null) {
            colorFilter = this.mTintFilter;
        }
        Matrix matrix = this.mTmpMatrix;
        canvas.getMatrix(matrix);
        float[] fArr = this.mTmpFloats;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iHeight = (int) (rect.height() * fAbs2);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && DrawableCompat$Api23Impl.getLayoutDirection(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        Bitmap bitmap = vectorDrawableCompatState.mCachedBitmap;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != vectorDrawableCompatState.mCachedBitmap.getHeight()) {
            vectorDrawableCompatState.mCachedBitmap = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            vectorDrawableCompatState.mCacheDirty = true;
        }
        if (this.mAllowCaching) {
            VectorDrawableCompatState vectorDrawableCompatState2 = this.mVectorState;
            if (vectorDrawableCompatState2.mCacheDirty || vectorDrawableCompatState2.mCachedTint != vectorDrawableCompatState2.mTint || vectorDrawableCompatState2.mCachedTintMode != vectorDrawableCompatState2.mTintMode || vectorDrawableCompatState2.mCachedAutoMirrored != vectorDrawableCompatState2.mAutoMirrored || vectorDrawableCompatState2.mCachedRootAlpha != vectorDrawableCompatState2.mVPathRenderer.getRootAlpha()) {
                VectorDrawableCompatState vectorDrawableCompatState3 = this.mVectorState;
                vectorDrawableCompatState3.mCachedBitmap.eraseColor(0);
                Canvas canvas2 = new Canvas(vectorDrawableCompatState3.mCachedBitmap);
                VPathRenderer vPathRenderer = vectorDrawableCompatState3.mVPathRenderer;
                vPathRenderer.drawGroupTree(vPathRenderer.mRootGroup, VPathRenderer.IDENTITY_MATRIX, canvas2, iMin, iMin2);
                VectorDrawableCompatState vectorDrawableCompatState4 = this.mVectorState;
                vectorDrawableCompatState4.mCachedTint = vectorDrawableCompatState4.mTint;
                vectorDrawableCompatState4.mCachedTintMode = vectorDrawableCompatState4.mTintMode;
                vectorDrawableCompatState4.mCachedRootAlpha = vectorDrawableCompatState4.mVPathRenderer.getRootAlpha();
                vectorDrawableCompatState4.mCachedAutoMirrored = vectorDrawableCompatState4.mAutoMirrored;
                vectorDrawableCompatState4.mCacheDirty = false;
            }
        } else {
            VectorDrawableCompatState vectorDrawableCompatState5 = this.mVectorState;
            vectorDrawableCompatState5.mCachedBitmap.eraseColor(0);
            Canvas canvas3 = new Canvas(vectorDrawableCompatState5.mCachedBitmap);
            VPathRenderer vPathRenderer2 = vectorDrawableCompatState5.mVPathRenderer;
            vPathRenderer2.drawGroupTree(vPathRenderer2.mRootGroup, VPathRenderer.IDENTITY_MATRIX, canvas3, iMin, iMin2);
        }
        VectorDrawableCompatState vectorDrawableCompatState6 = this.mVectorState;
        if (vectorDrawableCompatState6.mVPathRenderer.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (vectorDrawableCompatState6.mTempPaint == null) {
                Paint paint2 = new Paint();
                vectorDrawableCompatState6.mTempPaint = paint2;
                paint2.setFilterBitmap(true);
            }
            vectorDrawableCompatState6.mTempPaint.setAlpha(vectorDrawableCompatState6.mVPathRenderer.getRootAlpha());
            vectorDrawableCompatState6.mTempPaint.setColorFilter(colorFilter);
            paint = vectorDrawableCompatState6.mTempPaint;
        }
        canvas.drawBitmap(vectorDrawableCompatState6.mCachedBitmap, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.getAlpha() : this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? DrawableCompat$Api21Impl.getColorFilter(drawable) : this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.isAutoMirrored() : this.mVectorState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            if (vectorDrawableCompatState != null) {
                VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
                if (vPathRenderer.mIsStateful == null) {
                    vPathRenderer.mIsStateful = Boolean.valueOf(vPathRenderer.mRootGroup.isStateful());
                }
                if (vPathRenderer.mIsStateful.booleanValue() || ((colorStateList = this.mVectorState.mTint) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            VectorDrawableCompatState vectorDrawableCompatState2 = new VectorDrawableCompatState();
            vectorDrawableCompatState2.mTint = null;
            vectorDrawableCompatState2.mTintMode = DEFAULT_TINT_MODE;
            if (vectorDrawableCompatState != null) {
                vectorDrawableCompatState2.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
                vectorDrawableCompatState2.mVPathRenderer = vPathRenderer;
                if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                    vPathRenderer.mFillPaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                    vectorDrawableCompatState2.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
                }
                vectorDrawableCompatState2.mTint = vectorDrawableCompatState.mTint;
                vectorDrawableCompatState2.mTintMode = vectorDrawableCompatState.mTintMode;
                vectorDrawableCompatState2.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
            }
            this.mVectorState = vectorDrawableCompatState2;
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableCompatState.mTint;
        if (colorStateList == null || (mode = vectorDrawableCompatState.mTintMode) == null) {
            z = false;
        } else {
            this.mTintFilter = updateTintFilter(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        if (vPathRenderer.mIsStateful == null) {
            vPathRenderer.mIsStateful = Boolean.valueOf(vPathRenderer.mRootGroup.isStateful());
        }
        if (vPathRenderer.mIsStateful.booleanValue()) {
            boolean zOnStateChanged = vectorDrawableCompatState.mVPathRenderer.mRootGroup.onStateChanged(iArr);
            vectorDrawableCompatState.mCacheDirty |= zOnStateChanged;
            if (zOnStateChanged) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.mVectorState.mAutoMirrored = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.mColorFilter = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            AsyncTimeout.Companion.setTint(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.setTintList(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTint != colorStateList) {
            vectorDrawableCompatState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(colorStateList, vectorDrawableCompatState.mTintMode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.setTintMode(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTintMode != mode) {
            vectorDrawableCompatState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.mDelegateDrawable;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public final PorterDuffColorFilter updateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final class VectorDrawableDelegateState extends Drawable.ConstantState {
        public final Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public abstract class VPath extends VObject {
        public int mFillRule;
        public PathParser$PathDataNode[] mNodes;
        public String mPathName;

        public VPath() {
            this.mNodes = null;
            this.mFillRule = 0;
        }

        public PathParser$PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public void setPathData(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
            if (!WorkContinuation.canMorph(this.mNodes, pathParser$PathDataNodeArr)) {
                this.mNodes = WorkContinuation.deepCopyNodes(pathParser$PathDataNodeArr);
                return;
            }
            PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = this.mNodes;
            for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
                pathParser$PathDataNodeArr2[i].mType = pathParser$PathDataNodeArr[i].mType;
                int i2 = 0;
                while (true) {
                    float[] fArr = pathParser$PathDataNodeArr[i].mParams;
                    if (i2 < fArr.length) {
                        pathParser$PathDataNodeArr2[i].mParams[i2] = fArr[i2];
                        i2++;
                    }
                }
            }
        }

        public VPath(VPath vPath) {
            this.mNodes = null;
            this.mFillRule = 0;
            this.mPathName = vPath.mPathName;
            this.mNodes = WorkContinuation.deepCopyNodes(vPath.mNodes);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        VPathRenderer vPathRenderer;
        int i;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        Paint.Join join;
        Paint.Cap cap;
        Paint.Join join2;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
        TypedArray typedArrayObtainAttributes = CamUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        VectorDrawableCompatState vectorDrawableCompatState2 = this.mVectorState;
        VPathRenderer vPathRenderer2 = vectorDrawableCompatState2.mVPathRenderer;
        int i4 = !CamUtils.hasAttribute(xmlPullParser, "tintMode") ? -1 : typedArrayObtainAttributes.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i5 = 3;
        if (i4 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i4 != 5) {
            if (i4 != 9) {
                switch (i4) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        vectorDrawableCompatState2.mTintMode = mode;
        int i6 = 1;
        ColorStateList colorStateListCreateFromXml = null;
        boolean z3 = false;
        if (CamUtils.hasAttribute(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            typedArrayObtainAttributes.getValue(1, typedValue);
            int i7 = typedValue.type;
            if (i7 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i7 >= 28 && i7 <= 31) {
                colorStateListCreateFromXml = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayObtainAttributes.getResources();
                int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
                ThreadLocal threadLocal = ColorStateListInflaterCompat.sTempTypedValue;
                try {
                    colorStateListCreateFromXml = ColorStateListInflaterCompat.createFromXml(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
                }
            }
        }
        ColorStateList colorStateList = colorStateListCreateFromXml;
        if (colorStateList != null) {
            vectorDrawableCompatState2.mTint = colorStateList;
        }
        boolean z4 = vectorDrawableCompatState2.mAutoMirrored;
        if (CamUtils.hasAttribute(xmlPullParser, "autoMirrored")) {
            z4 = typedArrayObtainAttributes.getBoolean(5, z4);
        }
        vectorDrawableCompatState2.mAutoMirrored = z4;
        float f = vPathRenderer2.mViewportWidth;
        if (CamUtils.hasAttribute(xmlPullParser, "viewportWidth")) {
            f = typedArrayObtainAttributes.getFloat(7, f);
        }
        vPathRenderer2.mViewportWidth = f;
        float f2 = vPathRenderer2.mViewportHeight;
        if (CamUtils.hasAttribute(xmlPullParser, "viewportHeight")) {
            f2 = typedArrayObtainAttributes.getFloat(8, f2);
        }
        vPathRenderer2.mViewportHeight = f2;
        if (vPathRenderer2.mViewportWidth <= 0.0f) {
            throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 > 0.0f) {
            vPathRenderer2.mBaseWidth = typedArrayObtainAttributes.getDimension(3, vPathRenderer2.mBaseWidth);
            float dimension = typedArrayObtainAttributes.getDimension(2, vPathRenderer2.mBaseHeight);
            vPathRenderer2.mBaseHeight = dimension;
            if (vPathRenderer2.mBaseWidth <= 0.0f) {
                throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = vPathRenderer2.getAlpha();
                if (CamUtils.hasAttribute(xmlPullParser, "alpha")) {
                    alpha = typedArrayObtainAttributes.getFloat(4, alpha);
                }
                vPathRenderer2.setAlpha(alpha);
                String string = typedArrayObtainAttributes.getString(0);
                if (string != null) {
                    vPathRenderer2.mRootName = string;
                    vPathRenderer2.mVGTargetsMap.put(string, vPathRenderer2);
                }
                typedArrayObtainAttributes.recycle();
                vectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
                vectorDrawableCompatState.mCacheDirty = true;
                VectorDrawableCompatState vectorDrawableCompatState3 = this.mVectorState;
                VPathRenderer vPathRenderer3 = vectorDrawableCompatState3.mVPathRenderer;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(vPathRenderer3.mRootGroup);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z5 = true;
                while (eventType != i6 && (xmlPullParser.getDepth() >= depth || eventType != i5)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        VGroup vGroup = (VGroup) arrayDeque.peek();
                        boolean zEquals = "path".equals(name);
                        i = depth;
                        ArrayMap arrayMap = vPathRenderer3.mVGTargetsMap;
                        if (zEquals) {
                            VFullPath vFullPath = new VFullPath();
                            vFullPath.mStrokeWidth = 0.0f;
                            vFullPath.mStrokeAlpha = 1.0f;
                            vFullPath.mFillAlpha = 1.0f;
                            vFullPath.mTrimPathStart = 0.0f;
                            vFullPath.mTrimPathEnd = 1.0f;
                            vFullPath.mTrimPathOffset = 0.0f;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            vFullPath.mStrokeLineCap = cap2;
                            Paint.Join join3 = Paint.Join.MITER;
                            vFullPath.mStrokeLineJoin = join3;
                            vPathRenderer = vPathRenderer3;
                            vFullPath.mStrokeMiterlimit = 4.0f;
                            TypedArray typedArrayObtainAttributes2 = CamUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
                            if (CamUtils.hasAttribute(xmlPullParser, "pathData")) {
                                String string2 = typedArrayObtainAttributes2.getString(0);
                                if (string2 != null) {
                                    vFullPath.mPathName = string2;
                                }
                                String string3 = typedArrayObtainAttributes2.getString(2);
                                if (string3 != null) {
                                    vFullPath.mNodes = WorkContinuation.createNodesFromPathData(string3);
                                }
                                vFullPath.mFillColor = CamUtils.getNamedComplexColor(typedArrayObtainAttributes2, xmlPullParser, theme, "fillColor", 1);
                                float f3 = vFullPath.mFillAlpha;
                                if (CamUtils.hasAttribute(xmlPullParser, "fillAlpha")) {
                                    f3 = typedArrayObtainAttributes2.getFloat(12, f3);
                                }
                                vFullPath.mFillAlpha = f3;
                                int i8 = !CamUtils.hasAttribute(xmlPullParser, "strokeLineCap") ? -1 : typedArrayObtainAttributes2.getInt(8, -1);
                                Paint.Cap cap3 = vFullPath.mStrokeLineCap;
                                if (i8 != 0) {
                                    join = join3;
                                    if (i8 != 1) {
                                        cap = i8 != 2 ? cap3 : Paint.Cap.SQUARE;
                                    } else {
                                        cap = Paint.Cap.ROUND;
                                    }
                                } else {
                                    join = join3;
                                    cap = cap2;
                                }
                                vFullPath.mStrokeLineCap = cap;
                                int i9 = !CamUtils.hasAttribute(xmlPullParser, "strokeLineJoin") ? -1 : typedArrayObtainAttributes2.getInt(9, -1);
                                Paint.Join join4 = vFullPath.mStrokeLineJoin;
                                if (i9 == 0) {
                                    join2 = join;
                                } else if (i9 != 1) {
                                    join2 = i9 != 2 ? join4 : Paint.Join.BEVEL;
                                } else {
                                    join2 = Paint.Join.ROUND;
                                }
                                vFullPath.mStrokeLineJoin = join2;
                                float f4 = vFullPath.mStrokeMiterlimit;
                                if (CamUtils.hasAttribute(xmlPullParser, "strokeMiterLimit")) {
                                    f4 = typedArrayObtainAttributes2.getFloat(10, f4);
                                }
                                vFullPath.mStrokeMiterlimit = f4;
                                vFullPath.mStrokeColor = CamUtils.getNamedComplexColor(typedArrayObtainAttributes2, xmlPullParser, theme, "strokeColor", 3);
                                float f5 = vFullPath.mStrokeAlpha;
                                if (CamUtils.hasAttribute(xmlPullParser, "strokeAlpha")) {
                                    f5 = typedArrayObtainAttributes2.getFloat(11, f5);
                                }
                                vFullPath.mStrokeAlpha = f5;
                                float f6 = vFullPath.mStrokeWidth;
                                if (CamUtils.hasAttribute(xmlPullParser, "strokeWidth")) {
                                    f6 = typedArrayObtainAttributes2.getFloat(4, f6);
                                }
                                vFullPath.mStrokeWidth = f6;
                                float f7 = vFullPath.mTrimPathEnd;
                                if (CamUtils.hasAttribute(xmlPullParser, "trimPathEnd")) {
                                    f7 = typedArrayObtainAttributes2.getFloat(6, f7);
                                }
                                vFullPath.mTrimPathEnd = f7;
                                float f8 = vFullPath.mTrimPathOffset;
                                if (CamUtils.hasAttribute(xmlPullParser, "trimPathOffset")) {
                                    f8 = typedArrayObtainAttributes2.getFloat(7, f8);
                                }
                                vFullPath.mTrimPathOffset = f8;
                                float f9 = vFullPath.mTrimPathStart;
                                if (CamUtils.hasAttribute(xmlPullParser, "trimPathStart")) {
                                    f9 = typedArrayObtainAttributes2.getFloat(5, f9);
                                }
                                vFullPath.mTrimPathStart = f9;
                                int i10 = vFullPath.mFillRule;
                                if (CamUtils.hasAttribute(xmlPullParser, "fillType")) {
                                    i10 = typedArrayObtainAttributes2.getInt(13, i10);
                                }
                                vFullPath.mFillRule = i10;
                            }
                            typedArrayObtainAttributes2.recycle();
                            vGroup.mChildren.add(vFullPath);
                            if (vFullPath.getPathName() != null) {
                                arrayMap.put(vFullPath.getPathName(), vFullPath);
                            }
                            vectorDrawableCompatState3.mChangingConfigurations = vectorDrawableCompatState3.mChangingConfigurations;
                            z2 = false;
                            i2 = 1;
                            z5 = false;
                        } else {
                            vPathRenderer = vPathRenderer3;
                            if ("clip-path".equals(name)) {
                                VClipPath vClipPath = new VClipPath();
                                if (CamUtils.hasAttribute(xmlPullParser, "pathData")) {
                                    TypedArray typedArrayObtainAttributes3 = CamUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
                                    String string4 = typedArrayObtainAttributes3.getString(0);
                                    if (string4 != null) {
                                        vClipPath.mPathName = string4;
                                    }
                                    String string5 = typedArrayObtainAttributes3.getString(1);
                                    if (string5 != null) {
                                        vClipPath.mNodes = WorkContinuation.createNodesFromPathData(string5);
                                    }
                                    vClipPath.mFillRule = !CamUtils.hasAttribute(xmlPullParser, "fillType") ? 0 : typedArrayObtainAttributes3.getInt(2, 0);
                                    typedArrayObtainAttributes3.recycle();
                                }
                                vGroup.mChildren.add(vClipPath);
                                if (vClipPath.getPathName() != null) {
                                    arrayMap.put(vClipPath.getPathName(), vClipPath);
                                }
                                vectorDrawableCompatState3.mChangingConfigurations = vectorDrawableCompatState3.mChangingConfigurations;
                            } else if ("group".equals(name)) {
                                VGroup vGroup2 = new VGroup();
                                TypedArray typedArrayObtainAttributes4 = CamUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
                                float f10 = vGroup2.mRotate;
                                if (CamUtils.hasAttribute(xmlPullParser, "rotation")) {
                                    f10 = typedArrayObtainAttributes4.getFloat(5, f10);
                                }
                                vGroup2.mRotate = f10;
                                i2 = 1;
                                vGroup2.mPivotX = typedArrayObtainAttributes4.getFloat(1, vGroup2.mPivotX);
                                vGroup2.mPivotY = typedArrayObtainAttributes4.getFloat(2, vGroup2.mPivotY);
                                float f11 = vGroup2.mScaleX;
                                if (CamUtils.hasAttribute(xmlPullParser, "scaleX")) {
                                    f11 = typedArrayObtainAttributes4.getFloat(3, f11);
                                }
                                vGroup2.mScaleX = f11;
                                float f12 = vGroup2.mScaleY;
                                if (CamUtils.hasAttribute(xmlPullParser, "scaleY")) {
                                    f12 = typedArrayObtainAttributes4.getFloat(4, f12);
                                }
                                vGroup2.mScaleY = f12;
                                float f13 = vGroup2.mTranslateX;
                                if (CamUtils.hasAttribute(xmlPullParser, "translateX")) {
                                    f13 = typedArrayObtainAttributes4.getFloat(6, f13);
                                }
                                vGroup2.mTranslateX = f13;
                                float f14 = vGroup2.mTranslateY;
                                if (CamUtils.hasAttribute(xmlPullParser, "translateY")) {
                                    f14 = typedArrayObtainAttributes4.getFloat(7, f14);
                                }
                                vGroup2.mTranslateY = f14;
                                z2 = false;
                                String string6 = typedArrayObtainAttributes4.getString(0);
                                if (string6 != null) {
                                    vGroup2.mGroupName = string6;
                                }
                                vGroup2.updateLocalMatrix();
                                typedArrayObtainAttributes4.recycle();
                                vGroup.mChildren.add(vGroup2);
                                arrayDeque.push(vGroup2);
                                if (vGroup2.getGroupName() != null) {
                                    arrayMap.put(vGroup2.getGroupName(), vGroup2);
                                }
                                vectorDrawableCompatState3.mChangingConfigurations = vectorDrawableCompatState3.mChangingConfigurations;
                            }
                            z2 = false;
                            i2 = 1;
                        }
                        z = z2;
                        i3 = 3;
                    } else {
                        vPathRenderer = vPathRenderer3;
                        i = depth;
                        i2 = i6;
                        z = z3;
                        i3 = 3;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i5 = i3;
                    z3 = z;
                    i6 = i2;
                    depth = i;
                    vPathRenderer3 = vPathRenderer;
                }
                if (!z5) {
                    this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public final class VGroup extends VObject {
        public final ArrayList mChildren;
        public String mGroupName;
        public final Matrix mLocalMatrix;
        public float mPivotX;
        public float mPivotY;
        public float mRotate;
        public float mScaleX;
        public float mScaleY;
        public final Matrix mStackedMatrix;
        public float mTranslateX;
        public float mTranslateY;

        public VGroup() {
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean isStateful() {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.mChildren;
                if (i >= arrayList.size()) {
                    return false;
                }
                if (((VObject) arrayList.get(i)).isStateful()) {
                    return true;
                }
                i++;
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean onStateChanged(int[] iArr) {
            int i = 0;
            boolean zOnStateChanged = false;
            while (true) {
                ArrayList arrayList = this.mChildren;
                if (i >= arrayList.size()) {
                    return zOnStateChanged;
                }
                zOnStateChanged |= ((VObject) arrayList.get(i)).onStateChanged(iArr);
                i++;
            }
        }

        public void setPivotX(float f) {
            if (f != this.mPivotX) {
                this.mPivotX = f;
                updateLocalMatrix();
            }
        }

        public void setPivotY(float f) {
            if (f != this.mPivotY) {
                this.mPivotY = f;
                updateLocalMatrix();
            }
        }

        public void setRotation(float f) {
            if (f != this.mRotate) {
                this.mRotate = f;
                updateLocalMatrix();
            }
        }

        public void setScaleX(float f) {
            if (f != this.mScaleX) {
                this.mScaleX = f;
                updateLocalMatrix();
            }
        }

        public void setScaleY(float f) {
            if (f != this.mScaleY) {
                this.mScaleY = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.mTranslateX) {
                this.mTranslateX = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.mTranslateY) {
                this.mTranslateY = f;
                updateLocalMatrix();
            }
        }

        public final void updateLocalMatrix() {
            Matrix matrix = this.mLocalMatrix;
            matrix.reset();
            matrix.postTranslate(-this.mPivotX, -this.mPivotY);
            matrix.postScale(this.mScaleX, this.mScaleY);
            matrix.postRotate(this.mRotate, 0.0f, 0.0f);
            matrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        public VGroup(VGroup vGroup, ArrayMap arrayMap) {
            VPath vClipPath;
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            Matrix matrix = new Matrix();
            this.mLocalMatrix = matrix;
            this.mGroupName = null;
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            String str = vGroup.mGroupName;
            this.mGroupName = str;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.mLocalMatrix);
            ArrayList arrayList = vGroup.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    if (obj instanceof VFullPath) {
                        VFullPath vFullPath = (VFullPath) obj;
                        VFullPath vFullPath2 = new VFullPath(vFullPath);
                        vFullPath2.mStrokeWidth = 0.0f;
                        vFullPath2.mStrokeAlpha = 1.0f;
                        vFullPath2.mFillAlpha = 1.0f;
                        vFullPath2.mTrimPathStart = 0.0f;
                        vFullPath2.mTrimPathEnd = 1.0f;
                        vFullPath2.mTrimPathOffset = 0.0f;
                        vFullPath2.mStrokeLineCap = Paint.Cap.BUTT;
                        vFullPath2.mStrokeLineJoin = Paint.Join.MITER;
                        vFullPath2.mStrokeMiterlimit = 4.0f;
                        vFullPath2.mStrokeColor = vFullPath.mStrokeColor;
                        vFullPath2.mStrokeWidth = vFullPath.mStrokeWidth;
                        vFullPath2.mStrokeAlpha = vFullPath.mStrokeAlpha;
                        vFullPath2.mFillColor = vFullPath.mFillColor;
                        vFullPath2.mFillRule = vFullPath.mFillRule;
                        vFullPath2.mFillAlpha = vFullPath.mFillAlpha;
                        vFullPath2.mTrimPathStart = vFullPath.mTrimPathStart;
                        vFullPath2.mTrimPathEnd = vFullPath.mTrimPathEnd;
                        vFullPath2.mTrimPathOffset = vFullPath.mTrimPathOffset;
                        vFullPath2.mStrokeLineCap = vFullPath.mStrokeLineCap;
                        vFullPath2.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
                        vFullPath2.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
                        vClipPath = vFullPath2;
                    } else if (obj instanceof VClipPath) {
                        vClipPath = new VClipPath((VClipPath) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(vClipPath);
                    Object obj2 = vClipPath.mPathName;
                    if (obj2 != null) {
                        arrayMap.put(obj2, vClipPath);
                    }
                }
            }
        }
    }

    public VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    public final class VPathRenderer {
        public static final Matrix IDENTITY_MATRIX = new Matrix();
        public float mBaseHeight;
        public float mBaseWidth;
        public Paint mFillPaint;
        public final Matrix mFinalPathMatrix;
        public Boolean mIsStateful;
        public final Path mPath;
        public PathMeasure mPathMeasure;
        public final Path mRenderPath;
        public int mRootAlpha;
        public final VGroup mRootGroup;
        public String mRootName;
        public Paint mStrokePaint;
        public final ArrayMap mVGTargetsMap;
        public float mViewportHeight;
        public float mViewportWidth;

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new ArrayMap();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0139  */
        /* JADX WARN: Code duplicated, block: B:50:0x0146  */
        /* JADX WARN: Code duplicated, block: B:52:0x014a  */
        /* JADX WARN: Code duplicated, block: B:55:0x015f  */
        /* JADX WARN: Code duplicated, block: B:56:0x0170  */
        /* JADX WARN: Code duplicated, block: B:59:0x0191  */
        /* JADX WARN: Code duplicated, block: B:60:0x0194  */
        /* JADX WARN: Code duplicated, block: B:67:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:69:0x01ad  */
        /* JADX WARN: Code duplicated, block: B:72:0x01c0  */
        /* JADX WARN: Code duplicated, block: B:75:0x01c7  */
        /* JADX WARN: Code duplicated, block: B:78:0x01d5  */
        /* JADX WARN: Code duplicated, block: B:79:0x01e6  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v18 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v25 */
        /* JADX WARN: Type inference failed for: r9v8, types: [android.graphics.PathMeasure] */
        public final void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2) {
            int i3;
            float f;
            float f2;
            Splitter splitter;
            ?? r5;
            Splitter splitter2;
            Paint paint;
            Paint.Join join;
            Paint.Cap cap;
            Shader shader;
            Paint paint2;
            Shader shader2;
            Path.FillType fillType;
            int i4 = 1;
            vGroup.mStackedMatrix.set(matrix);
            Matrix matrix2 = vGroup.mStackedMatrix;
            matrix2.preConcat(vGroup.mLocalMatrix);
            canvas.save();
            ?? r11 = 0;
            int i5 = 0;
            while (true) {
                ArrayList arrayList = vGroup.mChildren;
                if (i5 >= arrayList.size()) {
                    canvas.restore();
                    return;
                }
                VObject vObject = (VObject) arrayList.get(i5);
                if (vObject instanceof VGroup) {
                    drawGroupTree((VGroup) vObject, matrix2, canvas, i, i2);
                    i3 = i4;
                } else if (vObject instanceof VPath) {
                    VPath vPath = (VPath) vObject;
                    float f3 = i / this.mViewportWidth;
                    float f4 = i2 / this.mViewportHeight;
                    float fMin = Math.min(f3, f4);
                    Matrix matrix3 = this.mFinalPathMatrix;
                    matrix3.set(matrix2);
                    matrix3.postScale(f3, f4);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    float fHypot = (float) Math.hypot(fArr[r11], fArr[i4]);
                    float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                    float f5 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float fMax = Math.max(fHypot, fHypot2);
                    float fAbs = fMax > 0.0f ? Math.abs(f5) / fMax : 0.0f;
                    if (fAbs != 0.0f) {
                        Path path = this.mPath;
                        vPath.getClass();
                        path.reset();
                        PathParser$PathDataNode[] pathParser$PathDataNodeArr = vPath.mNodes;
                        if (pathParser$PathDataNodeArr != null) {
                            PathParser$PathDataNode.nodesToPath(pathParser$PathDataNodeArr, path);
                        }
                        Path path2 = this.mRenderPath;
                        path2.reset();
                        if (vPath instanceof VClipPath) {
                            path2.setFillType(vPath.mFillRule == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            path2.addPath(path, matrix3);
                            canvas.clipPath(path2);
                        } else {
                            VFullPath vFullPath = (VFullPath) vPath;
                            float f6 = vFullPath.mTrimPathStart;
                            if (f6 == 0.0f) {
                                f = 1.0f;
                                if (vFullPath.mTrimPathEnd != 1.0f) {
                                }
                                path2.addPath(path, matrix3);
                                splitter = vFullPath.mFillColor;
                                if (((Shader) splitter.trimmer) != null && splitter.limit == 0) {
                                    r5 = r11;
                                } else {
                                    r5 = 1;
                                }
                                if (r5 != 0) {
                                    if (this.mFillPaint == null) {
                                        Paint paint3 = new Paint(1);
                                        this.mFillPaint = paint3;
                                        paint3.setStyle(Paint.Style.FILL);
                                    }
                                    paint2 = this.mFillPaint;
                                    shader2 = (Shader) splitter.trimmer;
                                    if (shader2 != null) {
                                        shader2.setLocalMatrix(matrix3);
                                        paint2.setShader(shader2);
                                        paint2.setAlpha(Math.round(vFullPath.mFillAlpha * 255.0f));
                                    } else {
                                        paint2.setShader(null);
                                        paint2.setAlpha(255);
                                        int i6 = splitter.limit;
                                        float f7 = vFullPath.mFillAlpha;
                                        PorterDuff.Mode mode = VectorDrawableCompat.DEFAULT_TINT_MODE;
                                        paint2.setColor((i6 & 16777215) | (((int) (Color.alpha(i6) * f7)) << 24));
                                    }
                                    paint2.setColorFilter(null);
                                    if (vFullPath.mFillRule == 0) {
                                        fillType = Path.FillType.WINDING;
                                    } else {
                                        fillType = Path.FillType.EVEN_ODD;
                                    }
                                    path2.setFillType(fillType);
                                    canvas.drawPath(path2, paint2);
                                }
                                splitter2 = vFullPath.mStrokeColor;
                                if (((Shader) splitter2.trimmer) == null || splitter2.limit != 0) {
                                    if (this.mStrokePaint == null) {
                                        Paint paint4 = new Paint(1);
                                        this.mStrokePaint = paint4;
                                        paint4.setStyle(Paint.Style.STROKE);
                                    }
                                    paint = this.mStrokePaint;
                                    join = vFullPath.mStrokeLineJoin;
                                    if (join != null) {
                                        paint.setStrokeJoin(join);
                                    }
                                    cap = vFullPath.mStrokeLineCap;
                                    if (cap != null) {
                                        paint.setStrokeCap(cap);
                                    }
                                    paint.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                                    shader = (Shader) splitter2.trimmer;
                                    if (shader != null) {
                                        shader.setLocalMatrix(matrix3);
                                        paint.setShader(shader);
                                        paint.setAlpha(Math.round(vFullPath.mStrokeAlpha * 255.0f));
                                    } else {
                                        paint.setShader(null);
                                        paint.setAlpha(255);
                                        int i7 = splitter2.limit;
                                        float f8 = vFullPath.mStrokeAlpha;
                                        PorterDuff.Mode mode2 = VectorDrawableCompat.DEFAULT_TINT_MODE;
                                        paint.setColor((i7 & 16777215) | (((int) (Color.alpha(i7) * f8)) << 24));
                                    }
                                    paint.setColorFilter(null);
                                    paint.setStrokeWidth(vFullPath.mStrokeWidth * fAbs * fMin);
                                    canvas.drawPath(path2, paint);
                                }
                            } else {
                                f = 1.0f;
                            }
                            float f9 = vFullPath.mTrimPathOffset;
                            float f10 = (f6 + f9) % f;
                            float f11 = (vFullPath.mTrimPathEnd + f9) % f;
                            if (this.mPathMeasure == null) {
                                this.mPathMeasure = new PathMeasure();
                            }
                            this.mPathMeasure.setPath(path, r11);
                            float length = this.mPathMeasure.getLength();
                            float f12 = f10 * length;
                            float f13 = f11 * length;
                            path.reset();
                            if (f12 > f13) {
                                this.mPathMeasure.getSegment(f12, length, path, true);
                                f2 = 0.0f;
                                this.mPathMeasure.getSegment(0.0f, f13, path, true);
                            } else {
                                f2 = 0.0f;
                                this.mPathMeasure.getSegment(f12, f13, path, true);
                            }
                            path.rLineTo(f2, f2);
                            path2.addPath(path, matrix3);
                            splitter = vFullPath.mFillColor;
                            if (((Shader) splitter.trimmer) != null) {
                                r5 = 1;
                            } else {
                                r5 = r11;
                            }
                            if (r5 != 0) {
                                if (this.mFillPaint == null) {
                                    Paint paint5 = new Paint(1);
                                    this.mFillPaint = paint5;
                                    paint5.setStyle(Paint.Style.FILL);
                                }
                                paint2 = this.mFillPaint;
                                shader2 = (Shader) splitter.trimmer;
                                if (shader2 != null) {
                                    shader2.setLocalMatrix(matrix3);
                                    paint2.setShader(shader2);
                                    paint2.setAlpha(Math.round(vFullPath.mFillAlpha * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i8 = splitter.limit;
                                    float f14 = vFullPath.mFillAlpha;
                                    PorterDuff.Mode mode3 = VectorDrawableCompat.DEFAULT_TINT_MODE;
                                    paint2.setColor((i8 & 16777215) | (((int) (Color.alpha(i8) * f14)) << 24));
                                }
                                paint2.setColorFilter(null);
                                if (vFullPath.mFillRule == 0) {
                                    fillType = Path.FillType.WINDING;
                                } else {
                                    fillType = Path.FillType.EVEN_ODD;
                                }
                                path2.setFillType(fillType);
                                canvas.drawPath(path2, paint2);
                            }
                            splitter2 = vFullPath.mStrokeColor;
                            if (((Shader) splitter2.trimmer) == null) {
                                if (this.mStrokePaint == null) {
                                    Paint paint6 = new Paint(1);
                                    this.mStrokePaint = paint6;
                                    paint6.setStyle(Paint.Style.STROKE);
                                }
                                paint = this.mStrokePaint;
                                join = vFullPath.mStrokeLineJoin;
                                if (join != null) {
                                    paint.setStrokeJoin(join);
                                }
                                cap = vFullPath.mStrokeLineCap;
                                if (cap != null) {
                                    paint.setStrokeCap(cap);
                                }
                                paint.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                                shader = (Shader) splitter2.trimmer;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix3);
                                    paint.setShader(shader);
                                    paint.setAlpha(Math.round(vFullPath.mStrokeAlpha * 255.0f));
                                } else {
                                    paint.setShader(null);
                                    paint.setAlpha(255);
                                    int i9 = splitter2.limit;
                                    float f15 = vFullPath.mStrokeAlpha;
                                    PorterDuff.Mode mode4 = VectorDrawableCompat.DEFAULT_TINT_MODE;
                                    paint.setColor((i9 & 16777215) | (((int) (Color.alpha(i9) * f15)) << 24));
                                }
                                paint.setColorFilter(null);
                                paint.setStrokeWidth(vFullPath.mStrokeWidth * fAbs * fMin);
                                canvas.drawPath(path2, paint);
                            } else {
                                if (this.mStrokePaint == null) {
                                    Paint paint7 = new Paint(1);
                                    this.mStrokePaint = paint7;
                                    paint7.setStyle(Paint.Style.STROKE);
                                }
                                paint = this.mStrokePaint;
                                join = vFullPath.mStrokeLineJoin;
                                if (join != null) {
                                    paint.setStrokeJoin(join);
                                }
                                cap = vFullPath.mStrokeLineCap;
                                if (cap != null) {
                                    paint.setStrokeCap(cap);
                                }
                                paint.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                                shader = (Shader) splitter2.trimmer;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix3);
                                    paint.setShader(shader);
                                    paint.setAlpha(Math.round(vFullPath.mStrokeAlpha * 255.0f));
                                } else {
                                    paint.setShader(null);
                                    paint.setAlpha(255);
                                    int i10 = splitter2.limit;
                                    float f16 = vFullPath.mStrokeAlpha;
                                    PorterDuff.Mode mode5 = VectorDrawableCompat.DEFAULT_TINT_MODE;
                                    paint.setColor((i10 & 16777215) | (((int) (Color.alpha(i10) * f16)) << 24));
                                }
                                paint.setColorFilter(null);
                                paint.setStrokeWidth(vFullPath.mStrokeWidth * fAbs * fMin);
                                canvas.drawPath(path2, paint);
                            }
                        }
                    }
                    i3 = 1;
                } else {
                    i3 = i4;
                }
                i5 += i3;
                i4 = i3;
                matrix2 = matrix2;
                r11 = 0;
            }
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            ArrayMap arrayMap = new ArrayMap();
            this.mVGTargetsMap = arrayMap;
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, arrayMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            String str = vPathRenderer.mRootName;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.mIsStateful = vPathRenderer.mIsStateful;
        }
    }
}
