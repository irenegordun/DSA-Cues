package edu.upc.eetac.dsa;

public class QueueImpl<E> implements Queue<E>{
    private E[] myQueu;
    private int cont;
    private int maxim;
    public QueueImpl(int maxim){
        myQueu = (E[]) new Object[maxim];
        this.cont = 0;

    }

    public void push(E e) throws FullQueueException{
        if(myQueu.length==cont)
            throw new FullQueueException();
        else{
            this.myQueu[this.cont] = e;
            this.cont++;
        }
    }
    public E pop() throws EmptyQueueException{
        E elem;
        if(cont != 0) {
            elem = myQueu[0];
            myQueu[0]=null;
            for (int i = 0; i < this.cont - 1; i++)
                this.myQueu[i] = this.myQueu[i+1];
            this.cont--;
        }else {
            throw new EmptyQueueException();
        }
        return elem;
    }

    @Override
    public int size() {
        return this.cont;
    }
}
