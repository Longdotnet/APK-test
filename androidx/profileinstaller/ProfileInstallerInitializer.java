package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import androidx.work.InputMergerFactory$1;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer {

    public abstract class Choreographer16Impl {
        public static void postFrameCallback(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$Choreographer16Impl$$ExternalSyntheticLambda0
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    runnable.run();
                }
            });
        }
    }

    public abstract class Handler28Impl {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new InputMergerFactory$1(17);
        }
        Choreographer16Impl.postFrameCallback(new GraphRequest$Companion$$ExternalSyntheticLambda1(this, context.getApplicationContext(), 4));
        return new InputMergerFactory$1(17);
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.emptyList();
    }
}
