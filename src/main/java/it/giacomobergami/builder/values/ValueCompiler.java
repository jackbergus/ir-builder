package it.giacomobergami.builder.values;

import com.github.rwl.irbuilder.types.IType;
import com.github.rwl.irbuilder.values.*;

public class ValueCompiler {

    public static IValue from(double val) {
        return new DoubleValue(val);
    }

    public static IValue from(int val) {
        return new IntValue(val);
    }

    public static IValue from(long val) {
        return new LongValue(val);
    }

    public static IValue from(String val) {
        return new StringValue(val);
    }

    public static IValue from() {
        return VoidValue.INSTANCE;
    }

    public static IValue nullOf(IType type) {
        return new NullValue(type);
    }

}
