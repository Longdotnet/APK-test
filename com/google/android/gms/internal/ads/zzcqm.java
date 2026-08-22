package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcqm extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcqm(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcqm zza(Context context, View view, zzfca zzfcaVar) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcqm zzcqmVar = new zzcqm(context);
        List list = zzfcaVar.zzu;
        if (!list.isEmpty() && (resources = zzcqmVar.zza.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            zzfcb zzfcbVar = (zzfcb) list.get(0);
            float f = zzfcbVar.zza;
            float f2 = displayMetrics.density;
            zzcqmVar.setLayoutParams(new FrameLayout.LayoutParams((int) (f * f2), (int) (zzfcbVar.zzb * f2)));
        }
        zzcqmVar.zzb = view;
        zzcqmVar.addView(view);
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzcas zzcasVar = zzvVar.zzE;
        zzcas.zzb(zzcqmVar, zzcqmVar);
        zzcas zzcasVar2 = zzvVar.zzE;
        zzcas.zza(zzcqmVar, zzcqmVar);
        JSONObject jSONObject = zzfcaVar.zzah;
        RelativeLayout relativeLayout = new RelativeLayout(zzcqmVar.zza);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
        if (jSONObjectOptJSONObject != null) {
            zzcqmVar.zzc(jSONObjectOptJSONObject, relativeLayout, 10);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("footer");
        if (jSONObjectOptJSONObject2 != null) {
            zzcqmVar.zzc(jSONObjectOptJSONObject2, relativeLayout, 12);
        }
        zzcqmVar.addView(relativeLayout);
        return zzcqmVar;
    }

    private final int zzb(double d) {
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        return com.google.android.gms.ads.internal.util.client.zzf.zzC(this.zza, (int) d);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int iZzb = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, iZzb, 0, iZzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY(-iArr[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY(-iArr[1]);
    }
}
