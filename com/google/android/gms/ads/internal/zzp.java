package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.gms.internal.ads.zzavu;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzp implements View.OnTouchListener {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object zza;

    public zzp(zzu zzuVar) {
        Objects.requireNonNull(zzuVar);
        this.zza = zzuVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppCompatPopupWindow appCompatPopupWindow;
        switch (this.$r8$classId) {
            case 0:
                zzavu zzavuVar = ((zzu) this.zza).zzh;
                if (zzavuVar != null) {
                    zzavuVar.zzd(motionEvent);
                }
                break;
            default:
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                ListPopupWindow listPopupWindow = (ListPopupWindow) this.zza;
                if (action == 0 && (appCompatPopupWindow = listPopupWindow.mPopup) != null && appCompatPopupWindow.isShowing() && x >= 0 && x < listPopupWindow.mPopup.getWidth() && y >= 0 && y < listPopupWindow.mPopup.getHeight()) {
                    listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250L);
                } else if (action == 1) {
                    listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
                }
                break;
        }
        return false;
    }

    public zzp(ListPopupWindow listPopupWindow) {
        this.zza = listPopupWindow;
    }
}
