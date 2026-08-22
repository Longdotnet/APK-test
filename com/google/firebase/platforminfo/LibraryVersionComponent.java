package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.tracing.ComponentMonitor$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public class LibraryVersionComponent {

    public interface VersionExtractor<T> {
        String extract(T t);
    }

    private LibraryVersionComponent() {
    }

    public static Component<?> create(String str, String str2) {
        return Component.intoSet(new AutoValue_LibraryVersion(str, str2), LibraryVersion.class);
    }

    public static Component<?> fromContext(String str, VersionExtractor<Context> versionExtractor) {
        return Component.intoSetBuilder(LibraryVersion.class).add(Dependency.required(Context.class)).factory(new ComponentMonitor$$ExternalSyntheticLambda0(str, versionExtractor, 1)).build();
    }

    public static LibraryVersion lambda$fromContext$0(String str, VersionExtractor versionExtractor, ComponentContainer componentContainer) {
        return new AutoValue_LibraryVersion(str, versionExtractor.extract((Context) componentContainer.get(Context.class)));
    }
}
