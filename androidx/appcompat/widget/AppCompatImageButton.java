package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.facebook.appevents.internal.SessionInfo;
import com.google.common.base.Splitter;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatImageButton extends ImageButton {
    public final SessionInfo mBackgroundTintHelper;
    public boolean mHasLevel;
    public final Splitter mImageHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintContextWrapper.wrap(context);
        this.mHasLevel = false;
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        SessionInfo sessionInfo = new SessionInfo(this);
        this.mBackgroundTintHelper = sessionInfo;
        sessionInfo.loadFromAttributes(attributeSet, i);
        Splitter splitter = new Splitter(this);
        this.mImageHelper = splitter;
        splitter.loadFromAttributes(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.applySupportBackgroundTint();
        }
        Splitter splitter = this.mImageHelper;
        if (splitter != null) {
            splitter.applySupportImageTint();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            return sessionInfo.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            return sessionInfo.getSupportBackgroundTintMode();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        ConnectionSpec.Builder builder;
        Splitter splitter = this.mImageHelper;
        if (splitter == null || (builder = (ConnectionSpec.Builder) splitter.strategy) == null) {
            return null;
        }
        return (ColorStateList) builder.cipherSuites;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        ConnectionSpec.Builder builder;
        Splitter splitter = this.mImageHelper;
        if (splitter == null || (builder = (ConnectionSpec.Builder) splitter.strategy) == null) {
            return null;
        }
        return (PorterDuff.Mode) builder.tlsVersions;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.mImageHelper.trimmer).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        Splitter splitter = this.mImageHelper;
        if (splitter != null) {
            splitter.applySupportImageTint();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Splitter splitter = this.mImageHelper;
        if (splitter != null && drawable != null && !this.mHasLevel) {
            splitter.limit = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (splitter != null) {
            splitter.applySupportImageTint();
            if (this.mHasLevel) {
                return;
            }
            ImageView imageView = (ImageView) splitter.trimmer;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(splitter.limit);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Splitter splitter = this.mImageHelper;
        ImageView imageView = (ImageView) splitter.trimmer;
        if (i != 0) {
            Drawable drawable = Headers.Companion.getDrawable(imageView.getContext(), i);
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageDrawable(null);
        }
        splitter.applySupportImageTint();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        Splitter splitter = this.mImageHelper;
        if (splitter != null) {
            splitter.applySupportImageTint();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.setSupportBackgroundTintMode(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        Splitter splitter = this.mImageHelper;
        if (splitter != null) {
            if (((ConnectionSpec.Builder) splitter.strategy) == null) {
                splitter.strategy = new ConnectionSpec.Builder();
            }
            ConnectionSpec.Builder builder = (ConnectionSpec.Builder) splitter.strategy;
            builder.cipherSuites = colorStateList;
            builder.supportsTlsExtensions = true;
            splitter.applySupportImageTint();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        Splitter splitter = this.mImageHelper;
        if (splitter != null) {
            if (((ConnectionSpec.Builder) splitter.strategy) == null) {
                splitter.strategy = new ConnectionSpec.Builder();
            }
            ConnectionSpec.Builder builder = (ConnectionSpec.Builder) splitter.strategy;
            builder.tlsVersions = mode;
            builder.tls = true;
            splitter.applySupportImageTint();
        }
    }
}
