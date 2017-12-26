package it.giacomobergami.builder;

import com.github.rwl.irbuilder.values.IValue;
import com.github.rwl.irbuilder.values.LocalVariable;

public class IRFunction {

    Module module;
    public IRFunction(Module module, LocalVariable[] localVariables) {
        this.module = module;
    }

    public Module end(IValue returnValue) {
        module.builder.endFunction(returnValue);
        return module;
    }

}
