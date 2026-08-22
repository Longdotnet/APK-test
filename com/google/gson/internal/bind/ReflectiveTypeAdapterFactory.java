package com.google.gson.internal.bind;

import com.google.firebase.auth.zzz;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    public final ReflectionAccessor accessor;
    public final zzz constructorConstructor;
    public final Excluder excluder;
    public final FieldNamingPolicy fieldNamingPolicy;
    public final MapTypeAdapterFactory jsonAdapterFactory;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1 */
    public final class AnonymousClass1 {
        public final String name;
        public final boolean serialized;
        public final /* synthetic */ Gson val$context;
        public final /* synthetic */ Field val$field;
        public final /* synthetic */ TypeToken val$fieldType;
        public final /* synthetic */ boolean val$jsonAdapterPresent;
        public final /* synthetic */ TypeAdapter val$typeAdapter;

        public AnonymousClass1(String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z4) {
            this.val$field = field;
            this.val$jsonAdapterPresent = z3;
            this.val$typeAdapter = typeAdapter;
            this.val$context = gson;
            this.val$fieldType = typeToken;
            this.name = str;
            this.serialized = z;
        }
    }

    public final class Adapter extends TypeAdapter {
        public final LinkedHashMap boundFields;

        public Adapter(ObjectConstructor objectConstructor, LinkedHashMap linkedHashMap) {
            this.boundFields = linkedHashMap;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (AnonymousClass1 anonymousClass1 : this.boundFields.values()) {
                    boolean z = anonymousClass1.serialized;
                    Field field = anonymousClass1.val$field;
                    if (z && field.get(obj) != obj) {
                        jsonWriter.name(anonymousClass1.name);
                        Object obj2 = field.get(obj);
                        boolean z2 = anonymousClass1.val$jsonAdapterPresent;
                        TypeAdapter typeAdapterRuntimeTypeWrapper = anonymousClass1.val$typeAdapter;
                        if (!z2) {
                            typeAdapterRuntimeTypeWrapper = new TypeAdapterRuntimeTypeWrapper(anonymousClass1.val$context, typeAdapterRuntimeTypeWrapper, anonymousClass1.val$fieldType.type);
                        }
                        typeAdapterRuntimeTypeWrapper.write(jsonWriter, obj2);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public ReflectiveTypeAdapterFactory(zzz zzzVar, Excluder excluder, MapTypeAdapterFactory mapTypeAdapterFactory) {
        FieldNamingPolicy.AnonymousClass1 anonymousClass1 = FieldNamingPolicy.IDENTITY;
        this.accessor = ReflectionAccessor.instance;
        this.constructorConstructor = zzzVar;
        this.fieldNamingPolicy = anonymousClass1;
        this.excluder = excluder;
        this.jsonAdapterFactory = mapTypeAdapterFactory;
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    @Override // com.google.gson.TypeAdapterFactory
    public final com.google.gson.TypeAdapter create(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r34v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */

    public final boolean excludeField(Field field, boolean z) {
        Class<?> type = field.getType();
        Excluder excluder = this.excluder;
        excluder.getClass();
        if (!Excluder.isAnonymousOrNonStaticLocal(type)) {
            excluder.excludeClassInStrategy(z);
            if ((field.getModifiers() & 136) == 0 && !field.isSynthetic() && !Excluder.isAnonymousOrNonStaticLocal(field.getType())) {
                List list = z ? excluder.serializationStrategies : excluder.deserializationStrategies;
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    if (it.hasNext()) {
                        it.next().getClass();
                        throw new ClassCastException();
                    }
                }
                return true;
            }
        }
        return false;
    }
}
