package com.facebook.appevents.codeless;

import android.view.View;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class CodelessLoggingEventListener$AutoLoggingOnClickListener implements View.OnClickListener {
    public View.OnClickListener existingOnClickListener;
    public WeakReference hostView;
    public EventBinding mapping;
    public WeakReference rootView;
    public boolean supportCodelessLogging;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(view, "view");
                View.OnClickListener onClickListener = this.existingOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                View view2 = (View) this.rootView.get();
                View view3 = (View) this.hostView.get();
                if (view2 == null || view3 == null) {
                    return;
                }
                CodelessMatcher.Companion.logEvent$facebook_core_release(this.mapping, view2, view3);
                return;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
                return;
            }
            CrashShieldHandler.handleThrowable(this, th);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
        }
    }
}
