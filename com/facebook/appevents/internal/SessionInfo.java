package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.view.ViewCompat;
import androidx.room.RoomOpenHelper;
import com.facebook.FacebookSdk;
import com.google.firebase.auth.zzaa;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;

/* JADX INFO: loaded from: classes.dex */
public final class SessionInfo {
    public Object diskRestoreTime;
    public int interruptionCount;
    public Object sessionId;
    public Object sessionLastEventTime;
    public final Object sessionStartTime;
    public Object sourceApplicationInfo;

    public SessionInfo(Long l, Long l2) {
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.sessionStartTime = l;
        this.sessionLastEventTime = l2;
        this.sessionId = uuidRandomUUID;
    }

    public void applySupportBackgroundTint() {
        View view = (View) this.sessionStartTime;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((ConnectionSpec.Builder) this.diskRestoreTime) != null) {
                if (((ConnectionSpec.Builder) this.sourceApplicationInfo) == null) {
                    this.sourceApplicationInfo = new ConnectionSpec.Builder();
                }
                ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.sourceApplicationInfo;
                builder.cipherSuites = null;
                builder.supportsTlsExtensions = false;
                builder.tlsVersions = null;
                builder.tls = false;
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ColorStateList backgroundTintList = ViewCompat.Api21Impl.getBackgroundTintList(view);
                if (backgroundTintList != null) {
                    builder.supportsTlsExtensions = true;
                    builder.cipherSuites = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = ViewCompat.Api21Impl.getBackgroundTintMode(view);
                if (backgroundTintMode != null) {
                    builder.tls = true;
                    builder.tlsVersions = backgroundTintMode;
                }
                if (builder.supportsTlsExtensions || builder.tls) {
                    AppCompatDrawableManager.tintDrawable(background, builder, view.getDrawableState());
                    return;
                }
            }
            ConnectionSpec.Builder builder2 = (ConnectionSpec.Builder) this.sessionId;
            if (builder2 != null) {
                AppCompatDrawableManager.tintDrawable(background, builder2, view.getDrawableState());
                return;
            }
            ConnectionSpec.Builder builder3 = (ConnectionSpec.Builder) this.diskRestoreTime;
            if (builder3 != null) {
                AppCompatDrawableManager.tintDrawable(background, builder3, view.getDrawableState());
            }
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.sessionId;
        if (builder != null) {
            return (ColorStateList) builder.cipherSuites;
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.sessionId;
        if (builder != null) {
            return (PorterDuff.Mode) builder.tlsVersions;
        }
        return null;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        ColorStateList tintList;
        View view = (View) this.sessionStartTime;
        Context context = view.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) zzaaVarObtainStyledAttributes.zzb;
        View view2 = (View) this.sessionStartTime;
        ViewCompat.saveAttributeDataForStyleable(view2, view2.getContext(), iArr, attributeSet, (TypedArray) zzaaVarObtainStyledAttributes.zzb, i);
        try {
            if (typedArray.hasValue(0)) {
                this.interruptionCount = typedArray.getResourceId(0, -1);
                AppCompatDrawableManager appCompatDrawableManager = (AppCompatDrawableManager) this.sessionLastEventTime;
                Context context2 = view.getContext();
                int i2 = this.interruptionCount;
                synchronized (appCompatDrawableManager) {
                    tintList = appCompatDrawableManager.mResourceManager.getTintList(context2, i2);
                }
                if (tintList != null) {
                    setInternalBackgroundTint(tintList);
                }
            }
            if (typedArray.hasValue(1)) {
                ViewCompat.Api21Impl.setBackgroundTintList(view, zzaaVarObtainStyledAttributes.getColorStateList(1));
            }
            if (typedArray.hasValue(2)) {
                ViewCompat.Api21Impl.setBackgroundTintMode(view, DrawableUtils.parseTintMode(typedArray.getInt(2, -1), null));
            }
            zzaaVarObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            zzaaVarObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void onSetBackgroundDrawable() {
        this.interruptionCount = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    public void onSetBackgroundResource(int i) {
        ColorStateList tintList;
        this.interruptionCount = i;
        AppCompatDrawableManager appCompatDrawableManager = (AppCompatDrawableManager) this.sessionLastEventTime;
        if (appCompatDrawableManager != null) {
            Context context = ((View) this.sessionStartTime).getContext();
            synchronized (appCompatDrawableManager) {
                tintList = appCompatDrawableManager.mResourceManager.getTintList(context, i);
            }
        } else {
            tintList = null;
        }
        setInternalBackgroundTint(tintList);
        applySupportBackgroundTint();
    }

    public void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((ConnectionSpec.Builder) this.diskRestoreTime) == null) {
                this.diskRestoreTime = new ConnectionSpec.Builder();
            }
            ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.diskRestoreTime;
            builder.cipherSuites = colorStateList;
            builder.supportsTlsExtensions = true;
        } else {
            this.diskRestoreTime = null;
        }
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (((ConnectionSpec.Builder) this.sessionId) == null) {
            this.sessionId = new ConnectionSpec.Builder();
        }
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.sessionId;
        builder.cipherSuites = colorStateList;
        builder.supportsTlsExtensions = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (((ConnectionSpec.Builder) this.sessionId) == null) {
            this.sessionId = new ConnectionSpec.Builder();
        }
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.sessionId;
        builder.tlsVersions = mode;
        builder.tls = true;
        applySupportBackgroundTint();
    }

    public void writeSessionToDisk() {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        Long l = (Long) this.sessionStartTime;
        editorEdit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", l == null ? 0L : l.longValue());
        Long l2 = (Long) this.sessionLastEventTime;
        editorEdit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", l2 != null ? l2.longValue() : 0L);
        editorEdit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.interruptionCount);
        editorEdit.putString("com.facebook.appevents.SessionInfo.sessionId", ((UUID) this.sessionId).toString());
        editorEdit.apply();
        RoomOpenHelper.ValidationResult validationResult = (RoomOpenHelper.ValidationResult) this.sourceApplicationInfo;
        if (validationResult == null || validationResult == null) {
            return;
        }
        SharedPreferences.Editor editorEdit2 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        editorEdit2.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", validationResult.expectedFoundMsg);
        editorEdit2.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", validationResult.isValid);
        editorEdit2.apply();
    }

    public SessionInfo(View view) {
        this.interruptionCount = -1;
        this.sessionStartTime = view;
        this.sessionLastEventTime = AppCompatDrawableManager.get();
    }
}
