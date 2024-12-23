package template;
import java.util.Arrays;

public class CLOOKSeekStrategy implements SeekStrategy{

    @Override
    public void seek(int[] queue, int start) {
        int i = 0;
        int startQueue = 0;

        int[] dupQueue = new int[queue.length]; //input된 queue 배열을 dupQueue에 복사
        for (i=0; i < queue.length; i++){
            dupQueue[i] = queue[i];
        }
        Arrays.sort(dupQueue); //한 쪽 방향으로 가기 위해 queue 정렬

        i = 0;
        while (dupQueue[i] < start){ //start의 위치가 전체 queue에서 어디에 위치하는지 확인
            startQueue = i;
            i++;
        }

        //start보다 작은 첫 위치~0번까지 출력 (왼쪽으로 이동)
        for (i = startQueue; i >= 0; i--){
            System.out.printf("%d ", dupQueue[i]);
        }
        //끝(0)에 도달하지 않고 바로 반대 방향으로 SCAN 시작
        for (i = startQueue+1; i < dupQueue.length; i++){
            System.out.printf("%d ", dupQueue[i]);
        }
        System.out.printf("\n");        
        
        // TODO Auto-generated method stub
    }

}
