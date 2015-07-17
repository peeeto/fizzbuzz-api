package org.pch.service;

import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

  public static final String FIZZ = "fizz";
  public static final String BUZZ = "buzz";

  public static final int FIZZ_DIVIDER = 3;
  public static final int BUZZ_DIVIDER = 5;

  public static final Pattern PATTERN = Pattern.compile(",|;|\\|");

  @Override
  public List<String> calculateFizzBuzz(List<String> messages) {
    return messages
        .stream()
        .map(message -> processRules(Ints.tryParse(message)))
        .filter(result -> !result.isEmpty())
        .collect(Collectors.toList());
  }

  @Override
  public List<String> calculateFizzBuzz(String numbers) {
    String[] nums = PATTERN.split(Strings.nullToEmpty(numbers));
    return calculateFizzBuzz(Arrays.asList(nums));
  }

  private String processRules(Integer number) {
    if (number == null) return "";

    StringBuilder sb = new StringBuilder();
    if (moduloZero(number, FIZZ_DIVIDER)) {
      sb.append(FIZZ);
    }
    if (moduloZero(number, BUZZ_DIVIDER)) {
      sb.append(BUZZ);
    }
    if (sb.length() == 0) {
      sb.append(number);
    }
    return sb.toString();
  }

  private boolean moduloZero(int divident, int divisor) {
    return (divident % divisor) == 0;
  }
}
