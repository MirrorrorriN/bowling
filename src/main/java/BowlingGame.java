import java.util.ArrayList;
public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
    String[] score=bowlingCode.split("|");;
    int n=score.length;
    int[] all=new int[10];
    int[] ball=new int[22];
    int k=0;
    int[] tag={0,0,0,0,0,0,0,0,0,0};
    for(int i=0;i<10;i++){
        int t=0;
        if(score[i].charAt(0)=='X'){
            ball[k]=10;
            k++;
            all[i]=10;
            tag[i]=2;
            continue;
        }
        if(score[i].charAt(0)=='-'){
            ball[k]=0;
            k++;
        }
        else{
            ball[k]=score[i].charAt(0)-'0';
            k++;
            t+=(score[i].charAt(0)-'0');
        }
        if(score[i].charAt(1)=='/'){
            ball[k]=10-(score[i].charAt(0)-'0');
            k++;
            all[i]=10;
            tag[i]=1;
        }
        else if(score[i].charAt(1)=='-'){
            ball[k]=0;
            k++;
            all[i]=t;
        }
        else{
            ball[k]=score[i].charAt(1)-'0';
            k++;
            t+=(score[i].charAt(1)-'0');
            all[i]=t;
        }
    }
    if(tag[9]!=0){
        if(score[11].charAt(0)=='X'){
            ball[k]=10;
            k++;
        }
        else if(score[11].charAt(0)=='-'){
            ball[k]=0;
            k++;
        }
        else{
            ball[k]=score[11].charAt(0)-'0';
            k++;
        }
        if(tag[9]==2){
            if(score[11].charAt(1)=='X'){
                ball[k]=10;
                k++;
            }
            else if(score[11].charAt(1)=='/'){
                ball[k]=10-score[11].charAt(0)+'0';
                k++;
            }
            else if(score[11].charAt(1)=='-'){
                ball[k]=0;
                k++;
            }
            else{
                ball[k]=score[11].charAt(1)-'0';
                k++;
            }
        }
    }
    int res=0;
    int index=0;
    for(int i=0;i<10;i++){
        if(tag[i]==2){
            index+=1;
            res+=(all[i]+ball[index]+ball[index+1]);
        }
        else if(tag[i]==1){
            index+=2;
            res+=(all[i]+ball[index]);
        }
        else{
            index+=2;
            res+=all[i];
        }
    }
        return res;
    }
}
