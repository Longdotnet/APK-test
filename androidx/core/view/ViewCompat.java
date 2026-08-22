package androidx.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.contentcapture.ContentCaptureSession;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.Insets;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.emoji2.text.flatbuffer.Table;
import androidx.fragment.app.Fragment;
import com.daerisoft.thespikerm.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewCompat {
    public static boolean sAccessibilityDelegateCheckFailed = false;
    public static Field sAccessibilityDelegateField;
    public static WeakHashMap sViewPropertyAnimatorMap;
    public static final ViewCompat$$ExternalSyntheticLambda0 NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new ViewCompat$$ExternalSyntheticLambda0();
    public static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();

    /* JADX INFO: renamed from: androidx.core.view.ViewCompat$1 */
    public final class AnonymousClass1 extends Table {
        public final /* synthetic */ int $r8$classId;

        public AnonymousClass1(int i, Class cls, int i2, int i3, int i4) {
            this.$r8$classId = i4;
            this.bb_pos = i;
            this.bb = cls;
            this.vtable_size = i2;
            this.vtable_start = i3;
        }

        @Override // androidx.emoji2.text.flatbuffer.Table
        public final Object frameworkGet(View view) {
            switch (this.$r8$classId) {
                case 0:
                    return Boolean.valueOf(Api28Impl.isScreenReaderFocusable(view));
                case 1:
                    return Api28Impl.getAccessibilityPaneTitle(view);
                default:
                    return Boolean.valueOf(Api28Impl.isAccessibilityHeading(view));
            }
        }

        @Override // androidx.emoji2.text.flatbuffer.Table
        public final void frameworkSet(View view, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    Api28Impl.setScreenReaderFocusable(view, ((Boolean) obj).booleanValue());
                    break;
                case 1:
                    Api28Impl.setAccessibilityPaneTitle(view, (CharSequence) obj);
                    break;
                default:
                    Api28Impl.setAccessibilityHeading(view, ((Boolean) obj).booleanValue());
                    break;
            }
        }

        @Override // androidx.emoji2.text.flatbuffer.Table
        public final boolean shouldUpdate(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    Boolean bool = (Boolean) obj;
                    Boolean bool2 = (Boolean) obj2;
                    return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
                case 1:
                    return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                default:
                    Boolean bool3 = (Boolean) obj;
                    Boolean bool4 = (Boolean) obj2;
                    return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
            }
        }
    }

    public final class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public final WeakHashMap mPanesToVisible = new WeakHashMap();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry entry : this.mPanesToVisible.entrySet()) {
                    View view = (View) entry.getKey();
                    boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
                    boolean z = view.isShown() && view.getWindowVisibility() == 0;
                    if (zBooleanValue != z) {
                        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, z ? 16 : 32);
                        entry.setValue(Boolean.valueOf(z));
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    public abstract class Api20Impl {
        public static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void requestApplyInsets(View view) {
            view.requestApplyInsets();
        }
    }

    public abstract class Api21Impl {

        /* JADX INFO: renamed from: androidx.core.view.ViewCompat$Api21Impl$1 */
        public final class AnonymousClass1 implements View.OnApplyWindowInsetsListener {
            public WindowInsetsCompat mLastInsets = null;
            public final /* synthetic */ OnApplyWindowInsetsListener val$listener;
            public final /* synthetic */ View val$v;

            public AnonymousClass1() {
                view = view;
                onApplyWindowInsetsListener = onApplyWindowInsetsListener;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                OnApplyWindowInsetsListener onApplyWindowInsetsListener = onApplyWindowInsetsListener;
                if (i < 30) {
                    Api21Impl.callCompatInsetAnimationCallback(windowInsets, view);
                    if (windowInsetsCompat.equals(this.mLastInsets)) {
                        return onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
                    }
                }
                this.mLastInsets = windowInsetsCompat;
                WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat);
                if (i >= 30) {
                    return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                }
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                Api20Impl.requestApplyInsets(view);
                return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
            }
        }

        public static void callCompatInsetAnimationCallback(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        public static boolean dispatchNestedPreFling(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        public static ColorStateList getBackgroundTintList(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode getBackgroundTintMode(View view) {
            return view.getBackgroundTintMode();
        }

        public static float getElevation(View view) {
            return view.getElevation();
        }

        public static WindowInsetsCompat getRootWindowInsets(View view) {
            WindowInsetsCompat.BuilderImpl builderImpl29;
            if (!WindowInsetsCompat.Api21ReflectionHolder.sReflectionSucceeded || !view.isAttachedToWindow()) {
                return null;
            }
            try {
                Object obj = WindowInsetsCompat.Api21ReflectionHolder.sViewAttachInfoField.get(view.getRootView());
                if (obj == null) {
                    return null;
                }
                Rect rect = (Rect) WindowInsetsCompat.Api21ReflectionHolder.sStableInsets.get(obj);
                Rect rect2 = (Rect) WindowInsetsCompat.Api21ReflectionHolder.sContentInsets.get(obj);
                if (rect == null || rect2 == null) {
                    return null;
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 30) {
                    builderImpl29 = new WindowInsetsCompat.BuilderImpl30();
                } else {
                    builderImpl29 = i >= 29 ? new WindowInsetsCompat.BuilderImpl29() : new WindowInsetsCompat.BuilderImpl20();
                }
                builderImpl29.setStableInsets(Insets.of(rect.left, rect.top, rect.right, rect.bottom));
                builderImpl29.setSystemWindowInsets(Insets.of(rect2.left, rect2.top, rect2.right, rect2.bottom));
                WindowInsetsCompat windowInsetsCompatBuild = builderImpl29.build();
                windowInsetsCompatBuild.mImpl.setRootWindowInsets(windowInsetsCompatBuild);
                windowInsetsCompatBuild.mImpl.copyRootViewBounds(view.getRootView());
                return windowInsetsCompatBuild;
            } catch (IllegalAccessException e) {
                Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                return null;
            }
        }

        public static String getTransitionName(View view) {
            return view.getTransitionName();
        }

        public static float getTranslationZ(View view) {
            return view.getTranslationZ();
        }

        public static float getZ(View view) {
            return view.getZ();
        }

        public static boolean hasNestedScrollingParent(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean isImportantForAccessibility(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean isNestedScrollingEnabled(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void setElevation(View view, float f) {
            view.setElevation(f);
        }

        public static void setNestedScrollingEnabled(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1
                    public WindowInsetsCompat mLastInsets = null;
                    public final /* synthetic */ OnApplyWindowInsetsListener val$listener;
                    public final /* synthetic */ View val$v;

                    public AnonymousClass1() {
                        view = view;
                        onApplyWindowInsetsListener = onApplyWindowInsetsListener;
                    }

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view2);
                        int i = Build.VERSION.SDK_INT;
                        OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener;
                        if (i < 30) {
                            Api21Impl.callCompatInsetAnimationCallback(windowInsets, view);
                            if (windowInsetsCompat.equals(this.mLastInsets)) {
                                return onApplyWindowInsetsListener2.onApplyWindowInsets(view2, windowInsetsCompat).toWindowInsets();
                            }
                        }
                        this.mLastInsets = windowInsetsCompat;
                        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = onApplyWindowInsetsListener2.onApplyWindowInsets(view2, windowInsetsCompat);
                        if (i >= 30) {
                            return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                        }
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        Api20Impl.requestApplyInsets(view2);
                        return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                    }
                });
            }
        }

        public static void setTransitionName(View view, String str) {
            view.setTransitionName(str);
        }

        public static void setTranslationZ(View view, float f) {
            view.setTranslationZ(f);
        }

        public static void setZ(View view, float f) {
            view.setZ(f);
        }

        public static boolean startNestedScroll(View view, int i) {
            return view.startNestedScroll(i);
        }

        public static void stopNestedScroll(View view) {
            view.stopNestedScroll();
        }
    }

    public abstract class Api23Impl {
        public static WindowInsetsCompat getRootWindowInsets(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets, null);
            WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
            impl.setRootWindowInsets(windowInsetsCompat);
            impl.copyRootViewBounds(view.getRootView());
            return windowInsetsCompat;
        }

        public static int getScrollIndicators(View view) {
            return view.getScrollIndicators();
        }

        public static void setScrollIndicators(View view, int i) {
            view.setScrollIndicators(i);
        }

        public static void setScrollIndicators(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    public abstract class Api28Impl {
        public static void addOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(R.id.tag_unhandled_key_listeners, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            View.OnUnhandledKeyEventListener viewCompat$Api28Impl$$ExternalSyntheticLambda0 = new ViewCompat$Api28Impl$$ExternalSyntheticLambda0();
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, viewCompat$Api28Impl$$ExternalSyntheticLambda0);
            view.addOnUnhandledKeyEventListener(viewCompat$Api28Impl$$ExternalSyntheticLambda0);
        }

        public static CharSequence getAccessibilityPaneTitle(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean isAccessibilityHeading(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean isScreenReaderFocusable(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void removeOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.getOrDefault(onUnhandledKeyEventListenerCompat, null)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static <T> T requireViewById(View view, int i) {
            return (T) view.requireViewById(i);
        }

        public static void setAccessibilityHeading(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void setAutofillId(View view, AutofillIdCompat autofillIdCompat) {
            view.setAutofillId(null);
        }

        public static void setScreenReaderFocusable(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    public abstract class Api29Impl {
        public static View.AccessibilityDelegate getAccessibilityDelegate(View view) {
            return view.getAccessibilityDelegate();
        }

        public static ContentCaptureSession getContentCaptureSession(View view) {
            return view.getContentCaptureSession();
        }

        public static List<Rect> getSystemGestureExclusionRects(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void saveAttributeDataForStyleable(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        public static void setContentCaptureSession(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
            view.setContentCaptureSession(null);
        }

        public static void setSystemGestureExclusionRects(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public abstract class Api30Impl {
        public static int getImportantForContentCapture(View view) {
            return view.getImportantForContentCapture();
        }

        public static CharSequence getStateDescription(View view) {
            return view.getStateDescription();
        }

        public static boolean isImportantForContentCapture(View view) {
            return view.isImportantForContentCapture();
        }

        public static void setImportantForContentCapture(View view, int i) {
            view.setImportantForContentCapture(i);
        }

        public static void setStateDescription(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public abstract class Api31Impl {
        public static String[] getReceiveContentMimeTypes(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat performReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo wrapped = contentInfoCompat.mCompat.getWrapped();
            Objects.requireNonNull(wrapped);
            ContentInfo contentInfoM15m = ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m15m((Object) wrapped);
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoM15m);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoM15m ? contentInfoCompat : new ContentInfoCompat(new Fragment.AnonymousClass7(contentInfoPerformReceiveContent));
        }

        public static void setOnReceiveContentListener(View view, String[] strArr, OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerAdapter(onReceiveContentListener));
            }
        }
    }

    public final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        public final OnReceiveContentListener mJetpackListener;

        public OnReceiveContentListenerAdapter(OnReceiveContentListener onReceiveContentListener) {
            this.mJetpackListener = onReceiveContentListener;
        }

        public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            ContentInfoCompat contentInfoCompat = new ContentInfoCompat(new Fragment.AnonymousClass7(contentInfo));
            ContentInfoCompat contentInfoCompatOnReceiveContent = ((TextViewOnReceiveContentListener) this.mJetpackListener).onReceiveContent(view, contentInfoCompat);
            if (contentInfoCompatOnReceiveContent == null) {
                return null;
            }
            if (contentInfoCompatOnReceiveContent == contentInfoCompat) {
                return contentInfo;
            }
            ContentInfo wrapped = contentInfoCompatOnReceiveContent.mCompat.getWrapped();
            Objects.requireNonNull(wrapped);
            return ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m15m((Object) wrapped);
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
    }

    public final class UnhandledKeyEventManager {
        public static final ArrayList sViewsWithListeners = new ArrayList();
        public SparseArray mCapturedKeys;
        public WeakReference mLastDispatchedPreViewKeyEvent;
        public WeakHashMap mViewsContainingListeners;

        public final View dispatchInOrder(View view) {
            int size;
            WeakHashMap weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewDispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount));
                        if (viewDispatchInOrder != null) {
                            return viewDispatchInOrder;
                        }
                    }
                }
                ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
                if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
                    arrayList.get(size).getClass();
                    throw new ClassCastException();
                }
            }
            return null;
        }
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = UnhandledKeyEventManager.sViewsWithListeners;
        UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (unhandledKeyEventManager == null) {
            unhandledKeyEventManager = new UnhandledKeyEventManager();
            unhandledKeyEventManager.mViewsContainingListeners = null;
            unhandledKeyEventManager.mCapturedKeys = null;
            unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = unhandledKeyEventManager.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = UnhandledKeyEventManager.sViewsWithListeners;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (unhandledKeyEventManager.mViewsContainingListeners == null) {
                            unhandledKeyEventManager.mViewsContainingListeners = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = UnhandledKeyEventManager.sViewsWithListeners;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                unhandledKeyEventManager.mViewsContainingListeners.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    unhandledKeyEventManager.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        View viewDispatchInOrder = unhandledKeyEventManager.dispatchInOrder(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewDispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                if (unhandledKeyEventManager.mCapturedKeys == null) {
                    unhandledKeyEventManager.mCapturedKeys = new SparseArray();
                }
                unhandledKeyEventManager.mCapturedKeys.put(keyCode, new WeakReference(viewDispatchInOrder));
            }
        }
        return viewDispatchInOrder != null;
    }

    public static View.AccessibilityDelegate getAccessibilityDelegateInternal(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getAccessibilityDelegate(view);
        }
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            Object obj = sAccessibilityDelegateField.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    public static String[] getOnReceiveContentMimeTypes(AppCompatEditText appCompatEditText) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.getReceiveContentMimeTypes(appCompatEditText) : (String[]) appCompatEditText.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void notifyViewAccessibilityStateChangedIfNeeded(View view, int i) {
        Object tag;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i2 = Build.VERSION.SDK_INT;
            Object accessibilityPaneTitle = null;
            if (i2 >= 28) {
                tag = Api28Impl.getAccessibilityPaneTitle(view);
            } else {
                tag = view.getTag(R.id.tag_accessibility_pane_title);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            boolean z = ((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    List<CharSequence> text = accessibilityEventObtain.getText();
                    if (i2 >= 28) {
                        accessibilityPaneTitle = Api28Impl.getAccessibilityPaneTitle(view);
                    } else {
                        Object tag2 = view.getTag(R.id.tag_accessibility_pane_title);
                        if (CharSequence.class.isInstance(tag2)) {
                            accessibilityPaneTitle = tag2;
                        }
                    }
                    text.add((CharSequence) accessibilityPaneTitle);
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            List<CharSequence> text2 = accessibilityEventObtain2.getText();
            if (i2 >= 28) {
                accessibilityPaneTitle = Api28Impl.getAccessibilityPaneTitle(view);
            } else {
                Object tag3 = view.getTag(R.id.tag_accessibility_pane_title);
                if (CharSequence.class.isInstance(tag3)) {
                    accessibilityPaneTitle = tag3;
                }
            }
            text2.add((CharSequence) accessibilityPaneTitle);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = Api20Impl.onApplyWindowInsets(view, windowInsets);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(windowInsetsOnApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ContentInfoCompat performReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.performReceiveContent(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.tag_on_receive_content_listener);
        OnReceiveContentViewBehavior onReceiveContentViewBehavior = NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
        if (onReceiveContentListener == null) {
            if (view instanceof OnReceiveContentViewBehavior) {
                onReceiveContentViewBehavior = (OnReceiveContentViewBehavior) view;
            }
            return onReceiveContentViewBehavior.onReceiveContent(contentInfoCompat);
        }
        ContentInfoCompat contentInfoCompatOnReceiveContent = ((TextViewOnReceiveContentListener) onReceiveContentListener).onReceiveContent(view, contentInfoCompat);
        if (contentInfoCompatOnReceiveContent == null) {
            return null;
        }
        if (view instanceof OnReceiveContentViewBehavior) {
            onReceiveContentViewBehavior = (OnReceiveContentViewBehavior) view;
        }
        return onReceiveContentViewBehavior.onReceiveContent(contentInfoCompatOnReceiveContent);
    }

    public static void saveAttributeDataForStyleable(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.mBridge);
    }

    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        new AnonymousClass1(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).set(view, charSequence);
        AccessibilityPaneVisibilityManager accessibilityPaneVisibilityManager = sAccessibilityPaneVisibilityManager;
        if (charSequence == null) {
            accessibilityPaneVisibilityManager.mPanesToVisible.remove(view);
            view.removeOnAttachStateChangeListener(accessibilityPaneVisibilityManager);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(accessibilityPaneVisibilityManager);
        } else {
            accessibilityPaneVisibilityManager.mPanesToVisible.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(accessibilityPaneVisibilityManager);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(accessibilityPaneVisibilityManager);
            }
        }
    }
}
