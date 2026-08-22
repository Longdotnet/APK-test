package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.daerisoft.thespikerm.R;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdwh {
    public static final void zzb(Context context, ViewGroup viewGroup, NativeAd nativeAd) {
        NativeAdView nativeAdView = new NativeAdView(context);
        nativeAdView.setTag("ad_view_tag");
        zzf(nativeAdView, -1, -1);
        viewGroup.addView(nativeAdView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setTag("layout_tag");
        linearLayout.setOrientation(1);
        zzf(linearLayout, -1, -1);
        linearLayout.setBackgroundColor(-1);
        nativeAdView.addView(linearLayout);
        Resources resourcesZze = com.google.android.gms.ads.internal.zzv.zza.zzi.zze();
        linearLayout.addView(zzc(context, resourcesZze == null ? "Headline" : resourcesZze.getString(R.string.native_headline), "headline_header_tag"));
        View viewZzd = zzd(context, zzfwg.zzc(nativeAd.getHeadline()), "headline_tag");
        nativeAdView.setHeadlineView(viewZzd);
        linearLayout.addView(viewZzd);
        linearLayout.addView(zzc(context, resourcesZze == null ? "Body" : resourcesZze.getString(R.string.native_body), "body_header_tag"));
        View viewZzd2 = zzd(context, zzfwg.zzc(nativeAd.getBody()), "body_tag");
        nativeAdView.setBodyView(viewZzd2);
        linearLayout.addView(viewZzd2);
        linearLayout.addView(zzc(context, resourcesZze == null ? "Media View" : resourcesZze.getString(R.string.native_media_view), "media_view_header_tag"));
        MediaView mediaView = new MediaView(context);
        mediaView.setTag("media_view_tag");
        nativeAdView.setMediaView(mediaView);
        linearLayout.addView(mediaView);
        nativeAdView.setNativeAd(nativeAd);
    }

    private static TextView zzc(Context context, String str, String str2) {
        return zze(context, str, android.R.style.TextAppearance.Small, -9210245, 0.0f, str2);
    }

    private static TextView zzd(Context context, String str, String str2) {
        return zze(context, str, android.R.style.TextAppearance.Medium, -16777216, 12.0f, str2);
    }

    private static TextView zze(Context context, String str, int i, int i2, float f, String str2) {
        TextView textView = new TextView(context);
        textView.setTag(str2);
        zzf(textView, -2, -2);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new TableRow.LayoutParams();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        marginLayoutParams.bottomMargin = (int) TypedValue.applyDimension(1, f, textView.getResources().getDisplayMetrics());
        textView.setLayoutParams(marginLayoutParams);
        textView.setTextAppearance(context, i);
        textView.setTextColor(i2);
        textView.setText(str);
        return textView;
    }

    private static void zzf(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new TableRow.LayoutParams();
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(layoutParams);
        layoutParams2.height = i;
        layoutParams2.width = i2;
        view.setLayoutParams(layoutParams2);
    }

    public static final void zza(Context context, ViewGroup viewGroup, AdView adView) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setTag("layout");
        zzf(linearLayout, -1, -1);
        linearLayout.setGravity(17);
        linearLayout.addView(adView);
        adView.setTag(RDFWIi.XRijWDlfbHQeVR);
        viewGroup.addView(linearLayout);
    }
}
