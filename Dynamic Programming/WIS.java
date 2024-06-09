// Weighted interval scheduling using dynamic programing
class job{
    int start, end, profit;
    job(int start,int end,int profit){
        this.start=start;
        this.end=end;
        this.profit=profit;
    }
}
public class WIS{
    public static void main(String[] args){
        job jobs[]=new job[5];
        jobs[0]=new job(1,4,20);
        jobs[1]=new job(3,5,40);
        jobs[2]=new job(0,6,60);
        jobs[3]=new job(5,7,80);
        jobs[4]=new job(2,8,100);
        System.out.println("The maximum profit is "+jobScheduling(jobs));
    }
    public static int jobScheduling(job jobs[]){
        int n=jobs.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=jobs[i].profit;
            dp[i][1]=jobs[i].end;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(jobs[j].end<=jobs[i].start){
                    dp[i][0]=Math.max(dp[i][0],dp[j][0]+jobs[i].profit);
                    dp[i][1]=Math.max(dp[i][1],jobs[i].end);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++) if(dp[i][0]>max) max=dp[i][0];
        return max;
    }
}
