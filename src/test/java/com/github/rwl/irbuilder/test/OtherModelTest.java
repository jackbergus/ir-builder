package com.github.rwl.irbuilder.test;

import com.github.rwl.irbuilder.types.IType;
import com.github.rwl.irbuilder.types.IntType;
import it.giacomobergami.builder.Module;

public class OtherModelTest {

    public static void main(String[] args) {
        Module language = new Module("language");
        language.array("a.containts",1L,2L,3L,4L);
        language.array("a.labels","hello");
        System.out.println(language);
    }

}
