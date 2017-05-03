import java.util.ArrayList;
public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
    String[] score=bowlingCode.split("|");;
    int n=score.length;
    int[] all=new int[10];
    ArrayList ball=new ArrayList();
    int[] tag={0,0,0,0,0,0,0,0,0,0};
    for(int i=0;i<10;i++){
        int t=0;
        if(score[i].charAt(0)=='X'){
            ball.add(10); 
            all[i]=10;
            tag[i]=2;
            continue;
        }
        if(score[i].charAt(0)=='-'){
            ball.add(0);
        }
        else{
            ball.add(score[i].charAt(0)-'0');
            t+=(score[i].charAt(0)-'0');
        }
        if(score[i].charAt(1)=='/'){
            ball.add(10-(score[i].charAt(0)-'0'));
            all[i]=10;
            tag[i]=1;
        }
        else if(score[i].charAt(1)=='-'){
            ball.add(0);
            all[i]=t;
        }
        else{
            ball.add(score[i].charAt(1)-'0');
            t+=(score[i].charAt(1)-'0');
            all[i]=t;
        }
    }
    if(tag[9]!=0){
        if(score[11].charAt(0)=='X'){
            ball.add(10);
        }
        else if(score[11].charAt(0)=='-'){
            ball.add(0);
        }
        else{
            ball.add(score[11].charAt(0)-'0');
        }
        if(tag[9]==2){
            if(score[11].charAt(1)=='X'){
                ball.add(10);
            }
            else if(score[11].charAt(1)=='/'){
                ball.add(10-score[11].charAt(0)+'0');
            }
            else if(score[11].charAt(1)=='-'){
                ball.add(0);
            }
            else{
                ball.add(score[11].charAt(1)-'0');
            }
        }
    }

    int res=0;
    int index=0;
    for(int i=0;i<10;i++){
        if(tag[i]==2){
            index+=1;
            res+=(all[i]+ball.get(index)+ball.get(index+1));
        }
        else if(tag[i]==1){
            index+=2;
            res+=(all[i]+ball.get(index));
        }
        else{
            index+=2;
            res+=all[i];
        }
    }
        return res;
    }
}
