package template;

public class SSTFSeekStrategy implements SeekStrategy{

    @Override
    public void seek(int[] queue, int start) {
        //필요 변수 선언
        boolean[] visited = new boolean[queue.length]; //input되는 queue의 크기만큼 false로 초기화된 boolean queue
        int distance; //거리 계산할 distance 변수
        int currentPos = start; //현재 위치, start로 초기화
        int[] seekedQueue = new int[queue.length]; //queue 도달 순서 입력할 배열

        //SSTF 메인 시작
        for (int i=0; i < queue.length; i++){
            int closest = -1; //가장 가까운 queue 위치를 담을 변수
            int minDist = 10000; //distance를 비교해서 최소 거리를 담을 변수

            for (int j = 0; j < queue.length; j++) {
                if (!visited[j]) { //visited가 false면 실행 = 방문하지 않았으면 실행
                    distance = Math.abs(queue[j] - currentPos); //거리 계산
                    if (distance < minDist) { //만약 해당 위치의 거리가 최소거리보다 짧으면 실행
                        minDist = distance; //최소 거리 바꾸고
                        closest = j; //가장 가까운 queue 위치 바꿈
                    }
                }
            }

            visited[closest] = true; //가장 가까운 queue위치 방문할 것이니, true로 변환
            seekedQueue[i] = queue[closest];
            currentPos = queue[closest];
        }

        //SSTF 완료 후 출력 라인
        for (int q: seekedQueue){
            System.out.printf("%d ", q);
        }
        System.out.printf("\n");

        // TODO Auto-generated method stub
    }
    // 현재 위치에서 가장 가까운 요소를 큐에서 찾아 처리. 
    // 큐에 있는 요소 중에서 어떤 것들이 처리되었는지 확인할 수 있도록 같은 크기의 boolean 배열을 생성하고 모두 false로 초기화. 
    // 큐에 있는 idx 위치의 요소가 처리되면 생성한 boolean 배열의 idx 위치의 요소값을 true로 치환. 
    // 가장 가까운 요소를 찾아서 처리한 후에 현재 위치를 다시 처리된 요소의 위치값으로 치환. 
    // 큐에서 현재 위치와 가장 가까운 요소를 찾아서 처리하는 작업을 반복.
}
