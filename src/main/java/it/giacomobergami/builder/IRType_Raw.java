package it.giacomobergami.builder;

import com.github.rwl.irbuilder.types.*;

public enum IRType_Raw {
    DOUBLE(DoubleType.INSTANCE),
    FLOAT(FloatType.INSTANCE),
    INT1(IntType.INT_1),
    INT8(IntType.INT_8),
    INT16(IntType.INT_16),
    INT32(IntType.INT_32),
    INT64(IntType.INT_64),
    Pointer(IntType.INT_8P),
    PointerPointer(IntType.INT_8PP),
    Void(VoidType.INSTANCE)
    ;

    public IType rawType;
    IRType_Raw(IType instance) {
        rawType = instance;
    }
}
