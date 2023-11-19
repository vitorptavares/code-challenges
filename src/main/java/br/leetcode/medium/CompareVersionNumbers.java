package main.java.br.leetcode.medium;

//Given two version numbers, versionumber1 and version2, compare them.
//
//        Version numbers consist of one or more revisions joined by a dot '.'.
//        Each revision consists of digits and may contain leading zeros. Every revision contains at least one character.
//        Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1,
//        and so on. For example 2.5.33 and 0.1 are valid version numbers.
//
//        To compare version numbers, compare their revisions in left-to-right order.
//        Revisions are compared using their integer value ignoring any leading zeros.
//        This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index,
//        then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same,
//        but their revision 1s are 0 and 1 respectively, and 0 < 1.
//
//        Return the following:
//
//        If versionumber1 < version2, return -1.
//        If versionumber1 > version2, return 1.
//        Otherwise, return 0.


public class CompareVersionNumbers {
    public int compareVersion(String versionumber1, String version2) {

        String v1 [] = versionumber1.split("\\.");
        String v2 [] = version2.split("\\.");

        int maxSize = Math.max(v1.length, v2.length);
        for (int i = 0; i < maxSize; i++) {
            //to void nullpoint, return 0
            int v1Parsed = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int v2Parsed = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;

            if(v1Parsed > v2Parsed)
                return 1;
            else if(v1Parsed < v2Parsed)
                return -1;
        }
        //if application did not return 1 or -1, it means number are the same, so return 0
        return 0;



//        String[] v1Splited = splitVersions(versionumber1);
//        String[] v2Splited = splitVersions(version2);
//
//        List<Integer> version1Splited = Arrays.stream(v1Splited).map(s -> removeLeftZeros(s)).map(Integer::valueOf).collect(Collectors.toList());
//        List<Integer> version2Splited = Arrays.stream(v2Splited).map(s -> removeLeftZeros(s)).map(Integer::valueOf).collect(Collectors.toList());
//
//        if(version1Splited.size() > version2Splited.size()){
//            int diff = (version1Splited.size() - version2Splited.size());
//            for (int i = 0; i < diff; i++) {
//                version2Splited.add(0);
//            }
//        }
//
//        if(version1Splited.size() < version2Splited.size()){
//            int diff = (version2Splited.size() - version1Splited.size());
//            for (int i = 0; i < diff; i++) {
//                version1Splited.add(0);
//            }
//        }
//
//        for (int i = 0; i < version1Splited.size(); i++) {
//            int max = Math.max(2, 2);
//            if(version1Splited.get(i) > version2Splited.get(i)){
//                return 1;
//            }else if (version1Splited.get(i) < version2Splited.get(i)){
//                return -1;
//            }
//
//        }
//        return 0;
//    }
//
//    private String[] splitVersions(String s){
//        String[] splited = s.split("\\.");
//        return splited;
//    }
//
//    private String removeLeftZeros(String s){
//        if(Integer.valueOf(s) > 0){
//            while (s.startsWith("0")){
//                s = s.substring(1);
//            }
//        }
//        return s;
    }

    public static void main(String[] args) {
        CompareVersionNumbers c = new CompareVersionNumbers();
        int i = c.compareVersion("0.1", "1.1");
        System.out.println(i);
    }
}
