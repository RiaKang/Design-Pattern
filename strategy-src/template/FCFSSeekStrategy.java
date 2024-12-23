package template;

public class FCFSSeekStrategy implements SeekStrategy{

    @Override
    public void seek(int[] queue, int start) {
        for (int q: queue){
            System.out.printf("%d ", q);
        }
        System.out.printf("\n");
        // TODO Auto-generated method stub
    }

}
