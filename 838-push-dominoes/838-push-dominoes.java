class Solution {
    public String pushDominoes(String dominoes) {

        int p1 = 0, p2 = 1;
        StringBuilder sb = new StringBuilder();

        for (; p2 < dominoes.length(); p2++) {
            int len = p2 - p1 - 1;
            switch (dominoes.charAt(p2)) {
                case '.':
                    break;
                case 'L':
                    if (dominoes.charAt(p1) == 'R') {
                        sb.append("R".repeat(len / 2 + 1));
                        if (len % 2 == 1) sb.append(".");
                        sb.append("L".repeat(len / 2));
                    } else {
                        sb.append("L".repeat(len + 1));
                    }
                    p1 = p2;
                    break;
                case 'R':
                    if(dominoes.charAt(p1) == 'R'){
                        sb.append("R".repeat(len + 1));
                    }
                    else {
                        sb.append(dominoes.substring(p1, p2));
                    }
                    p1 = p2;
                    break;
            }
        }
        if (dominoes.charAt(dominoes.length() - 1) == '.') {
            if (dominoes.charAt(p1) == 'R') {
                sb.append("R".repeat(p2 - p1));
            } else {
                sb.append(dominoes.substring(p1));
            }
        } else {
            sb.append(dominoes.charAt(dominoes.length() - 1));
        }
        return sb.toString();
    }
}