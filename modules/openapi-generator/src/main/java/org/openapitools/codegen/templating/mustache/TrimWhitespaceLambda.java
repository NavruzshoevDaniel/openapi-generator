/*
 * Copyright 2018 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 * Copyright 2018 SmartBear Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.codegen.templating.mustache;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template.Fragment;

import java.io.IOException;
import java.io.Writer;

/**
 * Replaces duplicate whitespace characters in a fragment with single space.
 * <p>
 * Register:
 * <pre>
 * additionalProperties.put("lambdaTrimWhitespace", new TrimWhitespaceLambda());
 * </pre>
 * <p>
 * Use:
 * <pre>
 * {{#lambdaTrimWhitespace}}{{name}}{{/lambdaTrimWhitespace}}
 * </pre>
 */
public class TrimWhitespaceLambda implements Mustache.Lambda {
    private static final String SINGLE_SPACE = " ";

    private static final String WHITESPACE_REGEX = "\\s+";

    @Override
    public void execute(Fragment fragment, Writer writer) throws IOException {
        writer.write(fragment.execute().replaceAll(WHITESPACE_REGEX, SINGLE_SPACE));
    }

}
