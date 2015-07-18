package org.pch.web.rest.dto;

import java.util.List;

public class FizzBuzzRes {
  private final List<String> fizzbuzz;

  public FizzBuzzRes(List<String> fizzbuzz) {
    this.fizzbuzz = fizzbuzz;
  }

  public List<String> getFizzbuzz() {
    return fizzbuzz;
  }
}
