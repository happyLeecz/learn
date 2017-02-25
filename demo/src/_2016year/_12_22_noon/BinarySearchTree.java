package _2016year._12_22_noon;

/**
 * Created by lcz on 2016/12/25.
 */
public class BinarySearchTree <T extends Comparable<? super T>>{

    //TreeNode
    private static class BinaryTreeNode<T>{
        BinaryTreeNode(T theElement){
            this(theElement,null,null);
        }
        BinaryTreeNode(T theElement,BinaryTreeNode left,BinaryTreeNode right){
            this.element = theElement;
            this.left = left;
            this.right = right;
        }
        T element;//the data in the node
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    private BinaryTreeNode<T> root;

    public BinarySearchTree(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public boolean contains(T x){
        return contains(x,root);
    }

    public T findMin(){
        if(isEmpty()){
         //throw exception
        }
        return findMin(root).element;
    }

    public T findMax(){
        if(isEmpty()){
            //throw exception
        }
        return findMax(root).element;
    }

    public void insert(T x){
        root = insert(x,root);
    }

    public void remove(T x){
        root = remove(x,root);
    }

    public void printTree(){

    }

    private boolean contains(T x,BinaryTreeNode<T> t){
        if(t == null){
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if(compareResult < 0){
            return contains(x,t.left);
        }
        else if(compareResult > 0){
            return contains(x,t.right);
        }
        else return true;
    }
    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> t){
        if(t == null) {
            return null;
        }
        else if(t.left == null){
            return t;
        }else{
             return findMin(t.left);
        }

    }
    private BinaryTreeNode<T> findMax(BinaryTreeNode<T> t){
        if(t == null){
            return null;
        }else{
            while(t.right !=null){
                t=t.right;
            }
            return t;
        }
    }
    private BinaryTreeNode<T> insert(T newItem,BinaryTreeNode<T> t){
        if(t == null){
            return new BinaryTreeNode<>(newItem,null,null);
        }
        int compareResult = newItem.compareTo(t.element);
        if(compareResult < 0){
            t.left = insert(newItem,t.left);
        }
         else if(compareResult > 0){
            t.right = insert(newItem, t.right);
        }
        else
            ;
        return t;
    }
    private BinaryTreeNode<T> remove(T x,BinaryTreeNode<T> t){
        if(t == null){
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if(compareResult < 0){
            t.left = remove(x,t.left);
        }else if(compareResult > 0){
            t.right = remove(x,t.right);
        }else if(t.left != null && t.right != null){
            t.element = findMin(t.right).element;
            t.right = remove(t.element,t.right);
        }
        else
            t = (t.left==null ? t.right : t.left);
        return t;
    }
    private void printTree(BinaryTreeNode<T> t){}



}
