package androidx.appcompat.widget;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat$Api23Impl;
import androidx.core.widget.TextViewCompat$Api34Impl;
import androidx.core.widget.TintableCompoundDrawablesView;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.foreground.SystemForegroundService;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import com.google.firebase.auth.zzaa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import kotlin.ranges.RangesKt;
import okhttp3.ConnectionSpec;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatTextHelper {
    public boolean mAsyncFontPending;
    public Object mAutoSizeTextHelper;
    public Object mDrawableBottomTint;
    public Object mDrawableEndTint;
    public Object mDrawableLeftTint;
    public Object mDrawableRightTint;
    public Object mDrawableStartTint;
    public Object mDrawableTint;
    public Object mDrawableTopTint;
    public Object mFontTypeface;
    public int mFontWeight;
    public int mStyle;
    public final Object mView;

    /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatTextHelper$2 */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final int val$style;
        public final Object val$textView;
        public final Object val$typeface;

        public /* synthetic */ AnonymousClass2(Object obj, int i, int i2, Object obj2) {
            this.$r8$classId = i2;
            this.val$textView = obj;
            this.val$typeface = obj2;
            this.val$style = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    ((TextView) this.val$textView).setTypeface((Typeface) this.val$typeface, this.val$style);
                    break;
                case 1:
                    ((CustomTabsClient.AnonymousClass2) this.val$typeface).val$callback.onNavigationEvent(this.val$style, (Bundle) this.val$textView);
                    break;
                case 2:
                    Intent intent = (Intent) this.val$typeface;
                    ((SystemAlarmDispatcher) this.val$textView).add(this.val$style, intent);
                    break;
                default:
                    ((SystemForegroundService) this.val$typeface).mNotificationManager.notify(this.val$style, (Notification) this.val$textView);
                    break;
            }
        }

        public /* synthetic */ AnonymousClass2(Object obj, int i, Parcelable parcelable, int i2) {
            this.$r8$classId = i2;
            this.val$typeface = obj;
            this.val$style = i;
            this.val$textView = parcelable;
        }
    }

    public abstract class Api21Impl {
        public static Locale forLanguageTag(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    public abstract class Api24Impl {
        public static LocaleList forLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void setTextLocales(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    public abstract class Api26Impl {
        public static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        public static boolean setFontVariationSettings(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    public abstract class Api28Impl {
        public static Typeface create(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    public AppCompatTextHelper() {
        this.mView = new HashSet();
        this.mDrawableLeftTint = new Bundle();
        this.mDrawableTopTint = new HashMap();
        this.mDrawableRightTint = new HashSet();
        this.mDrawableBottomTint = new Bundle();
        this.mDrawableStartTint = new HashSet();
        this.mDrawableTint = new ArrayList();
        this.mStyle = -1;
        this.mFontWeight = 60000;
    }

    public static ConnectionSpec.Builder createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList;
        synchronized (appCompatDrawableManager) {
            tintList = appCompatDrawableManager.mResourceManager.getTintList(context, i);
        }
        if (tintList == null) {
            return null;
        }
        ConnectionSpec.Builder builder = new ConnectionSpec.Builder();
        builder.supportsTlsExtensions = true;
        builder.cipherSuites = tintList;
        return builder;
    }

    public static void populateSurroundingTextIfNeeded(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i >= 30) {
            EditorInfoCompat.Api30Impl.setInitialSurroundingSubText(editorInfo, text);
            return;
        }
        text.getClass();
        if (i >= 30) {
            EditorInfoCompat.Api30Impl.setInitialSurroundingSubText(editorInfo, text);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        int length = text.length();
        if (i4 < 0 || i2 > length) {
            EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
            return;
        }
        int i5 = editorInfo.inputType & 4095;
        if (i5 == 129 || i5 == 225 || i5 == 18) {
            EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            EditorInfoCompat.setSurroundingText(editorInfo, text, i4, i2);
            return;
        }
        int i6 = i2 - i4;
        int i7 = i6 > 1024 ? 0 : i6;
        int i8 = 2048 - i7;
        int iMin = Math.min(text.length() - i2, i8 - Math.min(i4, (int) (((double) i8) * 0.8d)));
        int iMin2 = Math.min(i4, i8 - iMin);
        int i9 = i4 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i9))) {
            i9++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i2 + iMin) - 1))) {
            iMin--;
        }
        int i10 = iMin2 + i7;
        EditorInfoCompat.setSurroundingText(editorInfo, i7 != i6 ? TextUtils.concat(text.subSequence(i9, i9 + iMin2), text.subSequence(i2, iMin + i2)) : text.subSequence(i9, i10 + iMin + i9), iMin2, i10);
    }

    public void applyCompoundDrawableTint(Drawable drawable, ConnectionSpec.Builder builder) {
        if (drawable == null || builder == null) {
            return;
        }
        AppCompatDrawableManager.tintDrawable(drawable, builder, ((TextView) this.mView).getDrawableState());
    }

    public void applyCompoundDrawablesTints() {
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.mDrawableLeftTint;
        TextView textView = (TextView) this.mView;
        if (builder != null || ((ConnectionSpec.Builder) this.mDrawableTopTint) != null || ((ConnectionSpec.Builder) this.mDrawableRightTint) != null || ((ConnectionSpec.Builder) this.mDrawableBottomTint) != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], (ConnectionSpec.Builder) this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], (ConnectionSpec.Builder) this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], (ConnectionSpec.Builder) this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], (ConnectionSpec.Builder) this.mDrawableBottomTint);
        }
        if (((ConnectionSpec.Builder) this.mDrawableStartTint) == null && ((ConnectionSpec.Builder) this.mDrawableEndTint) == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        applyCompoundDrawableTint(compoundDrawablesRelative[0], (ConnectionSpec.Builder) this.mDrawableStartTint);
        applyCompoundDrawableTint(compoundDrawablesRelative[2], (ConnectionSpec.Builder) this.mDrawableEndTint);
    }

    public ColorStateList getCompoundDrawableTintList() {
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.mDrawableTint;
        if (builder != null) {
            return (ColorStateList) builder.cipherSuites;
        }
        return null;
    }

    public PorterDuff.Mode getCompoundDrawableTintMode() {
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.mDrawableTint;
        if (builder != null) {
            return (PorterDuff.Mode) builder.tlsVersions;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String string;
        String string2;
        boolean z3;
        int i2;
        int i3;
        float dimensionPixelSize;
        ColorStateList colorStateList;
        int resourceId;
        int i4;
        int resourceId2;
        int i5;
        TextView textView = (TextView) this.mView;
        Context context = textView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        int[] iArr = R$styleable.AppCompatTextHelper;
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(context, attributeSet, iArr, i);
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, (TypedArray) zzaaVarObtainStyledAttributes.zzb, i);
        TypedArray typedArray = (TypedArray) zzaaVarObtainStyledAttributes.zzb;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(2, 0));
        }
        if (typedArray.hasValue(5)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(6, 0));
        }
        zzaaVarObtainStyledAttributes.recycle();
        boolean z4 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = R$styleable.TextAppearance;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            zzaa zzaaVar = new zzaa(context, typedArrayObtainStyledAttributes);
            if (z4 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z = false;
                z2 = false;
            } else {
                z = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z2 = true;
            }
            updateTypefaceAndStyle(context, zzaaVar);
            int i6 = Build.VERSION.SDK_INT;
            if (typedArrayObtainStyledAttributes.hasValue(15)) {
                string2 = typedArrayObtainStyledAttributes.getString(15);
                i5 = 26;
            } else {
                i5 = 26;
                string2 = null;
            }
            string = (i6 < i5 || !typedArrayObtainStyledAttributes.hasValue(13)) ? null : typedArrayObtainStyledAttributes.getString(13);
            zzaaVar.recycle();
        } else {
            z = false;
            z2 = false;
            string = null;
            string2 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        zzaa zzaaVar2 = new zzaa(context, typedArrayObtainStyledAttributes2);
        if (z4 || !typedArrayObtainStyledAttributes2.hasValue(14)) {
            z3 = z;
        } else {
            z3 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z2 = true;
        }
        int i7 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        String str = string2;
        if (i7 >= 26 && typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (i7 >= 28 && typedArrayObtainStyledAttributes2.hasValue(0) && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, zzaaVar2);
        zzaaVar2.recycle();
        if (!z4 && z2) {
            textView.setAllCaps(z3);
        }
        Typeface typeface = (Typeface) this.mFontTypeface;
        if (typeface != null) {
            if (this.mFontWeight == -1) {
                textView.setTypeface(typeface, this.mStyle);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            Api26Impl.setFontVariationSettings(textView, string);
        }
        if (str != null) {
            if (i7 >= 24) {
                Api24Impl.setTextLocales(textView, Api24Impl.forLanguageTags(str));
            } else {
                textView.setTextLocale(Api21Impl.forLanguageTag(str.split(",")[0]));
            }
        }
        int[] iArr3 = R$styleable.AppCompatTextView;
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = (AppCompatTextViewAutoSizeHelper) this.mAutoSizeTextHelper;
        Context context2 = appCompatTextViewAutoSizeHelper.mContext;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i, 0);
        TextView textView2 = appCompatTextViewAutoSizeHelper.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes3.hasValue(3) && (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i8 = 0; i8 < length; i8++) {
                    iArr4[i8] = typedArrayObtainTypedArray.getDimensionPixelSize(i8, -1);
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArr4);
                appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
        } else if (appCompatTextViewAutoSizeHelper.mAutoSizeTextType == 1) {
            if (!appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i4 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i4 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i4, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(dimension2, dimension3, dimension);
            }
            appCompatTextViewAutoSizeHelper.setupAutoSizeText();
        }
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && appCompatTextViewAutoSizeHelper.mAutoSizeTextType != 0) {
            int[] iArr5 = appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx;
            if (iArr5.length > 0) {
                if (Api26Impl.getAutoSizeStepGranularity(textView) != -1.0f) {
                    Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(textView, Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx), 0);
                } else {
                    Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(textView, iArr5, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawable = resourceId4 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawable2 = resourceId5 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawable3 = resourceId6 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawable4 = resourceId7 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawable5 = resourceId8 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawable6 = resourceId9 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId9) : null;
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable7 == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            } else {
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = ContextCompat.getColorStateList(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                TextViewCompat$Api23Impl.setCompoundDrawableTintList(textView, colorStateList);
            } else if (textView instanceof TintableCompoundDrawablesView) {
                ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            PorterDuff.Mode tintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes4.getInt(12, -1), null);
            if (Build.VERSION.SDK_INT >= 24) {
                TextViewCompat$Api23Impl.setCompoundDrawableTintMode(textView, tintMode);
            } else if (textView instanceof TintableCompoundDrawablesView) {
                ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(tintMode);
            }
        }
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, -1);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, -1);
        if (typedArrayObtainStyledAttributes4.hasValue(19)) {
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes4.peekValue(19);
            if (typedValuePeekValue == null || typedValuePeekValue.type != 5) {
                i2 = -1;
                dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, -1);
                i3 = -1;
            } else {
                int i9 = typedValuePeekValue.data;
                int i10 = i9 & 15;
                dimensionPixelSize = TypedValue.complexToFloat(i9);
                i3 = i10;
                i2 = -1;
            }
        } else {
            i2 = -1;
            i3 = -1;
            dimensionPixelSize = -1.0f;
        }
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize2 != i2) {
            RangesKt.setFirstBaselineToTopHeight(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != i2) {
            RangesKt.setLastBaselineToBottomHeight(textView, dimensionPixelSize3);
        }
        if (dimensionPixelSize != -1.0f) {
            if (i3 == i2) {
                RangesKt.setLineHeight(textView, (int) dimensionPixelSize);
            } else if (Build.VERSION.SDK_INT >= 34) {
                TextViewCompat$Api34Impl.setLineHeight(textView, i3, dimensionPixelSize);
            } else {
                RangesKt.setLineHeight(textView, Math.round(TypedValue.applyDimension(i3, dimensionPixelSize, textView.getResources().getDisplayMetrics())));
            }
        }
    }

    public void onSetTextAppearance(Context context, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        zzaa zzaaVar = new zzaa(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = (TextView) this.mView;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, zzaaVar);
        if (i2 >= 26 && typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            Api26Impl.setFontVariationSettings(textView, string);
        }
        zzaaVar.recycle();
        Typeface typeface = (Typeface) this.mFontTypeface;
        if (typeface != null) {
            textView.setTypeface(typeface, this.mStyle);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = (AppCompatTextViewAutoSizeHelper) this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = (AppCompatTextViewAutoSizeHelper) this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArrCopyOf);
                if (!appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues = false;
            }
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = (AppCompatTextViewAutoSizeHelper) this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            if (i == 0) {
                appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
                appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx = -1.0f;
                appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx = -1.0f;
                appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx = -1.0f;
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = new int[0];
                appCompatTextViewAutoSizeHelper.mNeedsAutoSizeText = false;
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public void setCompoundDrawableTintList(ColorStateList colorStateList) {
        if (((ConnectionSpec.Builder) this.mDrawableTint) == null) {
            this.mDrawableTint = new ConnectionSpec.Builder();
        }
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.mDrawableTint;
        builder.cipherSuites = colorStateList;
        builder.supportsTlsExtensions = colorStateList != null;
        this.mDrawableLeftTint = builder;
        this.mDrawableTopTint = builder;
        this.mDrawableRightTint = builder;
        this.mDrawableBottomTint = builder;
        this.mDrawableStartTint = builder;
        this.mDrawableEndTint = builder;
    }

    public void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        if (((ConnectionSpec.Builder) this.mDrawableTint) == null) {
            this.mDrawableTint = new ConnectionSpec.Builder();
        }
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.mDrawableTint;
        builder.tlsVersions = mode;
        builder.tls = mode != null;
        this.mDrawableLeftTint = builder;
        this.mDrawableTopTint = builder;
        this.mDrawableRightTint = builder;
        this.mDrawableBottomTint = builder;
        this.mDrawableStartTint = builder;
        this.mDrawableEndTint = builder;
    }

    public void updateTypefaceAndStyle(Context context, zzaa zzaaVar) {
        String string;
        int i = this.mStyle;
        TypedArray typedArray = (TypedArray) zzaaVar.zzb;
        this.mStyle = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.mFontWeight = i3;
            if (i3 != -1) {
                this.mStyle &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.mAsyncFontPending = false;
                int i4 = typedArray.getInt(1, 1);
                if (i4 == 1) {
                    this.mFontTypeface = Typeface.SANS_SERIF;
                    return;
                } else if (i4 == 2) {
                    this.mFontTypeface = Typeface.SERIF;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.mFontTypeface = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.mFontTypeface = null;
        int i5 = typedArray.hasValue(12) ? 12 : 10;
        int i6 = this.mFontWeight;
        int i7 = this.mStyle;
        if (!context.isRestricted()) {
            try {
                Typeface font = zzaaVar.getFont(i5, this.mStyle, new AnonymousClass1(this, i6, i7, new WeakReference((TextView) this.mView)));
                if (font != null) {
                    if (i2 < 28 || this.mFontWeight == -1) {
                        this.mFontTypeface = font;
                    } else {
                        this.mFontTypeface = Api28Impl.create(Typeface.create(font, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                    }
                }
                this.mAsyncFontPending = ((Typeface) this.mFontTypeface) == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (((Typeface) this.mFontTypeface) != null || (string = typedArray.getString(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
            this.mFontTypeface = Typeface.create(string, this.mStyle);
        } else {
            this.mFontTypeface = Api28Impl.create(Typeface.create(string, 0), this.mFontWeight, (this.mStyle & 2) != 0);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatTextHelper$1 */
    public final class AnonymousClass1 {
        public final Object this$0;
        public final int val$fontWeight;
        public final int val$style;
        public final Object val$textViewWeak;

        public AnonymousClass1(String str, int i, int i2) {
            this.val$textViewWeak = str;
            this.val$style = i;
            this.val$fontWeight = i2;
            byte[] bArr = new byte[i * i2];
            this.this$0 = bArr;
            Arrays.fill(bArr, (byte) -1);
        }

        public void callbackFailAsync() {
            new Handler(Looper.getMainLooper()).post(new AccessTokenManager$$ExternalSyntheticLambda0(this, 4));
        }

        public void module(int i, int i2, int i3, int i4) {
            if (i < 0) {
                int i5 = this.val$fontWeight;
                i += i5;
                i2 += 4 - ((i5 + 4) % 8);
            }
            int i6 = this.val$style;
            if (i2 < 0) {
                i2 += i6;
                i += 4 - ((i6 + 4) % 8);
            }
            ((byte[]) this.this$0)[(i * i6) + i2] = (byte) ((((String) this.val$textViewWeak).charAt(i3) & (1 << (8 - i4))) == 0 ? 0 : 1);
        }

        public void onFontRetrieved(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.val$fontWeight) != -1) {
                typeface = Api28Impl.create(typeface, i, (this.val$style & 2) != 0);
            }
            AppCompatTextHelper appCompatTextHelper = (AppCompatTextHelper) this.this$0;
            if (appCompatTextHelper.mAsyncFontPending) {
                appCompatTextHelper.mFontTypeface = typeface;
                TextView textView = (TextView) ((WeakReference) this.val$textViewWeak).get();
                if (textView != null) {
                    if (textView.isAttachedToWindow()) {
                        textView.post(new AnonymousClass2(textView, appCompatTextHelper.mStyle, 0, typeface));
                    } else {
                        textView.setTypeface(typeface, appCompatTextHelper.mStyle);
                    }
                }
            }
        }

        public void utah(int i, int i2, int i3) {
            int i4 = i - 2;
            int i5 = i2 - 2;
            module(i4, i5, i3, 1);
            int i6 = i2 - 1;
            module(i4, i6, i3, 2);
            int i7 = i - 1;
            module(i7, i5, i3, 3);
            module(i7, i6, i3, 4);
            module(i7, i2, i3, 5);
            module(i, i5, i3, 6);
            module(i, i6, i3, 7);
            module(i, i2, i3, 8);
        }

        public AnonymousClass1(AppCompatTextHelper appCompatTextHelper, int i, int i2, WeakReference weakReference) {
            this.this$0 = appCompatTextHelper;
            this.val$fontWeight = i;
            this.val$style = i2;
            this.val$textViewWeak = weakReference;
        }
    }

    public AppCompatTextHelper(TextView textView) {
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }
}
