package androidx.vectordrawable.graphics.drawable;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import androidx.core.content.res.CamUtils;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.WorkContinuation;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AndroidResources {
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_GROUP = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_PATH = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH = {R.attr.name, R.attr.pathData, R.attr.fillType};
    public static final int[] STYLEABLE_ANIMATED_VECTOR_DRAWABLE = {R.attr.drawable};
    public static final int[] STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET = {R.attr.name, R.attr.animation};
    public static final int[] STYLEABLE_ANIMATOR = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};
    public static final int[] STYLEABLE_ANIMATOR_SET = {R.attr.ordering};
    public static final int[] STYLEABLE_PROPERTY_VALUES_HOLDER = {R.attr.valueFrom, R.attr.valueTo, R.attr.valueType, R.attr.propertyName};
    public static final int[] STYLEABLE_KEYFRAME = {R.attr.value, R.attr.interpolator, R.attr.valueType, R.attr.fraction};
    public static final int[] STYLEABLE_PROPERTY_ANIMATOR = {R.attr.propertyName, R.attr.pathData, R.attr.propertyXName, R.attr.propertyYName};

    public static PropertyValuesHolder getPVH(TypedArray typedArray, int i, int i2, int i3, String str) {
        int color;
        int color2;
        int color3;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            i = ((z && isColorType(i4)) || (z2 && isColorType(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser$PathDataNode[] pathParser$PathDataNodeArrCreateNodesFromPathData = WorkContinuation.createNodesFromPathData(string);
            PathParser$PathDataNode[] pathParser$PathDataNodeArrCreateNodesFromPathData2 = WorkContinuation.createNodesFromPathData(string2);
            if (pathParser$PathDataNodeArrCreateNodesFromPathData == null && pathParser$PathDataNodeArrCreateNodesFromPathData2 == null) {
                return null;
            }
            if (pathParser$PathDataNodeArrCreateNodesFromPathData == null) {
                if (pathParser$PathDataNodeArrCreateNodesFromPathData2 != null) {
                    return PropertyValuesHolder.ofObject(str, new AnimatorInflaterCompat$PathDataEvaluator(), pathParser$PathDataNodeArrCreateNodesFromPathData2);
                }
                return null;
            }
            AnimatorInflaterCompat$PathDataEvaluator animatorInflaterCompat$PathDataEvaluator = new AnimatorInflaterCompat$PathDataEvaluator();
            if (pathParser$PathDataNodeArrCreateNodesFromPathData2 == null) {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, animatorInflaterCompat$PathDataEvaluator, pathParser$PathDataNodeArrCreateNodesFromPathData);
            } else {
                if (!WorkContinuation.canMorph(pathParser$PathDataNodeArrCreateNodesFromPathData, pathParser$PathDataNodeArrCreateNodesFromPathData2)) {
                    throw new InflateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(" Can't morph from ", string, " to ", string2));
                }
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, animatorInflaterCompat$PathDataEvaluator, pathParser$PathDataNodeArrCreateNodesFromPathData, pathParser$PathDataNodeArrCreateNodesFromPathData2);
            }
            return propertyValuesHolderOfObject;
        }
        ArgbEvaluator argbEvaluator = i == 3 ? ArgbEvaluator.sInstance : null;
        if (z3) {
            if (z) {
                float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (z2) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, 0.0f);
            } else {
                color2 = isColorType(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, 0.0f);
                } else {
                    color3 = isColorType(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, 0.0f);
            } else {
                color = isColorType(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || argbEvaluator == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(argbEvaluator);
        return propertyValuesHolderOfInt;
    }

    public static boolean isColorType(int i) {
        return i >= 28 && i <= 31;
    }

    public static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlResourceParser xmlResourceParser) {
        ValueAnimator valueAnimator;
        int i;
        TypedArray typedArray;
        int resourceId;
        ValueAnimator valueAnimator2;
        TypedArray typedArrayObtainAttributes = CamUtils.obtainAttributes(resources, theme, attributeSet, STYLEABLE_ANIMATOR);
        TypedArray typedArrayObtainAttributes2 = CamUtils.obtainAttributes(resources, theme, attributeSet, STYLEABLE_PROPERTY_ANIMATOR);
        ValueAnimator valueAnimator3 = objectAnimator == null ? new ValueAnimator() : objectAnimator;
        long j = CamUtils.hasAttribute(xmlResourceParser, "duration") ? typedArrayObtainAttributes.getInt(1, 300) : 300;
        long j2 = !CamUtils.hasAttribute(xmlResourceParser, "startOffset") ? 0 : typedArrayObtainAttributes.getInt(2, 0);
        int i2 = !CamUtils.hasAttribute(xmlResourceParser, "valueType") ? 4 : typedArrayObtainAttributes.getInt(7, 4);
        if (CamUtils.hasAttribute(xmlResourceParser, "valueFrom") && CamUtils.hasAttribute(xmlResourceParser, "valueTo")) {
            if (i2 == 4) {
                TypedValue typedValuePeekValue = typedArrayObtainAttributes.peekValue(5);
                boolean z = typedValuePeekValue != null;
                int i3 = z ? typedValuePeekValue.type : 0;
                TypedValue typedValuePeekValue2 = typedArrayObtainAttributes.peekValue(6);
                boolean z2 = typedValuePeekValue2 != null;
                i2 = ((z && isColorType(i3)) || (z2 && isColorType(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder pvh = getPVH(typedArrayObtainAttributes, i2, 5, 6, "");
            if (pvh != null) {
                valueAnimator3.setValues(pvh);
            }
        }
        valueAnimator3.setDuration(j);
        valueAnimator3.setStartDelay(j2);
        valueAnimator3.setRepeatCount(!CamUtils.hasAttribute(xmlResourceParser, "repeatCount") ? 0 : typedArrayObtainAttributes.getInt(3, 0));
        valueAnimator3.setRepeatMode(!CamUtils.hasAttribute(xmlResourceParser, "repeatMode") ? 1 : typedArrayObtainAttributes.getInt(4, 1));
        if (typedArrayObtainAttributes2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator3;
            String namedString = CamUtils.getNamedString(typedArrayObtainAttributes2, xmlResourceParser, "pathData", 1);
            if (namedString != null) {
                String namedString2 = CamUtils.getNamedString(typedArrayObtainAttributes2, xmlResourceParser, "propertyXName", 2);
                String namedString3 = CamUtils.getNamedString(typedArrayObtainAttributes2, xmlResourceParser, "propertyYName", 3);
                if (namedString2 == null && namedString3 == null) {
                    throw new InflateException(typedArrayObtainAttributes2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path path = new Path();
                try {
                    PathParser$PathDataNode.nodesToPath(WorkContinuation.createNodesFromPathData(namedString), path);
                    PathMeasure pathMeasure = new PathMeasure(path, false);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Float.valueOf(0.0f));
                    float length = 0.0f;
                    while (true) {
                        length += pathMeasure.getLength();
                        arrayList.add(Float.valueOf(length));
                        if (!pathMeasure.nextContour()) {
                            break;
                        }
                        valueAnimator3 = valueAnimator3;
                    }
                    PathMeasure pathMeasure2 = new PathMeasure(path, false);
                    int iMin = Math.min(100, ((int) (length / 0.5f)) + 1);
                    float[] fArr = new float[iMin];
                    float[] fArr2 = new float[iMin];
                    float[] fArr3 = new float[2];
                    float f = length / (iMin - 1);
                    valueAnimator = valueAnimator3;
                    int i4 = 0;
                    int i5 = 0;
                    float f2 = 0.0f;
                    while (true) {
                        if (i5 >= iMin) {
                            break;
                        }
                        int i6 = iMin;
                        pathMeasure2.getPosTan(f2 - ((Float) arrayList.get(i4)).floatValue(), fArr3, null);
                        fArr[i5] = fArr3[0];
                        fArr2[i5] = fArr3[1];
                        f2 += f;
                        int i7 = i4 + 1;
                        if (i7 < arrayList.size() && f2 > ((Float) arrayList.get(i7)).floatValue()) {
                            pathMeasure2.nextContour();
                            i4 = i7;
                        }
                        i5++;
                        iMin = i6;
                    }
                    PropertyValuesHolder propertyValuesHolderOfFloat = namedString2 != null ? PropertyValuesHolder.ofFloat(namedString2, fArr) : null;
                    PropertyValuesHolder propertyValuesHolderOfFloat2 = namedString3 != null ? PropertyValuesHolder.ofFloat(namedString3, fArr2) : null;
                    if (propertyValuesHolderOfFloat == null) {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat2);
                    } else if (propertyValuesHolderOfFloat2 == null) {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat);
                    } else {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                    }
                    i = 0;
                } catch (RuntimeException e) {
                    throw new RuntimeException("Error in parsing ".concat(namedString), e);
                }
            } else {
                valueAnimator = valueAnimator3;
                i = 0;
                objectAnimator2.setPropertyName(CamUtils.getNamedString(typedArrayObtainAttributes2, xmlResourceParser, "propertyName", 0));
            }
        } else {
            valueAnimator = valueAnimator3;
            i = 0;
        }
        if (CamUtils.hasAttribute(xmlResourceParser, "interpolator")) {
            typedArray = typedArrayObtainAttributes;
            resourceId = typedArray.getResourceId(i, i);
        } else {
            resourceId = i;
            typedArray = typedArrayObtainAttributes;
        }
        if (resourceId > 0) {
            valueAnimator2 = valueAnimator;
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        } else {
            valueAnimator2 = valueAnimator;
        }
        typedArray.recycle();
        if (typedArrayObtainAttributes2 != null) {
            typedArrayObtainAttributes2.recycle();
        }
        return valueAnimator2;
    }

    public static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i) throws XmlPullParserException, IOException {
        PropertyValuesHolder[] propertyValuesHolderArr;
        AttributeSet attributeSet2;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        PropertyValuesHolder pvh;
        int size;
        int i6;
        int i7;
        Keyframe keyframeOfFloat;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlResourceParser xmlResourceParser2 = xmlResourceParser;
        int depth = xmlResourceParser.getDepth();
        Animator animatorLoadAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlResourceParser.next();
            int i8 = 0;
            int i9 = 3;
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                break;
            }
            int i10 = 1;
            if (next == 1) {
                break;
            }
            int i11 = 2;
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("objectAnimator")) {
                    ObjectAnimator objectAnimator = new ObjectAnimator();
                    loadAnimator(context, resources, theme, attributeSet, objectAnimator, xmlResourceParser);
                    animatorLoadAnimator = objectAnimator;
                } else if (name.equals("animator")) {
                    animatorLoadAnimator = loadAnimator(context, resources, theme, attributeSet, null, xmlResourceParser);
                } else if (name.equals(yzwzcWHcnH.fCeIZJonIhuFis)) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    TypedArray typedArrayObtainAttributes = CamUtils.obtainAttributes(resources2, theme2, attributeSet, STYLEABLE_ANIMATOR_SET);
                    createAnimatorFromXml(context, resources, theme, xmlResourceParser, attributeSet, animatorSet2, !CamUtils.hasAttribute(xmlResourceParser2, "ordering") ? 0 : typedArrayObtainAttributes.getInt(0, 0));
                    typedArrayObtainAttributes.recycle();
                    animatorLoadAnimator = animatorSet2;
                } else {
                    String str2 = "propertyValuesHolder";
                    if (!name.equals("propertyValuesHolder")) {
                        throw new RuntimeException("Unknown animator name: " + xmlResourceParser.getName());
                    }
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                    ArrayList arrayList2 = null;
                    while (true) {
                        int eventType = xmlResourceParser.getEventType();
                        if (eventType == i9 || eventType == i10) {
                            break;
                        }
                        if (eventType != i11) {
                            xmlResourceParser.next();
                        } else {
                            if (xmlResourceParser.getName().equals(str2)) {
                                TypedArray typedArrayObtainAttributes2 = CamUtils.obtainAttributes(resources2, theme2, attributeSetAsAttributeSet, STYLEABLE_PROPERTY_VALUES_HOLDER);
                                String namedString = CamUtils.getNamedString(typedArrayObtainAttributes2, xmlResourceParser2, "propertyName", i9);
                                int i12 = !CamUtils.hasAttribute(xmlResourceParser2, "valueType") ? 4 : typedArrayObtainAttributes2.getInt(i11, 4);
                                int i13 = i12;
                                ArrayList arrayList3 = null;
                                while (true) {
                                    int next2 = xmlResourceParser.next();
                                    attributeSet2 = attributeSetAsAttributeSet;
                                    if (next2 == i9 || next2 == 1) {
                                        break;
                                    }
                                    if (xmlResourceParser.getName().equals("keyframe")) {
                                        int[] iArr = STYLEABLE_KEYFRAME;
                                        i7 = i13;
                                        if (i7 == 4) {
                                            TypedArray typedArrayObtainAttributes3 = CamUtils.obtainAttributes(resources2, theme2, Xml.asAttributeSet(xmlResourceParser), iArr);
                                            TypedValue typedValuePeekValue = !CamUtils.hasAttribute(xmlResourceParser2, FirebaseAnalytics.Param.VALUE) ? null : typedArrayObtainAttributes3.peekValue(0);
                                            int i14 = (typedValuePeekValue == null || !isColorType(typedValuePeekValue.type)) ? 0 : 3;
                                            typedArrayObtainAttributes3.recycle();
                                            i7 = i14;
                                        }
                                        TypedArray typedArrayObtainAttributes4 = CamUtils.obtainAttributes(resources2, theme2, Xml.asAttributeSet(xmlResourceParser), iArr);
                                        float f = CamUtils.hasAttribute(xmlResourceParser2, "fraction") ? typedArrayObtainAttributes4.getFloat(3, -1.0f) : -1.0f;
                                        TypedValue typedValuePeekValue2 = !CamUtils.hasAttribute(xmlResourceParser2, FirebaseAnalytics.Param.VALUE) ? null : typedArrayObtainAttributes4.peekValue(0);
                                        boolean z = typedValuePeekValue2 != null;
                                        int i15 = i7 == 4 ? (z && isColorType(typedValuePeekValue2.type)) ? 3 : 0 : i7;
                                        if (!z) {
                                            keyframeOfFloat = i15 == 0 ? Keyframe.ofFloat(f) : Keyframe.ofInt(f);
                                        } else if (i15 == 0) {
                                            keyframeOfFloat = Keyframe.ofFloat(f, !CamUtils.hasAttribute(xmlResourceParser2, FirebaseAnalytics.Param.VALUE) ? 0.0f : typedArrayObtainAttributes4.getFloat(0, 0.0f));
                                        } else if (i15 == 1 || i15 == 3) {
                                            keyframeOfFloat = Keyframe.ofInt(f, !CamUtils.hasAttribute(xmlResourceParser2, FirebaseAnalytics.Param.VALUE) ? 0 : typedArrayObtainAttributes4.getInt(0, 0));
                                        } else {
                                            keyframeOfFloat = null;
                                        }
                                        int resourceId = !CamUtils.hasAttribute(xmlResourceParser2, "interpolator") ? 0 : typedArrayObtainAttributes4.getResourceId(1, 0);
                                        if (resourceId > 0) {
                                            keyframeOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                        }
                                        typedArrayObtainAttributes4.recycle();
                                        if (keyframeOfFloat != null) {
                                            if (arrayList3 == null) {
                                                arrayList3 = new ArrayList();
                                            }
                                            arrayList3.add(keyframeOfFloat);
                                        }
                                        xmlResourceParser.next();
                                    } else {
                                        i7 = i13;
                                    }
                                    resources2 = resources;
                                    theme2 = theme;
                                    str2 = str2;
                                    attributeSetAsAttributeSet = attributeSet2;
                                    i13 = i7;
                                    i9 = 3;
                                }
                                int i16 = i13;
                                str = str2;
                                if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                                    i4 = 3;
                                    i2 = 2;
                                    pvh = null;
                                } else {
                                    Keyframe keyframe = (Keyframe) arrayList3.get(0);
                                    Keyframe keyframe2 = (Keyframe) arrayList3.get(size - 1);
                                    float fraction = keyframe2.getFraction();
                                    if (fraction < 1.0f) {
                                        if (fraction < 0.0f) {
                                            keyframe2.setFraction(1.0f);
                                        } else {
                                            arrayList3.add(arrayList3.size(), keyframe2.getType() == Float.TYPE ? Keyframe.ofFloat(1.0f) : keyframe2.getType() == Integer.TYPE ? Keyframe.ofInt(1.0f) : Keyframe.ofObject(1.0f));
                                            size++;
                                        }
                                    }
                                    float fraction2 = keyframe.getFraction();
                                    if (fraction2 != 0.0f) {
                                        if (fraction2 < 0.0f) {
                                            keyframe.setFraction(0.0f);
                                        } else {
                                            arrayList3.add(0, keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(0.0f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(0.0f) : Keyframe.ofObject(0.0f));
                                            size++;
                                        }
                                    }
                                    Keyframe[] keyframeArr = new Keyframe[size];
                                    arrayList3.toArray(keyframeArr);
                                    int i17 = 0;
                                    while (i17 < size) {
                                        Keyframe keyframe3 = keyframeArr[i17];
                                        if (keyframe3.getFraction() >= 0.0f) {
                                            i6 = size;
                                        } else if (i17 == 0) {
                                            keyframe3.setFraction(0.0f);
                                            i6 = size;
                                        } else {
                                            int i18 = size - 1;
                                            if (i17 == i18) {
                                                keyframe3.setFraction(1.0f);
                                                i6 = size;
                                            } else {
                                                int i19 = i17;
                                                for (int i20 = i17 + 1; i20 < i18 && keyframeArr[i20].getFraction() < 0.0f; i20++) {
                                                    i19 = i20;
                                                }
                                                float fraction3 = (keyframeArr[i19 + 1].getFraction() - keyframeArr[i17 - 1].getFraction()) / ((i19 - i17) + 2);
                                                int i21 = i17;
                                                while (i21 <= i19) {
                                                    keyframeArr[i21].setFraction(keyframeArr[i21 - 1].getFraction() + fraction3);
                                                    i21++;
                                                    size = size;
                                                }
                                                i6 = size;
                                            }
                                        }
                                        i17++;
                                        size = i6;
                                    }
                                    i2 = 2;
                                    pvh = PropertyValuesHolder.ofKeyframe(namedString, keyframeArr);
                                    i4 = 3;
                                    if (i16 == 3) {
                                        pvh.setEvaluator(ArgbEvaluator.sInstance);
                                    }
                                }
                                i5 = 0;
                                i3 = 1;
                                if (pvh == null) {
                                    pvh = getPVH(typedArrayObtainAttributes2, i12, 0, 1, namedString);
                                }
                                if (pvh != null) {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    }
                                    arrayList2.add(pvh);
                                }
                                typedArrayObtainAttributes2.recycle();
                            } else {
                                attributeSet2 = attributeSetAsAttributeSet;
                                i2 = i11;
                                str = str2;
                                i3 = i10;
                                i4 = i9;
                                i5 = i8;
                            }
                            xmlResourceParser.next();
                            resources2 = resources;
                            theme2 = theme;
                            xmlResourceParser2 = xmlResourceParser;
                            i8 = i5;
                            i9 = i4;
                            i10 = i3;
                            i11 = i2;
                            str2 = str;
                            attributeSetAsAttributeSet = attributeSet2;
                        }
                    }
                    int i22 = i10;
                    int i23 = i8;
                    if (arrayList2 != null) {
                        int size2 = arrayList2.size();
                        propertyValuesHolderArr = new PropertyValuesHolder[size2];
                        for (int i24 = i23; i24 < size2; i24++) {
                            propertyValuesHolderArr[i24] = (PropertyValuesHolder) arrayList2.get(i24);
                        }
                    } else {
                        propertyValuesHolderArr = null;
                    }
                    if (propertyValuesHolderArr != null && (animatorLoadAnimator instanceof ValueAnimator)) {
                        ((ValueAnimator) animatorLoadAnimator).setValues(propertyValuesHolderArr);
                    }
                    i8 = i22;
                }
                if (animatorSet != null && i8 == 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(animatorLoadAnimator);
                }
                resources2 = resources;
                theme2 = theme;
                xmlResourceParser2 = xmlResourceParser;
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i25 = 0;
            while (it.hasNext()) {
                animatorArr[i25] = (Animator) it.next();
                i25++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animatorLoadAnimator;
    }
}
