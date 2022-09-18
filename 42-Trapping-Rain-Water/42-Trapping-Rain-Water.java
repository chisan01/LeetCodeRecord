class Block {
    public int H, pos;
    
    public Block(int H, int pos) {
        this.H = H;
        this.pos = pos;
    }
}

class Solution {
    
    int calc(Block left, Block cur, int prevH) {
        if(left.pos + 1 == cur.pos) return 0;
        return (Math.min(left.H, cur.H) - prevH) * (cur.pos - left.pos - 1);
    }
    
    public int trap(int[] height) {
        int result = 0;
        Stack<Block> S = new Stack<>();
        
        for(int i=0; i<height.length; i++) {
            
            if(height[i] == 0) continue;
            
            Block cur = new Block(height[i], i);
            int prevH = 0;
            while(!S.isEmpty()) {
                result += calc(S.peek(), cur, prevH);
                if(S.peek().H >= cur.H) {
                    if(S.peek().H == cur.H) S.pop();
                    break;
                } else {
                    prevH = S.pop().H;
                }
            }
            S.add(cur);
        }
        return result;
    }
}
