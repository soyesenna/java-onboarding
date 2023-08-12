package onboarding;

public class Problem2 {
    public static void main(String[] args) {
        String cryptogram = "zyelleyz";
        System.out.println(solution(cryptogram));
    }

    public static String solution(String cryptogram) {
        StringBuffer sb = new StringBuffer(cryptogram);
        boolean flag = true;

        while (flag && sb.length() != 0) {
            if (sb.length() == 2 && sb.charAt(0) == sb.charAt(1)){
                sb.delete(0, 2);
                break;
            }
            flag = false;
            char before = sb.charAt(0);
            boolean deleteFlag = false;
            int start = 0;
            for (int i = 1; i < sb.length(); i++) {
                try {
                    char now = sb.charAt(i);
                    if (now == before) {
                        if (!deleteFlag) {
                            deleteFlag = true;
                            flag = true;
                            start = i - 1;
                        }
                    } else if (deleteFlag) {
                        sb.delete(start, i);
                        deleteFlag = false;
                    }
                    before = now;
                }catch (StringIndexOutOfBoundsException e){
                    break;
                }

            }
        }


        String answer = sb.toString();
        return answer;
    }
}
