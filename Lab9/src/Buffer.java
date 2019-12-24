public class Buffer {
    private String data;
    private Object synchronizedObject = new Object();

    public synchronized void addData( String data){
        this.data = data;
    }
    public synchronized String getData(){
        return this.data;
    }
}
