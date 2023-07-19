package org.owasp.webgoat.fuzztests;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.owasp.webgoat.container.users.UserForm;
import org.owasp.webgoat.container.users.UserRepository;
import org.owasp.webgoat.container.users.UserValidator;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

@ExtendWith(MockitoExtension.class)
class MyClassFuzzTest1 {

  @Mock private UserRepository userRepository;

  @FuzzTest
  void passwordShouldMatch(FuzzedDataProvider data) {
    UserForm userForm = new UserForm();
    userForm.setAgree("true");

    String pwd = data.consumeString(100);

    userForm.setUsername(pwd);
    userForm.setPassword(pwd);
    userForm.setMatchingPassword(pwd);

    Errors errors = new BeanPropertyBindingResult(userForm, "userForm");
    new UserValidator(userRepository).validate(userForm, errors);
    Assertions.assertThat(errors.hasErrors()).isFalse();
  }

  @FuzzTest
  void throwErrorTest(FuzzedDataProvider data) {
    String pwd = data.consumeString(100);
    if (pwd.startsWith("t")) {
      throw new NullPointerException();
    }
  }
}
