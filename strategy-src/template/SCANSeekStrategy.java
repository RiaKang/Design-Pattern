package template;
import java.util.Arrays;

public class SCANSeekStrategy implements SeekStrategy{

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
        System.out.printf("0 ");
        for (i = startQueue+1; i < dupQueue.length; i++){
            System.out.printf("%d ", dupQueue[i]);
        }
        System.out.printf("\n");
        
        // TODO Auto-generated method stub
    }
    // SCAN 알고리즘에서는 배열을 복사해서 정렬한 후에 start 위치가 정렬된 배열에서 어느 위치에 속하는지를 확인. 
    // 하드 디스크를 읽는 헤드가 현재 위치에서 0쪽으로 움직이고 있다고 가정하고 처리. 
    // 정렬된 큐에서 현재 위치보다 작은 요소들을 내림차순 순서대로 처리. 다음에는 큐에서 현재 위치보다 큰 요소들을 오름차순 순서대로 처리.
}
