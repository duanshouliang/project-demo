import java.util.*;

public class Main2 {
    //缺勤
    private static final String ABSENT = "absent";
    //迟到
    private static final String LATE = "late";
    //早退
    private static final String LEAVEEARLY = "leaveearly";
    //正常上班
    private static final String PRESENT = "present";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer count = sc.nextInt();
        String[] records = new String[count];

        for (int i = 0; i < count; i++) {
            records[i] = sc.nextLine();
        }

        for(String record : records){
            int absent = 0;
            List<String> items = Arrays.asList(record.split(" "));
            String current = "";
            for(String item : items){
                if(item.equals(ABSENT)){
                    current = ABSENT;
                    absent ++;
                    if(absent > 1){
                        System.out.println(false);
                        return;
                    }
                }else if(item.equals(LATE)){
                    current = LATE;
                }else if(item.equals(LEAVEEARLY)){
                    current = LEAVEEARLY;
                }else if(item.equals(PRESENT)){
                    current = PRESENT;
                }

            }
        }

    }

    public static void print(List<Integer> list) {
        String res = "";
        for (Integer str : list) {
            res += str + " ";
        }
        System.out.println(res.substring(0, res.length() - 1));
    }
}
