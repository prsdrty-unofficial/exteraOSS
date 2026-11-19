package com.exteragram.messenger.ktx;

/**
 * Source-level stand-ins for Kotlin stdlib `$default` bridge methods that R8
 * inlined out of the public facades.  Semantics follow the Kotlin contracts
 * (the mask bit that corresponds to the parameter being defaulted).
 */
public final class KtCompat {
    private KtCompat() {
    }

    public static boolean startsWith$default(String s, String prefix, boolean ignoreCase, int mask, Object marker) {
        boolean ic = (mask & 2) != 0 ? false : ignoreCase;
        return ic ? s.regionMatches(true, 0, prefix, 0, prefix.length()) : s.startsWith(prefix);
    }

    public static boolean endsWith$default(String s, String suffix, boolean ignoreCase, int mask, Object marker) {
        boolean ic = (mask & 2) != 0 ? false : ignoreCase;
        return ic ? s.regionMatches(true, s.length() - suffix.length(), suffix, 0, suffix.length()) : s.endsWith(suffix);
    }

    public static boolean contains$default(CharSequence s, CharSequence other, boolean ignoreCase, int mask, Object marker) {
        boolean ic = (mask & 2) != 0 ? false : ignoreCase;
        if (!ic) {
            return s.toString().contains(other);
        }
        return s.toString().toLowerCase().contains(other.toString().toLowerCase());
    }

    public static String replace$default(String s, char oldChar, char newChar, boolean ignoreCase, int mask, Object marker) {
        return s.replace(oldChar, newChar);
    }

    public static String replace$default(String s, String oldValue, String newValue, boolean ignoreCase, int mask, Object marker) {
        return s.replace(oldValue, newValue);
    }

    public static int indexOf$default(CharSequence s, CharSequence other, int start, boolean ignoreCase, int mask, Object marker) {
        int from = (mask & 2) != 0 ? 0 : start;
        boolean ic = (mask & 4) != 0 ? false : ignoreCase;
        String hay = s.toString();
        String needle = other.toString();
        if (ic) {
            hay = hay.toLowerCase();
            needle = needle.toLowerCase();
        }
        return hay.indexOf(needle, from);
    }

    public static int lastIndexOf$default(CharSequence s, CharSequence other, int start, boolean ignoreCase, int mask, Object marker) {
        int from = (mask & 2) != 0 ? s.length() - 1 : start;
        boolean ic = (mask & 4) != 0 ? false : ignoreCase;
        String hay = s.toString();
        String needle = other.toString();
        if (ic) {
            hay = hay.toLowerCase();
            needle = needle.toLowerCase();
        }
        return hay.lastIndexOf(needle, from);
    }

    public static String substringBefore$default(String s, String delimiter, String missingDelimiterValue, int mask, Object marker) {
        String fallback = (mask & 2) != 0 ? s : missingDelimiterValue;
        int i = s.indexOf(delimiter);
        return i == -1 ? fallback : s.substring(0, i);
    }

    public static boolean contains$default(CharSequence s, char ch, boolean ignoreCase, int mask, Object marker) {
        boolean ic = (mask & 2) != 0 ? false : ignoreCase;
        String hay = s.toString();
        if (!ic) {
            return hay.indexOf(ch) >= 0;
        }
        return hay.toLowerCase().indexOf(Character.toLowerCase(ch)) >= 0;
    }

    public static boolean isBlank(CharSequence s) {
        return s == null || s.toString().trim().isEmpty();
    }

    public static String readText$default(java.io.File file, java.nio.charset.Charset charset, int mask, Object marker) {
        return kotlin.io.FilesKt.readText(file, (mask & 1) != 0 ? kotlin.text.Charsets.UTF_8 : charset);
    }

    public static java.util.List<String> split$default(CharSequence s, String[] delimiters, boolean ignoreCase, int limit, int mask, Object marker) {
        int lim = (mask & 4) != 0 ? 0 : limit;
        String pattern = delimiters.length == 0 ? "" : java.util.regex.Pattern.quote(delimiters[0]);
        String[] parts = s.toString().split(pattern, lim);
        return java.util.Arrays.asList(parts);
    }

    public static int indexOf$default(CharSequence s, char ch, int start, boolean ignoreCase, int mask, Object marker) {
        return indexOf$default(s, String.valueOf(ch), start, ignoreCase, mask, marker);
    }

    public static int lastIndexOf$default(CharSequence s, char ch, int start, boolean ignoreCase, int mask, Object marker) {
        return lastIndexOf$default(s, String.valueOf(ch), start, ignoreCase, mask, marker);
    }

    public static String substringBefore$default(String s, char delimiter, String missingDelimiterValue, int mask, Object marker) {
        String fallback = (mask & 2) != 0 ? s : missingDelimiterValue;
        int i = s.indexOf(delimiter);
        return i == -1 ? fallback : s.substring(0, i);
    }

    public static String joinToString$default(Iterable<?> items, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, kotlin.jvm.functions.Function1 transform, int mask, Object marker) {
        return joinToStringImpl(toList(items), separator, prefix, postfix, limit, truncated, transform, mask);
    }

    public static String joinToString$default(Object[] items, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, kotlin.jvm.functions.Function1 transform, int mask, Object marker) {
        java.util.List<Object> list = new java.util.ArrayList<>();
        java.util.Collections.addAll(list, items);
        return joinToStringImpl(list, separator, prefix, postfix, limit, truncated, transform, mask);
    }

    private static java.util.List<Object> toList(Iterable<?> it) {
        java.util.List<Object> list = new java.util.ArrayList<>();
        for (Object o : it) list.add(o);
        return list;
    }

    private static String joinToStringImpl(java.util.List<Object> list, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, kotlin.jvm.functions.Function1 transform, int mask) {
        String sep = (mask & 1) != 0 || separator == null ? ", " : separator.toString();
        String pre = (mask & 2) != 0 || prefix == null ? "" : prefix.toString();
        String post = (mask & 4) != 0 || postfix == null ? "" : postfix.toString();
        int lim = (mask & 8) != 0 || limit < 0 ? -1 : limit;
        String trunc = (mask & 16) != 0 || truncated == null ? "..." : truncated.toString();
        StringBuilder sb = new StringBuilder(pre);
        int n = 0;
        for (Object o : list) {
            if (lim >= 0 && n == lim) {
                sb.append(trunc);
                break;
            }
            if (n > 0) sb.append(sep);
            sb.append(transform != null ? String.valueOf(transform.invoke(o)) : String.valueOf(o));
            n++;
        }
        return sb.append(post).toString();
    }

    public static java.util.List<String> split$default(CharSequence s, char[] delimiters, boolean ignoreCase, int limit, int mask, Object marker) {
        String[] d = new String[delimiters.length];
        for (int i = 0; i < delimiters.length; i++) d[i] = String.valueOf(delimiters[i]);
        return split$default(s, d, ignoreCase, limit, mask, marker);
    }

    public static String substringAfterLast$default(String s, char delimiter, String missingDelimiterValue, int mask, Object marker) {
        String fallback = (mask & 2) != 0 ? s : missingDelimiterValue;
        int i = s.lastIndexOf(delimiter);
        return i == -1 ? fallback : s.substring(i + 1);
    }

    public static String padStart$default(String s, int length, char padChar, int mask, Object marker) {
        if (s.length() >= length) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < length; i++) {
            sb.append(padChar);
        }
        return sb.append(s).toString();
    }
}
