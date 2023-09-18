package org.owasp.webgoat;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

class MyClassFuzzTest2 {
  @FuzzTest
  void myFuzzTest(FuzzedDataProvider data) {
    int i = data.consumeInt();
    if (i == 7) {
      String[] arr = new String[i];
      System.out.println(arr[i]);
    }
  }
}
