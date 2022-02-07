package com.tuen.java;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1/N 2/Y 3/Y 4/N 5/Y 6/N 7/Y
        String stu = "1/Y 2/N 3/Y 4/N 5/Y 6/N 7/Y";
        if (null == sc || "".equals(sc)) {
            System.out.println("ERROR");
            return;
        }
        List<String> eles = Arrays.asList(stu.split(" "));
        if(null == eles || eles.size() == 0){
            System.out.println("ERROR");
            return;
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(Integer.parseInt(eles.get(0).split("/")[0]));
        for (int i = 1; i < eles.size(); i++) {
            if (eles.get(i).endsWith("Y")) {
                tmp.add(Integer.parseInt(eles.get(i).split("/")[0]));
            } else {
                tmp.add(-1);
                tmp.add(Integer.parseInt(eles.get(i).split("/")[0]));
            }
        }
        tmp.add(-1);
        List<List<Integer>> treeMap = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (Integer ele : tmp) {
            if (ele != -1) {
                list.add(ele);
            } else {
                Collections.sort(list);
                treeMap.add(list);
                list = new ArrayList<>();
            }
        }
        if (treeMap.size() == 1) {
            print(treeMap.get(0));
            System.out.println();
        } else {
            treeMap.sort(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {

                    return o1.get(0) - o2.get(0);
                }
            });
            for (List<Integer> ele : treeMap) {
                print(ele);
            }
        }
    }

    public static void print(List<Integer> list){
        String res = "";
        for(Integer str : list){
            res += str +" ";
        }
        System.out.println(res.substring(0, res.length() -1));
    }
}
