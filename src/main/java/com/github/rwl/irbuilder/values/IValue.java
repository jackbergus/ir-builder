package com.github.rwl.irbuilder.values;

import com.github.rwl.irbuilder.types.IType;

public interface IValue {

  String ir();

  IType type();

  default IValue asGlobalVariable(String name) {
    return new GlobalVariable(name, type().pointerTo());
  }
}
