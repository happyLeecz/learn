package _2016year._12_22_noon;

/**
 * Created by lcz on 2016/12/26.
 */
public class AvlTree<T extends Comparable<? super T>> {

    private static final int ALLOWED_IMBALANCE = 1;
    private static class AvlNode<T>{
        AvlNode(T theElement){
            this(theElement,null,null);
        }

        AvlNode(T data, AvlNode<T> left, AvlNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = 0;

        }
        T data;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
    }

    private int getHeight(AvlNode<T> node){
        return node == null ? -1 : node.height;
    }

    private AvlNode<T> insert(T newData, AvlNode<T> node){
        if(node == null){
            return new AvlNode<>(newData,null,null);
        }
        int compareResult = newData.compareTo(node.data);
        if(compareResult < 0){
            node.left = insert(newData,node.left);
        }else if(compareResult > 0){
            node.right = insert(newData,node.right);
        }else{
            ;
        }

        return balance(node);

    }

    private AvlNode<T> balance(AvlNode<T> node){
        if(node == null){
            return node;
        }
        if(getHeight(node.left) - getHeight(node.right) > ALLOWED_IMBALANCE){
            //这里用>=是在删除后进行平衡的时候有可能发生的相等的情况
            if(getHeight(node.left.left) >= getHeight(node.left.right)){
                node = rotateWithLeftChild(node);
            }else{
                node = doubleWithLeftChild(node);
            }
        }
        else if(getHeight(node.right) - getHeight(node.left) > ALLOWED_IMBALANCE){
            if(getHeight(node.right.right) >= getHeight(node.left.right)){
                node = rotateWithRightChild(node);
            }
            else{
                node = doubleWithRightChild(node);
            }
        }
        //node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1 ;
        return node;

    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> node){
        AvlNode<T> nodeLeft = node.left;
        node.left = nodeLeft.right;
        nodeLeft.right = node;
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        nodeLeft.height = Math.max(getHeight(nodeLeft.left),getHeight(nodeLeft.right)) +1;
        return nodeLeft;
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> node){
        AvlNode<T> nodeRight = node.right;
        node.right = nodeRight.left;
        nodeRight.left = node;
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) +1 ;
        nodeRight.height = Math.max(getHeight(nodeRight.left),getHeight(nodeRight.right)) +1;
        return nodeRight;
    }
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> node){
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }
    private AvlNode<T> doubleWithRightChild(AvlNode<T> node){
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }

    private AvlNode<T> findMin(AvlNode<T> node){
        if(node == null){
            return node;
        }else if(node.left != null){
            return findMin(node.left);
        }else{
            return node;
        }
    }
    private AvlNode<T> remove(T data,AvlNode<T> node){
        if(node == null){
            return node;
        }
        int comparableResult = data.compareTo(node.data);
        if(comparableResult < 0 ){
            node = remove(data,node.left);
        }else if(comparableResult > 0){
            node = remove(data,node.right);
        }else if(node.left != null&& node.right != null){
            node.data = findMin(node.right).data;
            node = remove(node.data,node.right);
        }else{
            node = (node.left == null) ? node.right : node.left;
        }

        return balance(node);
    }
}
