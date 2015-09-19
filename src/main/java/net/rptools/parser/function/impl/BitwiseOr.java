/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package net.rptools.parser.function.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import net.rptools.parser.Parser;
import net.rptools.parser.function.AbstractNumberFunction;
import net.rptools.parser.function.EvaluationException;
import net.rptools.parser.function.ParameterException;

public class BitwiseOr extends AbstractNumberFunction {
    public BitwiseOr() {
        super(1, -1, "bitwiseor", "bor");
    }

    @Override
    public Object childEvaluate(Parser parser, String functionName, List<Object> parameters)
            throws EvaluationException, ParameterException {
        BigInteger value = null;

        for (Object param : parameters) {
            BigDecimal n = (BigDecimal) param;
            if (value == null) {
                value = n.toBigInteger();
            } else {
                value = value.or(n.toBigInteger());
            }
        }

        return new BigDecimal(value);

    }

}
