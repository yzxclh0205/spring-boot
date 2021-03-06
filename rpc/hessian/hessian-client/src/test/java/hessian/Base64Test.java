package hessian;

import org.junit.Test;

/**
 * @author yezhaoxing
 * @since 2018/12/12
 * @description hessian请求头加密方式
 */
public class Base64Test {

    @Test
    public void calc() {
        int[] nums = new int[]{3, 7, 2, 15};
        int target = 9;
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    @Test
    public void test() {
        String authorization = "Basic " + base64("user:password");
    }

    private String base64(String value) {
        StringBuffer cb = new StringBuffer();
        long chunk;
        int i;
        for (i = 0; i + 2 < value.length(); i += 3) {
            chunk = (long) value.charAt(i);
            chunk = (chunk << 8) + (long) value.charAt(i + 1);
            chunk = (chunk << 8) + (long) value.charAt(i + 2);
            cb.append(encode(chunk >> 18));
            cb.append(encode(chunk >> 12));
            cb.append(encode(chunk >> 6));
            cb.append(encode(chunk));
        }

        if (i + 1 < value.length()) {
            chunk = (long) value.charAt(i);
            chunk = (chunk << 8) + (long) value.charAt(i + 1);
            chunk <<= 8;
            cb.append(encode(chunk >> 18));
            cb.append(encode(chunk >> 12));
            cb.append(encode(chunk >> 6));
            cb.append('=');
        } else if (i < value.length()) {
            chunk = (long) value.charAt(i);
            chunk <<= 16;
            cb.append(encode(chunk >> 18));
            cb.append(encode(chunk >> 12));
            cb.append('=');
            cb.append('=');
        }

        return cb.toString();
    }

    private static char encode(long d) {
        d &= 63L;
        if (d < 26L) {
            return (char) ((int) (d + 65L));
        } else if (d < 52L) {
            return (char) ((int) (d + 97L - 26L));
        } else if (d < 62L) {
            return (char) ((int) (d + 48L - 52L));
        } else {
            return (char) (d == 62L ? '+' : '/');
        }
    }
}
