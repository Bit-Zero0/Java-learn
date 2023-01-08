import java.util.Arrays;

public class MyArrayList {
    private int usedSize;
    private int[] elem;

    MyArrayList(){
        this.usedSize = 0;
        this.elem = new int[10];
    }

    public void add(int pos , int data){
        if(pos < 0 || pos > this.usedSize){
            return ;
        }
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem , this.elem.length*2);
        }

        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        elem[pos] = data;
        this.usedSize++;

    }

    public boolean isFull(){
        return this.elem.length == this.usedSize;
    }

    public void display(){
        for (int i = 0; i < usedSize; i++) {
            System.out.println(this.elem[i] + " ");
        }
    }

    public boolean contains(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }

    public int search(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind == this.elem[i]){
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos){
        if(pos < 0 || pos >= this.usedSize ){
            System.out.println("pos 位置不合法");
            return -1;
        }
        if(isEmpty()) {
            System.out.println("顺序表为空");
            return -1;
        }

        return this.elem[pos];
    }

    public void setPos(int pos , int value){
        if(pos < 0 || pos >= this.usedSize ){
            System.out.println("pos 位置不合法");
            return ;
        }

        if(isEmpty()) {
            System.out.println("顺序表为空");
            return ;
        }
        this.elem[pos] = value;

    }

    public boolean isEmpty()
    {
        return this.usedSize == 0;
    }

    public void remove(int data){
        if(isEmpty()) {
            System.out.println("顺序表为空");
            return ;
        }

        int index = search(data);
        if(index == -1) {
            System.out.println("没有该数据");
            return;
        }

        for (int i = index; i < usedSize; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    public void clear(){
        this.usedSize = 0;
    }

}


