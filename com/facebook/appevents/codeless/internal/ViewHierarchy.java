package com.facebook.appevents.codeless.internal;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.core.view.NestedScrollingChild;
import com.facebook.FacebookSdk;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewHierarchy {
    public static final ViewHierarchy INSTANCE = new ViewHierarchy();
    public static WeakReference RCTRootViewReference = new WeakReference(null);
    public static Method methodFindTouchTargetView;

    public static final ArrayList getChildrenOfView(View view) {
        int childCount;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if ((view instanceof ViewGroup) && (childCount = ((ViewGroup) view).getChildCount()) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(((ViewGroup) view).getChildAt(i));
                    if (i2 >= childCount) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ViewHierarchy.class, th);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0050 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #3 {all -> 0x004e, blocks: (B:16:0x0027, B:19:0x0030, B:28:0x0047, B:33:0x0050, B:41:0x0060, B:39:0x005b, B:26:0x0041, B:23:0x003b), top: B:84:0x0027, outer: #2, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0057  */
    /* JADX WARN: Code duplicated, block: B:41:0x0060 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #3 {all -> 0x004e, blocks: (B:16:0x0027, B:19:0x0030, B:28:0x0047, B:33:0x0050, B:41:0x0060, B:39:0x005b, B:26:0x0041, B:23:0x003b), top: B:84:0x0027, outer: #2, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0088 A[PHI: r3
  0x0088: PHI (r3v15 int) = (r3v14 int), (r3v16 int) binds: [B:48:0x0074, B:53:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static final int getClassTypeBitmask(View view) {
        Class<?> cls;
        Class cls2;
        int i;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            int i2 = view instanceof ImageView ? 2 : 0;
            if (view.isClickable()) {
                i2 |= 32;
            }
            boolean zIsObjectCrashing = CrashShieldHandler.isObjectCrashing(ViewHierarchy.class);
            ViewHierarchy viewHierarchy = INSTANCE;
            if (!zIsObjectCrashing) {
                try {
                    ViewParent parent = view.getParent();
                    if (!(parent instanceof AdapterView)) {
                        if (CrashShieldHandler.isObjectCrashing(viewHierarchy)) {
                            cls = null;
                            if (cls != null || !cls.isInstance(parent)) {
                                cls2 = CrashShieldHandler.isObjectCrashing(viewHierarchy) ? null : NestedScrollingChild.class;
                                if (cls2 != null && cls2.isInstance(parent)) {
                                }
                            }
                        } else {
                            try {
                                cls = Class.forName("android.support.v4.view.NestedScrollingChild");
                            } catch (ClassNotFoundException unused) {
                                cls = null;
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(viewHierarchy, th);
                                cls = null;
                            }
                            if (cls != null) {
                                if (CrashShieldHandler.isObjectCrashing(viewHierarchy)) {
                                }
                                if (cls2 != null) {
                                }
                            } else {
                                if (CrashShieldHandler.isObjectCrashing(viewHierarchy)) {
                                }
                                if (cls2 != null) {
                                }
                            }
                        }
                    }
                    i2 |= 512;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(ViewHierarchy.class, th2);
                }
            }
            if (!(view instanceof TextView)) {
                if (!(view instanceof Spinner) && !(view instanceof DatePicker)) {
                    if (view instanceof RatingBar) {
                        return i2 | 65536;
                    }
                    if (view instanceof RadioGroup) {
                        return i2 | 16384;
                    }
                    return ((view instanceof ViewGroup) && viewHierarchy.isRCTButton(view, (View) RCTRootViewReference.get())) ? i2 | 64 : i2;
                }
                return i2 | 4096;
            }
            int i3 = i2 | 1025;
            if (view instanceof Button) {
                i3 = i2 | 1029;
                if (view instanceof Switch) {
                    i = i2 | 9221;
                } else if (view instanceof CheckBox) {
                    i = i2 | 33797;
                } else {
                    i = i3;
                }
            } else {
                i = i3;
            }
            return view instanceof EditText ? i | 2048 : i;
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(ViewHierarchy.class, th3);
            return 0;
        }
    }

    public static final JSONObject getDictionaryOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view.getClass().getName().equals("com.facebook.react.ReactRootView")) {
                RCTRootViewReference = new WeakReference(view);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                updateBasicInfoOfView(view, jSONObject);
                JSONArray jSONArray = new JSONArray();
                ArrayList childrenOfView = getChildrenOfView(view);
                int size = childrenOfView.size() - 1;
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        jSONArray.put(getDictionaryOfView((View) childrenOfView.get(i)));
                        if (i2 > size) {
                            break;
                        }
                        i = i2;
                    }
                }
                jSONObject.put("childviews", jSONArray);
            } catch (JSONException e) {
                Log.e("com.facebook.appevents.codeless.internal.ViewHierarchy", "Failed to create JSONObject for view.", e);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ViewHierarchy.class, th);
            return null;
        }
    }

    public static final View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnClickListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ViewHierarchy.class, th);
            return null;
        }
    }

    public static final View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        try {
            if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                return null;
            }
            try {
                try {
                    Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                    if (declaredField2 != null) {
                        declaredField2.setAccessible(true);
                    }
                    Object obj = declaredField2.get(view);
                    if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                        return null;
                    }
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 != null) {
                        return (View.OnTouchListener) obj2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
                } catch (IllegalAccessException unused) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    return null;
                } catch (NoSuchFieldException unused2) {
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    return null;
                }
            } catch (ClassNotFoundException unused3) {
                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ViewHierarchy.class, th);
            return null;
        }
    }

    public static final String getHintOfView(View view) {
        CharSequence hint;
        String string;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (view instanceof EditText) {
                hint = ((EditText) view).getHint();
            } else {
                hint = view instanceof TextView ? ((TextView) view).getHint() : null;
            }
            return (hint == null || (string = hint.toString()) == null) ? "" : string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ViewHierarchy.class, th);
            return null;
        }
    }

    public static final ViewGroup getParentOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ViewHierarchy.class, th);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0101 A[EDGE_INSN: B:45:0x0101->B:46:0x0102 BREAK  A[LOOP:0: B:33:0x00d3->B:40:0x00f0]] */
    public static final String getTextOfView(View view) {
        CharSequence charSequenceValueOf;
        Object selectedItem;
        String string;
        int i = 0;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (!(view instanceof TextView)) {
                if (!(view instanceof Spinner)) {
                    if (!(view instanceof DatePicker)) {
                        if (!(view instanceof TimePicker)) {
                            if (!(view instanceof RadioGroup)) {
                                if (!(view instanceof RatingBar)) {
                                    charSequenceValueOf = null;
                                    break;
                                }
                                charSequenceValueOf = String.valueOf(((RatingBar) view).getRating());
                            } else {
                                int checkedRadioButtonId = ((RadioGroup) view).getCheckedRadioButtonId();
                                int childCount = ((RadioGroup) view).getChildCount();
                                if (childCount <= 0) {
                                    charSequenceValueOf = null;
                                    break;
                                }
                                while (true) {
                                    int i2 = i + 1;
                                    View childAt = ((RadioGroup) view).getChildAt(i);
                                    if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                                        charSequenceValueOf = ((RadioButton) childAt).getText();
                                        break;
                                    }
                                    if (i2 >= childCount) {
                                        charSequenceValueOf = null;
                                        break;
                                    }
                                    i = i2;
                                }
                            }
                        } else {
                            Integer currentHour = ((TimePicker) view).getCurrentHour();
                            Intrinsics.checkNotNullExpressionValue(currentHour, "view.currentHour");
                            int iIntValue = currentHour.intValue();
                            Integer currentMinute = ((TimePicker) view).getCurrentMinute();
                            Intrinsics.checkNotNullExpressionValue(currentMinute, "view.currentMinute");
                            charSequenceValueOf = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue), Integer.valueOf(currentMinute.intValue())}, 2));
                        }
                    } else {
                        charSequenceValueOf = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(((DatePicker) view).getYear()), Integer.valueOf(((DatePicker) view).getMonth()), Integer.valueOf(((DatePicker) view).getDayOfMonth())}, 3));
                    }
                } else {
                    if (((Spinner) view).getCount() <= 0 || (selectedItem = ((Spinner) view).getSelectedItem()) == null) {
                        charSequenceValueOf = null;
                        break;
                    }
                    charSequenceValueOf = selectedItem.toString();
                }
            } else {
                charSequenceValueOf = ((TextView) view).getText();
                if (view instanceof Switch) {
                    charSequenceValueOf = ((Switch) view).isChecked() ? "1" : "0";
                }
            }
            return (charSequenceValueOf == null || (string = charSequenceValueOf.toString()) == null) ? "" : string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ViewHierarchy.class, th);
            return null;
        }
    }

    public final JSONObject getDimensionOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("top", view.getTop());
                jSONObject.put("left", view.getLeft());
                jSONObject.put("width", view.getWidth());
                jSONObject.put("height", view.getHeight());
                jSONObject.put("scrollx", view.getScrollX());
                jSONObject.put("scrolly", view.getScrollY());
                jSONObject.put("visibility", view.getVisibility());
            } catch (JSONException e) {
                Log.e("com.facebook.appevents.codeless.internal.ViewHierarchy", "Failed to create JSONObject for dimension.", e);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final View getTouchReactView(float[] fArr, View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            Method method = methodFindTouchTargetView;
            if (method != null && view != null) {
                try {
                    Object objInvoke = method.invoke(null, fArr, view);
                    if (objInvoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                    View view2 = (View) objInvoke;
                    if (view2.getId() > 0) {
                        Object parent = view2.getParent();
                        if (parent != null) {
                            return (View) parent;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                } catch (IllegalAccessException unused) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                } catch (InvocationTargetException unused2) {
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final void initTouchTargetHelperMethods() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (methodFindTouchTargetView != null) {
                return;
            }
            try {
                Method declaredMethod = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", float[].class, ViewGroup.class);
                methodFindTouchTargetView = declaredMethod;
                if (declaredMethod == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                declaredMethod.setAccessible(true);
            } catch (ClassNotFoundException unused) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            } catch (NoSuchMethodException unused2) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final boolean isRCTButton(View view, View view2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup")) {
                return false;
            }
            float[] fArr = null;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    fArr = new float[]{iArr[0], iArr[1]};
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                }
            }
            View touchReactView = getTouchReactView(fArr, view2);
            return touchReactView != null && touchReactView.getId() == view.getId();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return false;
        }
    }

    public static final void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                jSONObject.put("classname", view.getClass().getCanonicalName());
                jSONObject.put(DaWYVMJ.daNyCxbBraq, getClassTypeBitmask(view));
                jSONObject.put("id", view.getId());
                if (SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    jSONObject.put("text", "");
                    jSONObject.put("is_user_input", true);
                } else {
                    jSONObject.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView)));
                }
                jSONObject.put("hint", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView)));
                if (tag != null) {
                    jSONObject.put("tag", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString())));
                }
                if (contentDescription != null) {
                    jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString())));
                }
                jSONObject.put(DaWYVMJ.yHgBzXxYkr, INSTANCE.getDimensionOfView(view));
            } catch (JSONException unused) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ViewHierarchy.class, th);
        }
    }
}
