package com.github.rwl.irbuilder.test;

import com.github.rwl.irbuilder.types.VoidType;
import junit.framework.TestCase;

import com.github.rwl.irbuilder.IRBuilder;
import com.github.rwl.irbuilder.types.FunctionType;
import com.github.rwl.irbuilder.types.IntType;
import com.github.rwl.irbuilder.values.GlobalVariable;
import com.github.rwl.irbuilder.values.IValue;
import com.github.rwl.irbuilder.values.StringValue;
import com.google.common.collect.Lists;

public class HelloTest extends TestCase {

  public void testHelloWorld() {
    StringValue hello = new StringValue("Hello world!\n");

    IRBuilder ir = new IRBuilder("top");
    ir.constant(null, hello, null, false, null);


    FunctionType ft = new FunctionType(IntType.INT_32, IntType.INT_8.pointerTo());
    GlobalVariable puts = ir.functionDecl("puts", ft);

    FunctionType vType = new FunctionType(VoidType.INSTANCE);
    ir.beginFunction("main", vType, null, null);
    ir.call(puts, Lists.newArrayList(hello), null);
    ir.endFunction(null);

    System.out.println(ir.build());
  }
}
