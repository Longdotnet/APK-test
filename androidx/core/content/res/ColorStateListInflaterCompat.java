package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.loader.app.gv.DYYbQc;
import com.daerisoft.thespikerm.R;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ColorStateListInflaterCompat {
    public static final ThreadLocal sTempTypedValue = new ThreadLocal();

    public static ColorStateList createFromXml(Resources resources, XmlResourceParser xmlResourceParser, Resources.Theme theme) {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlResourceParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0093  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r33v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.content.res.TypedArray] */
    public static ColorStateList createFromXmlInner(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int color;
        int i;
        int[] iArr;
        boolean z;
        int iIntFromLStar;
        float f;
        float f2;
        TypedValue typedValue;
        resources = resources;
        attributeSet = attributeSet;
        theme = theme;
        String name = xmlResourceParser.getName();
        if (!name.equals(DYYbQc.uxPvfUg)) {
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        ?? r4 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        Object[] objArr = new int[20][];
        int[] iArr2 = new int[20];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == r4 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlResourceParser.getName().equals("item")) {
                int[] iArr3 = R$styleable.ColorStateListItem;
                ?? ObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr3) : theme.obtainStyledAttributes(attributeSet, iArr3, i2, i2);
                int resourceId = ObtainAttributes.getResourceId(i2, -1);
                if (resourceId != -1) {
                    ThreadLocal threadLocal = sTempTypedValue;
                    TypedValue typedValue2 = (TypedValue) threadLocal.get();
                    if (typedValue2 == null) {
                        typedValue = new TypedValue();
                        threadLocal.set(typedValue);
                    } else {
                        typedValue = typedValue2;
                    }
                    resources.getValue(resourceId, typedValue, r4);
                    int i4 = typedValue.type;
                    if (i4 < 28 || i4 > 31) {
                        try {
                            color = createFromXml(resources, resources.getXml(resourceId), theme).getDefaultColor();
                        } catch (Exception unused) {
                            color = ObtainAttributes.getColor(i2, -65281);
                        }
                    } else {
                        color = ObtainAttributes.getColor(i2, -65281);
                    }
                } else {
                    color = ObtainAttributes.getColor(i2, -65281);
                }
                float f3 = ObtainAttributes.hasValue(r4) ? ObtainAttributes.getFloat(r4, 1.0f) : ObtainAttributes.hasValue(3) ? ObtainAttributes.getFloat(3, 1.0f) : 1.0f;
                float f4 = (Build.VERSION.SDK_INT < 31 || !ObtainAttributes.hasValue(2)) ? ObtainAttributes.getFloat(4, -1.0f) : ObtainAttributes.getFloat(2, -1.0f);
                ObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr4 = new int[attributeCount];
                int i5 = i2;
                for (int i6 = i5; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
                        int i7 = i5 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr4[i5] = attributeNameResource;
                        i5 = i7;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr4, i5);
                float f5 = 0.0f;
                float f6 = 100.0f;
                boolean z2 = f4 >= 0.0f && f4 <= 100.0f;
                if (f3 != 1.0f || z2) {
                    int iAlpha = (int) ((Color.alpha(color) * f3) + 0.5f);
                    if (iAlpha < 0) {
                        i = 0;
                    } else {
                        i = 255;
                        if (iAlpha <= 255) {
                            i = iAlpha;
                        }
                    }
                    if (z2) {
                        CamColor camColorFromColor = CamColor.fromColor(color);
                        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
                        float f7 = camColorFromColor.mChroma;
                        if (f7 >= 1.0d && Math.round(f4) > 0.0d && Math.round(f4) < 100.0d) {
                            float f8 = camColorFromColor.mHue;
                            float fMin = f8 < 0.0f ? 0.0f : Math.min(360.0f, f8);
                            float f9 = 0.0f;
                            float f10 = f7;
                            CamColor camColor = null;
                            boolean z3 = true;
                            while (true) {
                                if (Math.abs(f9 - f7) < 0.4f) {
                                    iArr = iArrTrimStateSet;
                                    depth2 = depth2;
                                    z = true;
                                    if (camColor != null) {
                                        iIntFromLStar = camColor.viewed(viewingConditions);
                                        break;
                                    }
                                    iIntFromLStar = CamUtils.intFromLStar(f4);
                                    break;
                                }
                                float f11 = 1000.0f;
                                float f12 = f5;
                                float f13 = f6;
                                float f14 = 1000.0f;
                                CamColor camColor2 = null;
                                while (true) {
                                    if (Math.abs(f12 - f13) <= 0.01f) {
                                        depth2 = depth2;
                                        fMin = fMin;
                                        f6 = f6;
                                        z = true;
                                        float f15 = f5;
                                        iArr = iArrTrimStateSet;
                                        f = f15;
                                        break;
                                    }
                                    float f16 = ((f13 - f12) / 2.0f) + f12;
                                    int iViewed = CamColor.fromJch(f16, f10, fMin).viewed(ViewingConditions.DEFAULT);
                                    float fLinearized = CamUtils.linearized(Color.red(iViewed));
                                    float fLinearized2 = CamUtils.linearized(Color.green(iViewed));
                                    float fLinearized3 = CamUtils.linearized(Color.blue(iViewed));
                                    z = true;
                                    float[] fArr = CamUtils.SRGB_TO_XYZ[1];
                                    f6 = 100.0f;
                                    float f17 = ((fLinearized3 * fArr[2]) + ((fLinearized2 * fArr[1]) + (fLinearized * fArr[0]))) / 100.0f;
                                    float fCbrt = f17 <= 0.008856452f ? f17 * 903.2963f : (((float) Math.cbrt(f17)) * 116.0f) - 16.0f;
                                    float fAbs = Math.abs(f4 - fCbrt);
                                    if (fAbs < 0.2f) {
                                        CamColor camColorFromColor2 = CamColor.fromColor(iViewed);
                                        CamColor camColorFromJch = CamColor.fromJch(camColorFromColor2.mJ, camColorFromColor2.mChroma, fMin);
                                        f2 = f16;
                                        float f18 = camColorFromColor2.mJstar - camColorFromJch.mJstar;
                                        fMin = fMin;
                                        float f19 = camColorFromColor2.mAstar - camColorFromJch.mAstar;
                                        float f20 = camColorFromColor2.mBstar - camColorFromJch.mBstar;
                                        double dSqrt = Math.sqrt((f20 * f20) + (f19 * f19) + (f18 * f18));
                                        iArr = iArrTrimStateSet;
                                        float fPow = (float) (Math.pow(dSqrt, 0.63d) * 1.41d);
                                        if (fPow <= 1.0f) {
                                            f14 = fPow;
                                            camColor2 = camColorFromColor2;
                                            f11 = fAbs;
                                        }
                                    } else {
                                        f2 = f16;
                                        fMin = fMin;
                                        iArr = iArrTrimStateSet;
                                    }
                                    f = 0.0f;
                                    if (f11 == 0.0f && f14 == 0.0f) {
                                        break;
                                    }
                                    if (fCbrt < f4) {
                                        f12 = f2;
                                    } else {
                                        f13 = f2;
                                    }
                                    f6 = 100.0f;
                                    depth2 = depth2;
                                    fMin = fMin;
                                    int[] iArr5 = iArr;
                                    f5 = 0.0f;
                                    iArrTrimStateSet = iArr5;
                                }
                                CamColor camColor3 = camColor2;
                                if (!z3) {
                                    if (camColor3 == null) {
                                        f7 = f10;
                                    } else {
                                        camColor = camColor3;
                                        f9 = f10;
                                    }
                                    f10 = ((f7 - f9) / 2.0f) + f9;
                                } else {
                                    if (camColor3 != null) {
                                        iIntFromLStar = camColor3.viewed(viewingConditions);
                                        break;
                                    }
                                    f10 = ((f7 - f9) / 2.0f) + f9;
                                    z3 = false;
                                }
                                int[] iArr6 = iArr;
                                f5 = f;
                                iArrTrimStateSet = iArr6;
                            }
                        } else {
                            iArr = iArrTrimStateSet;
                            depth2 = depth2;
                            z = true;
                            iIntFromLStar = CamUtils.intFromLStar(f4);
                        }
                        color = iIntFromLStar;
                    } else {
                        iArr = iArrTrimStateSet;
                        depth2 = depth2;
                        z = true;
                    }
                    color = (16777215 & color) | (i << 24);
                } else {
                    iArr = iArrTrimStateSet;
                    depth2 = depth2;
                    z = true;
                }
                int i8 = i3 + 1;
                if (i8 > iArr2.length) {
                    int[] iArr7 = new int[i3 <= 4 ? 8 : i3 * 2];
                    System.arraycopy(iArr2, 0, iArr7, 0, i3);
                    iArr2 = iArr7;
                }
                iArr2[i3] = color;
                if (i8 > objArr.length) {
                    Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i3 > 4 ? i3 * 2 : 8);
                    System.arraycopy(objArr, 0, objArr2, 0, i3);
                    objArr = objArr2;
                }
                objArr[i3] = iArr;
                objArr = (int[][]) objArr;
                i3 = i8;
                r4 = z;
                depth2 = depth2;
                i2 = 0;
            } else {
                int i9 = depth2;
                r4 = r4 == true ? 1 : 0;
                depth2 = i9;
                i2 = 0;
            }
        }
        int[] iArr8 = new int[i3];
        int[][] iArr9 = new int[i3][];
        System.arraycopy(iArr2, 0, iArr8, 0, i3);
        System.arraycopy(objArr, 0, iArr9, 0, i3);
        return new ColorStateList(iArr9, iArr8);
    }
}
