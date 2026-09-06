class Solution {
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        ArrayDeque<String> q = new ArrayDeque<>();
        if (!wordSet.contains(endWord))
            return 0;
        q.offer(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            //count++;
            for (int i = 0; i < size; i++) {
                String currNode = q.poll();
                if (currNode.equals(endWord))
                    return count;

                char[] temp = currNode.toCharArray();
                for (int j = 0; j < currNode.length(); j++) {
                    char originalAtj = temp[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalAtj)
                            continue;
                        temp[j] = c;
                        String newWord = new String(temp);
                        //if(newWord.equals(endWord))return count;
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            q.add(newWord);
                        }
                    }
                    temp[j] = originalAtj;
                }

            }
            count++;
        }
        return 0;
    }
}