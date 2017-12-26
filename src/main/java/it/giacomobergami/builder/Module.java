package it.giacomobergami.builder;

import com.github.rwl.irbuilder.IRBuilder;
import com.github.rwl.irbuilder.types.*;
import com.github.rwl.irbuilder.values.ArrayValue;
import com.github.rwl.irbuilder.values.GlobalVariable;
import com.github.rwl.irbuilder.values.IValue;
import it.giacomobergami.builder.values.ValueCompiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Module {

    IRBuilder builder;
    private HashMap<String, IValue> declarations;

    public Module(String name) {
        builder = new IRBuilder(name);
        declarations = new HashMap<>();
    }

    public IRFunction createFunction(String name, IType retType, IType... argTypes) {
        return new IRFunction(this,builder.beginFunction(name, new FunctionType(retType, argTypes), null, null));
    }

    Module declareType(NamedType nt) {
        builder.namedType(nt);
        return this;
    }

    public Module array(String arrayName, Long... longlist) {
        return longArray(arrayName, Arrays.asList(longlist));
    }

    public Module array(String arrayName, String... longlist) {
        return stringArray(arrayName, Arrays.asList(longlist));
    }


    private Module stringArray(String arrayName, List<String> stringlist) {
        ArrayType type = new ArrayType(IntType.INT_8P, stringlist.size());
        int pos = 0;
        ArrayList<IValue> compiledValues = new ArrayList<>(stringlist.size());
        for (String x : stringlist) {
            IValue stringValue = ValueCompiler.from(x);
            System.err.println(stringValue.ir());
            builder.global(arrayName+"."+(pos), stringValue, null, true, null);
            compiledValues.add(stringValue.asGlobalVariable(arrayName+"."+(pos++)));
        }
        ArrayValue value = new ArrayValue(type, compiledValues);
        declarations.put(arrayName, builder.constant(arrayName, value, null, true, null));
        return this;
    }

    private Module longArray(String arrayName, List<Long> longlist) {
        ArrayType type = new ArrayType(IntType.INT_64, longlist.size());
        ArrayValue value = new ArrayValue(type, longlist.stream().map(ValueCompiler::from).collect(Collectors.toList()));
        declarations.put(arrayName, builder.constant(arrayName, value, null, true, null));
        return this;
    }

    @Override
    public String toString() {
        return builder.build();
    }


}
