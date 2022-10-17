A test project to gauge measurement of internal declaration usage.

## Expected results

### Declarations table

Lists all internal declarations in the project.

Fields:

- declaration: FQN of an internal declaration
- expect: Boolean attribute indicating whether the `declaration` is _expect_;
  in case if it is true, there likely will be other _actual_ declarations
  with the same FQ-name in this project - they should not get into declarations table
- source-set: the name of the source set where the `declaration` is declared
  or the name of IDEA module if we're analyzing the project after importing it to IDEA
- file: file path (from the project root)

### Usages table

Lists usages of internal declarations in the project.
Examples of usages are:

  - internal type use,
  - internal function or property invocation.

Fields:

- declaration: FQN of an internal declaration being used
- usage: FQN of a declaration where the `declaration` above is used
- source set: the name of the source set where the `usage` is declared
  or the name of IDEA module if we're analyzing the project after importing it to IDEA
- file: file path (from the project root) where the `usage` is declared


### Example for this project

**Declarations**

```csv
declaration;expect;source-set;file
org.test.main.declarations.InternalClass;false;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.InternalClass.internalFun;false;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.InternalClass.Nested;false;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.internalFun;false;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.internalExpectFun;true;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
```

**Usages**

```csv
declaration;usage;source-set;file
org.test.main.declarations.InternalClass;org.test.main.declarations.SameFileUsages.test1;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.SameFileUsages.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.SameFileUsages.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.SameFileUsages.topLevel;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.SameFileUsages.TestClass;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.InternalClass.internalFun;org.test.main.declarations.SameFileUsages.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.InternalClass.Nested;org.test.main.declarations.SameFileUsages.TestNestedClass;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.internalFun;org.test.main.declarations.SameFileUsages.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt
org.test.main.declarations.internalExpectFun;org.test.main.declarations.SameFileUsages.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/declarations/internal.kt

org.test.main.declarations.InternalClass;org.test.main.declarations.test1;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/same-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/same-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/same-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.topLevel;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/same-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.TestClass;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/same-package/usages.kt
org.test.main.declarations.InternalClass.internalFun;org.test.main.declarations.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/same-package/usages.kt
org.test.main.declarations.InternalClass.Nested;org.test.main.declarations.TestNestedClass;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/same-package/usages.kt
org.test.main.declarations.internalFun;org.test.main.declarations.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/same-package/usages.kt
org.test.main.declarations.internalExpectFun;org.test.main.declarations.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/same-package/usages.kt

org.test.main.declarations.InternalClass;org.test.main.declarations.subpackage.test1;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/sub-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.subpackage.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/sub-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.subpackage.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/sub-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.subpackage.topLevel;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/sub-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.subpackage.TestClass;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/sub-package/usages.kt
org.test.main.declarations.InternalClass.internalFun;org.test.main.declarations.subpackage.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/sub-package/usages.kt
org.test.main.declarations.InternalClass.Nested;org.test.main.declarations.subpackage.TestNestedClass;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/sub-package/usages.kt
org.test.main.declarations.internalFun;org.test.main.declarations.subpackage.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/sub-package/usages.kt
org.test.main.declarations.internalExpectFun;org.test.main.declarations.subpackage.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/sub-package/usages.kt

org.test.main.declarations.InternalClass;org.test.main.test1;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/super-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/super-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/super-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.topLevel;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/super-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.TestClass;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/super-package/usages.kt
org.test.main.declarations.InternalClass.internalFun;org.test.main.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/super-package/usages.kt
org.test.main.declarations.InternalClass.Nested;org.test.main.TestNestedClass;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/super-package/usages.kt
org.test.main.declarations.internalFun;org.test.main.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/super-package/usages.kt
org.test.main.declarations.internalExpectFun;org.test.main.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/super-package/usages.kt

org.test.main.declarations.InternalClass;org.test.main.usages.other.test1;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/other-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.usages.other.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/other-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.usages.other.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/other-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.usages.other.topLevel;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/other-package/usages.kt
org.test.main.declarations.InternalClass;org.test.main.usages.other.TestClass;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/other-package/usages.kt
org.test.main.declarations.InternalClass.internalFun;org.test.main.usages.other.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/other-package/usages.kt
org.test.main.declarations.InternalClass.Nested;org.test.main.usages.other.TestNestedClass;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/other-package/usages.kt
org.test.main.declarations.internalFun;org.test.main.usages.other.test3;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/other-package/usages.kt
org.test.main.declarations.internalExpectFun;org.test.main.usages.other.test2;package-private-benchmark.commonMain;src/commonMain/kotlin/usages/other-package/usages.kt

org.test.main.declarations.InternalClass;org.test.main.declarations.tests.test1;package-private-benchmark.commonTest;src/commonTest/kotlin/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.tests.test2;package-private-benchmark.commonTest;src/commonTest/kotlin/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.tests.test3;package-private-benchmark.commonTest;src/commonTest/kotlin/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.tests.topLevel;package-private-benchmark.commonTest;src/commonTest/kotlin/usages.kt
org.test.main.declarations.InternalClass;org.test.main.declarations.tests.TestClass;package-private-benchmark.commonTest;src/commonTest/kotlin/usages.kt
org.test.main.declarations.InternalClass.internalFun;org.test.main.declarations.tests.test2;package-private-benchmark.commonTest;src/commonTest/kotlin/usages.kt
org.test.main.declarations.InternalClass.Nested;org.test.main.declarations.tests.TestNestedClass;package-private-benchmark.commonTest;src/commonTest/kotlin/usages.kt
org.test.main.declarations.internalFun;org.test.main.declarations.tests.test3;package-private-benchmark.commonTest;src/commonTest/kotlin/usages.kt
org.test.main.declarations.internalExpectFun;org.test.main.declarations.tests.test2;package-private-benchmark.commonTest;src/commonTest/kotlin/usages.kt
```