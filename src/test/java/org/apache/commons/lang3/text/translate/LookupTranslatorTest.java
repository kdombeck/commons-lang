/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.lang3.text.translate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.lang3.AbstractLangTest;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link org.apache.commons.lang3.text.translate.LookupTranslator}.
 */
@Deprecated
class LookupTranslatorTest extends AbstractLangTest {

    @Test
    void testBasicLookup() throws IOException {
        final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { "one", "two" } });
        final StringWriter out = new StringWriter();
        final int result = lt.translate("one", 0, out);
        assertEquals(3, result, "Incorrect code point consumption");
        assertEquals("two", out.toString(), "Incorrect value");
    }

    // Tests: https://issues.apache.org/jira/browse/LANG-882
    @Test
    void testLang882() throws IOException {
        final LookupTranslator lt = new LookupTranslator(new CharSequence[][] { { new StringBuffer("one"), new StringBuffer("two") } });
        final StringWriter out = new StringWriter();
        final int result = lt.translate(new StringBuffer("one"), 0, out);
        assertEquals(3, result, "Incorrect code point consumption");
        assertEquals("two", out.toString(), "Incorrect value");
    }

}
