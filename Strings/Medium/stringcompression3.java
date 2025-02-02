class Solution {
	//3163
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1, n = word.length();
        char c = word.charAt(0);

        for (int i = 1; i < n; i++) {
            if (c == word.charAt(i)) {
                cnt++;
            }
            if (c != word.charAt(i)) {
                if (cnt > 9) {
                    int count = cnt;
                    while (count > 9) {
                        sb.append(9);
                        sb.append(c);
                        count = count - 9;
                    }
                    sb.append(count);
                    sb.append(c);
                } else {
                    sb.append(cnt);
                    sb.append(c);
                }
                cnt = 1;
                c = word.charAt(i);
            }
        }
        if (sb.length() == 0) {
            if (cnt > 9) {
                int count = cnt;
                while (count > 9) {
                    sb.append(9);
                    sb.append(c);
                    count = count - 9;
                }
                sb.append(count);
                sb.append(c);
            } else {
                sb.append(cnt);
                sb.append(c);
            }
        } else {
            int count = cnt;
            while (count > 9) {
                sb.append(9);
                sb.append(word.charAt(word.length() - 1));
                count = count - 9;
            }
            sb.append(count);
            sb.append(word.charAt(word.length() - 1));
        }

        return sb.toString();

    }
}
