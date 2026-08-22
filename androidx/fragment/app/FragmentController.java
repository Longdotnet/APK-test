package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentController {
    public final FragmentActivity.HostCallbacks mHost;

    public FragmentController(FragmentActivity.HostCallbacks hostCallbacks) {
        this.mHost = hostCallbacks;
    }

    public final void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }
}
