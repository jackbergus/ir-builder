package it.giacomobergami.builder;

import com.github.rwl.irbuilder.types.IType;
import com.github.rwl.irbuilder.types.NamedType;
import com.github.rwl.irbuilder.types.StructType;

import java.util.ArrayList;

public class IRType_Struct {

    private Module module;
    private ArrayList<IType> types;
    private String name;

    public IRType_Struct(Module module, String name) {
        types = new ArrayList<>();
        this.module = module;
        this.name = name;
    }

    public IRType_Struct addType(IType type) {
        types.add(type);
        return this;
    }

    public Module declare() {
        return module.declareType(new NamedType(name, new StructType(types)));
    }

}
