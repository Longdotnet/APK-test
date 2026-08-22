package com.google.gson;

import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public enum FieldNamingPolicy {
    IDENTITY { // from class: com.google.gson.FieldNamingPolicy.1
        @Override // com.google.gson.FieldNamingPolicy
        public final String translateName(Field field) {
            return field.getName();
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF9 { // from class: com.google.gson.FieldNamingPolicy.2
        @Override // com.google.gson.FieldNamingPolicy
        public final String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF14 { // from class: com.google.gson.FieldNamingPolicy.3
        @Override // com.google.gson.FieldNamingPolicy
        public final String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF19 { // from class: com.google.gson.FieldNamingPolicy.4
        @Override // com.google.gson.FieldNamingPolicy
        public final String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), FKidOcdAYt.txPgDgmHmS).toLowerCase(Locale.ENGLISH);
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF24 { // from class: com.google.gson.FieldNamingPolicy.5
        @Override // com.google.gson.FieldNamingPolicy
        public final String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF29 { // from class: com.google.gson.FieldNamingPolicy.6
        @Override // com.google.gson.FieldNamingPolicy
        public final String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char cCharAt = str.charAt(i);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        if (i == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public abstract String translateName(Field field);
}
