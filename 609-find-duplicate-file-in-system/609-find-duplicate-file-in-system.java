import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {

        HashMap<String, List<String>> allFilePathsOfContent = new HashMap<>();

        for (String path : paths) {
            StringTokenizer st = new StringTokenizer(path);

            String dir = st.nextToken();
            while (st.hasMoreTokens()) {
                Pattern pattern = Pattern.compile("(.*.txt)\\((.*)\\)");
                Matcher matcher = pattern.matcher(st.nextToken());
                if (!matcher.find()) continue;

                String fileName = matcher.group(1);
                String content = matcher.group(2);

                if (!allFilePathsOfContent.containsKey(content)) {
                    allFilePathsOfContent.put(content, new ArrayList<>());
                }

                List<String> allFilePaths = allFilePathsOfContent.get(content);
                allFilePaths.add(dir + "/" + fileName);
                allFilePathsOfContent.put(content, allFilePaths);
            }
        }

        List<List<String>> answer = new ArrayList<>();
        for(String content : allFilePathsOfContent.keySet()) {
            List<String> allFilePaths = allFilePathsOfContent.get(content);
            if(allFilePaths.size() <= 1) continue;
            answer.add(allFilePaths);
        }
        return answer;
    }
}