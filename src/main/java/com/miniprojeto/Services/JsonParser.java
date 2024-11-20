package com.miniprojeto.Services;

import java.util.List;

public interface JsonParser<T> {
    List<T> parse(String responseBody);
}
