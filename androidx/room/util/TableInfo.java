package androidx.room.util;

import android.database.Cursor;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class TableInfo {
    public final Map columns;
    public final Set foreignKeys;
    public final Set indices;
    public final String name;

    /* JADX INFO: loaded from: classes.dex */
    public final class Column {
        public final int affinity;
        public final String defaultValue;
        public final int mCreatedFrom;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public Column(int i, String str, String str2, String str3, boolean z, int i2) {
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i;
            int i3 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i3 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i3 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i3 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.affinity = i3;
            this.defaultValue = str3;
            this.mCreatedFrom = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Column.class != obj.getClass()) {
                return false;
            }
            Column column = (Column) obj;
            if (this.primaryKeyPosition != column.primaryKeyPosition || !this.name.equals(column.name) || this.notNull != column.notNull) {
                return false;
            }
            String str = this.defaultValue;
            int i = this.mCreatedFrom;
            int i2 = column.mCreatedFrom;
            String str2 = column.defaultValue;
            if (i == 1 && i2 == 2 && str != null && !str.equals(str2)) {
                return false;
            }
            if (i != 2 || i2 != 1 || str2 == null || str2.equals(str)) {
                return (i == 0 || i != i2 || (str == null ? str2 == null : str.equals(str2))) && this.affinity == column.affinity;
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.defaultValue, "'}");
        }
    }

    public final class ForeignKey {
        public final List columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List list, List list2) {
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = Collections.unmodifiableList(list);
            this.referenceColumnNames = Collections.unmodifiableList(list2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ForeignKey.class != obj.getClass()) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (this.referenceTable.equals(foreignKey.referenceTable) && this.onDelete.equals(foreignKey.onDelete) && this.onUpdate.equals(foreignKey.onUpdate) && this.columnNames.equals(foreignKey.columnNames)) {
                return this.referenceColumnNames.equals(foreignKey.referenceColumnNames);
            }
            return false;
        }

        public final int hashCode() {
            return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(this.referenceTable.hashCode() * 31, 31, this.onDelete), 31, this.onUpdate)) * 31);
        }

        public final String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + "', onUpdate='" + this.onUpdate + ehgOP.MgpGvcqEFXpT + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class ForeignKeyWithSequence implements Comparable {
        public final String mFrom;
        public final int mId;
        public final int mSequence;
        public final String mTo;

        public ForeignKeyWithSequence(int i, int i2, String str, String str2) {
            this.mId = i;
            this.mSequence = i2;
            this.mFrom = str;
            this.mTo = str2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj;
            int i = this.mId - foreignKeyWithSequence.mId;
            return i == 0 ? this.mSequence - foreignKeyWithSequence.mSequence : i;
        }
    }

    public final class Index {
        public final List columns;
        public final String name;
        public final boolean unique;

        public Index(String str, boolean z, List list) {
            this.name = str;
            this.unique = z;
            this.columns = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Index.class != obj.getClass()) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique != index.unique || !this.columns.equals(index.columns)) {
                return false;
            }
            String str = this.name;
            boolean zStartsWith = str.startsWith("index_");
            String str2 = index.name;
            return zStartsWith ? str2.startsWith("index_") : str.equals(str2);
        }

        public final int hashCode() {
            String str = this.name;
            return this.columns.hashCode() + ((((str.startsWith("index_") ? -1184239155 : str.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31);
        }

        public final String toString() {
            return nYVxXTZQ.KBjnulEzrZRHyA + this.name + "', unique=" + this.unique + ", columns=" + this.columns + '}';
        }
    }

    public TableInfo(String str, HashMap map, HashSet hashSet, HashSet hashSet2) {
        this.name = str;
        this.columns = Collections.unmodifiableMap(map);
        this.foreignKeys = Collections.unmodifiableSet(hashSet);
        this.indices = hashSet2 == null ? null : Collections.unmodifiableSet(hashSet2);
    }

    public static ArrayList readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Index readIndex(FrameworkSQLiteProgram frameworkSQLiteProgram, String str, boolean z) {
        Cursor cursorQuery = frameworkSQLiteProgram.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("seqno");
            int columnIndex2 = cursorQuery.getColumnIndex("cid");
            int columnIndex3 = cursorQuery.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (cursorQuery.moveToNext()) {
                    if (cursorQuery.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(cursorQuery.getInt(columnIndex)), cursorQuery.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new Index(str, z, arrayList);
            }
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (obj == null || TableInfo.class != obj.getClass()) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        String str = tableInfo.name;
        String str2 = this.name;
        if (str2 == null ? str != null : !str2.equals(str)) {
            return false;
        }
        Map map = tableInfo.columns;
        Map map2 = this.columns;
        if (map2 == null ? map != null : !map2.equals(map)) {
            return false;
        }
        Set set2 = tableInfo.foreignKeys;
        Set set3 = this.foreignKeys;
        if (set3 == null ? set2 != null : !set3.equals(set2)) {
            return false;
        }
        Set set4 = this.indices;
        if (set4 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return set4.equals(set);
    }

    public final int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.columns;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set set = this.foreignKeys;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public final String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    public static TableInfo read(FrameworkSQLiteProgram frameworkSQLiteProgram, String str) {
        ArrayList arrayList;
        int i;
        Cursor cursorQuery = frameworkSQLiteProgram.query("PRAGMA table_info(`" + str + "`)");
        HashMap map = new HashMap();
        try {
            if (cursorQuery.getColumnCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("name");
                int columnIndex2 = cursorQuery.getColumnIndex("type");
                int columnIndex3 = cursorQuery.getColumnIndex("notnull");
                int columnIndex4 = cursorQuery.getColumnIndex("pk");
                int columnIndex5 = cursorQuery.getColumnIndex("dflt_value");
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndex);
                    map.put(string, new Column(cursorQuery.getInt(columnIndex4), string, cursorQuery.getString(columnIndex2), cursorQuery.getString(columnIndex5), cursorQuery.getInt(columnIndex3) != 0, 2));
                }
            }
            cursorQuery.close();
            HashSet hashSet = new HashSet();
            Cursor cursorQuery2 = frameworkSQLiteProgram.query(DYYbQc.JybslxgSvU + str + "`)");
            try {
                int columnIndex6 = cursorQuery2.getColumnIndex("id");
                int columnIndex7 = cursorQuery2.getColumnIndex("seq");
                int columnIndex8 = cursorQuery2.getColumnIndex("table");
                int columnIndex9 = cursorQuery2.getColumnIndex("on_delete");
                int columnIndex10 = cursorQuery2.getColumnIndex("on_update");
                ArrayList<ForeignKeyWithSequence> foreignKeyFieldMappings = readForeignKeyFieldMappings(cursorQuery2);
                int count = cursorQuery2.getCount();
                int i2 = 0;
                while (i2 < count) {
                    cursorQuery2.moveToPosition(i2);
                    if (cursorQuery2.getInt(columnIndex7) != 0) {
                        arrayList = foreignKeyFieldMappings;
                        i = count;
                    } else {
                        int i3 = cursorQuery2.getInt(columnIndex6);
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        for (ForeignKeyWithSequence foreignKeyWithSequence : foreignKeyFieldMappings) {
                            ArrayList arrayList4 = foreignKeyFieldMappings;
                            int i4 = count;
                            if (foreignKeyWithSequence.mId == i3) {
                                arrayList2.add(foreignKeyWithSequence.mFrom);
                                arrayList3.add(foreignKeyWithSequence.mTo);
                            }
                            foreignKeyFieldMappings = arrayList4;
                            count = i4;
                        }
                        arrayList = foreignKeyFieldMappings;
                        i = count;
                        hashSet.add(new ForeignKey(cursorQuery2.getString(columnIndex8), cursorQuery2.getString(columnIndex9), cursorQuery2.getString(columnIndex10), arrayList2, arrayList3));
                    }
                    i2++;
                    columnIndex6 = columnIndex6;
                    columnIndex7 = columnIndex7;
                    foreignKeyFieldMappings = arrayList;
                    count = i;
                }
                cursorQuery2.close();
                Cursor cursorQuery3 = frameworkSQLiteProgram.query("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = cursorQuery3.getColumnIndex("name");
                    int columnIndex12 = cursorQuery3.getColumnIndex(FirebaseAnalytics.Param.ORIGIN);
                    int columnIndex13 = cursorQuery3.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 == -1 || columnIndex12 == -1 || columnIndex13 == -1) {
                        cursorQuery3.close();
                        break;
                    }
                    HashSet hashSet3 = new HashSet();
                    while (true) {
                        if (!cursorQuery3.moveToNext()) {
                            cursorQuery3.close();
                            hashSet2 = hashSet3;
                            break;
                        }
                        if ("c".equals(cursorQuery3.getString(columnIndex12))) {
                            Index index = readIndex(frameworkSQLiteProgram, cursorQuery3.getString(columnIndex11), cursorQuery3.getInt(columnIndex13) == 1);
                            if (index == null) {
                                cursorQuery3.close();
                                break;
                            }
                            hashSet3.add(index);
                        }
                    }
                    return new TableInfo(str, map, hashSet, hashSet2);
                } catch (Throwable th) {
                    cursorQuery3.close();
                    throw th;
                }
            } catch (Throwable th2) {
                cursorQuery2.close();
                throw th2;
            }
        } catch (Throwable th3) {
            cursorQuery.close();
            throw th3;
        }
    }
}
