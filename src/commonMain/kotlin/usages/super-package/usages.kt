package org.test.main

import org.test.main.declarations.*

fun test1(instance: PublicClass) {
    val internal = InternalClass()
}

internal fun test2(instance: InternalClass) {
    internalExpectFun()
    instance.internalFun()
}

internal fun test3() {
    internalFun().publicFun()
}

val topLevel: Any = InternalClass()

private class TestClass : InternalClass()

class TestNestedClass : InternalClass.Nested
