package org.codingdojo.kata.args;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wynn5a
 * @date 2021/12/8
 */
public class Schema {
  private final Pattern parameterRegex = Pattern.compile("-[a-zA-Z]+\\s");
  private final Pattern defRegex = Pattern.compile("[a-zA-Z]:[a-zA-Z]+");
  private final Map<String, String> parameters = new HashMap<>();

  public Schema(String def) {
    Matcher matcher = defRegex.matcher(def);
    while(matcher.find()){
      String group = matcher.group();
      String[] split = group.split(":");
      parameters.putIfAbsent(split[0], split[1]);
    }
  }

  public int size() {
    return parameters.size();
  }

  public String getType(String parameter) {
    if(parameters.containsKey(parameter)){
      return parameters.get(parameter);
    }
    throw new IllegalArgumentException("cannot find parameter: " + parameter);
  }
}
