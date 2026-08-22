package com.facebook.internal.instrument.anrreport;

import androidx.core.provider.FontProvider$$ExternalSyntheticLambda2;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility$$ExternalSyntheticLambda5;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.RangesKt;
import okhttp3.Headers;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public abstract class ANRHandler {
    public static final AtomicBoolean enabled = new AtomicBoolean(false);

    public static final void sendANRReports() {
        File[] fileArrListFiles;
        if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
            return;
        }
        try {
            if (Utility.isDataProcessingRestricted()) {
                return;
            }
            File instrumentReportDir = Headers.Companion.getInstrumentReportDir();
            if (instrumentReportDir == null) {
                fileArrListFiles = new File[0];
            } else {
                fileArrListFiles = instrumentReportDir.listFiles(new Utility$$ExternalSyntheticLambda5(2));
                if (fileArrListFiles == null) {
                    fileArrListFiles = new File[0];
                }
            }
            ArrayList arrayList = new ArrayList(fileArrListFiles.length);
            for (File file : fileArrListFiles) {
                arrayList.add(GamepadHandler_API19.load(file));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((InstrumentData) obj).isValid()) {
                    arrayList2.add(obj);
                }
            }
            List listSortedWith = CollectionsKt.sortedWith(arrayList2, new FontProvider$$ExternalSyntheticLambda2(1));
            JSONArray jSONArray = new JSONArray();
            Iterator it = RangesKt.until(0, Math.min(listSortedWith.size(), 5)).iterator();
            while (((IntProgressionIterator) it).hasNext) {
                jSONArray.put(listSortedWith.get(((IntProgressionIterator) it).nextInt()));
            }
            Headers.Companion.sendReports("anr_reports", jSONArray, new ANRHandler$$ExternalSyntheticLambda1(0, listSortedWith));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(ANRHandler.class, th);
        }
    }
}
