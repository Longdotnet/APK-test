package androidx.sqlite.db;

import android.util.JsonWriter;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import com.google.android.gms.ads.internal.util.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzl;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery, zzk {
    public static SimpleSQLiteQuery zzb;
    public String mQuery;

    public /* synthetic */ SimpleSQLiteQuery(String str) {
        this.mQuery = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzk
    public void zza(JsonWriter jsonWriter) throws IOException {
        Object obj = zzl.zzb;
        jsonWriter.name("params").beginObject();
        String str = this.mQuery;
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(FrameworkSQLiteProgram frameworkSQLiteProgram) {
    }
}
