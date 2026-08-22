package com.facebook.appevents.codeless;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener implements View.OnTouchListener {
    public final View.OnTouchListener existingOnTouchListener;
    public final WeakReference hostView;
    public final EventBinding mapping;
    public final WeakReference rootView;
    public final boolean supportCodelessLogging = true;

    public RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener(EventBinding eventBinding, View view, View view2) {
        this.mapping = eventBinding;
        this.hostView = new WeakReference(view2);
        this.rootView = new WeakReference(view);
        this.existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        View view2 = (View) this.rootView.get();
        View view3 = (View) this.hostView.get();
        if (view2 != null && view3 != null && motionEvent.getAction() == 1) {
            CodelessMatcher.Companion.logEvent$facebook_core_release(this.mapping, view2, view3);
        }
        View.OnTouchListener onTouchListener = this.existingOnTouchListener;
        return onTouchListener != null && onTouchListener.onTouch(view, motionEvent);
    }
}
