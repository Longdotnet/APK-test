package com.facebook.appevents.codeless;

import android.view.View;
import android.widget.AdapterView;
import com.facebook.appevents.codeless.internal.EventBinding;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class CodelessLoggingEventListener$AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {
    public AdapterView.OnItemClickListener existingOnItemClickListener;
    public WeakReference hostView;
    public EventBinding mapping;
    public WeakReference rootView;
    public boolean supportCodelessLogging;

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(view, "view");
        AdapterView.OnItemClickListener onItemClickListener = this.existingOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i, j);
        }
        View view2 = (View) this.rootView.get();
        AdapterView adapterView2 = (AdapterView) this.hostView.get();
        if (view2 == null || adapterView2 == null) {
            return;
        }
        CodelessMatcher.Companion.logEvent$facebook_core_release(this.mapping, view2, adapterView2);
    }
}
