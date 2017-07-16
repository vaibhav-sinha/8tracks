package com.github.vaibhavsinha.eighttracks.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vaibhav on 16/07/17.
 */
public class ListUtils {

    public static List<String> doCaseInsensitiveDedup(List<String> original) {
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(original);
        return new ArrayList<>(set);
    }
}
