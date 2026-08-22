package androidx.activity;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.lifecycle.SavedStateViewModelFactory;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class ComponentActivity$fullyDrawnReporter$2 extends Lambda implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ComponentActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComponentActivity$fullyDrawnReporter$2(ComponentActivity componentActivity, int i) {
        super(0);
        this.$r8$classId = i;
        this.this$0 = componentActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                ComponentActivity componentActivity = this.this$0;
                return new FullyDrawnReporter(componentActivity.reportFullyDrawnExecutor, new ComponentActivity$fullyDrawnReporter$2(componentActivity, 2));
            case 1:
                ComponentActivity componentActivity2 = this.this$0;
                return new SavedStateViewModelFactory(componentActivity2.getApplication(), componentActivity2, componentActivity2.getIntent() != null ? componentActivity2.getIntent().getExtras() : null);
            case 2:
                this.this$0.reportFullyDrawn();
                return Unit.INSTANCE;
            default:
                ComponentActivity componentActivity3 = this.this$0;
                OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new ComponentActivity$$ExternalSyntheticLambda0(componentActivity3, 1));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                        componentActivity3.getLifecycle().addObserver(new MenuHostHelper$$ExternalSyntheticLambda1(onBackPressedDispatcher, componentActivity3, 1));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new GraphRequest$Companion$$ExternalSyntheticLambda1(componentActivity3, onBackPressedDispatcher, 1));
                    }
                }
                return onBackPressedDispatcher;
        }
    }
}
