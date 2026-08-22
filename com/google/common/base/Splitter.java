package com.google.common.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Xml;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat$Api21Impl;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.internal.consent_sdk.zzcm;
import com.google.android.gms.internal.consent_sdk.zzcu;
import com.google.android.ump.ConsentDebugSettings;
import com.google.firebase.auth.zzaa;
import com.google.firebase.inject.PVS.jIKWv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.Protocol;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class Splitter {
    public final /* synthetic */ int $r8$classId;
    public int limit;
    public Object strategy;
    public final Object trimmer;

    /* JADX INFO: loaded from: classes.dex */
    public interface Strategy {
        Iterator iterator(Splitter splitter, String str);
    }

    public Splitter(Context context) {
        this.$r8$classId = 3;
        this.trimmer = new ArrayList();
        this.limit = 0;
        this.strategy = context.getApplicationContext();
    }

    public void applySupportImageTint() {
        ConnectionSpec.Builder builder;
        ImageView imageView = (ImageView) this.trimmer;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            DrawableUtils.fixDrawable(drawable);
        }
        if (drawable == null || (builder = (ConnectionSpec.Builder) this.strategy) == null) {
            return;
        }
        AppCompatDrawableManager.tintDrawable(drawable, builder, imageView.getDrawableState());
    }

    public ConsentDebugSettings build() {
        boolean z = true;
        if (!zzcu.zza(true) && !((ArrayList) this.trimmer).contains(zzcm.zza((Context) this.strategy))) {
            z = false;
        }
        return new ConsentDebugSettings(z, this);
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        return ((Shader) this.trimmer) == null && (colorStateList = (ColorStateList) this.strategy) != null && colorStateList.isStateful();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.trimmer;
        Context context = imageView.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(context, attributeSet, iArr, i);
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) zzaaVarObtainStyledAttributes.zzb, i);
        try {
            Drawable drawable = imageView.getDrawable();
            TypedArray typedArray = (TypedArray) zzaaVarObtainStyledAttributes.zzb;
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = Headers.Companion.getDrawable(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            if (typedArray.hasValue(2)) {
                ImageViewCompat$Api21Impl.setImageTintList(imageView, zzaaVarObtainStyledAttributes.getColorStateList(2));
            }
            if (typedArray.hasValue(3)) {
                ImageViewCompat$Api21Impl.setImageTintMode(imageView, DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null));
            }
        } finally {
            zzaaVarObtainStyledAttributes.recycle();
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 4:
                StringBuilder sb = new StringBuilder();
                if (((Protocol) this.trimmer) == Protocol.HTTP_1_0) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(this.limit);
                sb.append(' ');
                sb.append((String) this.strategy);
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            default:
                return super.toString();
        }
    }

    public static Splitter createFromXml(Resources resources, int i, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        float f;
        float f2;
        float f3;
        int i2;
        Shader radialGradient;
        Shader.TileMode tileMode;
        Shader.TileMode tileMode2;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        if (!name.equals("gradient")) {
            if (name.equals("selector")) {
                ColorStateList colorStateListCreateFromXmlInner = ColorStateListInflaterCompat.createFromXmlInner(resources, xml, attributeSetAsAttributeSet, theme);
                return new Splitter((Shader) null, colorStateListCreateFromXmlInner, colorStateListCreateFromXmlInner.getDefaultColor());
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        String name2 = xml.getName();
        if (!name2.equals("gradient")) {
            throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
        TypedArray typedArrayObtainAttributes = CamUtils.obtainAttributes(resources, theme, attributeSetAsAttributeSet, androidx.core.R$styleable.GradientColor);
        float f4 = !CamUtils.hasAttribute(xml, "startX") ? 0.0f : typedArrayObtainAttributes.getFloat(8, 0.0f);
        float f5 = !CamUtils.hasAttribute(xml, jIKWv.wWrqbZE) ? 0.0f : typedArrayObtainAttributes.getFloat(9, 0.0f);
        float f6 = !CamUtils.hasAttribute(xml, "endX") ? 0.0f : typedArrayObtainAttributes.getFloat(10, 0.0f);
        float f7 = !CamUtils.hasAttribute(xml, "endY") ? 0.0f : typedArrayObtainAttributes.getFloat(11, 0.0f);
        float f8 = !CamUtils.hasAttribute(xml, "centerX") ? 0.0f : typedArrayObtainAttributes.getFloat(3, 0.0f);
        float f9 = !CamUtils.hasAttribute(xml, "centerY") ? 0.0f : typedArrayObtainAttributes.getFloat(4, 0.0f);
        int i3 = !CamUtils.hasAttribute(xml, "type") ? 0 : typedArrayObtainAttributes.getInt(2, 0);
        int color = !CamUtils.hasAttribute(xml, "startColor") ? 0 : typedArrayObtainAttributes.getColor(0, 0);
        boolean zHasAttribute = CamUtils.hasAttribute(xml, "centerColor");
        int color2 = !CamUtils.hasAttribute(xml, "centerColor") ? 0 : typedArrayObtainAttributes.getColor(7, 0);
        int color3 = !CamUtils.hasAttribute(xml, "endColor") ? 0 : typedArrayObtainAttributes.getColor(1, 0);
        int i4 = !CamUtils.hasAttribute(xml, "tileMode") ? 0 : typedArrayObtainAttributes.getInt(6, 0);
        float f10 = !CamUtils.hasAttribute(xml, "gradientRadius") ? 0.0f : typedArrayObtainAttributes.getFloat(5, 0.0f);
        typedArrayObtainAttributes.recycle();
        int depth = xml.getDepth() + 1;
        float f11 = f10;
        ArrayList arrayList = new ArrayList(20);
        float f12 = f7;
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next2 = xml.next();
            f = f6;
            if (next2 == 1) {
                f2 = f5;
                break;
            }
            int depth2 = xml.getDepth();
            f2 = f5;
            if (depth2 < depth && next2 == 3) {
                break;
            }
            if (next2 == 2 && depth2 <= depth && xml.getName().equals("item")) {
                TypedArray typedArrayObtainAttributes2 = CamUtils.obtainAttributes(resources, theme, attributeSetAsAttributeSet, androidx.core.R$styleable.GradientColorItem);
                boolean zHasValue = typedArrayObtainAttributes2.hasValue(0);
                boolean zHasValue2 = typedArrayObtainAttributes2.hasValue(1);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color4 = typedArrayObtainAttributes2.getColor(0, 0);
                float f13 = typedArrayObtainAttributes2.getFloat(1, 0.0f);
                typedArrayObtainAttributes2.recycle();
                arrayList2.add(Integer.valueOf(color4));
                arrayList.add(Float.valueOf(f13));
            }
            f6 = f;
            f5 = f2;
        }
        RoomOpenHelper roomOpenHelper = arrayList2.size() > 0 ? new RoomOpenHelper(arrayList2, arrayList) : null;
        if (roomOpenHelper == null) {
            roomOpenHelper = zHasAttribute ? new RoomOpenHelper(color, color2, color3) : new RoomOpenHelper(color, color3);
        }
        if (i3 == 1) {
            float f14 = f8;
            i2 = 0;
            if (f11 <= 0.0f) {
                f3 = f9;
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
            if (i4 == 1) {
                f3 = f9;
                tileMode = Shader.TileMode.REPEAT;
            } else if (i4 != 2) {
                f3 = f9;
                tileMode = Shader.TileMode.CLAMP;
            } else {
                f3 = f9;
                tileMode = Shader.TileMode.MIRROR;
            }
            radialGradient = new RadialGradient(f14, f3, f11, (int[]) roomOpenHelper.mConfiguration, (float[]) roomOpenHelper.mDelegate, tileMode);
        } else if (i3 != 2) {
            if (i4 != 1) {
                tileMode2 = i4 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
            } else {
                tileMode2 = Shader.TileMode.REPEAT;
            }
            Shader.TileMode tileMode3 = tileMode2;
            i2 = 0;
            radialGradient = new LinearGradient(f4, f2, f, f12, (int[]) roomOpenHelper.mConfiguration, (float[]) roomOpenHelper.mDelegate, tileMode3);
        } else {
            i2 = 0;
            radialGradient = new SweepGradient(f8, f9, (int[]) roomOpenHelper.mConfiguration, (float[]) roomOpenHelper.mDelegate);
        }
        return new Splitter(radialGradient, (ColorStateList) null, i2);
    }

    public Splitter(Protocol protocol, int i, String str) {
        this.$r8$classId = 4;
        this.trimmer = protocol;
        this.limit = i;
        this.strategy = str;
    }

    public Splitter(ImageView imageView) {
        this.$r8$classId = 1;
        this.limit = 0;
        this.trimmer = imageView;
    }

    public Splitter(Shader shader, ColorStateList colorStateList, int i) {
        this.$r8$classId = 2;
        this.trimmer = shader;
        this.strategy = colorStateList;
        this.limit = i;
    }

    public Splitter(Strategy strategy) {
        this.$r8$classId = 0;
        CharMatcher.None none = CharMatcher.None.INSTANCE;
        this.strategy = strategy;
        this.trimmer = none;
        this.limit = Integer.MAX_VALUE;
    }
}
