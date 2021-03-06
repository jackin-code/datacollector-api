/*
 * Copyright 2017 StreamSets Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.api.impl;

import com.streamsets.pipeline.api.base.Errors;

public class CharTypeSupport extends TypeSupport<Character> {

  @Override
  public Character convert(Object value) {
    if (value instanceof Character) {
      return (Character) value;
    }
    if (value instanceof String) {
      String s = (String) value;
      if (s.length() > 0) {
        return s.charAt(0);
      }
    }
    throw new TypeSupportConversionException(Errors.API_05,
                                                    value.getClass().getSimpleName(), value);
  }

}
