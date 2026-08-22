package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.collection.ContainerHelpers;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.daerisoft.thespikerm.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import okhttp3.Request;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ResourceManagerInternal {
    public static ResourceManagerInternal INSTANCE;
    public SimpleArrayMap mDelegates;
    public final WeakHashMap mDrawableCaches = new WeakHashMap(0);
    public boolean mHasCheckedVectorDrawableSetup;
    public Request mHooks;
    public SparseArrayCompat mKnownDrawableIdTags;
    public WeakHashMap mTintLists;
    public TypedValue mTypedValue;
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);

    public final class ColorFilterLruCache extends LruCache {
    }

    public final class DrawableDelegate {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ DrawableDelegate(int i) {
            this.$r8$classId = i;
        }

        public final Drawable createFromXmlInner(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
            switch (this.$r8$classId) {
                case 0:
                    String classAttribute = attributeSet.getClassAttribute();
                    if (classAttribute == null) {
                        return null;
                    }
                    try {
                        Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                        Compatibility$Api21Impl.inflate(drawable, context.getResources(), xmlResourceParser, attributeSet, theme);
                        return drawable;
                    } catch (Exception e) {
                        Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                        return null;
                    }
                case 1:
                    try {
                        return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlResourceParser, attributeSet, theme);
                    } catch (Exception e2) {
                        Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                        return null;
                    }
                case 2:
                    try {
                        Resources resources = context.getResources();
                        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
                        animatedVectorDrawableCompat.inflate(resources, xmlResourceParser, attributeSet, theme);
                        return animatedVectorDrawableCompat;
                    } catch (Exception e3) {
                        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e3);
                        return null;
                    }
                default:
                    try {
                        Resources resources2 = context.getResources();
                        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
                        vectorDrawableCompat.inflate(resources2, xmlResourceParser, attributeSet, theme);
                        return vectorDrawableCompat;
                    } catch (Exception e4) {
                        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e4);
                        return null;
                    }
            }
        }
    }

    public static synchronized ResourceManagerInternal get() {
        try {
            if (INSTANCE == null) {
                ResourceManagerInternal resourceManagerInternal = new ResourceManagerInternal();
                INSTANCE = resourceManagerInternal;
                installDefaultInflateDelegates(resourceManagerInternal);
            }
        } catch (Throwable th) {
            throw th;
        }
        return INSTANCE;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
        colorFilterLruCache.getClass();
        int i2 = (31 + i) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) colorFilterLruCache.get(Integer.valueOf(mode.hashCode() + i2));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public static void installDefaultInflateDelegates(ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.addDelegate("vector", new DrawableDelegate(3));
            resourceManagerInternal.addDelegate("animated-vector", new DrawableDelegate(2));
            resourceManagerInternal.addDelegate("animated-selector", new DrawableDelegate(1));
            resourceManagerInternal.addDelegate("drawable", new DrawableDelegate(0));
        }
    }

    public final void addDelegate(String str, DrawableDelegate drawableDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new SimpleArrayMap();
        }
        this.mDelegates.put(str, drawableDelegate);
    }

    public final synchronized void addDrawableToCache(Context context, long j, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                LongSparseArray longSparseArray = (LongSparseArray) this.mDrawableCaches.get(context);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                    this.mDrawableCaches.put(context, longSparseArray);
                }
                longSparseArray.put(j, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable createDrawableIfNeeded(Context context, int i) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable cachedDrawable = getCachedDrawable(context, j);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        LayerDrawable ratingBarLayerDrawable = null;
        if (this.mHooks != null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                ratingBarLayerDrawable = new LayerDrawable(new Drawable[]{getDrawable(context, R.drawable.abc_cab_background_internal_bg), getDrawable(context, 2131165201)});
            } else if (i == R.drawable.abc_ratingbar_material) {
                ratingBarLayerDrawable = Request.getRatingBarLayerDrawable(this, context, R.dimen.abc_star_big);
            } else if (i == R.drawable.abc_ratingbar_indicator_material) {
                ratingBarLayerDrawable = Request.getRatingBarLayerDrawable(this, context, R.dimen.abc_star_medium);
            } else if (i == R.drawable.abc_ratingbar_small_material) {
                ratingBarLayerDrawable = Request.getRatingBarLayerDrawable(this, context, R.dimen.abc_star_small);
            }
        }
        if (ratingBarLayerDrawable != null) {
            ratingBarLayerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, j, ratingBarLayerDrawable);
        }
        return ratingBarLayerDrawable;
    }

    public final synchronized Drawable getCachedDrawable(Context context, long j) {
        LongSparseArray longSparseArray = (LongSparseArray) this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) longSparseArray.get(j, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int iBinarySearch = ContainerHelpers.binarySearch(longSparseArray.mKeys, longSparseArray.mSize, j);
            if (iBinarySearch >= 0) {
                Object[] objArr = longSparseArray.mValues;
                Object obj = objArr[iBinarySearch];
                Object obj2 = LongSparseArray.DELETED;
                if (obj != obj2) {
                    objArr[iBinarySearch] = obj2;
                    longSparseArray.mGarbage = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable getDrawable(Context context, int i) {
        return getDrawable(context, i, false);
    }

    public final synchronized ColorStateList getTintList(Context context, int i) {
        ColorStateList colorStateList;
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap weakHashMap = this.mTintLists;
        ColorStateList tintListForDrawableRes = null;
        colorStateList = (weakHashMap == null || (sparseArrayCompat = (SparseArrayCompat) weakHashMap.get(context)) == null) ? null : (ColorStateList) sparseArrayCompat.get(i, null);
        if (colorStateList == null) {
            Request request = this.mHooks;
            if (request != null) {
                tintListForDrawableRes = request.getTintListForDrawableRes(context, i);
            }
            if (tintListForDrawableRes != null) {
                if (this.mTintLists == null) {
                    this.mTintLists = new WeakHashMap();
                }
                SparseArrayCompat sparseArrayCompat2 = (SparseArrayCompat) this.mTintLists.get(context);
                if (sparseArrayCompat2 == null) {
                    sparseArrayCompat2 = new SparseArrayCompat();
                    this.mTintLists.put(context, sparseArrayCompat2);
                }
                sparseArrayCompat2.append(i, tintListForDrawableRes);
            }
            colorStateList = tintListForDrawableRes;
        }
        return colorStateList;
    }

    public final Drawable loadDrawableFromDelegates(Context context, int i) {
        int next;
        SimpleArrayMap simpleArrayMap = this.mDelegates;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat sparseArrayCompat = this.mKnownDrawableIdTags;
        if (sparseArrayCompat != null) {
            String str = (String) sparseArrayCompat.get(i, null);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.mDelegates.getOrDefault(str, null) == null)) {
                return null;
            }
        } else {
            this.mKnownDrawableIdTags = new SparseArrayCompat();
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable cachedDrawable = getCachedDrawable(context, j);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
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
                this.mKnownDrawableIdTags.append(i, name);
                DrawableDelegate drawableDelegate = (DrawableDelegate) this.mDelegates.getOrDefault(name, null);
                if (drawableDelegate != null) {
                    cachedDrawable = drawableDelegate.createFromXmlInner(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (cachedDrawable != null) {
                    cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
                    addDrawableToCache(context, j, cachedDrawable);
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (cachedDrawable == null) {
            this.mKnownDrawableIdTags.append(i, "appcompat_skip_skip");
        }
        return cachedDrawable;
    }

    public final synchronized void onConfigurationChanged(Context context) {
        LongSparseArray longSparseArray = (LongSparseArray) this.mDrawableCaches.get(context);
        if (longSparseArray != null) {
            int i = longSparseArray.mSize;
            Object[] objArr = longSparseArray.mValues;
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = null;
            }
            longSparseArray.mSize = 0;
            longSparseArray.mGarbage = false;
        }
    }

    public final synchronized void setHooks(Request request) {
        this.mHooks = request;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:52:0x0103  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final Drawable tintDrawable(Context context, int i, boolean z, Drawable drawable) {
        int i2;
        boolean z2;
        int iRound;
        Drawable drawableMutate;
        int themeAttrColor;
        ColorStateList tintList = getTintList(context, i);
        PorterDuff.Mode mode = null;
        if (tintList != null) {
            Drawable drawableMutate2 = drawable.mutate();
            DrawableCompat$Api21Impl.setTintList(drawableMutate2, tintList);
            if (this.mHooks != null && i == R.drawable.abc_switch_thumb_material) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (mode == null) {
                return drawableMutate2;
            }
            DrawableCompat$Api21Impl.setTintMode(drawableMutate2, mode);
            return drawableMutate2;
        }
        if (this.mHooks != null) {
            if (i == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = AppCompatDrawableManager.DEFAULT_MODE;
                Request.setPorterDuffColorFilter(drawableFindDrawableByLayerId, themeAttrColor2, mode2);
                Request.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), mode2);
                Request.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), mode2);
                return drawable;
            }
            if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
                int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = AppCompatDrawableManager.DEFAULT_MODE;
                Request.setPorterDuffColorFilter(drawableFindDrawableByLayerId2, disabledThemeAttrColor, mode3);
                Request.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), mode3);
                Request.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), mode3);
                return drawable;
            }
        }
        Request request = this.mHooks;
        boolean z3 = false;
        if (request != null) {
            PorterDuff.Mode mode4 = AppCompatDrawableManager.DEFAULT_MODE;
            if (Request.arrayContains(i, (int[]) request.lazyCacheControl)) {
                i2 = R.attr.colorControlNormal;
            } else if (Request.arrayContains(i, (int[]) request.method)) {
                i2 = R.attr.colorControlActivated;
            } else {
                if (Request.arrayContains(i, (int[]) request.headers)) {
                    mode4 = PorterDuff.Mode.MULTIPLY;
                } else {
                    if (i == 2131165221) {
                        z2 = true;
                        iRound = Math.round(40.8f);
                        i2 = 16842800;
                    } else {
                        if (i != R.drawable.abc_dialog_material_background) {
                            i2 = 0;
                            z2 = false;
                        }
                        iRound = -1;
                    }
                    if (z2) {
                        drawableMutate = drawable.mutate();
                        themeAttrColor = ThemeUtils.getThemeAttrColor(context, i2);
                        synchronized (AppCompatDrawableManager.class) {
                            PorterDuffColorFilter porterDuffColorFilter = getPorterDuffColorFilter(themeAttrColor, mode4);
                        }
                        drawableMutate.setColorFilter(porterDuffColorFilter);
                        if (iRound != -1) {
                            drawableMutate.setAlpha(iRound);
                        }
                        z3 = true;
                    }
                }
                i2 = 16842801;
            }
            z2 = true;
            iRound = -1;
            if (z2) {
                drawableMutate = drawable.mutate();
                themeAttrColor = ThemeUtils.getThemeAttrColor(context, i2);
                synchronized (AppCompatDrawableManager.class) {
                    PorterDuffColorFilter porterDuffColorFilter2 = getPorterDuffColorFilter(themeAttrColor, mode4);
                    drawableMutate.setColorFilter(porterDuffColorFilter2);
                    if (iRound != -1) {
                        drawableMutate.setAlpha(iRound);
                    }
                    z3 = true;
                }
            }
        }
        if (z3 || !z) {
            return drawable;
        }
        return null;
    }

    public final synchronized Drawable getDrawable(Context context, int i, boolean z) {
        Drawable drawableLoadDrawableFromDelegates;
        try {
            if (!this.mHasCheckedVectorDrawableSetup) {
                this.mHasCheckedVectorDrawableSetup = true;
                Drawable drawable = getDrawable(context, R.drawable.abc_vector_test);
                if (drawable == null || (!(drawable instanceof VectorDrawableCompat) && !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName()))) {
                    this.mHasCheckedVectorDrawableSetup = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableLoadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
            if (drawableLoadDrawableFromDelegates == null) {
                drawableLoadDrawableFromDelegates = createDrawableIfNeeded(context, i);
            }
            if (drawableLoadDrawableFromDelegates == null) {
                drawableLoadDrawableFromDelegates = ContextCompat.getDrawable(context, i);
            }
            if (drawableLoadDrawableFromDelegates != null) {
                drawableLoadDrawableFromDelegates = tintDrawable(context, i, z, drawableLoadDrawableFromDelegates);
            }
            if (drawableLoadDrawableFromDelegates != null) {
                DrawableUtils.fixDrawable(drawableLoadDrawableFromDelegates);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableLoadDrawableFromDelegates;
    }
}
