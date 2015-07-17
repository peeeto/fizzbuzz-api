package org.pch.web.rest.dto;

import java.util.List;

/**
 * TODO: short description
 * <p/>
 * Created by petercho on 17/07/15.
 */
public class FizzBuzzReq {
  private final List<String> values;

  public FizzBuzzReq(List<String> values) {
    this.values = values;
  }

  public List<String> getValues() {
    return values;
  }

}
