package org.pch.web.rest.dto;

import java.util.List;

/**
 * TODO: short description
 * <p/>
 * Created by petercho on 17/07/15.
 */
public class FizzBuzzRes {
  private final List<String> fizzbuzz;

  public FizzBuzzRes(List<String> fizzbuzz) {
    this.fizzbuzz = fizzbuzz;
  }

  public List<String> getFizzbuzz() {
    return fizzbuzz;
  }
}
