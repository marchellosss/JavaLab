import java.util.ArrayList;
import java.util.List;

public class RingBuffer {
    private List<Buffer> secondBuffer = new ArrayList<>();
    private List<Buffer> firstBuffer =  new ArrayList<>();
    private int firstBufferLastIndex = 0;
    private int firstBufferMainIndex = 0;
    private int numberOfBuffers = 100;

    public RingBuffer(){
        this.initializeBuffers();
    }
    private void initializeBuffers(){
        for ( int i = 0; i < numberOfBuffers; i++)
        {
            this.firstBuffer.add(new Buffer());
            this.secondBuffer.add(new Buffer());
        }
    }
    private void addDataToFirstBuffer( int id, String data){
        this.firstBuffer.get(id).addData(data);
        this.firstBufferLastIndex++;
    }

    private void transferDataToSecondBuffer(int id, String data) {
        boolean bufferIsEmpty = true;
        while ( bufferIsEmpty){
            if (firstBuffer.get(firstBufferMainIndex).getData()!= null )
            {
                bufferIsEmpty = false;
            }
        }
        this.secondBuffer.get(id).addData(data + firstBuffer.get(firstBufferMainIndex).getData());
        firstBufferMainIndex++;
    }
    private String getDataFromSecondBuffer( int id){
        boolean bufferIsEmpty = true;
        while(bufferIsEmpty){
            if ( secondBuffer.get(id).getData()!=null ){
                bufferIsEmpty=false;
            }
        }
        return this.secondBuffer.get(id).getData();
    }
    public void initiateRingBufferStart(){
        RingBuffer ringBuffer = new RingBuffer();
        for ( int j = 0; j< 5; j++) {
            final int threadIndex = j;
           Thread firstTaskThread =  new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i =threadIndex ; i < numberOfBuffers; i = i + 5) {
                        ringBuffer.addDataToFirstBuffer(i, "Thread №"+threadIndex+"Create a Message..");
                        System.out.println("first");
                    }
                }
            });
            firstTaskThread.setDaemon(true);
            firstTaskThread.start();
        }

        for ( int j = 0; j< 2; j++) {
            final int threadIndex = j;
            Thread secondTaskThread  = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = threadIndex ; i < numberOfBuffers; i = i + 2) {
                        ringBuffer.transferDataToSecondBuffer(i, "Thread №"+threadIndex+"Change a Message..");
                        System.out.println("second");
                    }
                }
            });
            secondTaskThread.setDaemon(true);
            secondTaskThread.start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < 10; i++){
                    System.out.println(ringBuffer.getDataFromSecondBuffer(i));
                }
            }
        }).start();
    }


}
