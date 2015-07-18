package org.pch.service;

import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

  public static final String FIZZ = "fizz";
  public static final String BUZZ = "buzz";

  public static final int FIZZ_DIVIDER = 3;
  public static final int BUZZ_DIVIDER = 5;

  public static final Pattern PATTERN = Pattern.compile(",|;|\\|");

  @Override
  public List<String> calculateFizzBuzz(List<String> messages) {
    log.debug("calculateFizzBuzz - messages: {}", messages);
    List<String> results = Optional.ofNullable(messages)
        .map(msgs ->
                msgs.stream()
                    .map(msg -> processRules(Ints.tryParse(msg)))
                    .filter(res -> !res.isEmpty())
                    .collect(Collectors.toList())
        ).orElse(Collections.emptyList());
    log.debug("calculateFizzBuzz - results: {}", results);
    return results;
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
