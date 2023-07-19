package org.owasp.webgoat;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

class MyClassFuzzTest1 {
  @FuzzTest
  void myFuzzTest(FuzzedDataProvider data) {
    int i = data.consumeInt();
    if (i == 2) {
      String[] arr = new String[i];
      System.out.println(arr[i]);
    }
  }
}
