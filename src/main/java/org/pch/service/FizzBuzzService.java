package org.pch.service;

import java.util.List;

public interface FizzBuzzService {

  List<String> calculateFizzBuzz(List<String> messages);

  List<String> calculateFizzBuzz(String numbers);
}
