package 기출2_1.video;

class Solution {
    static int videoEnd;
    static int opStart;
    static int opEnd;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int hour = Integer.parseInt(video_len.substring(0, 2));
        int min = Integer.parseInt(video_len.substring(3, 5));
        videoEnd = hour * 60 + min;
        
        hour = Integer.parseInt(op_start.substring(0, 2));
        min = Integer.parseInt(op_start.substring(3, 5));
        opStart = hour * 60 + min;
        
        hour = Integer.parseInt(op_end.substring(0, 2));
        min = Integer.parseInt(op_end.substring(3, 5));
        opEnd = hour * 60 + min;
        
        hour = Integer.parseInt(pos.substring(0, 2));
        min = Integer.parseInt(pos.substring(3, 5));
        int current = hour * 60 + min;
        
        current = opCheck(current);
        
        for(String command : commands){
            if(command.equals("next")){
                current = timeCal(current, 1);
            }else{
                current = timeCal(current, -1);
            }
        }
        
        hour = current / 60;
        min =  current % 60;
        
        String hourStr = hour < 10 ? ("0" + hour) : (hour) + "";
        String minStr = min < 10 ? ("0" + min) : (min) + "";
        
        String answer = hourStr + ":" + minStr;
        return answer;
    }
    
    public int opCheck(int curr){
        if(curr >= opStart && curr < opEnd){
            curr = opEnd;
        }
        return curr;
    }
    
    public int timeCal(int curr, int flag){
        if(flag == 1){
            curr += 10;
            if(curr > videoEnd){
                curr = videoEnd;
            }
        }else{
            curr -= 10;
            if(curr < 0){
                curr = 0;
            }
        }
        
        return opCheck(curr);
    }
}