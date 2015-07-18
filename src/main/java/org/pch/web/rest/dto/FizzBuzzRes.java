package org.pch.web.rest.dto;

import java.util.List;

public class FizzBuzzRes {
  private final List<String> fizzBuzz;

  public FizzBuzzRes(List<String> fizzBuzz) {
    this.fizzBuzz = fizzBuzz;
  }

  public List<String> getFizzBuzz() {
    return fizzBuzz;
  }
}
