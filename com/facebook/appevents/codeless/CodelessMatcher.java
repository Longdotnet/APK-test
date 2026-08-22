package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class CodelessMatcher {
    public static final Companion Companion = new Companion();
    public static CodelessMatcher codelessMatcher;
    public final Set activitiesSet;
    public final HashMap activityToListenerMap;
    public HashSet listenerSet;
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    public final LinkedHashSet viewMatchers;

    public final class Companion {
        public static final Companion INSTANCE = new Companion();

        public static Bundle getParameters(EventBinding eventBinding, View view, View view2) {
            Bundle bundle = new Bundle();
            List<ParameterComponent> listUnmodifiableList = Collections.unmodifiableList(eventBinding.parameters);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(parameters)");
            for (ParameterComponent parameterComponent : listUnmodifiableList) {
                String str = parameterComponent.value;
                String str2 = parameterComponent.name;
                if (str == null || str.length() <= 0) {
                    ArrayList arrayList = parameterComponent.path;
                    if (arrayList.size() > 0) {
                        for (MatchedView matchedView : Intrinsics.areEqual(parameterComponent.pathType, "relative") ? RangesKt.findViewByPath(view2, arrayList, 0, -1, view2.getClass().getSimpleName()) : RangesKt.findViewByPath(view, arrayList, 0, -1, view.getClass().getSimpleName())) {
                            if (matchedView.getView() != null) {
                                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                                String textOfView = ViewHierarchy.getTextOfView(matchedView.getView());
                                if (textOfView.length() > 0) {
                                    bundle.putString(str2, textOfView);
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    bundle.putString(str2, parameterComponent.value);
                }
            }
            return bundle;
        }

        public static final void logEvent$facebook_core_release(EventBinding eventBinding, View view, View view2) {
            if (CrashShieldHandler.isObjectCrashing(Companion.class)) {
                return;
            }
            try {
                String str = eventBinding.eventName;
                Bundle parameters = getParameters(eventBinding, view, view2);
                INSTANCE.updateParameters$facebook_core_release(parameters);
                FacebookSdk.getExecutor().execute(new GraphRequest$Companion$$ExternalSyntheticLambda1(str, parameters, 14));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(Companion.class, th);
            }
        }

        public synchronized CodelessMatcher getInstance() {
            CodelessMatcher codelessMatcher;
            CodelessMatcher codelessMatcher2;
            try {
                codelessMatcher = null;
                if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
                    codelessMatcher2 = null;
                } else {
                    try {
                        codelessMatcher2 = CodelessMatcher.codelessMatcher;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(CodelessMatcher.class, th);
                        codelessMatcher2 = null;
                    }
                }
                if (codelessMatcher2 == null) {
                    CodelessMatcher codelessMatcher3 = new CodelessMatcher();
                    if (!CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
                        try {
                            CodelessMatcher.codelessMatcher = codelessMatcher3;
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(CodelessMatcher.class, th2);
                        }
                    }
                }
                if (!CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
                    try {
                        codelessMatcher = CodelessMatcher.codelessMatcher;
                    } catch (Throwable th3) {
                        CrashShieldHandler.handleThrowable(CodelessMatcher.class, th3);
                    }
                }
                if (codelessMatcher == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
                }
            } catch (Throwable th4) {
                throw th4;
            }
            return codelessMatcher;
        }

        public void updateParameters$facebook_core_release(Bundle bundle) {
            Locale locale;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                String string = bundle.getString("_valueToSum");
                if (string != null) {
                    double dDoubleValue = 0.0d;
                    try {
                        Matcher matcher = Pattern.compile("[-+]*\\d+([.,]\\d+)*([.,]\\d+)?", 8).matcher(string);
                        if (matcher.find()) {
                            String strGroup = matcher.group(0);
                            try {
                                locale = FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
                            } catch (Exception unused) {
                                locale = null;
                            }
                            if (locale == null) {
                                locale = Locale.getDefault();
                                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                            }
                            dDoubleValue = NumberFormat.getNumberInstance(locale).parse(strGroup).doubleValue();
                        }
                    } catch (ParseException unused2) {
                    }
                    bundle.putDouble("_valueToSum", dDoubleValue);
                }
                bundle.putString("_is_fb_codeless", "1");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
            }
        }
    }

    public final class MatchedView {
        public final WeakReference view;
        public final String viewMapKey;

        public MatchedView(View view, String viewMapKey) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(viewMapKey, "viewMapKey");
            this.view = new WeakReference(view);
            this.viewMapKey = viewMapKey;
        }

        public final View getView() {
            WeakReference weakReference = this.view;
            if (weakReference == null) {
                return null;
            }
            return (View) weakReference.get();
        }
    }

    public final class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        public final String activityName;
        public ArrayList eventBindings;
        public final HashSet listenerSet;
        public final WeakReference rootView;

        public ViewMatcher(View view, Handler handler, HashSet listenerSet, String str) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(listenerSet, "listenerSet");
            this.rootView = new WeakReference(view);
            this.listenerSet = listenerSet;
            this.activityName = str;
            handler.postDelayed(this, 200L);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0022  */
        public final void attachOnClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            View view2 = matchedView.getView();
            if (view2 == null) {
                return;
            }
            View.OnClickListener existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
            if (!(existingOnClickListener instanceof CodelessLoggingEventListener$AutoLoggingOnClickListener)) {
                z = false;
            } else {
                if (existingOnClickListener == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                }
                if (((CodelessLoggingEventListener$AutoLoggingOnClickListener) existingOnClickListener).supportCodelessLogging) {
                    z = true;
                } else {
                    z = false;
                }
            }
            HashSet hashSet = this.listenerSet;
            String str = matchedView.viewMapKey;
            if (hashSet.contains(str) || z) {
                return;
            }
            CodelessLoggingEventListener$AutoLoggingOnClickListener codelessLoggingEventListener$AutoLoggingOnClickListener = null;
            if (!CrashShieldHandler.isObjectCrashing(Companion.class)) {
                try {
                    CodelessLoggingEventListener$AutoLoggingOnClickListener codelessLoggingEventListener$AutoLoggingOnClickListener2 = new CodelessLoggingEventListener$AutoLoggingOnClickListener();
                    codelessLoggingEventListener$AutoLoggingOnClickListener2.mapping = eventBinding;
                    codelessLoggingEventListener$AutoLoggingOnClickListener2.hostView = new WeakReference(view2);
                    codelessLoggingEventListener$AutoLoggingOnClickListener2.rootView = new WeakReference(view);
                    codelessLoggingEventListener$AutoLoggingOnClickListener2.existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
                    codelessLoggingEventListener$AutoLoggingOnClickListener2.supportCodelessLogging = true;
                    codelessLoggingEventListener$AutoLoggingOnClickListener = codelessLoggingEventListener$AutoLoggingOnClickListener2;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(Companion.class, th);
                }
            }
            view2.setOnClickListener(codelessLoggingEventListener$AutoLoggingOnClickListener);
            hashSet.add(str);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0024  */
        public final void attachOnItemClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            AdapterView adapterView = (AdapterView) matchedView.getView();
            if (adapterView == null) {
                return;
            }
            AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
            if (!(onItemClickListener instanceof CodelessLoggingEventListener$AutoLoggingOnItemClickListener)) {
                z = false;
            } else {
                if (onItemClickListener == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                }
                if (((CodelessLoggingEventListener$AutoLoggingOnItemClickListener) onItemClickListener).supportCodelessLogging) {
                    z = true;
                } else {
                    z = false;
                }
            }
            HashSet hashSet = this.listenerSet;
            String str = matchedView.viewMapKey;
            if (hashSet.contains(str) || z) {
                return;
            }
            CodelessLoggingEventListener$AutoLoggingOnItemClickListener codelessLoggingEventListener$AutoLoggingOnItemClickListener = null;
            if (!CrashShieldHandler.isObjectCrashing(Companion.class)) {
                try {
                    CodelessLoggingEventListener$AutoLoggingOnItemClickListener codelessLoggingEventListener$AutoLoggingOnItemClickListener2 = new CodelessLoggingEventListener$AutoLoggingOnItemClickListener();
                    codelessLoggingEventListener$AutoLoggingOnItemClickListener2.mapping = eventBinding;
                    codelessLoggingEventListener$AutoLoggingOnItemClickListener2.hostView = new WeakReference(adapterView);
                    codelessLoggingEventListener$AutoLoggingOnItemClickListener2.rootView = new WeakReference(view);
                    codelessLoggingEventListener$AutoLoggingOnItemClickListener2.existingOnItemClickListener = adapterView.getOnItemClickListener();
                    codelessLoggingEventListener$AutoLoggingOnItemClickListener2.supportCodelessLogging = true;
                    codelessLoggingEventListener$AutoLoggingOnItemClickListener = codelessLoggingEventListener$AutoLoggingOnItemClickListener2;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(Companion.class, th);
                }
            }
            adapterView.setOnItemClickListener(codelessLoggingEventListener$AutoLoggingOnItemClickListener);
            hashSet.add(str);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0021  */
        public final void attachRCTListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            View view2 = matchedView.getView();
            if (view2 == null) {
                return;
            }
            View.OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
            if (!(existingOnTouchListener instanceof RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener)) {
                z = false;
            } else {
                if (existingOnTouchListener == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                }
                if (((RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener) existingOnTouchListener).supportCodelessLogging) {
                    z = true;
                } else {
                    z = false;
                }
            }
            HashSet hashSet = this.listenerSet;
            String str = matchedView.viewMapKey;
            if (hashSet.contains(str) || z) {
                return;
            }
            RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener rCTCodelessLoggingEventListener$AutoLoggingOnTouchListener = null;
            if (!CrashShieldHandler.isObjectCrashing(GamepadHandler_API19.class)) {
                try {
                    rCTCodelessLoggingEventListener$AutoLoggingOnTouchListener = new RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener(eventBinding, view, view2);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(GamepadHandler_API19.class, th);
                }
            }
            view2.setOnTouchListener(rCTCodelessLoggingEventListener$AutoLoggingOnTouchListener);
            hashSet.add(str);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            startMatch();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            startMatch();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                    if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.codelessEventsEnabled) {
                        JSONArray jSONArray = appSettingsWithoutQuery.eventBindings;
                        ArrayList arrayList = new ArrayList();
                        if (jSONArray != null) {
                            try {
                                int length = jSONArray.length();
                                if (length > 0) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i + 1;
                                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                                        Intrinsics.checkNotNullExpressionValue(jSONObject, "array.getJSONObject(i)");
                                        arrayList.add(ExceptionsKt.getInstanceFromJson(jSONObject));
                                        if (i2 >= length) {
                                            break;
                                        } else {
                                            i = i2;
                                        }
                                    }
                                }
                            } catch (IllegalArgumentException | JSONException unused) {
                            }
                        }
                        this.eventBindings = arrayList;
                        View view = (View) this.rootView.get();
                        if (view == null) {
                            return;
                        }
                        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.addOnGlobalLayoutListener(this);
                            viewTreeObserver.addOnScrollChangedListener(this);
                        }
                        startMatch();
                        return;
                        CrashShieldHandler.handleThrowable(this, th);
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(this, th2);
            }
        }

        public final void startMatch() {
            boolean zEquals;
            View view;
            ArrayList arrayList = this.eventBindings;
            if (arrayList == null) {
                return;
            }
            WeakReference weakReference = this.rootView;
            if (weakReference.get() == null) {
                return;
            }
            int i = -1;
            int size = arrayList.size() - 1;
            if (size < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                EventBinding eventBinding = (EventBinding) arrayList.get(i2);
                View view2 = (View) weakReference.get();
                if (eventBinding != null && view2 != null) {
                    String str = eventBinding.activityName;
                    int length = str.length();
                    String str2 = this.activityName;
                    if (length == 0 || str.equals(str2)) {
                        List listUnmodifiableList = Collections.unmodifiableList(eventBinding.path);
                        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(path)");
                        if (listUnmodifiableList.size() <= 25) {
                            for (MatchedView matchedView : RangesKt.findViewByPath(view2, listUnmodifiableList, 0, i, str2)) {
                                try {
                                    View view3 = matchedView.getView();
                                    if (view3 != null) {
                                        ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                                        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                                            view = null;
                                            break;
                                        }
                                        View view4 = view3;
                                        while (true) {
                                            if (view4 != null) {
                                                try {
                                                    ViewHierarchy viewHierarchy2 = ViewHierarchy.INSTANCE;
                                                    if (CrashShieldHandler.isObjectCrashing(viewHierarchy2)) {
                                                        zEquals = false;
                                                    } else {
                                                        try {
                                                            zEquals = view4.getClass().getName().equals("com.facebook.react.ReactRootView");
                                                        } catch (Throwable th) {
                                                            CrashShieldHandler.handleThrowable(viewHierarchy2, th);
                                                            zEquals = false;
                                                        }
                                                    }
                                                    if (zEquals) {
                                                        view = view4;
                                                        break;
                                                    } else {
                                                        Object parent = view4.getParent();
                                                        if (parent instanceof View) {
                                                            view4 = (View) parent;
                                                        }
                                                    }
                                                } catch (Throwable th2) {
                                                    CrashShieldHandler.handleThrowable(ViewHierarchy.class, th2);
                                                }
                                            }
                                            view = null;
                                            break;
                                        }
                                        if (view != null && ViewHierarchy.INSTANCE.isRCTButton(view3, view)) {
                                            attachRCTListener(matchedView, view2, eventBinding);
                                        } else if (!StringsKt__StringsKt.startsWith(view3.getClass().getName(), "com.facebook.react", false)) {
                                            if (!(view3 instanceof AdapterView)) {
                                                attachOnClickListener(matchedView, view2, eventBinding);
                                            } else if (view3 instanceof ListView) {
                                                attachOnItemClickListener(matchedView, view2, eventBinding);
                                            }
                                        }
                                    }
                                } catch (Exception unused) {
                                    CrashShieldHandler.isObjectCrashing(CodelessMatcher.class);
                                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                                }
                            }
                        }
                    }
                }
                if (i3 > size) {
                    return;
                }
                i2 = i3;
                i = -1;
            }
        }
    }

    public CodelessMatcher() {
        Set setNewSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap, "newSetFromMap(WeakHashMap())");
        this.activitiesSet = setNewSetFromMap;
        this.viewMatchers = new LinkedHashSet();
        this.listenerSet = new HashSet();
        this.activityToListenerMap = new HashMap();
    }

    public final void add(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Intrinsics.areEqual(null, Boolean.TRUE)) {
                return;
            }
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
            }
            this.activitiesSet.add(activity);
            this.listenerSet.clear();
            HashSet hashSet = (HashSet) this.activityToListenerMap.get(Integer.valueOf(activity.hashCode()));
            if (hashSet != null) {
                this.listenerSet = hashSet;
            }
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    matchViews();
                } else {
                    this.uiThreadHandler.post(new AccessTokenManager$$ExternalSyntheticLambda0(this, 9));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }

    public final void matchViews() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            for (Activity activity : this.activitiesSet) {
                if (activity != null) {
                    this.viewMatchers.add(new ViewMatcher(AppEventUtility.getRootView(activity), this.uiThreadHandler, this.listenerSet, activity.getClass().getSimpleName()));
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final void remove(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Intrinsics.areEqual(null, Boolean.TRUE)) {
                return;
            }
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
            }
            this.activitiesSet.remove(activity);
            this.viewMatchers.clear();
            this.activityToListenerMap.put(Integer.valueOf(activity.hashCode()), (HashSet) this.listenerSet.clone());
            this.listenerSet.clear();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
