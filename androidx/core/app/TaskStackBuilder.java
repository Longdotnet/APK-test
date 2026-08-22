package androidx.core.app;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable {
    public final ArrayList mIntents = new ArrayList();
    public final AppCompatActivity mSourceContext;

    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    public TaskStackBuilder(AppCompatActivity appCompatActivity) {
        this.mSourceContext = appCompatActivity;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.mIntents.iterator();
    }
}
