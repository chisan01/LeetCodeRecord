# LeetCodeRecord
Collection of LeetCode questions to ace the coding interview! - Created using [LeetHub](https://github.com/QasimWani/LeetHub)

<br>

# 오답노트

### [1770. Maximum Score from Performing Multiplication Operations](https://github.com/chisan01/LeetCodeRecord/tree/main/1770-maximum-score-from-performing-multiplication-operations)

- 처음에 3차원 DP 배열을 사용했는데, 메모리 초과가 발생했다. 크기가 크다보니 미리 예상하긴 했지만 다른 방법이 생각나지 않아서 결국 제출했던건데 역시는 역시나였다..

  ```
  dp[startIdx][endIdx][i]
  ```
  
  다시 곰곰히 생각해보니 `nums[]`의 끝이나 앞에서만 숫자를 제거할 수 있고, `i` 값으로 그동안 몇개의 숫자가 제거되었는지 알 수 있다.
  
  따라서 다음의 식이 성립한다는걸 깨달았고, startIdx만 저장해서 푸는 식으로 해결을 했다.
  
  ```
  endIdx = (nums.length - 1) - (i - startIdx)
  ```
  
- 그리고 `nums[]`에 숫자가 하나만 있을 경우, 값을 바로 리턴할 수 있도록 로직을 작성했는데 `nums[startIdx] * mulipliers[i]`가 아닌 `nums[startIdx]`만 리턴해주도록 구현 실수를 해서 한번 틀렸다.

  아마 오답 테스트케이스를 볼 수 없었다면 해결하는데 시간이 꽤 걸렸을 것 같다.

<br>

### [336. Palindrome Pairs](https://leetcode.com/problems/palindrome-pairs/submissions/)

- Trie 자료 구조를 모르는 상태로 풀다가 도저히 시간초과를 해결할 수가 없어서 풀이를 참고해서 해결했다.

  https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure
