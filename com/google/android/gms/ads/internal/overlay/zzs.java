package com.google.android.gms.ads.internal.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AnimatorListenerAdapter {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ ViewGroup zza;

    public zzs(zzu zzuVar) {
        Objects.requireNonNull(zzuVar);
        this.zza = zzuVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.$r8$classId) {
            case 0:
                zzu zzuVar = (zzu) this.zza;
                zzuVar.setEnabled(true);
                zzuVar.zza.setEnabled(true);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.zza;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                actionBarOverlayLayout.mAnimatingForFling = false;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.$r8$classId) {
            case 0:
                zzu zzuVar = (zzu) this.zza;
                zzuVar.setEnabled(true);
                zzuVar.zza.setEnabled(true);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.zza;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                actionBarOverlayLayout.mAnimatingForFling = false;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.$r8$classId) {
            case 0:
                zzu zzuVar = (zzu) this.zza;
                zzuVar.setEnabled(false);
                zzuVar.zza.setEnabled(false);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public zzs(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.zza = actionBarOverlayLayout;
    }
}
