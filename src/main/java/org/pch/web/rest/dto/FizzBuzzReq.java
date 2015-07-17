package org.pch.web.rest.dto;

import java.util.List;

/**
 * TODO: short description
 * <p/>
 * Created by petercho on 17/07/15.
 */
public class FizzBuzzReq {
  private List<String> numbers;

  FizzBuzzReq() {
  }

  public FizzBuzzReq(List<String> numbers) {
    this.numbers = numbers;
  }

  public List<String> getNumbers() {
    return numbers;
  }

}
