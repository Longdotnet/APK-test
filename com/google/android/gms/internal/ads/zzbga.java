package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbga extends RelativeLayout {
    private static final float[] zza = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzb;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzb;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }

    public zzbga(Context context, zzbfz zzbfzVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzbfzVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zza, null, null));
        shapeDrawable.getPaint().setColor(zzbfzVar.zzd());
        setLayoutParams(layoutParams);
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzbfzVar.zzg())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzbfzVar.zzg());
            textView.setTextColor(zzbfzVar.zze());
            textView.setTextSize(zzbfzVar.zzf());
            com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
            textView.setPadding(com.google.android.gms.ads.internal.util.client.zzf.zzC(context, 4), 0, com.google.android.gms.ads.internal.util.client.zzf.zzu(context.getResources().getDisplayMetrics(), 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List listZzi = zzbfzVar.zzi();
        String str = sgtsHsWT.Qwq;
        if (listZzi != null && listZzi.size() > 1) {
            this.zzb = new AnimationDrawable();
            Iterator it = listZzi.iterator();
            while (it.hasNext()) {
                try {
                    this.zzb.addFrame((Drawable) ObjectWrapper.unwrap(((zzbgc) it.next()).zzf()), zzbfzVar.zzb());
                } catch (Exception e) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh(str, e);
                }
            }
            imageView.setBackground(this.zzb);
        } else if (listZzi.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(((zzbgc) listZzi.get(0)).zzf()));
            } catch (Exception e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh(str, e2);
            }
        }
        addView(imageView);
    }
}
