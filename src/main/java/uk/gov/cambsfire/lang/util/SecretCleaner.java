package uk.gov.cambsfire.lang.util;

/*-
 * #%L
 * Java 8+ common language code
 * %%
 * Copyright (C) 2016 - 2017 Cambridgeshire Fire and Rescue Service
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the Cambridgeshire Fire and Rescue Service nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import java.util.regex.Pattern;

public final class SecretCleaner {

    private static final String SECRET_REGEX =
            "([\\\"']?\\w*?(\\w*password\\w*|\\w*secret\\w*)\\w*?[\\\"']?)"
                    + "(\\s*\\:?\\s*)?['\\\"]?.+?['\\\"]?(([,}\\]])|$)";
    private static final String SECRET_REPLACEMENT_STRING = "$1$3\"*****\"$4";
    private static final Pattern SECRET_PATTERN = Pattern.compile(SECRET_REGEX, Pattern.CASE_INSENSITIVE);

    private SecretCleaner() {
        // utils
    }

    /**
     * Remove potentially sensitive information from a string.
     *
     * Useful for logging output
     */
    public static String removeSecrets(final String str) {
        return SECRET_PATTERN.matcher(str).replaceAll(SECRET_REPLACEMENT_STRING);
    }
}
